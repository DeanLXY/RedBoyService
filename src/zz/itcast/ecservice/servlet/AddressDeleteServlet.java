package zz.itcast.ecservice.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.dao.AddressDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;
import zz.itcast.ecservice.utils.DefaultUtils;

/**
 * Servlet implementation class AddressDeleteServlet
 */
@WebServlet("/addressdelete")
public class AddressDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressDeleteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		data(request, response);
	}

	private void data(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("request", "addressDelete");
		AddressDaoImpl daoImpl = new AddressDaoImpl();
		String idStr = request.getParameter("id");
		if (idStr == null ||"".equals(idStr)) {
			DefaultUtils.defalutError(response, "删除的地址id 不能为空!");
			return;
		}
		int id = Integer.parseInt(idStr);
		int count = daoImpl.getDeleteAddress(id);
		if (count>0) {
			CommonUtil.renderJson(response, data);
		}else{
			DefaultUtils.defalutError(response, "地址删除失败!");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
