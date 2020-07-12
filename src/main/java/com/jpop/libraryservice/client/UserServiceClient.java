package com.jpop.libraryservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jpop.libraryservice.client.fallback.UserClientFallBack;
import com.jpop.libraryservice.dto.UserDto;

@FeignClient(name="user-service", fallback = UserClientFallBack.class)
public interface UserServiceClient {

	@GetMapping("/users")
	public List<UserDto> getAllUsers();
	
	@GetMapping("/users/{id}")
	public UserDto getUser(@PathVariable("id") int id);
	
	@PostMapping("/users")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto);
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable int id);
	
	@PutMapping("/users/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable int id);
}
