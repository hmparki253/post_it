package com.phm.community.service;

import com.phm.community.entity.Board;
import com.phm.community.entity.Reply;

public interface UtilService {
	public Board getBoardPagination(int size);
	public Reply getReplyPagination(int size);
}
