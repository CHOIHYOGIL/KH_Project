package rsv.model.vo;

import java.util.ArrayList;

public class RsvPageData {
	
	private ArrayList<Rsv> list;
	private String pageNavi;
	public RsvPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RsvPageData(ArrayList<Rsv> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<Rsv> getList() {
		return list;
	}
	public void setList(ArrayList<Rsv> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	

}
