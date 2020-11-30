package car.model.vo;

import java.util.ArrayList;

public class CarPageData {

	private ArrayList<Car> list;
	private String pageNavi;

	public CarPageData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarPageData(ArrayList<Car> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}

	public ArrayList<Car> getList() {
		return list;
	}

	public void setList(ArrayList<Car> list) {
		this.list = list;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
