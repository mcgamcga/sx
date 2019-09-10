package com.c.c.bean;


public class LotteryHistory {

	private String id;
	private Integer redOne;
	private Integer redTwo;
	private Integer redThree;
	private Integer redFour;
	private Integer redFive;
	private Integer redSix;
	private Integer blueOne;

	public int[] beanToArray() {
		int[] nums = {this.redOne,this.redTwo,this.redThree,this.redFour,this.redFive,this.redSix};
		return nums;
	}

	public LotteryHistory() {
	}

	public LotteryHistory(String id, Integer redOne, Integer redTwo, Integer redThree, Integer redFour, Integer redFive, Integer redSix, Integer blueOne) {
		this.id = id;
		this.redOne = redOne;
		this.redTwo = redTwo;
		this.redThree = redThree;
		this.redFour = redFour;
		this.redFive = redFive;
		this.redSix = redSix;
		this.blueOne = blueOne;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getRedOne() {
		return redOne;
	}

	public void setRedOne(Integer redOne) {
		this.redOne = redOne;
	}

	public Integer getRedTwo() {
		return redTwo;
	}

	public void setRedTwo(Integer redTwo) {
		this.redTwo = redTwo;
	}

	public Integer getRedThree() {
		return redThree;
	}

	public void setRedThree(Integer redThree) {
		this.redThree = redThree;
	}

	public Integer getRedFour() {
		return redFour;
	}

	public void setRedFour(Integer redFour) {
		this.redFour = redFour;
	}

	public Integer getRedFive() {
		return redFive;
	}

	public void setRedFive(Integer redFive) {
		this.redFive = redFive;
	}

	public Integer getRedSix() {
		return redSix;
	}

	public void setRedSix(Integer redSix) {
		this.redSix = redSix;
	}

	public Integer getBlueOne() {
		return blueOne;
	}

	public void setBlueOne(Integer blueOne) {
		this.blueOne = blueOne;
	}

	@Override
	public String toString() {
		return "LotteryHistory{" +
				"id='" + id + '\'' +
				", redOne=" + redOne +
				", redTwo=" + redTwo +
				", redThree=" + redThree +
				", redFour=" + redFour +
				", redFive=" + redFive +
				", redSix=" + redSix +
				", blueOne=" + blueOne +
				'}';
	}
}
