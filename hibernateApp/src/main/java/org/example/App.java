package org.example;

import org.example.entry.CreateEntry;
import org.example.load.LoadData;
import org.example.query.Query;
import org.example.query.StringPair;
import org.example.tshirt.Tshirt;
import org.example.utils.IO;
import org.example.utils.SortTshirtPrice;
import org.example.utils.SortTshirtRating;

import java.util.List;

public class App {
    public static void main( String[] args ) {
        LoadData l = new LoadData();
        l.start();
        List<String> ls = IO.input();
        StringPair[] sp = new StringPair[ls.size()];
        String[] key = IO.getInputsType();
        int pos = 0;
        for(String s: ls){
            sp[pos] = new StringPair(key[pos], s);
            pos++;
        }
        Query q = new Query(sp);
        CreateEntry searchRes = new CreateEntry();
        List<Tshirt> ans = searchRes.check(q);


        if(IO.getPreference().equalsIgnoreCase("price")) {
            ans.sort(new SortTshirtPrice());
        } else if(IO.getPreference().equals("rating")){
            ans.sort(new SortTshirtRating());
        }
        System.out.println(IO.log(ans));
    }
}
