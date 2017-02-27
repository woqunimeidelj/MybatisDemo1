package com.ittx.mybatis.model;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ittx.mybatis.dao.UserDao;
import com.ittx.mybatis.model.User;

public class UserTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void before() throws IOException {
		Reader reader = Resources.getResourceAsReader("Configuration.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	@Test
	public void test() throws IOException {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			//User user =  sqlSession.selectOne("UserMapper.selectUserById", 1);
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			User user =  userDao.selectUserByID(1);
	
			System.out.println(user);
			
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
	}
	
	@Test
	public void testInsertUser() {
		SqlSession sqlSession = null;
		try {
		User user = new User("小五",22);
		sqlSession = sqlSessionFactory.openSession();
		// sqlSession.insert("UserMapper.insertUser", user);
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		userDao.insertUser(user);
		sqlSession.commit();
		
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testDeleteUserById() {
		SqlSession sqlSession = null;
		try {
		sqlSession = sqlSessionFactory.openSession();
		// sqlSession.delete("UserMapper.deleteUserById", 5);
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		userDao.deleteUserById(5);
		sqlSession.commit();
		
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testUpdateUser() {
		SqlSession sqlSession = null;
		try {
		User user = new User(1,"王欢",18);
		sqlSession = sqlSessionFactory.openSession();
		// sqlSession.update("UserMapper.updateUser", user);
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		userDao.updateUser(user);
		sqlSession.commit();
		
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}

}
