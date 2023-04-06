package board;

import java.sql.Date;

public class BoardDTO {
	private String num;
	private String title;
	private String content;
	private String id;
	private Date posdate;
	private String visitcount;
	private String name;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getPosdate() {
		return posdate;
	}
	public void setPosdate(Date posdate) {
		this.posdate = posdate;
	}

	public String getVisitcount() {
		return visitcount;
	}
	public void setVisitcount(String visitcount) {
		this.visitcount = visitcount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
		
}
