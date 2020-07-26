package com.jpop.libraryservice.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookDto {

	private int bookId;
	
	private String bookName;
	
	private String author;
	
	private BigDecimal price;
	
	private int publishedYear;
	
	private int bookCount;
	
	private BigDecimal pricePerDay;
}
