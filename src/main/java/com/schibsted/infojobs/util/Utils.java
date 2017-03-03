package com.schibsted.infojobs.util;

import java.util.function.Supplier;

public class Utils {

	private Utils() {

	}

	public static void print(Supplier<Object> supplier) {
		System.out.println(supplier.get());
	}
}
