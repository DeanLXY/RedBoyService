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
import zz.itcast.ecservice.utils.DefaultUtils;

/**
 * 查询某一品牌下所有商品列表.
 * Servlet implementation class BrandProdListServlet
 */
@WebServlet("/brand/plist")
public class BrandProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrandProdListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
 
		String idStr = request.getParameter("id");
		if (idStr == null || "".equals(idStr)) {
			DefaultUtils.defalutError(response, "id 不能为空!");
			return ;
		}
		String pageStr = request.getParameter("page");
		pageStr = DefaultUtils.defalut(pageStr, "1");
		int page = Integer.parseInt(pageStr);
		String pageNumStr = request.getParameter("pageNum");
		pageNumStr = DefaultUtils.defalut(pageNumStr, "10");
		int pageNum = Integer.parseInt(pageNumStr);
	
		int brandId = Integer.parseInt(idStr);
		String orderby = request.getParameter("orderby");
		
		
		ProductListDaoImpl dao = new ProductListDaoImpl();
		List<Map<String,Object>> prodList = dao.getBrandProdList(page, pageNum,brandId, orderby);
		Map<String, Object> data = new HashMap<String, Object>();
		
//		"response": "topic_productlist",  "list_count":"15"  productlist
		data.put("response", "brandProductlist");
		data.put("listCount",prodList.size());
		data.put("productList", prodList);
		
		
		CommonUtil.renderJson(response, data);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
