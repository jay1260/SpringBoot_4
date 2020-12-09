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
	
	@Length(min=8, max=14)
	private String pw;
	
	@Size(min=3)
	private String name;
	
	@Range(min = 1, max = 200)
	private long age;
	
	@Email
	private String email;
	
	private List<MemberRoleVO> roles;
}
