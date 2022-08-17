package edu.fiu.cen4010.g5.BookStoreApp.model;

import java.util.Comparator;

public class RatingSortedByValueDes implements Comparator<Rating> {

    @Override
    public int compare(Rating r1, Rating r2) {
        return r2.getValue() - r1.getValue();
    }
}