package com.jpop.libraryservice.model;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Library {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int userId;
	
	private int bookId;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	@CreatedBy
	private String createdUser;
	
	@CreatedDate
	private LocalDateTime createdDateTime;
	
	@LastModifiedBy
	private String modifiedUser;
	
	@LastModifiedDate
	private LocalDateTime modifiedDateTime;
	
	@Version
	private long version;
	
	public void setEndDate() {
		this.endDate = LocalDateTime.now();
	}
}
