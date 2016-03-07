package zz.itcast.ecservice.servlet.balance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.dao.balance.LogisticDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;

//@WebServlet("/logistics")
public class LogisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogisticsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入物流查询");
		data(request, response);

	}

	private void data(HttpServletRequest request, HttpServletResponse response) {
		String orderId = request.getParameter("orderId");
		LogisticDaoImpl logisticDaoImpl = new LogisticDaoImpl();
//		List<Logistics> logisticList= logisticDaoImpl
//				.getLogisticByOrderId(orderId);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "logistics");
//		data.put("logistics", logisticList);
		CommonUtil.renderJson(response, data);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
