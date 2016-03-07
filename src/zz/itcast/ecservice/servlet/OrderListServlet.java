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

import zz.itcast.ecservice.dao.OrderDaoImpl;
import zz.itcast.ecservice.domain.ErrorMessage;
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * 订单
 * 
 */
@WebServlet("/orderlist")
public class OrderListServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderListServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("进入获取OrderList");
		data(req, resp);
	}

	private void data(HttpServletRequest req, HttpServletResponse resp) {
		// 返回格式
		// response": "orderlist",
		// "orderlist":[{
		// "orderid": "412423145", //订单ID
		// "status": "未处理", //订单显示状态
		// "time": "2011/10/100 12:16:40", //下单时间
		// "price": "1234.23", //订单金额
		// "flag":"1" //订单标识，1=>可删除可修改 2=>不可修改 3=>已完成
		// },
		// {},{},
		// ]
		// 调用业务类
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "orderlist");
		OrderDaoImpl orderDao = new OrderDaoImpl();
		int type = 1;
		int page = 0;
		int pageNum = 10;
		int userid = 110; // 默认查询110的
		try {
			type = Integer.parseInt(req.getParameter("type"));
			String userIdParameter = req.getParameter("userid");

			userid = Integer.parseInt(userIdParameter);

			page = Integer.parseInt(req.getParameter("page"));
			pageNum = Integer.parseInt(req.getParameter("pageNum"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			// {
			// "response": "error",
			// "error": {
			// "text": "用户名不存在"
			// }
			// }
			data = new HashMap<String, Object>();
			data.put("response", "error");
			ErrorMessage msg = new ErrorMessage(e.getMessage());
			data.put("error", msg);
			CommonUtil.renderJson(resp, data);
			return;
		}
		List<Map<String, Object>> orderList = orderDao.getOrderList(userid,
				type, page, pageNum);
		data.put("orderlist", orderList);
		System.out.println(data);
		CommonUtil.renderJson(resp, data);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
