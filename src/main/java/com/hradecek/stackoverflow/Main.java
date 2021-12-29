package com.hradecek.stackoverflow;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		final DataFrame df = new DataFrame();
		fillTestData(df);

		System.out.println(df.query("City", "Yankton"::equals));
		System.out.println(df.query("LatS", entry -> ((Integer) entry) > 58));
		System.out.println(df.query("LatM", entry -> ((Integer) entry) >= 16 && ((Integer) entry < 36)));
	}

	private static void fillTestData(DataFrame dataFrame) {
		dataFrame.setData("LatS", Arrays.asList(59, 48, 59, 12, 48));
		dataFrame.setData("LatD", Arrays.asList(41, 42, 46, 42));
		dataFrame.setData("EW", Arrays.asList("W", "W", "W", "W"));
		dataFrame.setData("NS", Arrays.asList("N", "N", "N", "N"));
		dataFrame.setData("LonM", Arrays.asList(39, 23, 30, 48));
		dataFrame.setData("State", Arrays.asList("OH", "SD", "WA", "MA"));
		dataFrame.setData("LatM", Arrays.asList(5, 52, 35, 16));
		dataFrame.setData("City", Arrays.asList("Youngstown", "Yankton", "Yakima", "Worcester"));
		dataFrame.setData("LonS", Arrays.asList(0, 23, 36, 0));
		dataFrame.setData("LonD", Arrays.asList(80, 97, 120, 71));
	}
}
