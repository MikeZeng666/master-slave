package com.mike.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mike.demo.entity.Member;
import com.mike.demo.service.MemberService;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
 
    @RequestMapping("/getUser/{id}")
    public String getUser(@PathVariable int id){
        return memberService.getMember(id).toString();
    }
    
    @RequestMapping("/getUsers")
    public String getUsers(){
    	StringBuffer sb = new StringBuffer();
    	for(Member member : memberService.selectAll()) {
    		sb.append(member.toString()).append("\r\n");
    	}
    	
    	return sb.toString();
    }
}
