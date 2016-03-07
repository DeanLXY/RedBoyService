package zz.itcast.ecservice.domain;

public class AddressArea {
	private int id;
	private String value;
	private int parentId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public AddressArea(int id, String value, int parentId) {
		super();
		this.id = id;
		this.value = value;
		this.parentId = parentId;
	}
	
	public AddressArea(String value) {
		super();
		this.value = value;
	}
	public AddressArea() {
		super();
	}
	@Override
	public String toString() {
		return "AddressDetail [id=" + id + ", value=" + value + ", parentId="
				+ parentId + "]";
	}
	
}
