package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.utils.DataSourceManager;


public class FavoritesDaoImpl {
	private QueryRunner runner=new QueryRunner(DataSourceManager.getDataSource());
	public List<Map<String, Object>> getFavoritesList(int userid,int page,int pagenum) {
		String sql = "select distinct productid from favorites where userid=? limit ?,?";
		try {
//			"id": "1102539",        //商品ID
//			"name": "雅培金装",    //商品名称
//			"pic": "",              //商品图片URL
//			"marketprice": "79",     //市场价
//            "price": "78",          //会员价
			List<Map<String, Object>> listId = runner.query(sql, new MapListHandler(), userid,(page-1)*pagenum,pagenum);
			List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
			for(Map<String ,Object> item: listId){
				int id = (Integer) item.get("productid");
				sql="select id,name,pic,marketprice,price,commentcount,isgift from product where id=?";
				list.add(runner.query(sql, new MapListHandler(),id).get(0));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getFavoritesNum(int userid){
		String sql="select favoritescount from user where userid=?";
		try {
			List<Map<String, Object>> query = runner.query(sql, new MapListHandler(),userid);
			return (Integer) query.get(0).get("favoritescount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 插入favotites信息
	 * @param userid
	 * @param productid
	 * @return
	 */
	public int insertFavorites(int userid,int productid){
		String sql="insert into favorites (userid,productid) values(?,?)";
		 try {
			 return runner.update(sql, userid,productid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return 0;
	}
}
