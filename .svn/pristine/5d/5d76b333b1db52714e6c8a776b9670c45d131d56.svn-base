package zz.itcast.ecservice.dao.balance;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.domain.Logistics;
import zz.itcast.ecservice.utils.DataSourceManager;

/**
 * 物流信息
 * 
 * 
 */
public class LogisticDaoImpl {
	protected QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());

	/**
	 * 根据订单id，获取物流信息
	 * 
	 * @param id
	 * @return
	 */
	public Logistics getLogisticByOrderId(String orderId) {
		try {
			String sql = "select expressWay,company,logisticsnum,transportnum from logistics where orderid = ?";
			return runner.query(sql,
					new BeanHandler<Logistics>(Logistics.class), orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Map<String, Object>> getFollowInfo() {
		List<Map<String, Object>> follow = null;
		try {
			String sql;
			Random random = new Random();
			int randNum = 0;
			randNum = random.nextInt(3) + 1;
			sql = "SELECT followinfo  FROM logistics_follow WHERE orderid = "
					+ randNum + "  ORDER BY num ";
			follow = runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return follow;
	}

}
