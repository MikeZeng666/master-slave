package com.mike.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mike.demo.entity.Member;

@Repository
public interface MemberMapper {

	 public int insert(Member member);
	 
	 public int save(Member member);
	 
	 public int update(Member member);
	 
	 public List<Member> selectAll();
	 
	 public Member getMember(int id);
}
