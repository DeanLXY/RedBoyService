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

@WebServlet("/search/recommend")
public class SearchRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SearchServlet.doGet()");
		data(request, response);
	}

	/**
	 * 搜索处理处理
	 * 
	 * @param request
	 * @param response
	 */
	private void data(HttpServletRequest request, HttpServletResponse response) {
		SearchDaoImpl daoImpl = new SearchDaoImpl();
		List<Object> recommentList = daoImpl.getRecommentList();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "searchrecommend");
		data.put("search_keywords", recommentList);
		CommonUtil.renderJson(response, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
