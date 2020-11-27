package com.nagarro.secondAssignment.services;

import com.nagarro.secondAssignment.constants.Constants;
import com.nagarro.secondAssignment.main.Main;

import java.io.File;
import java.util.*;

public class Watcher implements Runnable, Constants {
    HashMap<String, Long> modifiedAt = new HashMap<>();

    @Override
    public void run() {
        File files[] = file.listFiles();
        ArrayList<String> arrayList = new ArrayList<>();
        for (File f : files) {
            if ((!(modifiedAt.containsKey(f.getName()))) || (f.lastModified() > modifiedAt.get(f.getName()))) {
                modifiedAt.put(f.getName(), f.lastModified());
                synchronized (Main.flights) {
                    Main.flights.put(f.getName(), DirectoryReader.readFile(f));
                }
            }
            arrayList.add(f.getName());
        }
        Set<String> fc = modifiedAt.keySet();
        Set<String> fname = new HashSet<>();
        fname.addAll(fc);

        if (fc.size() == arrayList.size())
            return;
        for (String str : fname) {
            if (!(arrayList.contains(str))) {
                modifiedAt.remove(str);
                synchronized (Main.flights) {
                    Main.flights.remove(str);
                }
            }
        }
    }
}