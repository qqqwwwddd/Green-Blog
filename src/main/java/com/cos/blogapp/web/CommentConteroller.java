package com.cos.blogapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blogapp.domain.user.User;
import com.cos.blogapp.handler.ex.MyAsyncNotFoundException;
import com.cos.blogapp.service.CommentService;
import com.cos.blogapp.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CommentConteroller {
	
	private final CommentService commentService;
	private final HttpSession session;
	
	
	@DeleteMapping("/api/comment/{id}")
	public @ResponseBody CMRespDto<?> deleteById(@PathVariable int id){
		
		User principal = (User) session.getAttribute("principal");
		if(principal == null) {
			throw new MyAsyncNotFoundException("인증되지 않은 사용자 입니다");
		}
		
		commentService.댓글삭제(id, principal);
		return new CMRespDto<>(1, "성공", null);
	}
}
