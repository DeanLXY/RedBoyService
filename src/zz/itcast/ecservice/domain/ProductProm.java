package zz.itcast.ecservice.domain;

/**
 * 促销信息实体
 * 
 * @author Administrator
 * 
 */
public class ProductProm {
	// "促销信息1",
	// "促销信息2",
	private Integer id;
	private String prominfo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProminfo() {
		return prominfo;
	}

	public void setProminfo(String prominfo) {
		this.prominfo = prominfo;
	}

}
