package entity;
/**
 * 实体类：
 * 	与表的结构一致，用于存放从数据库中查询出来的记录。
 *
 */
public class User {
	private int id;
	private String username;
	private String pwd;
	private String phone;
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id 
				+ ", username=" + username 
				+ ", pwd=" + pwd + ", phone=" 
				+ phone + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}




