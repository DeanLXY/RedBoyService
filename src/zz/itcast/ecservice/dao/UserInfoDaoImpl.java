package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

public class UserInfoDaoImpl {

	private QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());

	public Map<String, Object> getUserInfoList(int userid) {
		try {
			// List<Map<String, Object>> data = new ArrayList<Map<String,
			// Object>>();
			// Map<String, Object> orderCountMap = new HashMap<String,
			// Object>();
			// String orderCountSql =
			// "SELECT COUNT(*) orderCount FROM orderinfo WHERE userid=?";
			// orderCountMap = runner.query(orderCountSql, new MapHandler(),
			// userid);
			// data.add(orderCountMap);

			String sql = "select *,COUNT(*) orderCount FROM USER RIGHT JOIN orderinfo ON user.`userid`=orderinfo.`userid` WHERE user.userid=? GROUP BY user.`userid`";

			Map<String, Object> data = runner.query(sql, new MapHandler(),
					userid);
			// String sql2 =
			// " SELECT COUNT(*) orderCount FROM orderinfo WHERE userid=?";
			return data;// runner.query(sql, new MapHandler(), userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
