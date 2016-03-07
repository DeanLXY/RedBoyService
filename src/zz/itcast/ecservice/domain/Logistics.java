package zz.itcast.ecservice.domain;

import java.util.List;
import java.util.Map;

/**
 * 物流表
 * 
 * @author boss
 * 
 */
public class Logistics {
	private String id;
	private String expressWay;
	private String company;
	private String logisticsnum;
	private String transportnum;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLogisticsnum() {
		return logisticsnum;
	}

	public void setLogisticsnum(String logisticsnum) {
		this.logisticsnum = logisticsnum;
	}

	public String getTransportnum() {
		return transportnum;
	}

	public void setTransportnum(String transportnum) {
		this.transportnum = transportnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExpressWay() {
		return expressWay;
	}

	public void setExpressWay(String expressWay) {
		this.expressWay = expressWay;
	}

}
