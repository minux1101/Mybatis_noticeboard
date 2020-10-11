package com.gongji.dao;

import java.util.List;

import com.gongji.dto.GongjiVO;

public interface GongjiDao {

	public int insert(GongjiVO gongjiVO) throws Exception;

	public List<GongjiVO> selectAll() throws Exception;

	public GongjiVO selectOne(int id) throws Exception;

	public int update(GongjiVO gongjiVO) throws Exception;

	public int delete(int id) throws Exception;
}
