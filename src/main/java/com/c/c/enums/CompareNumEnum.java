package com.c.c.enums;


public enum CompareNumEnum {
	c12(1,25), c13(2,26 ), c14(3,30),
	c15(4,31), c16(7,32 ), c23(1,23), c24(2,27), c25(3,29),
	c26(5,31), c34(1,23), c35(2,27), c36(3,30),
	c45(1,23), c46(2,27), c56(1,25),

	hisOne(1,24),hisTwo(2,28),hisThree(3,29),hisFour(5,31),
	hisFive(7,32),hisSix(11,33),

	hisSum(41,170),
	;
	private int min;
	private int max;

	private CompareNumEnum(int min,int max) {
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
}
