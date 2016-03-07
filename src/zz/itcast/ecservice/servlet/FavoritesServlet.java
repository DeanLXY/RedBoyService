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

import zz.itcast.ecservice.dao.FavoritesDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * Servlet implementation class FavoritesServlet
 */
@WebServlet("/favorites")
public class FavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoritesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		data(request, response);
	}
	private void data(HttpServletRequest request, HttpServletResponse response) {
		int page=Integer.parseInt(request.getParameter("page"));
		int pagenum=Integer.parseInt(request.getParameter("pageNum"));
		int userid=Integer.parseInt(request.getParameter("userId"));
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "favorites");
		FavoritesDaoImpl daoImpl=new FavoritesDaoImpl();
		List<Map<String, Object>> favoritesList = daoImpl.getFavoritesList(userid,page,pagenum);
		data.put("productlist", favoritesList);
		int favoritesNum = daoImpl.getFavoritesNum(userid);
		
		data.put("list_count",favoritesNum);
		CommonUtil.renderJson(response, data);
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
