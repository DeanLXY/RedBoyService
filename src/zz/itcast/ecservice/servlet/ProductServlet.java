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

import zz.itcast.ecservice.dao.ProductDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// pId 商品ID 1102539
		Integer pID = 1102539;
		try {
			pID = Integer.parseInt(request.getParameter("pId"));
		} catch (Exception e) {
			//商品id 出错z
			e.printStackTrace();
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "product");
		ProductDaoImpl daoImpl = new ProductDaoImpl();
		List<Map<String, Object>> productDetail = daoImpl.getProductDetail(pID);
		data.put("product", productDetail);
		CommonUtil.renderJson(response, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
