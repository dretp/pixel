package com.company;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        File csv1 = new File("Session2_2020.csv");
        File csv2 = new File("Session3_2020.csv");
        List<String> csv1Headers = parse.getHeadersFromACsv(csv1);
        //csv1Headers.forEach(h -> System.out.print(h + " "));
        //System.out.println();
        List<String> csv2Headers = parse.getHeadersFromACsv(csv2);
        //csv2Headers.forEach(h -> System.out.print(h + " "));
        //System.out.println();
        List<String> allCsvHeaders = new ArrayList<>();
        allCsvHeaders.addAll(csv1Headers);
        allCsvHeaders.addAll(csv2Headers);
        //allCsvHeaders.forEach(h -> System.out.print(h + " "));
        //System.out.println();
        Set<String> uniqueHeaders = new HashSet<>(allCsvHeaders);
        //uniqueHeaders.forEach(h -> System.out.print(h + " "));
        //System.out.println();
        List<data> csv1Records = parse.getRecodrsFromACsv(csv1, csv1Headers);
        List<data> csv2Records = parse.getRecodrsFromACsv(csv2, csv2Headers);
        List<data> allCsvRecords = new ArrayList<>();
        allCsvRecords.addAll(csv1Records);
        allCsvRecords.addAll(csv2Records);
        parse.writeToCsv(new File("merged.csv"), uniqueHeaders, allCsvRecords);
    }
}


