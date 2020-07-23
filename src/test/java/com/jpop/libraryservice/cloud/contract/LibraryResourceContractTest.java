package com.jpop.libraryservice.cloud.contract;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jpop.libraryservice.LibraryServiceApplication;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryServiceApplication.class)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(stubsMode = StubsMode.LOCAL, ids = {"com.jpop:book-service:0.0.1-SNAPSHOT:8096" })
public class LibraryResourceContractTest {
	@Autowired
	private MockMvc mockMvc;

	public void validate_get_all_books_contract() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/books"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
			.andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(2)))
			
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].bookId",is(100)))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].bookName",is("book")))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].author",is("Camille")))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].price",is("1000")))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].publishedYear",is("2015")))
			
			.andExpect(MockMvcResultMatchers.jsonPath("$[1].bookId",is(101)))
			.andExpect(MockMvcResultMatchers.jsonPath("$[1].bookName",is("Book1")))
			.andExpect(MockMvcResultMatchers.jsonPath("$[1].author",is("Davina")))
			.andExpect(MockMvcResultMatchers.jsonPath("$[1].price",is("500")))
			.andExpect(MockMvcResultMatchers.jsonPath("$[1].publishedYear",is("1996")));
	}
}
