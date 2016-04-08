package zz.itcast.ecservice.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import zz.itcast.ecservice.utils.DataSourceManager;

public class FavoritesAddDaoImpl {
	private QueryRunner runner=new QueryRunner(DataSourceManager.getDataSource());
	
	public int add2Fatorites(String pid, String userid) {
		String sql = "insert into favorites(productid,userid) values(?,?)";
		
		try {
			return runner.update(sql, pid,userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
