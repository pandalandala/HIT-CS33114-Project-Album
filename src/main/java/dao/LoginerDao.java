package dao;

import java.util.List;

import entity.Loginer;

public interface LoginerDao {
	public boolean login(String userid,String pwd);
	List<Loginer> getAll(String sql);
	Loginer getBySid(String sid);
	int add(Loginer a);
	int modify(Loginer a);
	int remove(String sid);
}
