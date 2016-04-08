package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import zz.itcast.ecservice.utils.DataSourceManager;
import zz.itcast.ecservice.utils.DateUtil;

/**
 * 订单业务类
 * 
 * 
 */
public class OrderDaoImpl {
	protected QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
	private SimpleDateFormat format;
	private Random random = new Random();;

	/**
	 * 获取订单列表
	 * 
	 * @param type
	 *            :1/2/3 1=>近一个月订单 2=>一个月前订单 3=>已取消订单
	 * @param page
	 *            :第几页 1
	 * @param pageNum
	 *            :每页个数 10
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public List<Map<String, Object>> getOrderList(int userid,int type, int page, int pageNum) {
		try {
			// type 1/2/3 1=>近一个月订单 2=>一个月前订单 3=>已取消订单
			// page 第几页 1
			// pageNum 每页个数 10

			// "orderid": "412423145", //订单ID
			// "status": "未处理", //订单显示状态 交易成功 已完成
			// "time": "2011/10/100 12:16:40", //下单时间
			// "price": "1234.23", //订单金额
			// "flag":"1" //订单标识，1=>可删除可修改 2=>不可修改 3=>已完成 4-->已取消
			// 日期的处理
			String month = "";
			String flag = "";
			if (type == 1) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
				month = format.format(new Date());
			} else if (type == 2) {
				// new Date().
				// TODO 获取上个月
				month = DateUtil.getLastDate();
			} else if (type == 3) {
				flag = "4";
			}

			// 分页处理
			if(page<=0)page=1;
			int startNum = (page - 1) * pageNum;
			// TODO：日期处理不能是2013-01-01格式，协议中是2013/01/01
			String sql = "select orderid,status,time,price,flag," +
					"(SELECT TYPE FROM paymenttype WHERE id = paymenttypeid) paymenttype" +
					" from orderinfo where userid =? and time like '" + month + "%' ";
			if (!"".equals(flag)) {
				sql += " and flag =   '" + flag + "'";
			}
			sql += "order by time desc limit ?,?";
			return runner.query(sql, new MapListHandler(), userid,startNum, pageNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取订单详情
	 * 
	 * @param orderId
	 * @return
	 */
	public Map<String, Object> getOderDetail(String orderId) {
		try {
			List<Map<String, Object>> orderList = getOrderList(-1,0, 1, 1);
			String sql = "SELECT orderid,status,time,price,flag,userid," +
					"productinfos productlist, " +
					"(SELECT TYPE FROM paymenttype WHERE id = paymenttypeid) payment_info, " +
					"(SELECT TYPE FROM deliveryinfo WHERE id = deliveryid) delivery_info, " +
					" addressid, " +
					" (SELECT title FROM invoiceinfo i WHERE i.orderid = o.orderid) invoice_info"+
					" FROM orderinfo o WHERE orderid= ?";
			return runner.query(sql, new MapHandler(), orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 订单取消，更新flag为4，已取消标志。status：订单显示状态
	 * 
	 * @param orderid
	 */
	public boolean orderCancle(String orderid) {
		try {
			String sql = "update orderinfo set flag = '4' ,status = '订单已取消' where orderid = ?";
			int update = runner.update(sql, orderid);
			if (update > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 插入新的订单.
	 * 
	 * @param userId
	 * @param productInfos
	 * @param addressId
	 * @param paymentId
	 * @param delivetyId
	 * @param invoiceType
	 * @param invoiceTitle
	 * @param invoiceContent
	 * @return 
	 */
	public Map<String, Object> insertNewOrder(String userId, String productInfos, String addressId, String paymentId, String delivetyId, String invoiceType,
			String invoiceTitle, String invoiceContent) {
		// userId
		//
		// Sku 商品ID:数量:属性ID|商品ID:数量:属性ID 1200001:3:1,2|1200004:2:2,3
		// addressid 地址簿ID 1001
		// paymentid 支付方式 1
		// deliveryid 送货时间 1
		// invoicetype 发票类型 1=>个人 2=>单位
		// invoicetitle 发票抬头 北京红孩子互联科技有限公司
		// invoicecontent 发票内容 1
		

		try {

			// 1.根据客户端传递的信息,开始往orderinfo表中生成新的order.
			String sql_insertOrder = "INSERT INTO orderinfo(STATUS,TIME,price,flag,userid,productinfos,paymenttypeid,deliveryid,addressid)VALUES(?,?,?,?,?,?,?,?,?);";

			Date date = new Date();
			format = new SimpleDateFormat("yyyy-MM-dd");
			
			String str_date = format.format(date);
			double totalPrice = 0;
			productInfos = "101211:2:2,3|10211:2:4,3";
			String[] cartItems = productInfos.split("\\|");
			for (String cartItem : cartItems) {
				String[] infos = cartItem.split(":");
				// 根据商品的id查询该商品的价格
				String price = runner.query("select price from product where id=?", new ScalarHandler(), infos[0]).toString();
				totalPrice = Double.parseDouble(price) * Integer.parseInt(infos[1]);
			}
			runner.update(sql_insertOrder, "1", str_date, totalPrice, "1", userId, productInfos, paymentId, delivetyId, addressId);
			
			//2.开始查找刚插入数据id值
			String orderId = runner.query("select orderid from orderinfo order by orderid desc", new ScalarHandler()).toString();
			
			//3.给用户插入一条新的发票.如果这三个数据都是空,那么就不开发票.
			if(StringUtils.isNotBlank(invoiceType)||StringUtils.isNotBlank(invoiceType)||StringUtils.isNotBlank(invoiceType)){
				String sql_insertInvoice = "INSERT INTO invoiceinfo(userid,orderid,title,content,TYPE)VALUES(?,?,?,?,?);";
				runner.update(sql_insertInvoice,userId,orderId,invoiceTitle,invoiceContent,invoiceType);
			}
			
			//4.从支付方式表中插入用户的付款方式的名称:直接判断
			String payType = "";
			if("1".equals(paymentId)){
				payType = "货到付款";
			}else if("2".equals(paymentId)){
				payType ="POS机";
			}else{
				payType= "支付宝";
			}
			
			//生成一个随机的运费.
			int freight = random.nextInt(30);
			
			Map<String,Object> orderInfo = new HashMap<String, Object>();
			orderInfo.put("orderid", orderId);
			orderInfo.put("price", totalPrice+freight);
			orderInfo.put("paymenttype", payType);
			
			return orderInfo;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @param userid
	 */
	public int getOrderCount(String userid) {
		if(null == userid ||"".equals(userid))return 0;
		try {
			String sql = "SELECT COUNT(1) as num FROM orderinfo WHERE userid = ?";
			Map<String, Object> query = runner.query(sql, new MapHandler(),userid);
			if(query!=null){
				return Integer.parseInt(query.get("num").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
