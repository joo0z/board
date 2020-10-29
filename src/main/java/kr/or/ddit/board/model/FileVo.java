package kr.or.ddit.board.model;

public class FileVo {
	private int file_no;
	private String file_name;
	private String file_realnm;
	private int post_no;
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_realnm() {
		return file_realnm;
	}
	public void setFile_realnm(String file_realnm) {
		this.file_realnm = file_realnm;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	@Override
	public String toString() {
		return "FileVo [file_no=" + file_no + ", file_name=" + file_name + ", file_realnm=" + file_realnm + ", post_no="
				+ post_no + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file_name == null) ? 0 : file_name.hashCode());
		result = prime * result + file_no;
		result = prime * result + ((file_realnm == null) ? 0 : file_realnm.hashCode());
		result = prime * result + post_no;
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
		FileVo other = (FileVo) obj;
		if (file_name == null) {
			if (other.file_name != null)
				return false;
		} else if (!file_name.equals(other.file_name))
			return false;
		if (file_no != other.file_no)
			return false;
		if (file_realnm == null) {
			if (other.file_realnm != null)
				return false;
		} else if (!file_realnm.equals(other.file_realnm))
			return false;
		if (post_no != other.post_no)
			return false;
		return true;
	}

	
	
}
