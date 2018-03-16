package com.phm.community.config;

import java.beans.PropertyVetoException;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.phm.community")
@PropertySource("classpath:persistence-mysql.properties")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer, TransactionManagementConfigurer{

	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// 뷰 리졸버 설정
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setContentType("text/html;charset=UTF-8");
		return viewResolver;
	}
	
	@Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
 
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
    
    // 데이터 소스와 커넥션 풀 셋업
    @Bean
	public DataSource dataSource() {
		
		// create connection pool
		ComboPooledDataSource dataSource
			= new ComboPooledDataSource();
		
		// set the jdbc driver class
		try {
			logger.info(">>> jdbc.driver = " + env.getProperty("jdbc.driver"));
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// log the connection properties
		logger.info(">>> jdbc.url = " + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user = " + env.getProperty("jdbc.user"));
		
		// set database connection properties
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool properties
		dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return dataSource;
	}
    
    // 하이버네이트 세션 팩토리 셋업 
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
    		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    		sessionFactory.setDataSource(dataSource());
    		sessionFactory.setPackagesToScan("com.phm.community.entity");
    		sessionFactory.setHibernateProperties(hibernateProperties());
    		return sessionFactory;
    }
    
    // 하이버네이트 프로퍼티 값 설정
    private final Properties hibernateProperties() {
    		Properties hibernateProperties = new Properties();
    		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    		hibernateProperties.setProperty("hibernate.show_sql", "true");
    		return hibernateProperties;
    }
    
    // 하이버네이트 트랜잭션 매니저 설정 
    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {
    		HibernateTransactionManager transactionManager
    			= new HibernateTransactionManager();
    		transactionManager.setSessionFactory(sessionFactory().getObject());
    		return transactionManager;
    }
    
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return hibernateTransactionManager();
	}
	
//	@Bean
//	public CommonsMultipartResolver multipartResolver() {
//		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//		resolver.setDefaultEncoding("utf-8");
//		return resolver;
//	}
	
	// 파일 업로드와 다운로드를 위한 MultipartResolver 빈 등록
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = 
				new CommonsMultipartResolver();
		resolver.setMaxInMemorySize(100000000);
		resolver.setMaxUploadSize(200000000);
		return resolver;
	}
	
	// css, js, image등을 위한 resource 경로 지정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}
	
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		
		// convert string to int
		
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
}
