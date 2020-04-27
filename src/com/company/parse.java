package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.io.File;
public class parse {

    public static List<data> getRecodrsFromACsv(File file, List<String> keys) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<data> records = new ArrayList<>();
        boolean isHeader = true;
        String line = null;
        while ((line = br.readLine()) != null) {
            if (isHeader) {// first line is header
                isHeader = false;
                continue;
            }
            data record = new data(file.getName());
            String[] lineSplit = line.split(",");
            for (int i = 0; i < lineSplit.length; i++) {
                record.put(keys.get(i), lineSplit[i]);
            }
            records.add(record);
        }
        br.close();
        return records;
    }
    public static List<String> getHeadersFromACsv(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> headers = null;
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] lineSplit = line.split(",");
            headers = new ArrayList<>(Arrays.asList(lineSplit));
            break;
        }
        br.close();
        return headers;
    }
    public static void writeToCsv(final File file, final Set<String> headers, final List<data> records)
            throws IOException {
        FileWriter csvWriter = new FileWriter(file);
        // write headers
        String sep = "";
        String[] headersArr = headers.toArray(new String[headers.size()]);
        for (String header : headersArr) {
            csvWriter.append(sep);
            csvWriter.append(header);
            sep = ",";
        }
        csvWriter.append("\n");
        // write records at each line
        for (data record : records) {
            sep = "";
            for (int i = 0; i < headersArr.length; i++) {
                csvWriter.append(sep);
                csvWriter.append(record.get(headersArr[i]));
                sep = ",";
            }
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }
}

