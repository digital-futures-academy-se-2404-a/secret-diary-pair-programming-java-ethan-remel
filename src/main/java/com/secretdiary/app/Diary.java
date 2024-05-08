package com.secretdiary.app;
import java.util.ArrayList;

public class Diary {

    private ArrayList<String> entries = new ArrayList<>();

    public void addEntry(String entry) {
        if (entry == null || entry.trim().isEmpty()) {
            throw new IllegalArgumentException("Entry cannot be null or empty");
        }
        entries.add(entry);
    }

    public  String getEntry(int index) {
        if (index < 0 || index >= entries.size()) {
            throw new IllegalArgumentException("Entry cannot be below 0 or larger than the size of the list");
        }

        return entries.get(index);
    }

    public ArrayList<String> getEntries() {
        return entries;
    }




}
