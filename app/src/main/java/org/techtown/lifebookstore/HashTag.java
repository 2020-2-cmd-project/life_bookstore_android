package org.techtown.lifebookstore;

import io.realm.RealmObject;

public class HashTag extends RealmObject {
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String tag;
}
