package com.mike.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.mike.demo.bean.DBContextHolder;

@Aspect
@Component
public class DataSourceAop {

	@Pointcut("!@annotation(com.mike.demo.annotation.Master)"
			+ "&& (execution(* com.mike.demo.service..*.select*(..))"
			+ "|| execution(* com.mike.demo.service..*.get*(..)))")
	public void readPointcut() {
		
	}
	
	@Pointcut("@annotation(com.mike.demo.annotation.Master)"
			+ "|| execution(* com.mike.demo.service..*.insert*(..))"
			+ "|| execution(* com.mike.demo.service..*.add*(..))"
			+ "|| execution(* com.mike.demo.service..*.save*(..))"
			+ "|| execution(* com.mike.demo.service..*.update*(..))"
			+ "|| execution(* com.mike.demo.service..*.edit*(..))"
			+ "|| execution(* com.mike.demo.service..*.modify*(..))"
			+ "|| execution(* com.mike.demo.service..*.delete*(..))"
			+ "|| execution(* com.mike.demo.service..*.remove*(..))")
	public void writePointcut() {
		
	}
	
	@Before("readPointcut()")
	public void read() {
		DBContextHolder.slave();
	}
	
	@Before("writePointcut()")
	public void write() {
		DBContextHolder.master();
	}
}
