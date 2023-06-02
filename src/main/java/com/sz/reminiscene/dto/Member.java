package com.sz.reminiscene.dto;

import java.sql.Date;

import lombok.*;

/*
 * Member DTO
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String id;
	private String pw;
	private String nickname;
	private String email;
	private int enabled;
	private Date enrollDate;
	private String authority;
}