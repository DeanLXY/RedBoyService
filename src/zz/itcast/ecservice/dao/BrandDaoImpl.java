package zz.itcast.ecservice.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;

public class BrandDaoImpl {
	private DataSource db = DataSourceManager.getDataSource();

	/**
	 * 查询所有的推进品牌,品牌专区-所有品牌
	 * 
	 * @return
	 */
	public List<HashMap<String, Object>> getBrandList() {
		List<HashMap<String, Object>> info = new ArrayList<HashMap<String, Object>>();
		QueryRunner run = new QueryRunner(db);
		String sql1 = "SELECT * FROM recommendbrand";
		try {
			List<Object[]> query1 = run.query(sql1, new ArrayListHandler());
			for (Object[] obj : query1) {
				String recommendid = obj[0].toString();
				String sql2 = "SELECT id,name,pic FROM brandinfo WHERE recommendid = ?";
				List<Map<String, Object>> query2 = run.query(sql2,
						new MapListHandler(), recommendid);

				HashMap<String, Object> infoMap = new HashMap<String, Object>();
				infoMap.put("key", obj[1]);
				infoMap.put("value", query2);

				info.add(infoMap);
			}

			return info;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
