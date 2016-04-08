package zz.itcast.ecservice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zz.itcast.ecservice.domain.Delivery;
import zz.itcast.ecservice.domain.Payment;
import zz.itcast.ecservice.domain.Pic;
import zz.itcast.ecservice.domain.Product;
import zz.itcast.ecservice.utils.CommonUtil;

public class CheckOutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * { "response": "checkOut", "paymentList": [//支付方式 { "type":"1",
		 * “des”:“货到付款” }, { "type":"2", “des”:“货到POS机” }, { "type":"3",
		 * “des”:“支付宝” }
		 * 
		 * ] "deliveryList": [//送货时间 　　 { 　　 "type":"1", 　　 “des”:“周一至周五送货” 　　
		 * }, 　　 { 　　 "type":"2", 　　 “des”:“双休日及公众假期送货” 　　 }, 　　 { 　　
		 * "type":"3", 　　 “des”:“时间不限，工作日双休日及公众假期均可送货” 　　 } 　　 ] "productList":
		 * [ //商品列表 { "id":"1102539", //商品ID "name": "雅培金装", //商品名称 "pic":"",
		 * //商品图片URL "price":"89", //商品售价 "productProperty":[ //属性 { "key":
		 * "颜色", "value": "红色", }, { "key": "大小", "value": "M", } ], "prodNum":
		 * 3, //商品数量，0为缺货或下架 }, { "id":"1102539", //商品ID "name": "雅培金装", //商品名称
		 * "pic":"", //商品图片URL "price":"89", //商品售价 "productProperty":[ //子母码属性
		 * { "key": "颜色", "value": "红色", }, { "key": "大小", "value": "M", } ],
		 * "prodNum":"10" } ], "checkoutAddup":{ //总计 "totalCount":"3", //商品数量总计
		 * "totalPrice":"230", //商品金额总计 "totalPoint":"230"， //商品积分总计
		 * "freight":"10" //运费 } }
		 */
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "checkOut");
		List<Payment> paymentList = new ArrayList<Payment>();
		paymentList.add(new Payment("1", "货到付款"));
		paymentList.add(new Payment("2", "POS机付款"));
		paymentList.add(new Payment("3", "支付宝"));
		data.put("paymentList", paymentList);
		List<Delivery> deliveryList = new ArrayList<Delivery>();
		deliveryList.add(new Delivery("1", "周一到周五送货"));
		deliveryList.add(new Delivery("2", "双休日及公众假期送货"));
		deliveryList.add(new Delivery("3", "时间不限，工作日双休日及公众假期均可送货"));
		data.put("deliveryList", deliveryList);
		Map<String, Object> propertyMap = new HashMap<String, Object>();
		propertyMap.put("key", "颜色");
		propertyMap.put("value", "红色");

		List<Map<String, Object>> productProertyLists = new ArrayList<Map<String, Object>>();

		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		productProertyLists.add(propertyMap);
		product.setProductProertyLists(productProertyLists);
		product.setId(1102539);
		product.setName("雅培金装");
		product.setPrice(89);
		Pic pic = new Pic();
		pic.setPicUrl("/images/12.jpg");
		product.setPic(pic);
		product.setProdNum(83);

		productList.add(product);
		product = new Product();
		product.setId(1102539);
		product.setName("雅培金装");
		product.setPrice(89);
		pic = new Pic();
		pic.setPicUrl("/images/12.jpg");
		product.setPic(pic);
		product.setProdNum(10);
		productProertyLists = new ArrayList<Map<String, Object>>();
		propertyMap = new HashMap<String, Object>();
		propertyMap.put("key", "颜色");
		propertyMap.put("value", "蓝色");
		productProertyLists.add(propertyMap);
		product.setProductProertyLists(productProertyLists);
		productList.add(product);
		data.put("productList", productList);
//		"checkoutAddup":{            //总计
//			  "totalCount":"3",            //商品数量总计
//			  "totalPrice":"230",          //商品金额总计
//			  "totalPoint":"230"，        //商品积分总计
//			  "freight":"10"              //运费
//			}
		
//		Map<String, Object> checkoutMap = new HashMap<String, Object>();
		Map<String, Object> checkoutDetailMap = new HashMap<String, Object>();
		checkoutDetailMap.put("totalCount", "2");
		checkoutDetailMap.put("totalPrice", "249.5");
		checkoutDetailMap.put("totalPoint", "250");
		checkoutDetailMap.put("freight", "6");
		data.put("checkoutAddup", checkoutDetailMap);
		CommonUtil.renderJson(response, data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
