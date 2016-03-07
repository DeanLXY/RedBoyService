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

import zz.itcast.ecservice.dao.ProductListDaoImpl;
import zz.itcast.ecservice.domain.ErrorMessage;
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/productlist")
public class ProductListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Integer page = 1;
	private Integer pageNum = 5;
	private Integer cID =1;
	private String orderBy = "sales desc";
	private String filter = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductListServlet() {
		super();
	}

	/**
	 * @param page
	 *            页码
	 * @param pageNum
	 *            每页显示
	 * @param cID
	 *            分类ID(表中是categoryid)
	 * @param orderBy
	 *            排序
	 * @param filter
	 *            筛选条件
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductListServlet.doGet()");

		try {
			page = Integer.parseInt(request.getParameter("page"));
			pageNum = Integer.parseInt(request.getParameter("pagenum"));
			cID = Integer.parseInt(request.getParameter("cid"));
			// sale_down(销量降序)，price_up(价格升序)，price_down(价格降序)
			orderBy = request.getParameter("orderby");
			filter = request.getParameter("filter");


		} catch (NumberFormatException e) {
			// TODO 参数转换异常
			e.printStackTrace();
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("response", "error");
			data.put("error", new ErrorMessage(e.getMessage()));
			CommonUtil.renderJson(response, data);
			return;
		}
		data(request, response);
	}

	/**
	 * 商品列表的处理
	 * 
	 * @param request
	 * @param response
	 */
	private void data(HttpServletRequest request, HttpServletResponse response) {
		ProductListDaoImpl daoImpl = new ProductListDaoImpl();
		List<Map<String, Object>> productList = daoImpl.getProductList(page, pageNum, cID, orderBy, filter);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "category_productlist");
		data.put("productlist", productList);
		data.put("list_count", 1500); // TODO 商品总数
		CommonUtil.renderJson(response, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
