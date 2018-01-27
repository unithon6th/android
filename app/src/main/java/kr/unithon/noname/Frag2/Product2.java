package kr.unithon.noname.Frag2;

/**
 * Created by HANSUNG on 2018-01-28.
 */

public class Product2 {
    String img;
    String sort;
    String title;
    String content;
    int price;

    public Product2(String img, String sort, String title, String content, int price) {
        this.img = img;
        this.sort = sort;
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
