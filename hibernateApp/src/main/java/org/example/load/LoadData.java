package org.example.load;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.entry.CreateEntry;
import org.example.tshirt.Tshirt;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class LoadData extends Thread {
    private File f;
    private List<String> fileLst;
    public static final String PATH = "./src/data";
    private final String SEPERATOR = "|";
    private CreateEntry entry = new CreateEntry();

    public LoadData() {
        this.fileLst = new ArrayList<>();
        try {
            f = new File(PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        do {
            List<String> oldList = this.fileLst;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            this.fileLst = Arrays.asList((Objects.requireNonNull(f.list())));
            if (isChanged(oldList, fileLst)) {
                loadInSQL();
            } else if (isFileChanged(oldList, fileLst)) {
                loadInSQL();
            }
        } while (true);
    }

    private void loadInSQL() {
        String[] fLst = this.f.list();
        System.out.println(entry.dropTable());
        List<CSVReader> readers = this.getRecords(fLst);
        for (CSVReader records : readers) {
            while (records.iterator().hasNext()) {
                try {
                    String[] record = records.readNext();
                    Tshirt shirt = new Tshirt(record[0], record[1], record[2], record[3],
                            record[4], Double.parseDouble(record[5]), Double.parseDouble(record[6]), record[7]);
                    System.out.print(entry.insert(shirt));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<CSVReader> getRecords(String[] fLst) {
        List<CSVReader> ls = new ArrayList<>();
        CSVParser parser = new CSVParserBuilder().withSeparator(SEPERATOR.charAt(0)).build();
        try {
            for (String fname : fLst) {
                FileReader reader = new FileReader(PATH + "/" + fname);
                CSVReader records = new CSVReaderBuilder(reader).withCSVParser(parser).build();
                ls.add(records);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    protected boolean isChanged(List<String> prev, List<String> curr) {
        if (prev.size() != curr.size()) {
            return true;
        }
        Collections.sort(prev);
        Collections.sort(curr);
        int pos = 0;
        for (String s : prev) {
            if (!s.equals(curr.get(pos))) {
                return true;
            }
            pos += 1;
        }
        return false;
    }

    private int compareReader(List<CSVReader> reader){
        int count = 0;
        for(CSVReader rd: reader){
            while(rd.iterator().hasNext()){
                try{
                    rd.readNext();
                    count++;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return count;
    }

    private String[] toStringArray(List<String> ls){
        String[] arr = new String[ls.size()];
        int pos = 0;
        for(String s : ls){
            arr[pos] = s;
            pos++;
        }
        return  arr;
    }
    protected boolean isFileChanged(List<String> prev, List<String> curr){
        List<CSVReader> readersPrev = getRecords(toStringArray(prev));
        List<CSVReader> readersCurr = getRecords(toStringArray(curr));
        return !(compareReader(readersCurr) == compareReader(readersPrev));
    }
}
