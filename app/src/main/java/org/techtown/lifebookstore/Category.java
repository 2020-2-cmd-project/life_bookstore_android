package org.techtown.lifebookstore;

import java.util.ArrayList;

import io.realm.RealmObject;

public class Category extends RealmObject {
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    private String categoryName;
    //ArrayList<String> QList = new ArrayList();
}
