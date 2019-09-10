package com.c.c.service;

import com.c.c.bean.LotteryHistory;
import com.c.c.dao.LotteryHistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class LotteryHistoryService {

	@Autowired
	LotteryHistoryDao lotteryHistoryDao;



	public int insert(LotteryHistory lotteryHistory) {
		return lotteryHistoryDao.insert(lotteryHistory);
	}

	public LotteryHistory selectMax() {
		return lotteryHistoryDao.selectMax();
	}

	public List<LotteryHistory> selectAll() {
		return lotteryHistoryDao.selectAll();
	}

	public LotteryHistory selectById(String id) {
		return lotteryHistoryDao.selectById(id);
	}

	public List<Integer> selectAllRedDown(int num, String id, int location) {
		Map map = new HashMap();
		map.put("num",num);
		map.put("id",Integer.valueOf(id));
		map.put("location",location);
		List<Integer> ids = lotteryHistoryDao.selectRedListOfAppointDown(map);
		List<LotteryHistory> lhs = lotteryHistoryDao.selectAllDownFromId(ids);
		List<Integer> numList = lhs.stream().collect(ArrayList::new,(list,lh)->{
			if (location == 1) {
				list.add(lh.getRedOne());
			} else if (location == 2) {
				list.add(lh.getRedTwo());
			} else if(location == 3) {
				list.add(lh.getRedThree());
			} else if(location == 4) {
				list.add(lh.getRedFour());
			} else if(location == 5) {
				list.add(lh.getRedFive());
			} else if(location == 6) {
				list.add(lh.getRedSix());
			}
		},ArrayList::addAll);
		return numList;
	}

	public List<LotteryHistory> selectByRedAll(int[] arr) {
		Map<String,Integer> map = new HashMap<>();
		map.put("one",arr[0]);
		map.put("two",arr[1]);
		map.put("three",arr[2]);
		map.put("four",arr[3]);
		map.put("five",arr[4]);
		map.put("six",arr[5]);
		return lotteryHistoryDao.selectByRedAll(map);
	}
}
