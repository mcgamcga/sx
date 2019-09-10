package com.c.c.service;

import com.c.c.bean.LotteryHistory;
import com.c.c.dao.LotteryHistoryDao;
import com.c.c.util.JsoupUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class LhInsertService {

	private Logger logger = LoggerFactory.getLogger(LhInsertService.class);

	@Autowired
	LotteryHistoryService lotteryHistoryService;

	public boolean insertNew() {
		LotteryHistory lhb = lotteryHistoryService.selectMax();
		String url = "http://kaijiang.500.com/shtml/ssq/" + lhb.getId() + ".shtml";
		Document doc = null;
		try {
			doc = JsoupUtil.getContext(url);
			Elements ele = doc.getElementsByClass("iSelectBox");
			Elements as = ele.get(0).select("a");
			for(Element e:as) {
				String hrefV = e.attr("href");
				if(hrefV.equals("javascript:void(0)") || e.text().equals("17001")) {
					continue;
				}
				if (Integer.valueOf(e.text()) <= Integer.valueOf(lhb.getId())) {continue;}
				insert(doc,hrefV,e);
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 解析
	 * @param doc
	 * @param hrefV
	 * @param e
	 * @throws IOException
	 */
	private void insert(Document doc,String hrefV,Element e) throws IOException {
		System.out.println(hrefV);
		doc = JsoupUtil.getContext(hrefV);
		Elements ball_box01 = doc.getElementsByClass("ball_box01");
		Element ul = ball_box01.get(0).getElementsByTag("ul").get(0);
		Elements lis = ul.getElementsByTag("li");
		List<Integer> lottery = new ArrayList<>();
		LotteryHistory lh = new LotteryHistory();
		lh.setId(e.text());
		for(Element li:lis) {
			if (lh.getRedOne() == null || lh.getRedOne() == 0) {
				lh.setRedOne(Integer.valueOf(li.text()));
				continue;
			}
			if (lh.getRedTwo() == null || lh.getRedTwo() == 0) {
				lh.setRedTwo(Integer.valueOf(li.text()));
				continue;
			}
			if (lh.getRedThree() == null || lh.getRedThree() == 0) {
				lh.setRedThree(Integer.valueOf(li.text()));
				continue;
			}
			if (lh.getRedFour() == null || lh.getRedFour() == 0) {
				lh.setRedFour(Integer.valueOf(li.text()));
				continue;
			}
			if (lh.getRedFive() == null || lh.getRedFive() == 0) {
				lh.setRedFive(Integer.valueOf(li.text()));
				continue;
			}
			if (lh.getRedSix() == null || lh.getRedSix() == 0) {
				lh.setRedSix(Integer.valueOf(li.text()));
				continue;
			}
			if (lh.getBlueOne() == null || lh.getBlueOne() == 0) {
				lh.setBlueOne(Integer.valueOf(li.text()));
				continue;
			}
		}
		lotteryHistoryService.insert(lh);
		System.out.println(lh.toString());
	}

	public boolean initLotteryHistory(String url) {
		Document doc = null;
		try {
			doc = JsoupUtil.getContext(url);
			Elements ele = doc.getElementsByClass("iSelectBox");
			Elements as = ele.get(0).select("a");
			for(Element e:as) {
				String hrefV = e.attr("href");
				if(hrefV.equals("javascript:void(0)") || e.text().equals("17001")) {
					continue;
				}
				insert(doc,hrefV,e);
			}
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
