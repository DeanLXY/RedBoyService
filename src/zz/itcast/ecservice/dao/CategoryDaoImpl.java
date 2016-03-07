package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import zz.itcast.ecservice.domain.Category;
import zz.itcast.ecservice.utils.DataSourceManager;

/**
 * 类别的业务实现类
 * 
 * @author Administrator
 * 
 */
public class CategoryDaoImpl {

	public List<Category> getCateGoryList() {
		try {
			QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
			String sql = "SELECT id,isleafnode,name,parentid,pic,t,level FROM category";
			return runner.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
