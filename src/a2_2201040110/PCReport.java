package a2_2201040110;

/**
 * create a required form
 */
public class PCReport {
    public String displayReport(PC[] objs) {
        StringBuilder hyphens = new StringBuilder();
        for (int i = 0; i < 99; i++) {
            hyphens.append("-");
        }

        StringBuilder report = new StringBuilder();

        report.append(hyphens).append("\n");

        report.append(String.format("%" + (99 + 13) / 2 + "s\n", "PCPROG REPORT"));

        report.append(hyphens).append("\n");

        for (int i = 0; i < objs.length; i++) {
            report.append(String.format("%3d %s\n", i + 1, objs[i].toString()));
        }

        report.append(hyphens);

        return report.toString();
    }
}
