package com.jpop.libraryservice.service;


public interface LibraryService {

	public void issueBookToUser(int userId, int bookId);

	public void returnBookFromUser(int userId, int bookId);
}
