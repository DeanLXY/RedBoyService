package zz.itcast.ecservice.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.dao.HelpDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;

@WebServlet(urlPatterns = "/help")
public class HelpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelpServlet.doGet()");
		data(request, response);
	}

	private void data(HttpServletRequest request, HttpServletResponse response) {
		int version = 0;
		try {
			String versionStr = request.getParameter("version");
			version = Integer.parseInt(versionStr);
		} catch (Exception e) {
			// TODO: 处理用户请求版本错误
		}

		/*
		 * { "response": "help", "version":"12", "helplist": [ { "id":"1",
		 * "title":"购物指南", //title },
		 * 
		 * { "id":"2", "title":"配送方式", //title }, ] }
		 */

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "help");

		// 类图
		// 方案一：建数据库+建表
		HelpDaoImpl daoImpl = new HelpDaoImpl();
		data.put("version", daoImpl.getLastVersion());
		List<Map<String, Object>> helpList = daoImpl.getHelpList(version);
		data.put("helpList", helpList);

		// Json字符串的生成
		// String json = JSONObject.fromObject(data).toString();
		//
		// response.getWriter().write(json)
		CommonUtil.renderJson(response, data);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}