package com.springmvc.filters;

import com.springmvc.filters.rd.FilterInterface;

public class FilterClass {

	public String getCurrentSessionId() {
		// return () -> FilterInterface.getSession();
		return null;

	}

	public static void main(String[] args) {
		System.out.println(new FilterClass().getCurrentSessionId());
	}

}
