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

import zz.itcast.ecservice.dao.CommentDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;
import zz.itcast.ecservice.utils.DefaultUtils;

/**
 * 评论的servlet
 * 
 * @author Administrator
 * 
 */
@WebServlet("/product/comment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pId = 1021;
	int page = 1;
	int pageNum = 10;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String pidStr = request.getParameter("pId");
			if (pidStr == null) {
				DefaultUtils.defalutError(response, "pId 不能为空");
				return;
			}
			
			pId = Integer.parseInt(pidStr);
			page = Integer.parseInt(request.getParameter("page"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			// TODO 传递的数据又错误了
		}

		data(request, response);
	}

	/**
	 * 处理获取评论的业务
	 * 
	 * @param request
	 * @param response
	 */
	private void data(HttpServletRequest request, HttpServletResponse response) {
		CommentDaoImpl daoImpl = new CommentDaoImpl();

		List<Map<String, Object>> commentInfoList = daoImpl.getCommentInfoList(pId, page, pageNum);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "productComment");
		data.put("comment", commentInfoList);
		CommonUtil.renderJson(response, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
