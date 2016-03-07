package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

/**
 * 搜索的业务类
 * 
 * @author Administrator
 * 
 */
public class SearchDaoImpl {
	// {
	// 　"response": "searchrecommend",
	// "search_keywords": [ //CMS定义推荐关键词，如无为空
	// "adidas",
	// "361",
	// "nike"
	// ]
	// }
	public List<Object> getRecommentList() {
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
		String sql = "SELECT searchkeyword FROM search_keywords";
		try {
			return runner.query(sql, new ColumnListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据 关键字 查询商品列表
	 * 
	 * @param searchkey
	 * @param page
	 * @param pageNum
	 * @param orderby
	 * @return
	 */
	public List<Map<String, Object>> getProductList(String searchkey, int page, int pageNum, String orderby) {
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
		// SELECT id,NAME,pic,marketprice,price FROM product WHERE searchkey='1'
		// ORDER BY sales DESC LIMIT 10,10
		String sql = "SELECT id,name,pic,marketprice,price FROM product WHERE searchkey =" + searchkey;
		try {
			return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
