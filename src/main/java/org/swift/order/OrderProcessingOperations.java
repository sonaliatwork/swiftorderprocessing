package org.swift.order;

import java.util.List;

public interface OrderProcessingOperations {
	void create();

	List<? extends Object> readAll();

	void update();

	void delete();

	Object search();

	void showAll();

	String getFileLocation();

}
