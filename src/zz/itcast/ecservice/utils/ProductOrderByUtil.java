package zz.itcast.ecservice.utils;

/**
 * 商品列表排序的工具类
 * 
 * @author Administrator
 * 
 */
public class ProductOrderByUtil {

	/**
	 * 根据参数获取排序规则
	 * 
	 * @param orderby
	 * @return
	 */
	public static String getOrderModel(String orderby) {

		if ("price_up".equals(orderby)) {
			return "price asc";
		}
		if ("price_down".equals(orderby)) {
			return "price desc";
		}
		return "sales desc";
	}
}
