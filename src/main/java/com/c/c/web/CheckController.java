package com.c.c.web;

import com.c.c.bean.LotteryHistory;
import com.c.c.service.LhCheckService;
import com.c.c.service.LhNextForNumService;
import com.c.c.service.LotteryHistoryService;
import com.c.c.util.CompareUtil;
import com.c.c.util.ConsulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CheckController {

	@Autowired
	LotteryHistoryService lotteryHistoryService;
	@Autowired
	LhNextForNumService lhNextForNumService;
	@Autowired
	LhCheckService lhCheckService;

	@GetMapping("/check/subAdd33")
	public boolean subAdd33() {
		List<LotteryHistory> lhs = lotteryHistoryService.selectAll();
		Thread t1 = new Thread(() -> {
			lhCheckService.subAdd33(lhs);
		});
		t1.start();
		return true;
	}

	@GetMapping("/check/isSame")
	public boolean isSame() {
		List<LotteryHistory> lhs = lotteryHistoryService.selectAll();
		Thread t1 = new Thread(() -> {
			lhCheckService.isSame(lhs);
		});
		t1.start();
		return true;
	}

}
