package zz.itcast.ecservice.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import zz.itcast.ecservice.utils.DataSourceManager;

public class CartAddDaoImpl {
	private QueryRunner runner = new QueryRunner(
			DataSourceManager.getDataSource());

	public int add2Shoppingcart(String userid, String sku) {
		String insertSql = "insert into shoppingcart (userid,s,k,u) values (?,?,?,?)";
		String[] skus = sku.split("\\|");
		for (int i = 0; i < skus.length; i++) {
			String tempSku = skus[i];
			String[] tempSkus = tempSku.split(":");
			try {
				return runner.update(insertSql, userid, tempSkus[0],
						tempSkus[1], tempSkus[2]);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return 0;
	}
	
	
//	public void getShoppingCartByUserId(String userid){
//		String sql = "select * from shppingcart where userid=?";
//		return runner.query(sql, new Map)
//	}
}
