package zz.itcast.ecservice.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.dao.CartDaoImpl;
import zz.itcast.ecservice.domain.ErrorMessage;
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * 获取购物车信息 Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test CartServlet");

		String sku = request.getParameter("sku");
		Map<String, Object> data = new HashMap<String, Object>();
		if (null == sku || "".equals(sku)) {
			data.put("response", "error");
			ErrorMessage msg = new ErrorMessage("userid  不能为空");
			data.put("error", msg);
			CommonUtil.renderJson(response, data);
			return;
		}
		// 1200001:3:1,2|1200004:2:2,3 商品Id:数量:属性id,属性id...|商品Id:数量:属性id,属性id...
		CartDaoImpl dao = new CartDaoImpl();

		data = dao.getCartInfo(sku);

		CommonUtil.renderJson(response, data);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
