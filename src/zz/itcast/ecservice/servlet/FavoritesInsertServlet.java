package zz.itcast.ecservice.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.dao.FavoritesDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * Servlet implementation class FavoritesInsertServlet
 */
@WebServlet("/favorites_insert")
public class FavoritesInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoritesInsertServlet() {
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
		
		String userid = request.getParameter("userId");
		String productid = request.getParameter("productId");
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "favorites_insert");
		FavoritesDaoImpl daoImpl=new FavoritesDaoImpl();
		int insertFavorites = daoImpl.insertFavorites(Integer.parseInt(userid), Integer.parseInt(productid));
		data.put("insertFavorites",insertFavorites );
		CommonUtil.renderJson(response, data);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
