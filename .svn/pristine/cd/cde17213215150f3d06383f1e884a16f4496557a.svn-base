package zz.itcast.ecservice.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.dao.AddressDaoImpl;
import zz.itcast.ecservice.domain.AddressArea;

/**
 * Servlet implementation class AddressLinkage
 */
@WebServlet("/AddressLinkage")
public class AddressLinkage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressLinkage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddressArea aa = new AddressArea();
		AddressDaoImpl daoImpl = new AddressDaoImpl();
		List<Map<String, Object>> provinceAll = daoImpl.getProvinceAll();
		Map<String, Object> map = provinceAll.get(1);
		int pid = (Integer) map.get("id");
		List<Map<String, Object>> cityAll = daoImpl.getCityAll(pid);
		Map<String, Object> map2 = cityAll.get(0);
		int cid = (Integer)map2.get("id");
		List<Map<String, Object>> areaAll = daoImpl.getAreaAll(cid);
		Map<String, Object> map3 = areaAll.get(1);
		String province = (String) map.get("value");
		String city = (String) map2.get("value");
		String area = (String) map3.get("value");
		System.out.println(province+"\t"+city+"\t"+area);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
