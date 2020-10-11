package com.gongji.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gongji.dto.GongjiVO;

@Repository
public class GongjiDaoImpl implements GongjiDao {

	@Inject
	private SqlSession sqlSession;
	private static final String Namespace = "com.gongji.mapper.gongjiMapper";

	@Override
	public int insert(GongjiVO gongjiVO) throws Exception {
		return sqlSession.insert(Namespace + ".insert", gongjiVO);
	}

	@Override
	public List<GongjiVO> selectAll() throws Exception {
		return sqlSession.selectList(Namespace + ".select");
	}

	@Override
	public GongjiVO selectOne(int id) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectOne", id);
	}

	@Override
	public int update(GongjiVO gongjiVO) throws Exception {
		return sqlSession.update(Namespace + ".update", gongjiVO);
	}

	@Override
	public int delete(int id) throws Exception {
		return sqlSession.delete(Namespace + ".delete", id);
	}

}
