package com.jpop.libraryservice.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jpop.libraryservice.client.BookServiceClient;
import com.jpop.libraryservice.client.UserServiceClient;
import com.jpop.libraryservice.dto.BookDto;
import com.jpop.libraryservice.dto.UserDto;

@RestController
@RequestMapping(value="/library")
public class LibraryController {

	@Autowired
	BookServiceClient bookServiceClient;
	
	@Autowired
	UserServiceClient userServiceClient;

	@RequestMapping("/books")
	public List<BookDto> getAllBooks() {
		return bookServiceClient.getAllBooks();
	}
	
	@GetMapping("/books/{book_id}")
	public BookDto getBook(@PathVariable("book_id") int bookId) {
		return bookServiceClient.getBook(bookId);
	}
	
	@PostMapping("/books/{book_id}")
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto book) {
		return bookServiceClient.createBook(book);
	}
	
	@DeleteMapping("/books/{book_id}")
	public ResponseEntity<BookDto> deleteBook(@PathVariable("book_id") int id) {
		return bookServiceClient.deleteBook(id);
	}
	
	@GetMapping("/users")
	public List<UserDto> getAllUsers() {
		return userServiceClient.getAllUsers();
	}
	
	@GetMapping("/users/{user_id}")
	public UserDto getUser(@PathVariable("user_id") int id) {
		return userServiceClient.getUser(id);
	}
	
	@PostMapping("/user/{user_id}")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		return userServiceClient.createUser(userDto);
	}
	
	@DeleteMapping("/user/{user_id}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable("user_id") int id) {
		return userServiceClient.deleteUser(id);
	}
	
	@PutMapping("/users/{user_id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("user_id") int id) {
		return userServiceClient.updateUser(userDto, id);
	}
}
