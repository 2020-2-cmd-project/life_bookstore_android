package org.techtown.lifebookstore;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Book extends RealmObject {
    private String title;
    private String date;
    private String location;
    private String content;
    private String color;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(int categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    private int index=-1;
    private int categoryIndex=-1;
    private int questionIndex=-1;
    private RealmList<HashTag> hashRealmList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

