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

import zz.itcast.ecservice.dao.AddressDaoImpl;
import zz.itcast.ecservice.dao.DeliveryInfoDaoImpl;
import zz.itcast.ecservice.dao.OrderDaoImpl;
import zz.itcast.ecservice.dao.PaymentInfoDaoImpl;
import zz.itcast.ecservice.dao.ProductListDaoImpl;
import zz.itcast.ecservice.domain.Product;
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * 获取订单详情
 * 
 * 
 */
@WebServlet("/orderdetail")
public class OrderDetailServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderDetailServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("进入获取订单详情");
		data(req, resp);
	}

	private void data(HttpServletRequest req, HttpServletResponse resp) {
		// 调用业务类
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "orderdetail");
		OrderDaoImpl orderDao = new OrderDaoImpl();

		String orderId = req.getParameter("orderid");
		// 封装OrderInfo
		Map<String, Object> order = orderDao.getOderDetail(orderId);
		data.put("order_info", order);
		// 封装地址信息
		AddressDaoImpl addressDao = new AddressDaoImpl();
		Map<String, Object> addressInfo = addressDao.getAddressByOrderId(orderId);
		data.put("address_info", addressInfo);

//		// 封装支付方式
//		// "type":"1", //支付类型，1=>货到付款 2=>货到POS机 3=>支付宝(待定)
		PaymentInfoDaoImpl payment = new PaymentInfoDaoImpl();
		Map<String, Object> payMentInfo = payment.getPayMentInfo(orderId);
		data.put("payment_info", payMentInfo);
//
//		// 封装送货信息
//		// type":"1", //1 => 周一至周五送货 2=> 双休日及公众假期送货 3=> 时间不限，工作日双休日及公众假期均可送货
		DeliveryInfoDaoImpl deliveryDao = new DeliveryInfoDaoImpl(); 
		Map<String, Object> deliverInfo = deliveryDao.getDeliverInfo(orderId);
		data.put("delivery_info", deliverInfo);
//
//		// 封装发票信息
//		// "title":"红孩子信息有限公司", //发票抬头
//		// "content":"办公用品" //发票内容
//		data.put("invoice_info", null);
//		// 分装商品信息
		ProductListDaoImpl productDao = new ProductListDaoImpl();
		List<Product> orderDetail_ProductList = productDao.getOrderDetail_ProductList(orderId);
		data.put("productlist", orderDetail_ProductList);

		CommonUtil.renderJson(resp, data);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
