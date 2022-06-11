package dao;

import java.util.List;

import entity.Comment;

public interface CommentDao {
	List<Comment> getAll(String sql);
	int add(Comment s);
}
