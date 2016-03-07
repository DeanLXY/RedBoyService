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

import zz.itcast.ecservice.dao.HelpDetailDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;

@WebServlet("/help_detail")
public class HelpDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public HelpDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		data(request, response);
	}

	/**
	 * 获取数据
	 * 
	 * @param request
	 * @param response
	 */
	private void data(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HelpDetailServlet.data()");
		// 根据帮助id获取默认错误信息提示
		int helpId = 0;
		try {
			helpId = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			// TODO 用户请求帮助详情出错
		}
		HelpDetailDaoImpl daoImpl = new HelpDetailDaoImpl();
		// 获取到详细帮助
		List<Map<String, Object>> data = daoImpl.getHelpDetailList(helpId);

		// 　"response": "help_detail ",
		// 　" help ":[
		// {
		// "title":"怎么购买？", //title
		// "content":" content " //帮助内容
		// },
		// {
		// "title":"怎么配送？", //title
		// "content":" content " //帮助内容
		// },
		// ] 
		// 拼串操作
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("response", "help_detail");
		maps.put("help", data);
		CommonUtil.renderJson(response, maps);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
