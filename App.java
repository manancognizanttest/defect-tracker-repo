package com.genspark.qa;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Defect> defects = new ArrayList<>();
        defects.add(new Defect("DEF-001", "Login crash", "critical", "open"));
        defects.add(new Defect("DEF-002", "Search broken", "high", "open"));

        // This will return null because DEF-999 does not exist
        Defect found = DefectService.findById(defects, "DEF-999");

        // BUG 1: passing null to getSeverityLabel causes NullPointerException
        System.out.println(DefectService.getSeverityLabel(found));

        // BUG 2: passing a non-numeric string causes NumberFormatException
        int count = DefectService.parseDefectCount("twenty");
        System.out.println("Count: " + count);
    }
}