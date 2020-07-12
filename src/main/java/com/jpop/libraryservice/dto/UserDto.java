package com.jpop.libraryservice.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class UserDto {

	private int userId;
	
	private String userName;
	
	private LocalDate dob;
	
	private String email;
	
	private String phoneNumber;
}
