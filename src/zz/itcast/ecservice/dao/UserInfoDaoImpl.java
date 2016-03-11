package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

public class UserInfoDaoImpl {

	private QueryRunner runner=new QueryRunner(DataSourceManager.getDataSource());
	public List<Map<String, Object>> getUserInfoList(int userid) {
		String sql = "select userid,username,bonus,level,usersession,ordercount,favoritescount from user where userid=?";
		try {
			 return runner.query(sql, new MapListHandler(), userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
