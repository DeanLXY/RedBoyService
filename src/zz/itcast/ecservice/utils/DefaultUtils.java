package zz.itcast.ecservice.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.domain.ErrorMessage;

public class DefaultUtils {

	public static String defalut(String page, String defaultVal) {
		if (null == page || page.equals(page)) {
			return defaultVal;
		}
		return page;
	}

	public static void defalutError(HttpServletResponse response,String message) {
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("response", "error");
			data.put("error", new ErrorMessage(message));
			CommonUtil.renderJson(response, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
