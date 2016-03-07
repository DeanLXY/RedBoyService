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

import zz.itcast.ecservice.dao.AddressDaoImpl;
import zz.itcast.ecservice.domain.Address;
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * Servlet implementation class AddressDefaultServlet
 */
@WebServlet("/addressupdate")
public class AddressDefaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressDefaultServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		data(request, response);
	}

	private void data(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("request", "addressupdate");
		Address a = new Address();
		AddressDaoImpl daoImpl = new AddressDaoImpl();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		System.out.println(name);
		String phoneNumber = request.getParameter("phoneNumber");
		String addressDetail = request.getParameter("addressDetail");
		String fixedtel = request.getParameter("fixedtel");
		String zipCode = request.getParameter("zipCode");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		int isDefault = Integer.parseInt(request.getParameter("isDefault"));
		
		List<Map<String, Object>> provinceId = daoImpl.getProvinceId(province);
		Map<String, Object> map = provinceId.get(0);
		int value = (Integer) map.get("id");
		a.setProvinceId(value);
		List<Map<String, Object>> cityId = daoImpl.getCityId(city);
		Map<String, Object> map2 = cityId.get(0);
		int value2 = (Integer) map2.get("id");
		a.setCityId(value2);
		List<Map<String, Object>> areaId = daoImpl.getAreaId(area);
		Map<String, Object> map3 = areaId.get(0);
		int value3 = (Integer) map3.get("id");
		a.setAreaId(value3);
		
		
		daoImpl.getUpdateAddress(new Address(id,name,phoneNumber,fixedtel,value,value2,value3,addressDetail,zipCode,2,isDefault));
		System.out.println(data);
		CommonUtil.renderJson(response, data);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
