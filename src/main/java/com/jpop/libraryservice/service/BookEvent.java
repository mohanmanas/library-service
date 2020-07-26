package com.jpop.libraryservice.service;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BookEvent {

	private int bookId;
	
	private boolean bookAssigned;
}
