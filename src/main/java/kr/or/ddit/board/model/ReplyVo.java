package kr.or.ddit.board.model;

import java.util.Date;

public class ReplyVo {
	private int rep_no;
	private String rep_content;
	private String rep_status;
	private Date rep_regdate;
	private String user_id;
	private int board_no;
	public int getRep_no() {
		return rep_no;
	}
	public void setRep_no(int rep_no) {
		this.rep_no = rep_no;
	}
	public String getRep_content() {
		return rep_content;
	}
	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}
	public String getRep_status() {
		return rep_status;
	}
	public void setRep_status(String rep_status) {
		this.rep_status = rep_status;
	}
	public Date getRep_regdate() {
		return rep_regdate;
	}
	public void setRep_regdate(Date rep_regdate) {
		this.rep_regdate = rep_regdate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	@Override
	public String toString() {
		return "ReplyVo [rep_no=" + rep_no + ", rep_content=" + rep_content + ", rep_status=" + rep_status
				+ ", rep_regdate=" + rep_regdate + ", user_id=" + user_id + ", board_no=" + board_no + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_no;
		result = prime * result + ((rep_content == null) ? 0 : rep_content.hashCode());
		result = prime * result + rep_no;
		result = prime * result + ((rep_regdate == null) ? 0 : rep_regdate.hashCode());
		result = prime * result + ((rep_status == null) ? 0 : rep_status.hashCode());
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
		if (board_no != other.board_no)
			return false;
		if (rep_content == null) {
			if (other.rep_content != null)
				return false;
		} else if (!rep_content.equals(other.rep_content))
			return false;
		if (rep_no != other.rep_no)
			return false;
		if (rep_regdate == null) {
			if (other.rep_regdate != null)
				return false;
		} else if (!rep_regdate.equals(other.rep_regdate))
			return false;
		if (rep_status == null) {
			if (other.rep_status != null)
				return false;
		} else if (!rep_status.equals(other.rep_status))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	 

}
