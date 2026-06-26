package com.genspark.qa;

import java.util.List;

public class DefectService {

    public static Defect findById(List<Defect> defects, String targetId) {
        for (Defect defect : defects) {
            if (defect.getId().equals(targetId)) {
                return defect;
            }
        }
        return null;
    }

    public static String getSeverityLabel(Defect defect) {
        // BUG: no null check before calling defect.getSeverity()
        if(defect == null){
            return "Severity: UNKNOWN (defect not found)";
        }
        return "Severity: " + defect.getSeverity().toUpperCase();
    }

    public static int parseDefectCount(String countStr) {
        try {
            return Integer.parseInt(countStr);
        } catch (NumberFormatException e) {
            System.out.println("Warning: Invalid count value '" + countStr + "'. Defaulting to 0.");
            return 0;
        }
    }
}