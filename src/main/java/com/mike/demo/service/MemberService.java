package com.mike.demo.service;

import java.util.List;

import com.mike.demo.entity.Member;

public interface MemberService {

	 public int insert(Member member);
	 
	 public int save(Member member);
	 
	 public int update(Member member);
	 
	 public List<Member> selectAll();
	 
	 public Member getMember(int id);
	 
}
