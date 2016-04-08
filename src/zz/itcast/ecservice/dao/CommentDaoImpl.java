package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

/**
 * 商品评论的业务类
 * 
 * @author Administrator
 * 
 */
public class CommentDaoImpl {
	// pId 商品ID 1102539
	// page 第几页 1
	// pageNum 每页个数 10
	public List<Map<String, Object>> getCommentInfoList(Integer pId, int page, int pageNum) {
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
		// 　　 "title":"东西不错", //评论标题
		// 　　 "content":"东西不错", //评论内容
		// 　　 "username":"用户", //评论用户
		// 　　 "time":"2001-12-24 23:00:00" //评论时间
		String sql = "SELECT title,content,username,time FROM comment WHERE productid=?";
		try {
			return runner.query(sql, new MapListHandler(), pId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
