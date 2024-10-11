package org.example.utils;

import org.example.tshirt.Tshirt;

import java.util.Comparator;

public class SortTshirtRating implements Comparator<Tshirt> {
    @Override
    public int compare(Tshirt o1, Tshirt o2) {
        return (int)(o2.getRating() - o1.getRating());
    }
}
