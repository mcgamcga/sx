package com.c.c.web;

import com.c.c.service.LhInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/lh")
public class InitController {

	@Autowired
	LhInsertService lotteryHistoryService;

//	@GetMapping("/insertLhb")
//	public boolean insertLhBatch() {
//		Thread t1 = new Thread(() -> {
//			lotteryHistoryService.initLotteryHistory("http://kaijiang.500.com/shtml/ssq/17001.shtml");
//		});
//		t1.start();
//		return true;
//	}

	@GetMapping("/insertNew")
	public boolean insertNew() {
		Thread t1 = new Thread(() -> {
			lotteryHistoryService.insertNew();
		});
		t1.start();
		return true;
	}


}
