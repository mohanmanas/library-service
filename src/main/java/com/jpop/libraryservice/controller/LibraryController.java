package com.jpop.libraryservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpop.libraryservice.client.BookServiceClient;
import com.jpop.libraryservice.client.UserServiceClient;
import com.jpop.libraryservice.dto.BookDto;
import com.jpop.libraryservice.dto.UserDto;
import com.jpop.libraryservice.service.LibraryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/library")
@Slf4j
public class LibraryController {

	@Autowired
	BookServiceClient bookServiceClient;

	@Autowired
	UserServiceClient userServiceClient;

	@Autowired
	LibraryService libraryService;

	@RequestMapping("/books")
	public List<BookDto> getAllBooks() {
		log.info("Fetch books from library"); 
		return bookServiceClient.getAllBooks();
	}

	@GetMapping("/books/{book_id}")
	public BookDto getBook(@PathVariable("book_id") int bookId) {
		log.info("Fetch {} book from library", bookId); 
		return bookServiceClient.getBook(bookId);
	}

	@PostMapping("/books/{book_id}")
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto book) {
		log.info("Create book from library"); 
		return bookServiceClient.createBook(book);
	}

	@DeleteMapping("/books/{book_id}")
	public ResponseEntity<BookDto> deleteBook(@PathVariable("book_id") int bookId) {
		log.info("Delete {} book from library", bookId); 
		return bookServiceClient.deleteBook(bookId);
	}

	@GetMapping("/users")
	public List<UserDto> getAllUsers() {
		log.info("Fetch users from library"); 
		return userServiceClient.getAllUsers();
	}

	@GetMapping("/users/{user_id}")
	public UserDto getUser(@PathVariable("user_id") int userId) {
		log.info("Fetch {} users from library", userId); 
		return userServiceClient.getUser(userId);
	}

	@PostMapping("/user/{user_id}")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		log.info("Create user from library"); 
		return userServiceClient.createUser(userDto);
	}

	@DeleteMapping("/user/{user_id}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable("user_id") int userId) {
		log.info("Delete {} user from library", userId); 
		return userServiceClient.deleteUser(userId);
	}

	@PutMapping("/users/{user_id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("user_id") int userId) {
		log.info("Update {} user from library", userId); 
		return userServiceClient.updateUser(userDto, userId);
	}

	@PostMapping("/user/{user_id}/books/{book_id}")
	public ResponseEntity<UserDto> issueBookToUser( @PathVariable("user_id") int userId,  @PathVariable("book_id") int bookId) {
		log.info("Issue {} book to {} user from library", bookId, userId); 
		libraryService.issueBookToUser(userId, bookId);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/user/{user_id}/books/{book_id}")
	public ResponseEntity<UserDto> returnBookFromUser( @PathVariable("user_id") int userId,  @PathVariable("book_id") int bookId) {
		log.info("Return {} book from {} user through library", bookId, userId);
		libraryService.returnBookFromUser(userId, bookId);
		return ResponseEntity.noContent().build();
	}
}
