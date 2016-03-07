package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

public class LoginDaoImpl {

	protected QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());
	public List<Map<String, Object>> getLoginList(String username,String password) {
		String sql = "select userid,level,bonus from user where username=? and password=?";
		try {
			 return runner.query(sql, new MapListHandler(), username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Map<String, Object>> getLoginList(String username) {
		String sql = "select userid from user where username=?";
		try {
			return runner.query(sql, new MapListHandler(), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
