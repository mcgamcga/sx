package com.c.c.main;

import com.alibaba.druid.sql.visitor.functions.If;


public class Demo {


	public static void main(String[] args) {
		Thread t = new Thread(new De());
		Thread t2 = new Thread(new De());
		t.start();
		t2.start();
	}
}

class De implements Runnable {
	private static int count = 10;
	@Override
	public void run() {
		while (count>0) {
			count = count-5;
			System.out.println(Thread.currentThread().getName()+":"+count);
		}
	}
}
