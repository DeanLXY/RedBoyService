package zz.itcast.ecservice.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zz.itcast.ecservice.domain.ProductProperty;

/**
 * 购物车
 * @author Administrator
 *
 */
public class CartDaoImpl {
	
	
	
	/**
	 * 获得购物车详情.
	 * @return 一个封装好的data对象.
	 */
	public  Map<String, Object> getCartInfo(String sku){
		
		
		Map<String, Object> data  = new HashMap<String, Object>();
		
		data.put("response", "cart");
		
		
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		
		int totalCount = 0;
		double totalPrice = 0;
		int totalPoint = 0;
		
		List<Object> cart = new ArrayList<Object>();		
		// 1200001:3:1,2|1200004:2:2,3 商品Id:数量:属性id,属性id...|商品Id:数量:属性id,属性id...
		String[] cartItems = sku.split("\\|");
		for (String cartItem : cartItems) {
			
			Map<String, Object> map_cartItem = new HashMap<String, Object>();
			
			String[] infos = cartItem.split(":");
			
			int prodCount = Integer.parseInt(infos[1]);
			
			map_cartItem.put("prodNum", infos[1]);//设置商品数量.
			//加入总计
			totalCount += prodCount;
			
			
			String prodId = infos[0];
			
			Map<String, Object> map_product = productDaoImpl.getCartProdById(prodId);
			
			
			//计算总额
			totalPrice += prodCount * Double.parseDouble(map_product.get("price").toString());
			
			//计算总积分
			totalPoint += prodCount * Double.parseDouble(map_product.get("score").toString()); 
			
			//移除积分这个属性.
			map_product.remove("score");
			
			//查找商品的属性,设置给商品.
			List<ProductProperty> prodPropertyList = productDaoImpl.getProdPropertyList(Integer.parseInt(prodId));
			
			//查找此商品的促销信息.
			List<Object> prodPromList = productDaoImpl.getProdPromList(Integer.parseInt(prodId));
			 
			map_product.put("prom", prodPromList);
			
			map_product.put("product_property", prodPropertyList);
			
			
			
			map_cartItem.put("product", map_product);
			
			cart.add(map_cartItem);
			
		}
		
		data.put("cart", cart);
		
		data.put("totalCount", totalCount);
		data.put("totalPrice", totalPrice);
		data.put("totalPoint", totalPoint);
		
		
		return data;
		
	}
	
}
