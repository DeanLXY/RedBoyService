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

import zz.itcast.ecservice.dao.balance.LogisticDaoImpl;
import zz.itcast.ecservice.domain.Logistics;
import zz.itcast.ecservice.utils.CommonUtil;
import zz.itcast.ecservice.utils.DefaultUtils;

@WebServlet("/logistics")
public class LogisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogisticsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logistics.doGet()");
		data(request, response);
	}

	private void data(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "logistics");
		LogisticDaoImpl dao = new LogisticDaoImpl();
		String orderid = request.getParameter("orderid");
		
		if (orderid == null || "".equals(orderid)) {
			DefaultUtils.defalutError(response, "orderid 不能为空!");
			return;
		}
		Logistics logistics = dao.getLogisticByOrderId(orderid);

		data.put("logistics", logistics);
		List<Map<String, Object>> followInfo = dao.getFollowInfo();
		data.put("followInfo", followInfo);
		System.out.println(data);
		CommonUtil.renderJson(response, data);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
