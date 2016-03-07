package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

public class HelpDetailDaoImpl {
	// {
	// "title":"怎么购买？", //title
	// "content":" content " //帮助内容
	// },
	// {
	// "title":"怎么配送？", //title
	// "content":" content " //帮助内容
	// },
	protected QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());

	public List<Map<String, Object>> getHelpDetailList(int helpId) {
		String sql = "SELECT title,content FROM help_detail WHERE state=1 AND help_id=?";
		try {
			return runner.query(sql, new MapListHandler(), helpId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
