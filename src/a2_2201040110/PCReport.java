package a2_2201040110;

import utils.TextIO;
import java.util.*;

public class PCReport {
    public String displayReport(PC[] objs) {
        StringBuilder report = new StringBuilder();

        // create hyphen above the TITLE
        for (int i = 0; i < 99; i++) {
            report.append("-");
        }

        report.append(
                "\n                                           PCPROG  REPORT                                           \n");

        // create hyphen below PCPROG REPORT
        for (int i = 0; i < 99; i++) {
            report.append("-");
        }

        // create formatted and width: ordinal number (3), model (20), year (6),
        // manufacturer (15), components (as a string)
        String ordinalFormat = "%3s",
                modelFormat = "%20s",
                yearFormat = "%6s",
                manufacturerFormat = "%15s",
                compsFormat = "%s";

        // mai lam tiep
    }
}
