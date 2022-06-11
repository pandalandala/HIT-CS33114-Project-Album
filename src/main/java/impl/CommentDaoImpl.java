package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CommentDao;
import entity.Comment;
import utils.DBUtils;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> getAll(String sql) {
		// TODO Auto-generated method stub
		int cid, pid, uid;
		String comment;
		ResultSet rs = DBUtils.executeQuery(sql);
		List<Comment> list = new ArrayList<>();
		try {
			while(rs.next()) {
				cid=rs.getInt(1);
				pid=rs.getInt(2);
				uid=rs.getInt(3);
				comment = rs.getString(4);
				Comment com = new Comment(cid,pid,uid,comment);
				list.add(com);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int add(Comment s) {
		// TODO Auto-generated method stub
		//int cid = s.getCid();
		int pid = s.getPid();
		int uid = s.getUid();
		String comment = s.getComment();
		String sql = "insert into comment(pid, uid, comment) values ("+ pid +","+ uid +",'"+ comment +"')";
		return DBUtils.executeUpdate(sql);	
	}

}
