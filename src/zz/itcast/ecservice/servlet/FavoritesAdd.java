package zz.itcast.ecservice.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.dao.FavoritesAddDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;
import zz.itcast.ecservice.utils.DefaultUtils;
@WebServlet("/addfavorites")
public class FavoritesAdd extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		pid
		String pid = request.getParameter("pid");
		if (pid== null || "".equals(pid)) {
			DefaultUtils.defalutError(response, " pid 不能为空");
			return;
		}
		String userid = request.getParameter("userid");
		if (userid== null || "".equals(userid)) {
			DefaultUtils.defalutError(response, " userid 不能为空");
			return;
		}
		FavoritesAddDaoImpl addDaoImpl = new FavoritesAddDaoImpl();
		int id = addDaoImpl.add2Fatorites(pid,userid);
//		{
//			"response": "addfavorites"
//			}
		if (id == 0) {
			DefaultUtils.defalutError(response, "商品添加失败,请联系客服验证后重新添加!");
		}else{
			Map<String,String> data = new HashMap<String, String>();
			data.put("response", "addfavorites");
			CommonUtil.renderJson(response, data);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
