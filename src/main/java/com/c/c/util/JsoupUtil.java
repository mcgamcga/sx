package com.c.c.util;

import com.c.c.enums.UserAgentEnum;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsoupUtil {
	
	private static final String USER_AGENT = "User-Agent";
	private static String URL_STATIC = "";
	private static Document DOC_STATIC = null;

	public static Document getContext(String url) throws IOException {
		if(url.equals(URL_STATIC)) {
			return DOC_STATIC;
		}
		Connection conn = Jsoup.connect(url);
		conn.header(USER_AGENT, UserAgentEnum.CHORME.getDesc());
		conn.header("Connection", "keep-alive");
		conn.header("Accept-Encoding", "gzip, deflate");
		conn.header("Accept-Language", "zh-CN,zh;q=0.9");
		conn.header("Cookie", "seo_key=baidu%7C%7Chttps://www.baidu.com/link?url=iDaB7SKEsXGtyty8wcx6wDCX8G7qb_n8EQR7GtprhEEwRZcBTXY4pxydiU0yXwWQUzx3hhchnVkOubpN_kDzS_&wd=&eqid=b47a4eb1000699a3000000025c85bf39; __utmz=63332592.1552269133.2.2.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; ck_RegFromUrl=http%3A//kaijiang.500.com/ssq.shtml%3F0_ala_baidu; sdc_session=1552283486685; Hm_lvt_4f816d475bb0b9ed640ae412d6b42cab=1551777817,1552269132,1552282376,1552283487; __utmc=63332592; sdc_userflag=1552285977030::1552285977030::1; Hm_lpvt_4f816d475bb0b9ed640ae412d6b42cab=1552285977; __utma=63332592.92610383.1551777812.1552282378.1552285978.4; __utmt=1; __utmb=63332592.1.10.1552285978; motion_id=1552285991429_0.7542890612968149; CLICKSTRN_ID=111.204.81.82-1551777812.189687::09FFD1084CB7855D794DE2279FF48DF5");
		conn.header("Host", "market.500.com");
		DOC_STATIC = conn.get();
		URL_STATIC = url;
		return DOC_STATIC;
	}
	
}
