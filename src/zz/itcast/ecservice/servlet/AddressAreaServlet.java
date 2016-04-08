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

import zz.itcast.ecservice.dao.AddressAreaImpl;
import zz.itcast.ecservice.domain.AddressArea;
import zz.itcast.ecservice.utils.CommonUtil;
@WebServlet("/addressarea")
public class AddressAreaServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AddressAreaImpl addressAreaImpl = new AddressAreaImpl();
		List<AddressArea> addressAreas = addressAreaImpl.queryArea();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "addressArea");
		data.put("areaList",addressAreas);
		CommonUtil.renderJson(response, data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
