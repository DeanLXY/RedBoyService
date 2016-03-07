package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.domain.ProductProperty;
import zz.itcast.ecservice.utils.DataSourceManager;

/**
 * 商品详情的业务实现
 * 
 * @author Administrator
 * 
 */
public class ProductDaoImpl {

	public List<Map<String, Object>> getProductDetail(int pID) {
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		try {
			List<Object> picList = getPicUrlList(pID);
			data.put("pic", picList);
			List<Object> promList = getProdPromList(pID);
			data.put("productProm", promList);
			List<Object> bigPicList = getBigPicUrlList(pID);
			data.put("bigpic", bigPicList);
			List<ProductProperty> prodPropertyList = getProdPropertyList(pID);
			data.put("product_property", prodPropertyList);

			// 　　　"score": "4.5", //评分
			// 　　　"available": "yes/no", //是否可售
			// 　　　"buyLimit":"购买上限" //单品购买上限
			// 　　　"commentCount":"23", //商品评论数
			// 　　　"inventoryArea":"可发送至", //配货说明
			List<Map<String, Object>> prodInfoList = getProdInfoList(pID);
			dataList.add(data);
			dataList.addAll(prodInfoList);
			return dataList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataList;
	}

	/**
	 * 查询商品详情几列的信息
	 * 
	 * @param pID
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getProdInfoList(int pID) {
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());

		try {
			String prodInfoSql = "SELECT * FROM product WHERE id=?";
			return runner.query(prodInfoSql, new MapListHandler(), pID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 商品属性查询
	 * 
	 * @param pID
	 * @return
	 * @throws SQLException
	 */
	public List<ProductProperty> getProdPropertyList(int pID) {
		try {
			QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());

			String productPropertySql = "SELECT id,prodkey,prodvalue FROM product_property WHERE prodid=?";
			List<ProductProperty> prodPropertyList = runner.query(productPropertySql,
					new BeanListHandler<ProductProperty>(ProductProperty.class), pID);
			return prodPropertyList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 大图查询
	 * 
	 * @param pID
	 * @return
	 * @throws SQLException
	 */
	public List<Object> getBigPicUrlList(int pID) {
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());

		try {
			String bigPicUrlSql = "SELECT picurl FROM pic WHERE relatedid=? AND type =1";
			List<Object> bigPicList = runner.query(bigPicUrlSql, new ColumnListHandler(1), pID);
			return bigPicList;
		} catch (SQLException e) {
		}
		return null;
	}

	/**
	 * 商品促销查询
	 * 
	 * @param pID
	 * @return
	 * @throws SQLException
	 */
	public List<Object> getProdPromList(int pID) {
		try {
			QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());

			String productPromSql = "SELECT prominfo FROM productprom WHERE prodid = ?";
			List<Object> promList = runner.query(productPromSql,new ColumnListHandler(1), pID);
			return promList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 小图查询
	 * 
	 * @param pID
	 * @return
	 * @throws SQLException
	 */
	public List<Object> getPicUrlList(int pID) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());

		String picUrlSql = "select picurl from pic where relatedid=? and type = 0";
		List<Object> picList = runner.query(picUrlSql, new ColumnListHandler(1), pID);
		return picList;
	}

	/**
	 * 通过一个商品id,获取购物车所需的信息.
	 * 
	 * @param prodId
	 *            商品id
	 * @return 封装所需product信息的map
	 */
	public Map<String, Object> getCartProdById(String prodId) {
		// "id":"1200001", //商品ID
		// "name": "雅培金装", //商品名称
		// "pic":"", //商品图片URL
		// "price":"89", //商品售价
		// "number": 0, //商品库存数量，0为缺货或下架
		// "uplimit":"10", //商品购买数量上限
		// "isgift":"true"
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
		String sql = "select id,name,pic,price,number,buylimit as uplimit,isgift,score from product where id = ?";
		try {
			List<Map<String, Object>> query = runner.query(sql, new MapListHandler(), prodId);
			Map<String, Object> product = query.get(0);
			String isGift = product.get("isgift").toString();
			product.put("isgift", isGift);
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
