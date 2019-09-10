package com.c.c.main;

import com.c.c.util.CompareUtil;
import com.c.c.util.ConsulUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Chuisuiji {

	public static void main(String[] args) {
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		for (int k=0;k<500;k++) {
			Random r = new Random();
			int[] arr = new int[6];
			List<Integer> list = new ArrayList<>();
			for (int i=0;i<6;i++) {
				int c = r.nextInt(33)+1;
				if(list.contains(c)) {
					i--;
					continue;
				}
				list.add(c);
				arr[i] = c;
			}
			Arrays.sort(arr);
//			if (arr[0]>9) {
//				k--;
//				continue;
//			}
			if (!CompareUtil.compareNum(arr)/* || !CompareUtil.compareHis(arr)
					|| !CompareUtil.compareSum(arr)*/) {
				k--;
				continue;
			}
			System.out.print(Arrays.toString(arr));
//			System.out.print(r.nextInt(16)+1);
			List<Integer> containsNums = CompareUtil.containsNum(arr,9,15,19,21,23,29);
			switch (containsNums.size()) {
				case 4 :
					count4++;
					ConsulUtil.greenOut(containsNums);
					break;
				case 5 :
					count5++;
					ConsulUtil.blueOut(containsNums);
					break;
				case 6:
					count6++;
					ConsulUtil.redOut(containsNums);
					break;
				default:
					System.out.println(containsNums.toString());
			}
			System.out.println(k);
		}
		System.out.println("count4:"+count4+",count5:"+count5+",count6:"+count6);
	}
}
