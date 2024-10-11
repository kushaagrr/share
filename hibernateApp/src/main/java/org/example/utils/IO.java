package org.example.utils;

import org.example.tshirt.Tshirt;

import java.util.*;

public class IO {
    private static String preference;
    private static Scanner in = new Scanner(System.in);
    private final static String[] inputs = {"color", "size", "gender"};
    public IO(){

    }

    public static List<String> input(){
        List<String> ls = new ArrayList<>();
        System.out.print("Enter color : ");
        String color = in.nextLine();
        System.out.print("Enter size : ");
        String size = in.nextLine();
        System.out.print("Enter gender : ");
        String gender = in.nextLine();
        System.out.print("Enter preference : ");
        preference = in.nextLine();
        ls.add(pascalCase(color)); ls.add(size.toUpperCase()); ls.add(gender.toUpperCase());
        return ls;
    }

    public static String log(List<Tshirt> ls){
        String str = "";
        if(ls.isEmpty()){
            return "Sorry, there is no shirt available for your choices";
        }
        str += "The t-shirts that match your options are : \n";
        for(Tshirt shirt: ls){
            String s = "name: " + shirt.getName() + "\n" +
                    "color: " + shirt.getColor() + "\n" +
                    "size: " + shirt.getSize() + "\n" +"price: " + shirt.getPrice() + "\n" +
                    "ratings: " + shirt.getRating() + "\n"+
                    ("y".equalsIgnoreCase(shirt.getAvailability())? "Available" : "Not Available") + "\n\n";
            str = str.concat(s);
        }
        return str;

    }

    private static String pascalCase(String str){
        String s = String.valueOf(Character.toUpperCase(str.charAt(0)));
        for(int i = 1; i < str.length(); i++){
            s = s.concat(String.valueOf(str.charAt(i)));
        }
        return s;
    }

    public static String getPreference(){
        return preference;
    }
    public static String[] getInputsType(){
        return  inputs;
    }
}
