package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.domain.Product;
import zz.itcast.ecservice.utils.DataSourceManager;
import zz.itcast.ecservice.utils.ProductOrderByUtil;

/**
 * 商品列表的业务类
 * 
 * @author Administrator
 * 
 */
public class ProductListDaoImpl {
	// page 第几页 1
	// pageNum 每页个数 10
	// cId 分类ID 1010101
	// orderby 排序
	// sale_down(销量降序)，price_up(价格升序)，price_down(价格降序)，comment_down(评价降序)，shelves_down(上架降序)。
	// 目前只有价格有双向排序，其他都只有降序，其中默认为sale_down
	// filter 筛选 "t1-s2-p1" (三个条件)
	private QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());

	/**
	 * @param page
	 *            页码
	 * @param pageNum
	 *            每页显示
	 * @param cID
	 *            分类ID(表中是categoryid)
	 * @param orderBy
	 *            排序
	 * @param filter
	 *            筛选条件
	 * @return
	 */
	public List<Map<String, Object>> getProductList(int page, int pageNum, Integer cID, String orderBy, String filter) {
		// select id,name,pic,marketprice,price,commentcount from ec.product
		// where categoryid=1 order by sales desc limit 10,10
	System.out.println("ProductListDaoImpl.getProductList()"+page+","+pageNum+","+cID+","+orderBy+","+filter+",");
		String sql = "SELECT id,name,pic,marketprice,price,commentcount,sales FROM product WHERE categoryid=? ORDER BY ? LIMIT ?,?";
		try {
			return runner.query(sql, new MapListHandler(), cID, orderBy, (page - 1) * pageNum, pageNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得某一个topic下的所有的商品.
	 * 
	 * @param page
	 *            页码
	 * @param pageNum
	 *            每页显示
	 * @param topicID
	 *            主题id(对应的表:topic)
	 * @param orderBy
	 *            排序条件
	 */
	public List<Map<String, Object>> getTopicProdList(int page, int pageNum, Integer topicID, String orderBy) {
		// "id": "1102539", //商品ID
		// "name": "雅培金装", //商品名称
		// "pic": "", //商品图片URL
		// "marketprice": "79", //市场价
		// "price": "78", //会员价

		String orderModel = ProductOrderByUtil.getOrderModel(orderBy);

		String sql = "SELECT id,name,pic,marketprice,price,sales FROM product WHERE topicid=? ORDER BY ? LIMIT ?,?";
		try {
			return runner.query(sql, new MapListHandler(), topicID, orderModel, (page - 1) * pageNum, pageNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 获得某一个brand下的所有的商品.
	 * 
	 * @param page
	 *            页码
	 * @param pageNum
	 *            每页显示
	 * @param brandId
	 *            主题id(对应的表:topic)
	 * @param orderBy
	 *            排序条件
	 */
	public List<Map<String, Object>> getBrandProdList(int page, int pageNum, Integer brandId, String orderBy) {
		// "id": "1102539", //商品ID
		// "name": "雅培金装", //商品名称
		// "pic": "", //商品图片URL
		// "marketprice": "79", //市场价
		// "price": "78", //会员价

		String orderModel = ProductOrderByUtil.getOrderModel(orderBy);

		String sql = "SELECT id,name,pic,marketprice,price,sales FROM product WHERE topicid=? ORDER BY ? LIMIT ?,?";
		try {
			return runner.query(sql, new MapListHandler(), brandId, orderModel, (page - 1) * pageNum, pageNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得限时抢购的商品
	 * 
	 * @param page
	 * @param pageNum
	 * @return
	 */
	public List<Map<String, Object>> getLimitBuyProdList(int page, int pageNum) {
		String sql = "SELECT id,NAME,pic,price,limitprice,lefttime,sales FROM product WHERE islimitbuy=TRUE LIMIT ?,?";
		try {
			return runner.query(sql, new MapListHandler(), (page - 1) * pageNum, pageNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得某一个新品上架的商品.
	 * 
	 * @param page
	 *            页码
	 * @param pageNum
	 *            每页显示
	 * @param orderBy
	 *            排序条件
	 */
	public List<Map<String, Object>> getNewProdList(int page, int pageNum, String orderBy) {
		// "id": "1102539", //商品ID
		// "name": "雅培金装", //商品名称
		// "pic": "", //商品图片URL
		// "marketprice": "79", //市场价
		// "price": "78", //会员价

		String orderModel = ProductOrderByUtil.getOrderModel(orderBy);

		String sql = "SELECT id,name,pic,marketprice,price,sales FROM product WHERE isnewproduct=1 ORDER BY ? LIMIT ?,?";
		try {
			return runner.query(sql, new MapListHandler(), orderModel, (page - 1) * pageNum, pageNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得某一个热销的商品.
	 * 
	 * @param page
	 *            页码
	 * @param pageNum
	 *            每页显示
	 * @param orderBy
	 *            排序条件
	 */
	public List<Map<String, Object>> getHotProdList(int page, int pageNum, String orderBy) {
		// "id": "1102539", //商品ID
		// "name": "雅培金装", //商品名称
		// "pic": "", //商品图片URL
		// "marketprice": "79", //市场价
		// "price": "78", //会员价
		String orderModel = ProductOrderByUtil.getOrderModel(orderBy);

		String sql = "SELECT id,name,pic,marketprice,price,sales FROM product WHERE ishotproduct=1 ORDER BY ? LIMIT ?,?";
		try {
			return runner.query(sql, new MapListHandler(), orderModel, (page - 1) * pageNum, pageNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取订单详情的商品列表
	 *  --wangdh
	 */
	public List<Product> getOrderDetail_ProductList(String orderid) {
//		"id":"1102539",              //商品ID
//		"name": "雅培金装",          //商品名称
//		"pic":"",                    //商品图片URL
//		"price":"89",                 //商品售价
//		"product_property":[          //属性
//		    {
//		       "key": "颜色",
//		       "value": "红色",
//		},
//		{
//		       "key": "大小",
//		       "value": "M",
//		}
//		],
//		  "number": 0,                //商品数量，0为缺货或下架
//		  "uplimit":"10"               //商品购买数量上限
//		"isgift":"yes"                //是否赠品
		String sql = "SELECT id,name,pic,marketprice,number,buylimit,isgift FROM product  WHERE id in (select productinfos from orderinfo where orderid = ?)";
		try {
			List<Product> products = runner.query(sql, new BeanListHandler<Product>(Product.class),orderid);
			int productId ;
			for (Product product : products) {
				productId = product.getId();
				sql = "select prodkey key,prodvalue value from product_property where prodid = ?";
				List<Map<String, Object>> property = runner.query(sql,new  MapListHandler(),productId);
				product.setProductProertyLists(property);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
