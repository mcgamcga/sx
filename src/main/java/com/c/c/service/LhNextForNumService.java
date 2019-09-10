package com.c.c.service;

import com.c.c.bean.LotteryHistory;
import com.c.c.dao.LotteryHistoryDao;
import com.c.c.util.CompareUtil;
import org.hibernate.validator.internal.engine.messageinterpolation.InterpolationTermType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.font.NumericShaper;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class LhNextForNumService {

	@Autowired
	LotteryHistoryService lotteryHistoryService;

	private static Map<Integer,List<Integer>> dismap;
	private static Map<Integer,List<Integer>> nomap;
	private static int[] NUMS;
	private static int[] DELNUMS;


	public int[] getRandomOfNexHistory(boolean isdist,String id,int[] delNums) {
		LotteryHistory lh = lotteryHistoryService.selectById(id);
		Map<Integer,List<Integer>> map = initMap(isdist, lh, delNums);
		Random r = new Random();
		boolean flag = true;
		int[] arr = null;
		while (flag) {
			arr = new int[6];
			for (int i=0;i<map.size();i++) {
				int num = r.nextInt(map.get(i).size());
				num = map.get(i).get(num);
				arr[i] = num;
			}
			Arrays.sort(arr);
			if (CompareUtil.allVali(arr) && !CompareUtil.isSameOfOne(arr)
					&& CompareUtil.compare358(arr)) {
				flag = false;
			}
		}
		return arr;
	}

	private Map<Integer,List<Integer>> initMap(boolean isdist,LotteryHistory lh,int[] del) {
		if (nomap == null || (NUMS != null && NUMS[0] != lh.getRedOne())
				|| del.length != DELNUMS.length) {
			List<Integer> one =	lotteryHistoryService.selectAllRedDown(lh.getRedOne(),lh.getId(),1);
			List<Integer> two = lotteryHistoryService.selectAllRedDown(lh.getRedTwo(),lh.getId(),2);
			List<Integer> three = lotteryHistoryService.selectAllRedDown(lh.getRedThree(),lh.getId(),3);
			List<Integer> four = lotteryHistoryService.selectAllRedDown(lh.getRedFour(),lh.getId(),4);
			List<Integer> five = lotteryHistoryService.selectAllRedDown(lh.getRedFive(),lh.getId(),5);
			List<Integer> six = lotteryHistoryService.selectAllRedDown(lh.getRedSix(),lh.getId(),6);
			if (del.length > 0) {
				one = remove(one,del);
				two = remove(two,del);
				three = remove(three,del);
				four = remove(four,del);
				five = remove(five,del);
				six = remove(six,del);
			}
			setMap(nomap = new HashMap<>(), one,two,three,four,five,six);
			setMap(dismap = new HashMap<>(),
					one.stream().distinct().collect(Collectors.toList()),
					two.stream().distinct().collect(Collectors.toList()),
					three.stream().distinct().collect(Collectors.toList()),
					four.stream().distinct().collect(Collectors.toList()),
					five.stream().distinct().collect(Collectors.toList()),
					six.stream().distinct().collect(Collectors.toList()));
			NUMS = lh.beanToArray();
			DELNUMS = del;
		}
		return isdist == true ? dismap : nomap;
	}

	private List<Integer> remove(List<Integer> list,int[] del) {
		List<Integer> newList = new ArrayList<>();
		for (int k=0;k<list.size();k++) {
			boolean flag = CompareUtil.isArrContains(del,list.get(k));
			if (!flag) {
				newList.add(list.get(k));
			}
		}
		return newList;
	}

	private void setMap(Map<Integer,List<Integer>> map, List... nums) {
		for (int i=0;i<nums.length;i++) {
			map.put(i,nums[i]);
		}
	}

}
