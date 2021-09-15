package com.cos.blogapp.web;

import org.junit.jupiter.api.Test;

import com.cos.blogapp.domain.board.Board;

public class BoardControllerTest {
	@Test
	public void 익셉션테스트() {
		try {
			Board b = null;
			System.out.println(b.getContent());
		} catch (Exception e) {  
			System.out.println("오류가 났어요");
			System.out.println(e.getMessage());
			// 여기서 처리하는거 
			
		}
	}
	
	@Test
	public void 익셉션테스트2() throws Exception {
		throw new Exception(); // 함수를 호출하는 애한테 던져줌 디스패쳐서블릿에 던져줌 
		
	}
}
