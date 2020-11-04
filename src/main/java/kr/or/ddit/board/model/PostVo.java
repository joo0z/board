package kr.or.ddit.board.model;

import java.util.Date;

public class PostVo {
	private String post_title;
	private String post_content;
	private String post_status;
	private Date post_regdate;
	private int post_no;
	private int post_pno;
	private String user_id;
	private int board_no;
	
//	private int page;
//	private int pageSize;
//	
//	public PostVo() {
//		
//	}
//	public PostVo(int page, int pageSize, int board_no, int post_pno, int post_no, String post_title) {
//		this.page = page;
//		this.pageSize = pageSize;
//		this.board_no = board_no;
//		this.post_no = post_no;
//		this.post_pno = post_pno;
//		this.post_title = post_title;
//	}
	
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public String getPost_status() {
		return post_status;
	}
	public void setPost_status(String post_status) {
		this.post_status = post_status;
	}
	public Date getPost_regdate() {
		return post_regdate;
	}
	public void setPost_regdate(Date post_regdate) {
		this.post_regdate = post_regdate;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public int getPost_pno() {
		return post_pno;
	}
	public void setPost_pno(int post_pno) {
		this.post_pno = post_pno;
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
//	public int getPage() {
//		return page;
//	}
//	public void setPage(int page) {
//		this.page = page;
//	}
//	public int getPageSize() {
//		return pageSize;
//	}
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}
//	@Override
//	public String toString() {
//		return "PostVo [post_title=" + post_title + ", post_content=" + post_content + ", post_status=" + post_status
//				+ ", post_regdate=" + post_regdate + ", post_no=" + post_no + ", post_pno=" + post_pno + ", user_id="
//				+ user_id + ", board_no=" + board_no + ", page=" + page + ", pageSize=" + pageSize + "]";
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + board_no;
//		result = prime * result + page;
//		result = prime * result + pageSize;
//		result = prime * result + ((post_content == null) ? 0 : post_content.hashCode());
//		result = prime * result + post_no;
//		result = prime * result + post_pno;
//		result = prime * result + ((post_regdate == null) ? 0 : post_regdate.hashCode());
//		result = prime * result + ((post_status == null) ? 0 : post_status.hashCode());
//		result = prime * result + ((post_title == null) ? 0 : post_title.hashCode());
//		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		PostVo other = (PostVo) obj;
//		if (board_no != other.board_no)
//			return false;
//		if (page != other.page)
//			return false;
//		if (pageSize != other.pageSize)
//			return false;
//		if (post_content == null) {
//			if (other.post_content != null)
//				return false;
//		} else if (!post_content.equals(other.post_content))
//			return false;
//		if (post_no != other.post_no)
//			return false;
//		if (post_pno != other.post_pno)
//			return false;
//		if (post_regdate == null) {
//			if (other.post_regdate != null)
//				return false;
//		} else if (!post_regdate.equals(other.post_regdate))
//			return false;
//		if (post_status == null) {
//			if (other.post_status != null)
//				return false;
//		} else if (!post_status.equals(other.post_status))
//			return false;
//		if (post_title == null) {
//			if (other.post_title != null)
//				return false;
//		} else if (!post_title.equals(other.post_title))
//			return false;
//		if (user_id == null) {
//			if (other.user_id != null)
//				return false;
//		} else if (!user_id.equals(other.user_id))
//			return false;
//		return true;
//	}
//	
//	
	
	
	
	
	
}
