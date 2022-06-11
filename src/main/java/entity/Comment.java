package entity;

public class Comment {
	
	private int cid;
	private int pid;
	private int uid;
	private String comment;
	
	public Comment(int pid, int uid, String comment) {
		//super();
		this.pid = pid;
		this.uid = uid;
		this.comment = comment;
	}
	
	public Comment(int cid,int pid, int uid, String comment) {
		//super();
		this.cid = cid;
		this.uid = uid;
		this.pid = pid;
		this.comment = comment;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}