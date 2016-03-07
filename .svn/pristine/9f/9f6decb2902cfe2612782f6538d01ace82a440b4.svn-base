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
		data.put("request", "addressdelete");
		AddressDaoImpl daoImpl = new AddressDaoImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		daoImpl.getDeleteAddress(id);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
