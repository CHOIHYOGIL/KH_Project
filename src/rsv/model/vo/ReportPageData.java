package rsv.model.vo;

import java.util.ArrayList;

import member.model.vo.User;

public class ReportPageData {


   private ArrayList<Report> list;
   private String pageNavi;
   
   public ArrayList<Report> getList() {
      return list;
   }
   public void setList(ArrayList<Report> list) {
      this.list = list;
   }
   public String getPageNavi() {
      return pageNavi;
   }
   public void setPageNavi(String pageNavi) {
      this.pageNavi = pageNavi;
   }
   public ReportPageData(ArrayList<Report> list, String pageNavi) {
      super();
      this.list = list;
      this.pageNavi = pageNavi;
   }

   public ReportPageData() {
      super();
      // TODO Auto-generated constructor stub
   }

   

}