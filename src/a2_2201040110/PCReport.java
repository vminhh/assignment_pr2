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

        int idx = 0;
        for (PC pc : objs) {
            StringBuilder components = new StringBuilder();

            if (pc.getComps().isEmpty()) {
                components.append("[]");
            } else {
                int charLimited = 99 - 3 - 1 - 20 - 1 - 6 - 1 - 15 - 1 - 4;
                for (char c : pc.getComps().getElements().toString().toCharArray()) {
                    if (components.length() == charLimited) {
                        components.append("...]");
                        break;
                    }
                    
                    components.append(c);
                }
            }

            report.append(String.format("%3d %20s %6d %15s %s\n", ++idx,
                    pc.getModel(), pc.getYear(), pc.getManufacturer(), components.toString()));
        }

        return report.append(hyphens).toString();
    }
}
