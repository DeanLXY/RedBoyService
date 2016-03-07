package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

/**
 * 商品详细描述的业务类
 * 
 * @author Administrator
 * 
 */
public class ProductDescriptionDaoImpl {
	// {
	// "response": "product_description",
	// 　　"productdesc": "" //商品详情描述
	// }

	public List<Map<String, Object>> getProductDesc(Integer pId) {
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
		String sql = "SELECT productdesc FROM product WHERE id =?";
		try {
			return runner.query(sql, new MapListHandler(), pId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
