package zz.itcast.ecservice.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.dao.ProductDaoImpl;
import zz.itcast.ecservice.domain.ProductProperty;
import zz.itcast.ecservice.utils.CommonUtil;
import zz.itcast.ecservice.utils.DefaultUtils;

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
			DefaultUtils.defalutError(response, "pId 不能为空");
			return;
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "product");
		List<ProductProperty> productProperties = new ArrayList<ProductProperty>();
		ProductProperty property = new ProductProperty(1, "颜色", "红色");
		productProperties.add(property);
		property = new ProductProperty(2, "颜色", "白色");
		productProperties.add(property);
		property = new ProductProperty(3, "大小", "L");
		productProperties.add(property);
		data.put("productProperty", productProperties);
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
