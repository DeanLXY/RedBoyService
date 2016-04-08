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
import zz.itcast.ecservice.utils.DefaultUtils;

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
		String pageStr = request.getParameter("page");
		pageStr = DefaultUtils.defalut(pageStr, "1");
		int page=Integer.parseInt(pageStr);
		String pageNumStr = request.getParameter("pageNum");
		pageNumStr = DefaultUtils.defalut(pageNumStr, "10");
		int pagenum=Integer.parseInt(pageNumStr);
		String useridStr = request.getParameter("userid");
		if (useridStr == null || "".equals(useridStr)) {
			DefaultUtils.defalutError(response, "userId 不能为空");
			return;
		}
		int userid=Integer.parseInt(useridStr);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "favorites");
		FavoritesDaoImpl daoImpl=new FavoritesDaoImpl();
		List<Map<String, Object>> favoritesList = daoImpl.getFavoritesList(userid,page,pagenum);
		data.put("productList", favoritesList);
		int favoritesNum = daoImpl.getFavoritesNum(userid);
		
		data.put("listCount",favoritesNum);
		CommonUtil.renderJson(response, data);
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
