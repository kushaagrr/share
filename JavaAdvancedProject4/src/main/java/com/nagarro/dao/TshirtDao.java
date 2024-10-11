package com.nagarro.dao;

import com.nagarro.model.Tshirt;

import java.util.List;

public interface TshirtDao {
    List<Tshirt> getShirt(String color, String size, String gender);
    List<Tshirt> getShirtByPreference(List<Tshirt> shirts, String prefrence);

}
