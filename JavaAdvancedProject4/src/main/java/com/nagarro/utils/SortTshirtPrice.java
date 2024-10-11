package com.nagarro.utils;

import com.nagarro.model.Tshirt;

import java.util.Comparator;

public class SortTshirtPrice implements Comparator<Tshirt> {
    @Override
    public int compare(Tshirt o1, Tshirt o2) {
        return (int)(o2.getPrice() - o1.getPrice());
    }
}