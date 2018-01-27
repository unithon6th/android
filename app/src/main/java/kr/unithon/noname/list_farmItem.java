package kr.unithon.noname;

import android.os.Bundle;

/**
 * Created by yunjiseon on 2018. 1. 27..
 */
 // 농장 정보 들어갈 클래스
public class list_farmItem {

    /*
*  식물 이름
*  메인이미지 // int 로 ??
*  농장이름
*  농장 설명
* */
    private String cropname;
    private int profile_image;
    public String farmname;
    private String content;

    public list_farmItem(int profile_image, String cropname, String farmname, String content) {
        this.profile_image = profile_image;
        this.cropname = cropname;
        this.farmname= farmname;
        this.content= content;
    }

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public void setFarmname(String farmname) {
        this.content = farmname;
    }

    public String getFarmname() {
        return farmname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
