package com.gb.sb4.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO {

	@NotEmpty
	private String id;
	
	@Length(min=6, max=14)
	private String pw;
	
	// 비밀번호 재확인을 위한 변수 선언
	private String pw2;
	
	@Size(min=3)
	private String name;
	
	@Range(min = 1, max = 200)
	private long age;
	
	@Email
	private String email;
	
	private MemberFileVO memberFileVO;
	
	private List<MemberRoleVO> roles;
}
