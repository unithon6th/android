package kr.unithon.noname;

/**
 * Created by yunjiseon on 2018. 1. 27..
 */

public class list_cropItem {
    //메인이미지 // int 로 일단 -> url 로 변경 ?

    private String profile_image;
    private int Dday;
    private String nickname; // 작물 이름
    public String farmname; // 농장

    public list_cropItem(String profile_image, String nickname, String farmname,int Dday) {
        this.profile_image = profile_image;
        this.nickname = nickname;
        this.Dday= Dday;
        this.farmname= farmname;
    }

    public String getProfile_image() {
        return profile_image;
    }
    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
    public int getDday(){return Dday;}
    public void setDday(int dday){ this.Dday = dday;}

    public String getFarmname() {
        return this.farmname;
    }
    public void setFarmname(String farmname)
    {
        this.farmname= farmname;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname)
    {
        this.nickname=nickname;
    }


}
