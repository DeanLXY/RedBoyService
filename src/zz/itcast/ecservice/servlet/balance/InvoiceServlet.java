package zz.itcast.ecservice.servlet.balance;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.dao.balance.InvoiceDaoImpl;
import zz.itcast.ecservice.domain.Invoice;
import zz.itcast.ecservice.utils.CommonUtil;

@WebServlet("/invoice")
public class InvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int userId=1;
       
    public InvoiceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		userId = Integer.parseInt(request.getParameter("userid"));
		data(request,response);
		
	}

	/**
	 *  数据板块
	 * @param response 
	 * @param request 
	 */
	private void data(HttpServletRequest request, HttpServletResponse response) {
		/*{
			  "response": "invoice",
			  "invoice":[                        //发票内容列表
			　　　{
			　　　  "id":"123",
			　　　  "content":"服装"
			　　　},
			　　　{
			　　　  "id":"123",
			　　　  "content":"服装"
			　　　
			　　　}
			　]
			}*/
		Map<String,Object>  data=new HashMap<String, Object>();
		InvoiceDaoImpl  daoImpl=new InvoiceDaoImpl();
		List<Invoice> invoiceList = daoImpl.getInvoiceList(userId);
		
		data.put( "response", "invoice");
		data.put("invoiceList", invoiceList);
		CommonUtil.renderJson(response, data);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
