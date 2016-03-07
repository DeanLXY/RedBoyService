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

@WebServlet("/ordercancel")
public class OrderCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public OrderCancelServlet(){
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("进入取消订单操作");
		data(req,resp);
	}

	private void data(HttpServletRequest req, HttpServletResponse resp) {
//		{
//			"response": "ordercancel"
//				"result":"true"   这个是自己加的标志，取消是否成
//			}

		//调用业务类
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "ordercancel");
		OrderDaoImpl orderDao = new OrderDaoImpl();
		String orderid = req.getParameter("orderId");
		boolean result = orderDao.orderCancle(orderid);
		data.put("result",result);
		CommonUtil.renderJson(resp, data);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}