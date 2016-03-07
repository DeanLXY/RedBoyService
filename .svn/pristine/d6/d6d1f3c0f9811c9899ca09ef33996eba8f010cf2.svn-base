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
 * Servlet implementation class TopicPordListServlet
 * 
 * 请求topic对应商品列表.
 */
@WebServlet("/topic/plist")
public class TopicPordListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopicPordListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test TopicPordListServlet");
		
		int page = Integer.parseInt(request.getParameter("page"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int topic = Integer.parseInt(request.getParameter("id"));
		String orderby = request.getParameter("orderby");
		
		ProductListDaoImpl dao = new ProductListDaoImpl();
		List<Map<String,Object>> topicProdList = dao.getTopicProdList(page, pageNum, topic, orderby);
		Map<String, Object> data = new HashMap<String, Object>();
//		"response": "topic_productlist",  "list_count":"15"  productlist
		data.put("response", "topic_productlist");
		data.put("list_count","15");
		data.put("productlist", topicProdList);
		
		
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
