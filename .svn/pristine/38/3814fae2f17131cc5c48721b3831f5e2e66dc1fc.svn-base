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
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * 获得限时抢购商品列表
 * Servlet implementation class LimitBuyProdListServlet
 */
@WebServlet("/limitbuy")
public class LimitBuyProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LimitBuyProdListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test LimitBuyProdListServlet");
		
		int page = Integer.parseInt(request.getParameter("page"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		ProductListDaoImpl dao = new ProductListDaoImpl();
		List<Map<String,Object>> limitBuyProdList = dao.getLimitBuyProdList(page, pageNum);
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "limitbuy");
		data.put("list_count","15");
		data.put("productlist", limitBuyProdList);
		
		
		CommonUtil.renderJson(response, data);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
