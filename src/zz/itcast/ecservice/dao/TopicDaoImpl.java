package zz.itcast.ecservice.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

public class TopicDaoImpl {
	private DataSource db = DataSourceManager.getDataSource();

	/**
	 * 获得促销快报.
	 * @return 
	 */
	public List<Map<String, Object>> getTopicList(String page, String pageNum) {
		QueryRunner run = new QueryRunner(db);
		try {
			return run.query("select id,title as name,picurl as pic from topic", new MapListHandler());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
