package zz.itcast.ecservice.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import zz.itcast.ecservice.domain.Help;
import zz.itcast.ecservice.utils.DataSourceManager;

public class HelpDao {
	QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
	
	 public  List<Help>  getHelpList(String version){
		 String sql = "SELECT * FROM help WHERE version>? AND state =1";
//		 ResultSetHandler<T>
		try {
			List<Help> list = runner.query(sql, new BeanListHandler<Help>(Help.class), version);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	 }

	public Object getLastVersion() {
		String sql = "SELECT version  FROM help WHERE state =1  ORDER BY version DESC LIMIT 0,1";
//	 ResultSetHandler<T>
	try {
		return runner.query(sql, new ScalarHandler());
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;}
}
