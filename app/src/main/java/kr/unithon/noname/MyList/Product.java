package kr.unithon.noname.MyList;

/**
 * Created by HANSUNG on 2018-01-27.
 */

public class Product {
    String ImageUrl;
    String Dday;
    String title;
    String content;

    public Product(String imageUrl, String dday, String title, String content) {
        ImageUrl = imageUrl;
        Dday = dday;
        this.title = title;
        this.content = content;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getDday() {
        return Dday;
    }

    public void setDday(String dday) {
        Dday = dday;
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
}
