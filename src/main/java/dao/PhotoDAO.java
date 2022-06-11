package dao;

import java.util.List;

import entity.Photo;

public interface PhotoDAO {
	public List<Photo> getAll();
    public boolean addPhoto(Photo p);
    public boolean delPhotoByAid(int aid);
    public List<Photo> findByAid(int aid, int pageSize, int currentPage);
    public boolean delPhotoByPid(int pid);
    public int getTotalPage(int aid, int pageSize);
    public Photo findByPid(int pid);
    public int getTotalNum(int aid);
    public List<Photo> findAll(int aid);
    public List<Photo> queryPhoto(String sql, int pageSize, int currentPage);
    public int getTotalPage(String sql, int pageSize);
}

