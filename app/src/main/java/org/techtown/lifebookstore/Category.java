package org.techtown.lifebookstore;

import io.realm.RealmObject;

public class Category extends RealmObject {
    private String categoryName="무제";

    public Category() {

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        //System.out.println(this.categoryName);
    }



}
