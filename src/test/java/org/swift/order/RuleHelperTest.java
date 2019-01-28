package org.swift.order;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Disabled;

public class RuleHelperTest {

	@Test
	public void testGetInstance() {
		assertNotNull(RuleHelper.getInstance());
	}


}
