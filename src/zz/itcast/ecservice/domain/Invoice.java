package zz.itcast.ecservice.domain;

/**
 *  发票表
 * @author boss
 *
 */
public class Invoice {
	/*`userId` int(11) NOT NULL,
	  `title` varchar(20) default NULL,
	  `content` varchar(100) default NULL*/
	private  Integer userId;
	private String title;
	private String content;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
}
