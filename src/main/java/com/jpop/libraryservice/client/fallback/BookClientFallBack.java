package com.jpop.libraryservice.client.fallback;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jpop.libraryservice.client.BookServiceClient;
import com.jpop.libraryservice.dto.BookDto;

@Service
public class BookClientFallBack implements BookServiceClient{

	@Override
	public List<BookDto> getAllBooks() {
		return Arrays.asList(BookDto.builder()
				.bookId(1000)
				.bookName("Dummy Book1")
				.author("Dummy author1")
				.publishedYear(2020)
				.build(),
				BookDto.builder()
				.bookId(1001)
				.bookName("Dummy Book2")
				.author("Dummy author2")
				.publishedYear(2020)
				.build());
	}

	@Override
	public BookDto getBook(int id) {
		return BookDto.builder()
				.bookId(1000)
				.bookName("Dummy Book")
				.author("Dummy author")
				.publishedYear(2020)
				.build();
	}

	@Override
	public ResponseEntity<BookDto> createBook(BookDto book) {
		return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
	}

	@Override
	public ResponseEntity<BookDto> deleteBook(int id) {
		return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
	}

	@Override
	public ResponseEntity<BookDto> updateBook(BookDto book, int id) {
		return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
	}

}
