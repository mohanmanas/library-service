package com.jpop.libraryservice.client.fallback;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jpop.libraryservice.client.UserServiceClient;
import com.jpop.libraryservice.dto.BookDto;
import com.jpop.libraryservice.dto.UserDto;

@Service
public class UserClientFallBack implements UserServiceClient{

	@Override
	public List<UserDto> getAllUsers() {
		return Arrays.asList(UserDto.builder()
				.userId(500)
				.userName("Klaus")
				.dob(LocalDate.of(1995, 07, 03))
				.email("klaus@gmail.com")
				.phoneNumber("9999999999")
				.build(),
				UserDto.builder()
				.userId(500)
				.userName("Marcel")
				.dob(LocalDate.of(1997, 04, 25))
				.email("marcel@gmail.com")
				.phoneNumber("9999999899")
				.build());
	}

	@Override
	public UserDto getUser(int id) {
		return UserDto.builder()
				.userId(500)
				.userName("Marcel")
				.dob(LocalDate.of(1997, 04, 25))
				.email("marcel@gmail.com")
				.phoneNumber("9999999899")
				.build();
	}

	@Override
	public ResponseEntity<UserDto> createUser(UserDto userDto) {
		return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
	}

	@Override
	public ResponseEntity<UserDto> deleteUser(int id) {
		return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
	}

	@Override
	public ResponseEntity<UserDto> updateUser(UserDto userDto, int id) {
		return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
	}
}
