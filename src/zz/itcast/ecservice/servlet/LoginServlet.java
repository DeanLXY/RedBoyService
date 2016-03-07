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

import zz.itcast.ecservice.dao.LoginDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String username = request.getParameter("username");
		String password=request.getParameter("password");
		Map<String, Object> data = new HashMap<String, Object>();
		LoginDaoImpl daoImpl=new LoginDaoImpl();
		List<Map<String, Object>> loginList = daoImpl.getLoginList(username, password);
		if(loginList.size()==0){
			Map<String,String> error=new HashMap<String, String>();
			error.put("text", "用户名或密码错误！！");
			data.put("response", "error");
			data.put("error", error);
			CommonUtil.renderJson(response, data);
			return;
		}
		data.put("response", "login");
		data.put("userinfo",loginList.get(0));
		CommonUtil.renderJson(response, data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
