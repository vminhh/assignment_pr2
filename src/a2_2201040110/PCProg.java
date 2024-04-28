package a2_2201040110;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import utils.NotPossibleException;

/**
 * A program that captures data about PC objects and displays
 * a report about them on the console.
 */
public class PCProg {
    private static final Object YES = "Y";
    private Set<PC> objs;

    /**
     * Initialise this to have an empty set of PCs
     */
    public PCProg() {
        objs = new Set<>();
    }

    /**
     * create objs
     */
    public void createObjects() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the model: ");
        String model = sc.nextLine();

        System.out.print("Enter the year: ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the manufacturer: ");
        String manufacturer = sc.nextLine();

        Set<String> comps = new Set<>();

        PC pc = PCFactory.getInstance().createPC(model, year, manufacturer, comps);

        System.out.println("Add component or press ENTER to stop!!");
        int idx = 0;
        while (true) {
            System.out.printf("Add components [%d]: ", idx + 1);
            String comp = sc.nextLine();

            if (comp.trim().equals(""))
                break;

            if (comps.isIn(comp)) {
                System.out.println("Component is already exist!!");
                continue;
            }

            pc.addComp(comp);
            idx++;
        }

        if (!getObjects().isEmpty()) {
            for (PC o : getObjects().getElements()) {
                if (o.equals(pc)) {
                    System.out.println("PC is already exist!!");
                    break;
                }
            }
        }

        this.objs.insert(pc);

        System.out.println("Do you want to add another PC? [Y/N]");
        String toAdd = sc.nextLine().toUpperCase();

        if (toAdd.equals(YES)) {
            createObjects();
        }
    }

    /**
     * get objs
     */
    public Set<PC> getObjects() {
        return this.objs;
    }

    /**
     * If <tt>objs</tt> is not empty, displays a text-based tabular
     * report on <tt>objs</tt> to the standard console.
     * Displays nothing if <tt>objs</tt> is empty.
     *
     * @return this report if <tt>objs</tt> is not empty or <tt>null</tt> otherwise.
     */
    public String displayReport() {
        if (!objs.isEmpty()) {
            Vector<PC> pcs = objs.getElements();
            PCReport reportObj = new PCReport();
            return reportObj.displayReport(pcs.toArray(new PC[0]));
        } else {
            return null;
        }
    }

    /**
     * Saves report to a file <tt>pcs.txt</tt> in the program's working directory.
     */
    public void saveReport(String report) {
        String fileName = "pcs.txt";
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.println(report);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Initializes an instance of <tt>PCProg</tt>.
     * Create objects from data entered by the user.
     * Display a report on the objects.
     * Prompt user to save report to file. If user answers "Y", save report.
     * Otherwise, end program.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PCProg prog = new PCProg();
        try {
            // create objects
            prog.createObjects();
            // display report
            String report = prog.displayReport();
            System.out.println(report);
            if (report != null) {
                // prompt user to save report
                System.out.println("Save report to file? [Y/N]");
                String toSave = sc.nextLine();
                if (toSave.equals("Y")) {
                    prog.saveReport(report);
                    System.out.println("report saved");
                }
            }
        } catch (NotPossibleException e) {
            System.err.printf("%s: %s%n", e, e.getMessage());
        }
        System.out.println("~END~");
    }
}
