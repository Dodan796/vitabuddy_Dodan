package com.example.vitabuddy.service;

import com.example.vitabuddy.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private SqlSession sqlSession;

	public User getUserById(int id) {
		// XML에서 정의된 selectUser 쿼리 호출
		return sqlSession.selectOne("UserMapper.selectUser", id);
	}

	public void insertUser(User user) {
		// XML에서 정의된 insertUser 쿼리 호출
		sqlSession.insert("UserMapper.insertUser", user);
	}
}