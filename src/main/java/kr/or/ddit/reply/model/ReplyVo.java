package kr.or.ddit.reply.model;

import java.util.Date;

public class ReplyVo {
	private int reply_no;
	private String reply_content;
	private String reply_status;
	private Date reply_regdate;
	private String user_id;
	private int post_no;
	@Override
	public String toString() {
		return "ReplyVo [reply_no=" + reply_no + ", reply_content=" + reply_content + ", reply_status=" + reply_status
				+ ", reply_regdate=" + reply_regdate + ", user_id=" + user_id + ", post_no=" + post_no + "]";
	}
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_status() {
		return reply_status;
	}
	public void setReply_status(String reply_status) {
		this.reply_status = reply_status;
	}
	public Date getReply_regdate() {
		return reply_regdate;
	}
	public void setReply_regdate(Date reply_regdate) {
		this.reply_regdate = reply_regdate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + post_no;
		result = prime * result + ((reply_content == null) ? 0 : reply_content.hashCode());
		result = prime * result + reply_no;
		result = prime * result + ((reply_regdate == null) ? 0 : reply_regdate.hashCode());
		result = prime * result + ((reply_status == null) ? 0 : reply_status.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplyVo other = (ReplyVo) obj;
		if (post_no != other.post_no)
			return false;
		if (reply_content == null) {
			if (other.reply_content != null)
				return false;
		} else if (!reply_content.equals(other.reply_content))
			return false;
		if (reply_no != other.reply_no)
			return false;
		if (reply_regdate == null) {
			if (other.reply_regdate != null)
				return false;
		} else if (!reply_regdate.equals(other.reply_regdate))
			return false;
		if (reply_status == null) {
			if (other.reply_status != null)
				return false;
		} else if (!reply_status.equals(other.reply_status))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	
	
	

}
