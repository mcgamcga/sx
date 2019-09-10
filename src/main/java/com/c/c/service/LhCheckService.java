package com.c.c.service;

import com.c.c.bean.LotteryHistory;
import com.c.c.util.CompareUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LhCheckService {

	public void subAdd33(List<LotteryHistory> lhs) {
		int count = 0;
		int num = 0;
		for(int i=0;i<lhs.size();i++) {
			LotteryHistory lh = lhs.get(i);
			num += numAdd(lh.getRedOne());
			num += numAdd(lh.getRedTwo());
			num += numAdd(lh.getRedThree());
			num += numAdd(lh.getRedFour());
			num += numAdd(lh.getRedFive());
			num += numAdd(lh.getRedSix());
			if (num > 33) {
				num = num - 33;
			}
			if (num < 33) {
				num = 33 - num;
			}
			if (i <= lhs.size()-2) {
				boolean l = CompareUtil.isArrContains(lhs.get(i+1).beanToArray(),num);
				if (!l) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private int numAdd(Integer num) {
		if (num.toString().length() == 1) {
			return num;
		} else {
			int one = Integer.valueOf(num.toString().split("")[0]);
			int two = Integer.valueOf(num.toString().split("")[1]);
			return one+two;
		}
	}

	public void isSame(List<LotteryHistory> lhs) {
		int count = 0;
		for (int i=0;i<lhs.size();i++) {
			for (int k=i+1;k<lhs.size();k++) {
				if (CompareUtil.isArrSameLength(lhs.get(i).beanToArray(), lhs.get(k).beanToArray())) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
