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

import zz.itcast.ecservice.dao.UserInfoDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;
import zz.itcast.ecservice.utils.DefaultUtils;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/userinfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		data(request,response);
	}

	private void data(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		if (null == userid|| "".equals(userid)) {
			DefaultUtils.defalutError(response, "userid 不能为空");
			return;
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "userinfo");
		UserInfoDaoImpl daoImpl=new UserInfoDaoImpl();
		List<Map<String, Object>> userInfoList = daoImpl.getUserInfoList(Integer.parseInt(userid));
		data.put("userinfo", userInfoList.get(0));
		CommonUtil.renderJson(response, data);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
