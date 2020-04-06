package com.cornelio.losyondris.covi19;

public class Pojo_News {
    private String name;
   // private String author;
    private String title;
    private String description;
   // private String url;
    private String urlToImage;
    private String content;


    public Pojo_News(String name, String title, String description, String urlToImage, String content) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;
        this.content = content;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
