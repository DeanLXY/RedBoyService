package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

/**
 * 帮助列表操作
 * 
 * @author Administrator
 * 
 */
public class HelpDaoImpl{
	protected QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());
	public List<Map<String, Object>> getHelpList(int version) {
		String sql = "select id,title from help where state =1 and version>?";
		try {
			return runner.query(sql, new MapListHandler(), version);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Object getLastVersion() {
		String sql = "SELECT version FROM help  WHERE state =1 ORDER BY version DESC LIMIT 0,1";
		try {
//			ResultSetHandler<T>
			return runner.query(sql , new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}