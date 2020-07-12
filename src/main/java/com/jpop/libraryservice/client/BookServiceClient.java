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

import com.jpop.libraryservice.client.fallback.BookClientFallBack;
import com.jpop.libraryservice.dto.BookDto;

@FeignClient(name="book-service", fallback = BookClientFallBack.class)
public interface BookServiceClient {

	@GetMapping("/books")
	public List<BookDto> getAllBooks();
	
	@GetMapping("/books/{id}")
	public BookDto getBook(@PathVariable("id") int id);
	
	@PostMapping
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto book);
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<BookDto> deleteBook(@PathVariable int id);
	
	@PutMapping("/{id}")
	public ResponseEntity<BookDto> updateBook(@RequestBody BookDto book, @PathVariable int id);
}
