package zz.itcast.ecservice.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.dao.OrderDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;
@WebServlet("/ordercount")
public class OrderCountServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		data(req, resp);
	}

	private void data(HttpServletRequest req, HttpServletResponse resp) {
		// 调用业务类
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "orderCount");
		OrderDaoImpl orderDao = new OrderDaoImpl();
		String userid = req.getParameter("userid");
		int count =orderDao.getOrderCount(userid);
		data.put("count", count);
		CommonUtil.renderJson(resp, data);

	}

}
