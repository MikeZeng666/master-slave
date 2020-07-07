package com.mike.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.demo.annotation.Master;
import com.mike.demo.entity.Member;
import com.mike.demo.mapper.MemberMapper;
import com.mike.demo.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mapper;
	
	@Override
	public int insert(Member member) {
		// TODO Auto-generated method stub
		return mapper.insert(member);
	}

	@Override
	public int save(Member member) {
		// TODO Auto-generated method stub
		return mapper.save(member);
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return mapper.update(member);
	}

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	@Master
	public Member getMember(int id) {
		return mapper.getMember(id);
	}

}
