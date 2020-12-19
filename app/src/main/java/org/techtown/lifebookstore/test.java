package org.techtown.lifebookstore;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class test extends RealmObject {
    /**
     *  PrimaryKey -> 기본키, 암묵적 @Index 포함
     *  Required -> non null
     *  Index -> 색인 기능
     */

    @PrimaryKey
    private int id;

    @Required
    private String name;
    private String gender;
    private int age;

    private RealmList<Book> books;
}
