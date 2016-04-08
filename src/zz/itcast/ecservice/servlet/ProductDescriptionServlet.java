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

import zz.itcast.ecservice.dao.ProductDescriptionDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;
import zz.itcast.ecservice.utils.DefaultUtils;

/**
 * 商品描述的servlet
 * 
 * @author Administrator
 * 
 */
@WebServlet("/product/description")
public class ProductDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer pId = 1021;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductDescriptionServlet.doGet()");

		try {
			pId = Integer.parseInt(request.getParameter("pId"));
		} catch (Exception e) {
			// TODO pid数据出错
			DefaultUtils.defalutError(response, "pid 不能为空");
			
			return ;
		}
		data(request, response);
	}

	/**
	 * 商品描述信息查询
	 * 
	 * @param request
	 * @param response
	 */
	private void data(HttpServletRequest request, HttpServletResponse response) {
		ProductDescriptionDaoImpl daoImpl = new ProductDescriptionDaoImpl();
		List<Map<String, Object>> productDesc = daoImpl.getProductDesc(pId);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "productDescription");
		data.put("productdesc", productDesc);
		CommonUtil.renderJson(response, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
