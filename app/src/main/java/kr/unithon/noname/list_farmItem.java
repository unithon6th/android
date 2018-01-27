package kr.unithon.noname;

import android.os.Bundle;

/**
 * Created by yunjiseon on 2018. 1. 27..
 */
 // 농장 정보 들어갈 클래스
public class list_farmItem {


 //메인이미지 // int 로 일단 -> url 로 변경 ?

    private String profile_image;
    private String sort; // 종류
    private String cropname; // 작물 이름
  //  public String farmname; // 농장 이름
    private String content; // ₩가격
    private int price;

    public list_farmItem(String profile_image, String cropname,int price, String content, String sort) {
        this.profile_image = profile_image;
        this.cropname = cropname;
        this.price = price;
      //  this.farmname= farmname;
        this.content= content;
        this.sort= sort;
    }

    public String getProfile_image() {
        return profile_image;
    }
    public int getPrice(){return price;}
    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
