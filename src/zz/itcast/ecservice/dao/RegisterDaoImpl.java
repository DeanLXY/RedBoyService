package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

public class RegisterDaoImpl {

	private QueryRunner runner=new QueryRunner(DataSourceManager.getDataSource());
	
	public List<Map<String, Object>> getRegisterList(String username,String password) {
		String insertSql="insert into user (username,password) values (?,?)";
		String sql = "select userid from user where username=? and password=?";
		try {
			runner.update(insertSql, username,password);
			return runner.query(sql, new MapListHandler(), username,password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
