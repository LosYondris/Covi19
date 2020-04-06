package com.cornelio.losyondris.covi19.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class New {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("toralResult")
    @Expose
    private int toralResult;

    @SerializedName("articles")
    @Expose
    private List<Article> article;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getToralResult() {
        return toralResult;
    }

    public void setToralResult(int toralResult) {
        this.toralResult = toralResult;
    }

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }
}
