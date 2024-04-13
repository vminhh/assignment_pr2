package a2_2201040110;

/**
 * @overview PCReport will take data user input from PC obj and print out a
 *           table according to required form
 * @effects
 * 
 *          <pre>
 *      To display a report, the program first generates it and then presents the result on a table 
 *      that looks like the one shown in Listing 1 below.
 *      
 *      DATA...
 *      The report title is displayed in the middle of the top banner (PCPROG REPORT).
 *      All but the first column corresponds to the PC attributes; the rows are data about the PC objects.
 *      Thus:
 *          the second column corresponds to the attribute model
 *          the third corresponds to the year
 *          the fourth corresponds to the manufacturer.
 * 
 *      TABLE...
 *      The last column lists the string representations of the components of the PC objects.
 *      The first column sequentially displays the row numbers.
 *      Widths of the second and fourth columns are the lengths of the corresponding attributes.
 *      The widths of the first and third columns are 3 and 6, respectively.
 *      The fifth column is unrestricted in width.
 *      The cell values are properly aligned with the columns and are displayed right-justified,
 *        except for the fifth column (to display components), which is left-aligned.
 * 
 * 
 *                            Listing 1: A tabular report for PCs
 * 
 *  ---------------------------------------------------------------------------------------------------
 *                                           PCPROG REPORT
 *  ---------------------------------------------------------------------------------------------------
 *    1   Thinkpad X1 Carbon   2022          Lenovo [AMD Ryzen 5, 8GB DDR4, 512GB SSD, NVIDIA MX450]
 *  ---------------------------------------------------------------------------------------------------
 * 
 *          </pre>
 */
public class PCReport {
    public String displayReport(PC[] objs) {
        StringBuilder report = new StringBuilder();

        StringBuilder hyphen = new StringBuilder();
        for (int i = 0; i < 99; i++) {
            hyphen.append("-");
        }

        report.append(hyphen).append("\n");

        report.append(String.format("%56s\n", "PCPROG REPORT"));

        report.append(hyphen).append("\n");

        for (int i = 0; i < objs.length; i++) {
            report.append(String.format("%3d %s", i + 1, objs[i].toString()))
                    .append("\n");
        }

        report.append(hyphen);

        return report.toString();
    }
}
