package com.jpop.libraryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpop.libraryservice.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer>{

	public Library findByUserIdAndBookId(int userId, int bookId);
}
