package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

public class PaymentInfoDaoImpl {

	protected QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());

	/**
	 * 获取支付信息
	 * 
	 * @param orderid
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Map<String, Object> getPayMentInfo(String orderid) {
		try {
			//这里的id，就是支付类型，封装的协议中是type，所以id起别名为type
			String sql = "  select id type from paymenttype where id = ( select paymenttypeid from orderinfo where orderid = ?)";
			return runner.query(sql, new MapHandler(), orderid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
