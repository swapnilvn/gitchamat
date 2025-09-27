package com.mongo.crud;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MongoCrudApplicationTests {

	@Mock
	ManiRepository maniRepository;

	@Mock
	MongoTemplate mongoTemplate;

	@InjectMocks
	ManiServiceImpl maniServiceImpl;

	@Test
	void getManiByNameTest() {
		when(maniRepository.findByName(anyString()))
				.thenReturn(Mani.builder().id("99").name("swapnil").email("abc@gmail.com").phone("1234567890").address("pune").build());
		Mani mani = maniServiceImpl.getManiByName("pagal");
		assert(mani.getName().equals("swapnil"));
	}

	@Test
	void getManiByStoreTest() {
		String storeKey = "store123";
		Mani mani = Mani.builder().id("99").name("swapnil").email("abc@gmail.com").phone("1234567890").address("pune").storeKeys(List.of("pune")).build();
		List<Mani> expectedList = List.of(mani);

		when(mongoTemplate.find(any(Query.class), eq(Mani.class)))
				.thenReturn(expectedList);

		assertEquals(1, maniServiceImpl.getManiByStore(storeKey).size());
	}

}
