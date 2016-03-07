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
import zz.itcast.ecservice.dao.RegisterDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password=request.getParameter("password");
		Map<String, Object> data = new HashMap<String, Object>();
		LoginDaoImpl daoLogin=new LoginDaoImpl();
		List<Map<String, Object>> userExist = daoLogin.getLoginList(username);
		if(userExist!= null&&userExist.size()!=0){
			Map<String,String> error=new HashMap<String, String>();
			error.put("text", "用户名已存在");
			data.put("response", "error");
			data.put("error", error);
			CommonUtil.renderJson(response, data);
			return;
		}
		RegisterDaoImpl daoImpl=new RegisterDaoImpl();
		List<Map<String, Object>> registerList = daoImpl.getRegisterList(username, password);
		data.put("response", "register");
		data.put("userinfo",registerList.get(0) );
		CommonUtil.renderJson(response, data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
