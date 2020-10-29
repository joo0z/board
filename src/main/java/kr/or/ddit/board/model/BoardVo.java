package kr.or.ddit.board.model;

import java.io.Serializable;
import java.util.Date;

public class BoardVo implements Serializable{
	
	private int board_no;
	private String board_title;
	private String board_status;
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_status() {
		return board_status;
	}
	public void setBoard_status(String board_status) {
		this.board_status = board_status;
	}
	
	@Override
	public String toString() {
		return "BoardVo [board_no=" + board_no + ", board_title=" + board_title + ", board_status=" + board_status
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_no;
		result = prime * result + ((board_status == null) ? 0 : board_status.hashCode());
		result = prime * result + ((board_title == null) ? 0 : board_title.hashCode());
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
		BoardVo other = (BoardVo) obj;
		if (board_no != other.board_no)
			return false;
		if (board_status == null) {
			if (other.board_status != null)
				return false;
		} else if (!board_status.equals(other.board_status))
			return false;
		if (board_title == null) {
			if (other.board_title != null)
				return false;
		} else if (!board_title.equals(other.board_title))
			return false;
		return true;
	}

	
}
