package kr.or.ddit.board.model;

public class PageVo {
	
	private int page;
	private int pageSize;
	private int board_no;
	
	public PageVo() {
		
	}
	
	public PageVo(int page, int pageSize, int board_no) {
		this.page = page;
		this.pageSize = pageSize;
		this.board_no = board_no;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	@Override
	public String toString() {
		return "PageVo [page=" + page + ", pageSize=" + pageSize + ", board_no=" + board_no + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_no;
		result = prime * result + page;
		result = prime * result + pageSize;
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
		PageVo other = (PageVo) obj;
		if (board_no != other.board_no)
			return false;
		if (page != other.page)
			return false;
		if (pageSize != other.pageSize)
			return false;
		return true;
	}
	
}
