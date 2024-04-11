package a2_2201040110;

public class PCReport {
    public String displayReport(PC[] objs) {
        StringBuilder report = new StringBuilder();

        // create hyphen above the TITLE
        for (int i = 1; i < 100; i++) {
            report.append("-");
        }

        // create "PCPROG REPORT"
        report.append(
                "\n                                           PCPROG REPORT                                           \n");

        // create hyphen below PCPROG REPORT
        for (int i = 1; i < 100; i++) {
            report.append("-");
        }

        report.append("\n");

        /**
         * <pre>
          * create a table
          *  print line with formatted ordinal, model, year, manufacturer, comps (toString in PC class)
          *      formatted and width:
          *          ordinal number (3)
          *          model (20)
          *          year (6)
          *          manufacturer (15)
          *          components (as a string)
         * </pre>
         */

        for (int i = 0; i < objs.length; i++) {
            PC pc = objs[i];
            report.append(String.format("%3d ", i + 1))
                    .append(pc.toString()).append("\n");
        }

        // create hyphen at the end
        for (int i = 1; i < 100; i++) {
            report.append("-");
        }

        // covert to String
        return report.toString();
    }
}
