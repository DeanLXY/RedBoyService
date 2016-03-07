package zz.itcast.ecservice.domain;

/**
 * 版本的业务类
 * 
 * @author Administrator
 * 
 */
public class Version {
	private boolean isNew;

	/**
	 * 默认设置version为 1.1
	 */
	private String version = "1.1";

	private boolean isForse;
	private String url;

	/*********** 使用单例设计模式 ***********************************/
	private static Version versionInstance = new Version();

	private Version() {
	}

	public static Version getInstance() {
		return versionInstance;
	}

	/*********************************************************/
	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public boolean isForse() {
		return isForse;
	}

	public void setForse(boolean isForse) {
		this.isForse = isForse;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVersion() {
		return version;
	}

}
