package rugu.yetote.com.zhihuadvertisementdemo;

/**
 * rugu.yetote.com.zhihuadvertisementdemo
 *
 * @author Swg
 * @date 2017/12/22 15:29
 */
public class MyModel {
    private String title, content, tag, img, date;
    private int discuss;

    public int getDiscuss() {
        return discuss;
    }

    public void setDiscuss(int discuss) {
        this.discuss = discuss;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public MyModel(String title, String content, String tag, String img, String date, int discuss) {
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.img = img;
        this.date = date;
        this.discuss = discuss;
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tag='" + tag + '\'' +
                ", img='" + img + '\'' +
                ", discuss='" + discuss + '\'' +
                ", date='" + date + '\'' +
                '}';
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
