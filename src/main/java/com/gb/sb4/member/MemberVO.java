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
	
	@Length(min = 6, max = 12)
	private String pw;
	
	@Size(min=2)
	private String name;
	
	@Range(min = 0, max = 200)
	private long age;
	
	@Email
	private String email;
	
	private List<MemberRoleVO> roles;
}
