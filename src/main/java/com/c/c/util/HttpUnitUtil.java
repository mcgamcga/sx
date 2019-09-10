package com.c.c.util;

import com.meterware.httpunit.*;
import org.xml.sax.SAXException;

import java.io.IOException;

public class HttpUnitUtil {
	
	private static final String USER_AGENT = "User-Agent";
	private static final Integer CONN_TIME_OUT = 5*1000;
	private static WebConversation WC = null;
	
	private static WebConversation getConn(boolean clearner) {
		WC = clearner == true ? null : WC;
		if(WC == null) {
			HttpUnitOptions.setScriptingEnabled(false);
			WC = new WebConversation();
			WC.set_connectTimeout(CONN_TIME_OUT);
//			WC.setHeaderField(USER_AGENT, UserAgentEnum.CHORME.getDesc());
		}
		return WC;
	}
	
	public static WebResponse getResponse(String url) throws IOException, SAXException {
		WebConversation wc = getConn(true);
		WebResponse wRes = wc.getResponse(url);
		return wRes;
	}

	private static WebResponse getResponseFormGet(String url) throws IOException, SAXException {
		WebConversation wc = getConn(true);
		WebRequest wReq = new GetMethodWebRequest(url);
		WebResponse wRes = wc.getResponse(wReq);
		return wRes;
	}
	
	private static WebResponse getResponseFormPost(String url,String formName,Object... objects) throws IOException, SAXException {
		WebConversation wc = getConn(true);
		WebRequest wReq = new PostMethodWebRequest(url);
		WebResponse wRes = wc.getResponse(wReq);
	    WebForm form = wRes.getFormWithName(formName);
	    if(form == null) {
	    	form = wRes.getForms()[0];
	    }
	    for(Object obj:objects) {
	    	//form.setAttribute(name, value);
	    }
	    wRes = form.submit();
		return wRes;
	}
	
	public static WebResponse getResponseForClick(String url,String linkName) {
		try {
			WebResponse wr = getResponse(url);
			WebLink wLink = wr.getLinkWith(linkName);
			wLink.click();
			wr = getConn(false).getCurrentPage();
			return wr;
		} catch (IOException | SAXException e) {
		}
		return null;
	}
	

}
