package zz.itcast.ecservice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import zz.itcast.ecservice.domain.Address;
import zz.itcast.ecservice.utils.DataSourceManager;

public class AddressDaoImpl {

	/**
	 * 查询地址列表
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getAddressList(Address a) {
		try {
			QueryRunner runner = new QueryRunner(
					DataSourceManager.getDataSource());
//			String sql = "select address.name,address.phoneNumber,address.addressDetail,addressarea.value from addressarea,address where address.provinceId=addressarea.id";
			String sql = "select *,(select value from addressarea where id = provinceid) province,(select value from addressarea where id = cityid) city,(select value from addressarea where id = areaid) area from address";
			if(a != null && "".equals(a.getId())){
				sql+=" and address.id="+a.getId();
			}
			return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询出现异常");
		}
	
	}
	
	public List<Map<String,Object>> getCity(Address a){
		try {
			QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
			String sql = "select address.name,addressarea.value from addressarea,address where address.cityId=addressarea.id and address.id=?";
			return runner.query(sql, new MapListHandler(),a.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询城市出现异常");
		}
	}
	
	public List<Map<String,Object>> getArea(Address a){
		try {
			QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
			String sql = "select address.name,addressarea.value from addressarea,address where address.areaId=addressarea.id and address.id=?";
			return runner.query(sql, new MapListHandler(), a.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询地区出现异常");
		}
	}

	/**
	 * 新增地址
	 * 
	 * @param a
	 */
	public void getInsertAddress(Address a) {
		try {
			QueryRunner runner = new QueryRunner(
					DataSourceManager.getDataSource());
			String sql = "insert into address values(null,?,?,?,?,?,?,?,?,?,?)";
			runner.update(sql, a.getName(),a.getPhoneNumber(),a.getFixedtel(),a.getProvinceId(),a.getCityId(),a.getAreaId(),a.getAddressDetail(),a.getZipCode(),a.getUserId(),a.getIsDefault());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加出现异常");
		}
	}

	/**
	 * 根据id删除地址
	 * 
	 * @param id
	 */
	public void getDeleteAddress(int id) {
		try {
			QueryRunner runner = new QueryRunner(
					DataSourceManager.getDataSource());
			String sql = "delete from address where id = ?";
			runner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除出现异常");
		}
	}

	public void getUpdateAddress(Address a) {
		try {
			QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
			String sql = "update address set name=?,phoneNumber=?,fixedtel=?,provinceId=?,cityId=?,areaId=?,addressDetail=?,zipCode=?,userId=?,isDefault=? where id=?";
			runner.update(sql, a.getName(), a.getPhoneNumber(), a.getFixedtel(), a.getProvinceId(),a.getCityId(), a.getAreaId(), a.getAddressDetail(),a.getZipCode(),a.getUserId(), a.getIsDefault(), a.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改出现异常");
		}
	}
	
	public List<Map<String, Object>> getProvinceId(String string){
		String sql = "select id from addressarea where value=?";
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
		try {
			return runner.query(sql, new MapListHandler(), string);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("根据省获取省id出现异常");
		}
	}
	public List<Map<String, Object>> getCityId(String string){
		String sql = "select id from addressarea where value=?";
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
		try {
			return runner.query(sql, new MapListHandler(), string);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("根据省获取省id出现异常");
		}
	}
	public List<Map<String, Object>> getAreaId(String string){
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
		String sql = "select id from addressarea where value=?";
		try {
			return runner.query(sql, new MapListHandler(), string);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("根据地区获取地区id出现异常");
		}
	}
	public List<Map<String, Object>> getProvinceAll(){
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
		String sql = "select id,value from addressarea where parentId=0";
		try {
			return runner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有省份出现异常");
		}
	}
	public List<Map<String, Object>> getCityAll(int pid){
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
		String sql2 = "select id,value from addressarea where parentId=?";
		try {
			return runner.query(sql2, new MapListHandler(),pid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("根据省份查询所有城市出现异常");
		}
	}
	public List<Map<String, Object>> getAreaAll(int pid){
		QueryRunner runner = new QueryRunner(DataSourceManager.getDataSource());
		String sql3 = "select value from addressarea where parentId=?";
		try {
			return runner.query(sql3, new MapListHandler(),pid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("根据城市查询所有地区出现异常");
		}
	}
	/**
	 * 根据OrderId，查询地址信息
	 * 
	 * @return
	 */
	public Map<String, Object> getAddressByOrderId(String orderId) {
//		"id":"1001",                   //地址簿ID
//		  "name":"肖文",                //收货人姓名
//		  "address_area":"北京市海淀区",  //国家三级地址
//		  "address_detail":"闵庄路3号"    //地址详情
		try {
			QueryRunner runner = new QueryRunner(
					DataSourceManager.getDataSource());
			String sql = "select id,name,phonenumber phoneNumber, addressDetail , zipCode" +
					" from address where id = ( select addressid from orderinfo where orderid = ?)";
			return runner.query(sql,new MapHandler(),orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
