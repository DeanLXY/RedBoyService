package zz.itcast.ecservice.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.dao.CartAddDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;
import zz.itcast.ecservice.utils.DefaultUtils;
@WebServlet("/cart/add")
public class CartAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userid = req.getParameter("userid");
		if (null==userid|| "".equals(userid)) {
			DefaultUtils.defalutError(resp, "userid 不能为空");
			return;
		}
		String sku = req.getParameter("sku");
		
		CartAddDaoImpl cartAddDaoImpl = new CartAddDaoImpl();
		int count = cartAddDaoImpl.add2Shoppingcart(userid, sku);
		if (count == 0) {
			DefaultUtils.defalutError(resp, "添加购物车失败");
			return;
		}else{
//			{
//				"response": "cart",
//			}
			Map<String, Object> data  = new HashMap<String, Object>();
			data.put("response", "cart");
			data.put("message", "添加成功");
			CommonUtil.renderJson(resp, data);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
