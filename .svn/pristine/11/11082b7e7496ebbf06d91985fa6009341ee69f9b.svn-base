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

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import zz.itcast.ecservice.dao.CategoryDaoImpl;
import zz.itcast.ecservice.domain.Category;
import zz.itcast.ecservice.domain.Version;
import zz.itcast.ecservice.utils.CommonUtil;


/**
 * 请求类别的servlet
 * 
 * @author wangxj
 * 
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CategoryServlet.doGet()");
		data(request, response);
	}

	/**
	 * 数据的处理
	 * 
	 * @param request
	 * @param response
	 */
	private void data(HttpServletRequest request, HttpServletResponse response) {
		Version version = Version.getInstance();
		String defaultVersion = version.getVersion();
		try {
			defaultVersion = request.getParameter("version");
		} catch (Exception e) {
			// TODO version 版本号没有进行传递
		}
		// 版本相同 直接返回版本号
		if (version.getVersion().equals(defaultVersion)) {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[] { "forse", "new", "url" });
			JSONObject jsonStr = JSONObject.fromObject(version, jsonConfig);
			CommonUtil.renderJson(response, jsonStr.toString());
		} else {
			// {
			// 　　　"response":"category",
			// 　　　"version":"1.2"，
			// 　　　"category":[
			// 　　　　{
			// 　　　　　　"id":"1",
			// 　　　　　　"isleafnode":false,
			// 　　　　　　"name":"奶粉,
			// 　　　　　　"parentId":"0",
			// 　　　　　　"pic":"",
			// 　　　　　　"tag":"孕妇奶粉   幼儿奶粉"
			// 　　　　　}
			// 　　　　]
			// }
			CategoryDaoImpl daoImpl = new CategoryDaoImpl();
			List<Category> cateGoryList = daoImpl.getCateGoryList();
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("response", "category");
			data.put("version", version.getVersion());
			data.put("category", cateGoryList);
			CommonUtil.renderJson(response, data);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
