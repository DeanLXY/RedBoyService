package zz.itcast.ecservice.domain;

public class HelpDetail {
	private int id;
	private int helpId;
	private String title;
	private String content;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHelpId() {
		return helpId;
	}
	public void setHelpId(int helpId) {
		this.helpId = helpId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "HelpDetail [id=" + id + ", helpId=" + helpId + ", title="
				+ title + ", content=" + content + ", state=" + state + "]";
	}
	
}
