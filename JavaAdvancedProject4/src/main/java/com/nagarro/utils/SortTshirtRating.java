package com.nagarro.utils;

import com.nagarro.model.Tshirt;

import java.util.Comparator;

public class SortTshirtRating implements Comparator<Tshirt> {
    @Override
    public int compare(Tshirt o1, Tshirt o2) {
        return (int)(o2.getRating() - o1.getRating());
    }
}
