package com.mike.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mike.demo.DemoApplication;
import com.mike.demo.entity.Member;
import com.mike.demo.service.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class DemoTest {

	@Autowired
    private MemberService memberService;

    @Test
    public void testWrite() {
        Member member = new Member();
        member.setId(2);
        member.setName("zhangsan");
        System.out.println("before testWrite insert");
        int result = memberService.insert(member);
        System.out.println("after testWrite insert， result = " + result);
    }

    @Test
    public void testRead() {
    	System.out.println("before testRead selectAll");
        memberService.selectAll();
        System.out.println("after testRead selectAll");
    }

    @Test
    public void testSave() {
        Member member = new Member();
        member.setId(3);
        member.setName("wangwu");
        System.out.println("before testSave save");
        int result = memberService.save(member);
        System.out.println("after testSave save， result = " + result);
    }
    
    @Test
    public void testReadFromMaster() {
    	System.out.println("before testReadFromMaster getMember");
        memberService.getMember(2);
        System.out.println("after testReadFromMaster getMember");
    }
    
    @Test
    public void testUpdate() {
    	Member member = new Member();
    	member.setId(1);
    	member.setName("testUpdate");
    	System.out.println("before testUpdate update");
    	int result = memberService.update(member);
    	System.out.println("after testUpdate update， result = " + result);
    }
}
