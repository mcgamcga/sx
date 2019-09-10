package com.c.c.util;

import com.c.c.enums.CompareNumEnum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompareUtil {

	public static List<Integer> containsNum(int[] arr,int... nus) {
		List<Integer> list = new ArrayList<>();
		for (int i:nus) {
			for(int k:arr) {
				if (k == i) {
					list.add(k);
				}
			}
		}
		return list;
	}

	public static boolean isSame(int[] arr,int... nus) {
		for (int i=0;i<6;i++) {
			if (arr[i] != nus[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean compareNum(int[] arr) {
		int c12 = arr[1] - arr[0];
		if (c12 < CompareNumEnum.c12.getMin() || c12 > CompareNumEnum.c12.getMax()) {
			return false;
		}
		int c13 = arr[2] - arr[0];
		if (c13 < CompareNumEnum.c13.getMin() || c13 > CompareNumEnum.c13.getMax()) {
			return false;
		}
		int c14 = arr[3] - arr[0];
		if (c14 < CompareNumEnum.c14.getMin() || c14 > CompareNumEnum.c14.getMax()) {
			return false;
		}
		int c15 = arr[4] - arr[0];
		if (c15 < CompareNumEnum.c15.getMin() || c15 > CompareNumEnum.c15.getMax()) {
			return false;
		}
		int c16 = arr[5] - arr[0];
		if (c16 < CompareNumEnum.c16.getMin() || c16 > CompareNumEnum.c16.getMax()) {
			return false;
		}
		int c23 = arr[2] - arr[1];
		if (c23 < CompareNumEnum.c23.getMin() || c23 > CompareNumEnum.c23.getMax()) {
			return false;
		}
		int c24 = arr[3] - arr[1];
		if (c24 < CompareNumEnum.c24.getMin() || c24 > CompareNumEnum.c24.getMax()) {
			return false;
		}
		int c25 = arr[4] - arr[1];
		if (c25 < CompareNumEnum.c25.getMin() || c25 > CompareNumEnum.c25.getMax()) {
			return false;
		}
		int c26 = arr[5] - arr[1];
		if (c26 < CompareNumEnum.c26.getMin() || c26 > CompareNumEnum.c26.getMax()) {
			return false;
		}
		int c34 = arr[3] - arr[2];
		if (c34 < CompareNumEnum.c34.getMin() || c34 > CompareNumEnum.c34.getMax()) {
			return false;
		}
		int c35 = arr[4] - arr[2];
		if (c35 < CompareNumEnum.c35.getMin() || c35 > CompareNumEnum.c35.getMax()) {
			return false;
		}
		int c36 = arr[5] - arr[2];
		if (c36 < CompareNumEnum.c36.getMin() || c36 > CompareNumEnum.c36.getMax()) {
			return false;
		}
		int c45 = arr[4] - arr[3];
		if (c45 < CompareNumEnum.c45.getMin() || c45 > CompareNumEnum.c45.getMax()) {
			return false;
		}
		int c46 = arr[5] - arr[3];
		if (c46 < CompareNumEnum.c46.getMin() || c46 > CompareNumEnum.c46.getMax()) {
			return false;
		}
		int c56 = arr[5] - arr[4];
		if (c56 < CompareNumEnum.c56.getMin() || c56 > CompareNumEnum.c56.getMax()) {
			return false;
		}
		return true;
	}


	public static boolean compareHis(int[] arr) {
		if (arr[0] < CompareNumEnum.hisOne.getMin() || arr[0] > CompareNumEnum.hisOne.getMax()) {
			return false;
		}
		if (arr[1] < CompareNumEnum.hisTwo.getMin() || arr[1] > CompareNumEnum.hisTwo.getMax()) {
			return false;
		}
		if (arr[2] < CompareNumEnum.hisThree.getMin() || arr[2] > CompareNumEnum.hisThree.getMax()) {
			return false;
		}
		if (arr[3] < CompareNumEnum.hisFour.getMin() || arr[3] > CompareNumEnum.hisFour.getMax()) {
			return false;
		}
		if (arr[4] < CompareNumEnum.hisFive.getMin() || arr[4] > CompareNumEnum.hisFive.getMax()) {
			return false;
		}
		if (arr[5] < CompareNumEnum.hisSix.getMin() || arr[5] > CompareNumEnum.hisSix.getMax()) {
			return false;
		}
		return true;
	}


	public static boolean compareSum(int[] arr) {
		int i = 0;
		for (int k:arr) {
			i += k;
		}
		if (i < CompareNumEnum.hisSum.getMin() || i > CompareNumEnum.hisSum.getMax()) {
			return false;
		}
		return true;
	}

	public static boolean compare358(int[] arr) {
		for (int i=0;i<arr.length;i++) {
			if (String.valueOf(arr[i]).length() == 1) {
				if (son358(arr[i])) {
					return true;
				}
			} else {
				int two = Integer.valueOf(String.valueOf(arr[i]).split("")[1]);
				if (son358(two)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean son358(int num) {
		return num == 3 || num == 5 || num == 8;
	}

	public static boolean isArrContains(int[] arr,int num) {
		List<Integer> nums = new ArrayList<>();
		for (int i = 0;i < arr.length;i++) {
			nums.add(arr[i]);
		}
		return nums.contains(num);
	}

	public static boolean isArrSameLength(int[] arr,int[] arr2) {
		for (int j=0;j<arr.length;j++) {
			if (arr[j] != arr2[j]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSameOfOne(int... arr) {
		Set<Integer> set = new HashSet<>();
		for (int i:arr) {
			set.add(i);
		}
		return set.size() != arr.length;
	}

	public static boolean allVali(int[] arr) {
		return CompareUtil.compareHis(arr) && CompareUtil.compareNum(arr)
				&& CompareUtil.compareSum(arr);
	}

	public static void main(String[] args) {
		int [] arr = {1, 6, 11, 23, 29, 30};
		System.out.println(CompareUtil.compare358(arr));
	}
}
