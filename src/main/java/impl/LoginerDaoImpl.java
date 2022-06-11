package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.LoginerDao;
import entity.Loginer;
import utils.DBUtils;

public class LoginerDaoImpl implements LoginerDao{
	public boolean login(String sid,String pwd) {
		int count = 0;
		DBUtils du = new DBUtils();
		ResultSet rs = du.executeQuery("select count(*) from users where sid = '" + sid +"'and pwd = '" + pwd +"'");
		try {
			rs.next();
			count = rs.getInt(1);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count > 0 ?true:false;
	}
	
	@Override
	public List<Loginer> getAll(String sql) {
		ResultSet rs = DBUtils.executeQuery(sql);
		List<Loginer> userList = new ArrayList<>();
		String sid, position, username,pwd,email,phone;
		try {
			while(rs.next()) {
				position = rs.getString(1);
				sid = rs.getString(2);
				username = rs.getString(3);
				pwd = rs.getString(4);
				email = rs.getString(5);
				phone =rs.getString(6);
				Loginer user  = new Loginer(position, sid, username,pwd,email,phone);
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public Loginer getBySid(String sid) {
		ResultSet rs = DBUtils.executeQuery("select * from users where sid = '" + sid + "'");
		String position, username,pwd,email,phone;
		Loginer s = null;
		try {
			if(rs.next()) {
				position = rs.getString(1);
				username = rs.getString(3);
				pwd = rs.getString(4);
				email = rs.getString(5);
				phone =rs.getString(6);
				s = new Loginer(position, sid, username,pwd,email,phone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	@Override
	public int add(Loginer s) {
		String sid = s.getSid();
		String username = s.getUsername();
		String position = s.getPosition();
		String pwd = s.getPwd();
		String email =s.getEmail();
		String phone = s.getPhone();
		String sql = "insert into users(position, sid, username, pwd, email, phone) values('" + position + "','" + sid +  "','"+ username +"','"+ pwd+"','"+ email+"','"+ phone +"')";
		return DBUtils.executeUpdate(sql);	
	}
	
	@Override
	public int modify(Loginer s) {
		String sid = s.getSid();
		String username = s.getUsername();
		String pwd = s.getPwd();
		String sql = "update users set username = '" + username 
				+ ", pwd = '" + pwd
				+ "' where sid = '" + sid + "'";
		return DBUtils.executeUpdate(sql);
	}
	
	@Override
	public int remove(String sid) {
		String sql = "delete from users where sid = '" + sid + "'";
		return DBUtils.executeUpdate(sql);
	}
}
