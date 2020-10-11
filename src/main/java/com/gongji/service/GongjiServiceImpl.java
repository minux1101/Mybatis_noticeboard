package com.gongji.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gongji.dao.GongjiDao;
import com.gongji.dto.GongjiVO;

@Service
public class GongjiServiceImpl implements GongjiService {

	@Inject
	private GongjiDao dao;

	@Override
	public int insert(GongjiVO gongjiVO) throws Exception {
		return dao.insert(gongjiVO);
	}

	@Override
	public List<GongjiVO> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	public GongjiVO selectOne(int id) throws Exception {
		return dao.selectOne(id);
	}

	@Override
	public int update(GongjiVO gongjiVO) throws Exception {
		return dao.update(gongjiVO);
	}

	@Override
	public int delete(int id) throws Exception {
		return dao.delete(id);
	}

}
