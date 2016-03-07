package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

public class HomeBannerDaoImpl {

	private QueryRunner runner=new QueryRunner(DataSourceManager.getDataSource());
	public List<Map<String, Object>> getHomeBannerList(){
		String sql="select * from homebanner";		
		try {
			return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
