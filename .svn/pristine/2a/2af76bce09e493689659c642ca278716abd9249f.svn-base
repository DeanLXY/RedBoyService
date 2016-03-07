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

import zz.itcast.ecservice.dao.SearchDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;
import zz.itcast.ecservice.utils.ProductOrderByUtil;

/**
 * @author Administrator
 * 
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer page = 1;
	private Integer pageNum = 5;
	private String orderby = "sales desc";
	private String searchkey;
	private int size;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// keyword 搜索关键字 keyword=奶粉
		// page 第几页 1
		// pageNum 每页多少个 10
		// orderby 排序
		// sale_down(销量降序)，price_up(价格升序)，price_down(价格降序)，comment_down(评价降序)，shelves_down(上架降序)。目前只有价格有双向排序，其他都只有降序，其中默认为sale_down

		try {
			orderby = request.getParameter("orderby");
			searchkey = request.getParameter("searchkey");
			page = Integer.parseInt(request.getParameter("page"));
			pageNum = Integer.parseInt(request.getParameter("pagenum"));
			orderby = ProductOrderByUtil.getOrderModel(orderby);
		} catch (Exception e) {
			// TODO c传递数据出错,转换异常
		}

		data(request, response);

	}

	/**
	 * 搜索
	 * 
	 * @param request
	 * @param response
	 */
	private void data(HttpServletRequest request, HttpServletResponse response) {
		SearchDaoImpl daoImpl = new SearchDaoImpl();
		List<Map<String, Object>> productList = daoImpl.getProductList(searchkey, page, pageNum, orderby);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "search");
		data.put("productlist",productList);
		if(productList!=null) {
			size = productList.size();
		}
			data.put("list_count",size);
		CommonUtil.renderJson(response, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
