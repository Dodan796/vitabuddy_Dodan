/*
 * package com.example.vitabuddy.mapper; import
 * com.example.vitabuddy.model.User; import
 * org.apache.ibatis.annotations.Mapper; import
 * org.apache.ibatis.annotations.Select; import
 * org.apache.ibatis.annotations.Insert;
 * 
 * @Mapper public interface UserMapper { // User 정보를 ID로 조회하는 쿼리
 * 
 * @Select("SELECT * FROM users WHERE id = #{id}") User selectUser(int id); //
 * User 정보를 삽입하는 쿼리
 * 
 * @Insert("INSERT INTO users (id, name, email) VALUES (#{id}, #{name}, #{email})"
 * ) void insertUser(User user); }
 */