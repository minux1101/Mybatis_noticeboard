package com.gongji.service;

import java.util.List;

import com.gongji.dto.GongjiVO;

public interface GongjiService {

	public int insert(GongjiVO gongjiVO) throws Exception;

	public List<GongjiVO> selectAll() throws Exception;

	public GongjiVO selectOne(int id) throws Exception;

	public int update(GongjiVO gongjiVO) throws Exception;

	public int delete(int id) throws Exception;

}
