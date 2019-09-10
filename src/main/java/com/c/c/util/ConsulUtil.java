package com.c.c.util;

public class ConsulUtil {

	public static void redOut(Object t) {
		System.out.println("\033[31;4m"+ t.toString() + "\033[0m");
	}

	public static void blueOut(Object t) {
		System.out.println("\033[34;4m"+ t.toString() + "\033[0m");
	}

	public static void greenOut(Object t) {
		System.out.println("\033[36;4m"  +  t.toString() + "\033[0m");
	}

	public static void main(String[] args) {
		String s = "[23232,2342342,234]";
		ConsulUtil.redOut(s);
		ConsulUtil.greenOut(s);
		ConsulUtil.blueOut(s);
	}
}
