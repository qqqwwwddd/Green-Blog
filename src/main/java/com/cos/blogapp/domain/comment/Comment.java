package com.cos.blogapp.domain.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cos.blogapp.domain.board.Board;
import com.cos.blogapp.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 테이블 모델
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment {  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //PK (자동증가 번호)
	
	@Column(nullable = false) // Not Null 설정
	private String content;
	
	@JoinColumn(name = "userId") // FK의 컬럼명 정해줌
	@ManyToOne
	private User user;
	
	@JoinColumn(name = "boardId") // FK의 컬럼명 정해줌
	@ManyToOne
	private Board board;
}
