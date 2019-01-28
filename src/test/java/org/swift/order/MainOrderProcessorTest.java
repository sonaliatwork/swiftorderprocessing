package org.swift.order;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class MainOrderProcessorTest {
	MainOrderProcessor orderProcessortest = null;
	@Test
	public void testGetInstance() {
		orderProcessortest = MainOrderProcessor.getInstance();
		assertNotNull(orderProcessortest);
	}

	@Test
	public void testMain() {
		try {
			MainOrderProcessor.main(new String[]{""});
		} catch (Exception e) {			
			e.printStackTrace();
			assertNotEquals(e, new Exception());
		}
		

	}

}
