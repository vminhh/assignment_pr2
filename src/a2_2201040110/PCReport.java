package a2_2201040110;

public class PCReport {
    public String displayReport(PC[] objs) {
        StringBuilder hyphens = new StringBuilder();
        for (int i = 0; i < 99; i++) {
            hyphens.append("-");
        }

        StringBuilder report = new StringBuilder();
        
        report.append(hyphens).append("\n")
                .append(String.format("%56s\n", "PCPROG REPORT"))
                .append(hyphens).append("\n");

        for (int i = 0; i < objs.length; i++) {
            report.append(String.format("%3d %s\n", i + 1, objs[i].toString()));
        }

        return report.append(hyphens).toString();
    }
}
