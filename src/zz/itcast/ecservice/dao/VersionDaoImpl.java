package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

public class VersionDaoImpl {

	private QueryRunner runner=new QueryRunner(DataSourceManager.getDataSource());
	public List<Map<String, Object>> getVersion() {
		String sql = "SELECT * FROM VERSION ORDER BY VERSION DESC";
		try {
			 return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
