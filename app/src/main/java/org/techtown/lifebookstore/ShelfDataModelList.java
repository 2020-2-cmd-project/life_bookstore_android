package org.techtown.lifebookstore;

import io.realm.RealmList;
import io.realm.RealmObject;

public class ShelfDataModelList extends RealmObject {
    private int shelfIndex = -1;
    private RealmList<Book> books;
}
