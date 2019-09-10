package com.c.c.web;

import com.c.c.bean.LotteryHistory;
import com.c.c.service.LhNextForNumService;
import com.c.c.service.LotteryHistoryService;
import com.c.c.util.CompareUtil;
import com.c.c.util.ConsulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.util.resources.cldr.ne.LocaleNames_ne;

import java.util.Arrays;
import java.util.List;


@RestController
public class NextController {

	@Autowired
	LhNextForNumService lhNextForNumService;
	@Autowired
	LotteryHistoryService lotteryHistoryService;

	@GetMapping("/next/{id}/{nextId}/{count}/{dis}/{del}")
	public boolean getNext(@PathVariable String id,@PathVariable String nextId,
						   @PathVariable int count,@PathVariable boolean dis,
						   @PathVariable int[] del) {
		Thread t1 = new Thread(() -> {
			boolean flag = true;
			int count4 = 0;
			int count5 = 0;
			int count6 = 0;
			LotteryHistory lhNext = lotteryHistoryService.selectById(nextId);
			for (int i=0;i<count;i++) {
				int[] arr = lhNextForNumService.getRandomOfNexHistory(dis,id,del);
				System.out.println(i+1);
				System.out.print(Arrays.toString(arr));
				List<Integer> containsNums = CompareUtil.containsNum(arr,lhNext.beanToArray());
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
						break;
				}
			}
			System.out.println("count4:"+count4+",count5:"+count5+",count6:"+count6);
		});
		t1.start();
		return true;
	}


}
