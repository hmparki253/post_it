package com.phm.community.util;

import java.io.IOException;
import java.util.Collection;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
        
	}
	
	protected void handle(HttpServletRequest request, 
			HttpServletResponse response, Authentication authentication) throws IOException {
		
		// 권한 별 로그인 성공 이후 redirection될 url 결정하는 메서드
		String targetUrl = determineTargetUrl(authentication);  
		
		// ? response.iscommitted를 잘 이해하지 못하는듯함 
		if(response.isCommitted()) {
			logger.info("응답이 이미 커밋되었습니다. 요청한 url로 리다이렉트 할 수 없습니다." 
					+ targetUrl);
			return;
		}
		
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	// 타겟 url 설정 
	protected String determineTargetUrl(Authentication authentication) {
		boolean isUser = false; // 유저인지 체크하는 flag 값 
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities(); // 해당 계정이 갖고있는 권한 목록 리턴 

		// 해당 계정이 갖고있는 권한목록 체크 
		for(GrantedAuthority grantedAuthority : authorities) {
			// user 권한을 갖고있는지 체크하여 flag 값 변경 
			if(grantedAuthority.getAuthority().equals("ROLE_USER")) {
				isUser = true;
				break;
			}
		}
		
		// 유저 권한을 갖고있는 회원은 root context로 redirect된다
		if(isUser) {
			return "/";
		} else {
			throw new IllegalStateException();
		}
	}
	
	protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
	// RedirectStrategy getter, setter
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}