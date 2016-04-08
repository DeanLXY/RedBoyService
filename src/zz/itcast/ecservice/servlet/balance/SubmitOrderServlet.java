package zz.itcast.ecservice.servlet.balance;

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
import zz.itcast.ecservice.utils.DefaultUtils;

/**
 * Servlet implementation class SubmitOrderServlet
 */
@WebServlet("/ordersumbit")
public class SubmitOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SubmitOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		userId
//
//		Sku	商品ID:数量:属性ID|商品ID:数量:属性ID	1200001:3:1,2|1200004:2:2,3
//		addressid	地址簿ID	1001
//		paymentid	支付方式	1
//		deliveryid	送货时间	1
//		invoicetype	发票类型	1=>个人 2=>单位
//		invoicetitle	发票抬头	北京红孩子互联科技有限公司
//		invoicecontent	发票内容	1
		
		OrderDaoImpl dao = new OrderDaoImpl();
		
		String userId = request.getParameter("userid");
		String productInfos = request.getParameter("sku");
		if (productInfos == null || productInfos.equals("")) {
			DefaultUtils.defalutError(response, "sku 不能为空!");
			return;
		}
		
		
		String addressId = request.getParameter("addressid");
		String paymentId = request.getParameter("paymentid");
		String delivetyId = request.getParameter("deliveryid");
		String invoiceType = request.getParameter("invoicetype");
		String invoiceTitle = request.getParameter("invoicetitle");
		String invoiceContent = request.getParameter("invoicecontent");
		
		Map<String, Object> orderInfo = dao.insertNewOrder(userId, productInfos, addressId, paymentId, delivetyId, invoiceType, invoiceTitle, invoiceContent);
		
		//orderInfo = dao.insertNewOrder("1", "101211:2:2,3|10211:2:4,3", "1", "1", "3", "1", "参数太多了", "gogogogoogogogogoo");
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "orderSumbit");
		data.put("orderInfo",orderInfo);
		
		
		CommonUtil.renderJson(response, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
