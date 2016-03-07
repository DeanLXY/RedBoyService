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

import zz.itcast.ecservice.dao.TopicDaoImpl;
import zz.itcast.ecservice.utils.CommonUtil;

/**
 * 获得topic信息.
 * dyj
 * Servlet implementation class TopicServlet
 */
@WebServlet("/topic")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("test TopicServlet");
		
		String page = request.getParameter("page");
		String pageNum = request.getParameter("pageNum");
		
		TopicDaoImpl dao = new TopicDaoImpl();
		List<Map<String,Object>> topicList = dao.getTopicList(page, pageNum);
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response","topic");
		data.put("topic", topicList);
		

		CommonUtil.renderJson(response, data);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
