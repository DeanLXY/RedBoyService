package zz.itcast.ecservice.domain;

public class Address {
	private int id;				//d地址薄ID
	private String name;		//收货人姓名
	private String phoneNumber;	//手机号码
	private String fixedtel;	//固定号码
	private int provinceId;		//省ID
	private int cityId;			//市ID
	private int areaId;			//区ID
	private String addressDetail;	//地址详情
	private String zipCode;		//邮编
	private int userId;			//用户id
	private int isDefault;		//是否为默认地址
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFixedtel() {
		return fixedtel;
	}
	public void setFixedtel(String fixedtel) {
		this.fixedtel = fixedtel;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}
	public Address(int id, String name, String phoneNumber, String fixedtel,
			int provinceId, int cityId, int areaId, String addressDetail,
			String zipCode, int userId, int isDefault) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.fixedtel = fixedtel;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.areaId = areaId;
		this.addressDetail = addressDetail;
		this.zipCode = zipCode;
		this.userId = userId;
		this.isDefault = isDefault;
	}
	
	
	
	public Address(int id, String name, String phoneNumber, String fixedtel,
			int provinceId, int cityId, int areaId, String addressDetail,
			String zipCode, int isDefault) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.fixedtel = fixedtel;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.areaId = areaId;
		this.addressDetail = addressDetail;
		this.zipCode = zipCode;
		this.isDefault = isDefault;
	}
	
	
	public Address(int id) {
		super();
		this.id = id;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", phoneNumber="
				+ phoneNumber + ", fixedtel=" + fixedtel + ", provinceId="
				+ provinceId + ", cityId=" + cityId + ", areaId=" + areaId
				+ ", addressDetail=" + addressDetail + ", zipCode=" + zipCode
				+ ", userId=" + userId + ", isDefault=" + isDefault + "]";
	}
	
}
