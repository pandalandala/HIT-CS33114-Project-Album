package entity;

public class Loginer {
	private String position;
	private String sid;
	private String username;
	private String pwd;
	private String email;
	private String phone;
	
	public Loginer() {
		super();
	}
	public Loginer(String position,String sid,String username,String pwd,String email,String phone)
	{
		this.position = position;
		this.sid = sid;
		this.username = username;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
	}
	public String getPosition()
	{
		return position;
	}
	public String getSid()
	{
		return sid;
	}
	public String getUsername()
	{
		return username;
	}
	public String getPwd()
	{
		return pwd;
	}
	public String getEmail()
	{
		return email;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPosition(String position)
	{
		this.position = position;
	}
	
	public void setSid(String sid)
	{
		this.sid = sid;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
}