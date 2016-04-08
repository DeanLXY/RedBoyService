package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import zz.itcast.ecservice.domain.AddressArea;
import zz.itcast.ecservice.utils.DataSourceManager;

public class AddressAreaImpl {
	QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());

	public List<AddressArea> queryArea() {
		String sql = "select * from addressarea";
		try {
			return runner.query(sql, new BeanListHandler<AddressArea>(
					AddressArea.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
