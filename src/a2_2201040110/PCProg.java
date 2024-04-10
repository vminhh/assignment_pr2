package a2_2201040110;

import static utils.TextIO.*;

import java.util.*;

import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.TextIO;

/**
 * @overview PCProg is a program that captures data about PC objects and
 *           displays a report about them on the console.
 * 
 * @attributes objs Set<PC>
 * 
 * @object A typical PCProg is {c1,...,cn} where c1,...,cn are pcs
 * 
 * @abstract_properties mutable(objs)=true /\ optional(objs)=false
 * 
 * @author dmle
 */
public class PCProg {
	private static final Object YES = "Y";

	@DomainConstraint(mutable = true, optional = false)
	private Set<PC> objs;

	/**
	 * @effects initialise this to have an empty set of PCs
	 */
	public PCProg() {
		objs = new Set<>();
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * get data from user input
	 * 		create a while loop
	 * 			get data from user
	 * 				if user want to stop add component 
	 * 					press enter (data will be a blank line)
	 * 				else
	 * 					continue adding
	 * 		while loop exit
	 *	
	 * create a newPC and add it in objs
	 * Aks user want to add new PC [Y/N]
	 * 		if Y 
	 * 			call method again
	 * 
	 *          </pre>
	 */
	public void createObjects() {
		TextIO.putln("Enter your model ");
		String model = TextIO.getlnString();

		TextIO.putln("Enter year released ");
		int year = TextIO.getlnInt();

		TextIO.putln("Enter the manufacturer ");
		String manufacturer = TextIO.getlnString();

		TextIO.putln("Enter the components ");
		TextIO.putln("Notice that Can't enter the duplicate components. Press Enter to stop add.");
		Set<String> comps = new Set<>();
		boolean hasNextComps = true;

		while (hasNextComps) {
			String comp = TextIO.getln();

			if (comp.equals("")) {
				hasNextComps = false;
			} else {
				comps.insert(comp);
				TextIO.putln("Continue to add component? Press enter to stop.");
			}
		}

		PC newPC = PCFactory.getFactory().createPC(model, year, manufacturer, comps);

		objs.insert(newPC);

		TextIO.putln("Do you want to add another PC? [Y/N] ");
		boolean Continue = true;
		if (Continue == TextIO.getln().equals(YES)) {
			createObjects();
		}
	}

	/**
	 * @effects
	 *          return PC obj with size of objs (number of PC made)
	 *          covert obj to Array
	 */
	public PC[] getObjects() {
		return objs.getElements().toArray(new PC[objs.size()]);
	}

	/**
	 * @effects if objs is not empty display to the standard console a text-based
	 *          tabular report on objs return this report else display nothing and
	 *          return null
	 */
	public String displayReport() {
		if (objs.size() > 0) {
			Vector<PC> pcs = objs.getElements();

			PCReport reportObj = new PCReport();
			return reportObj.displayReport(pcs.toArray(new PC[pcs.size()]));
		} else {
			return null;
		}
	}

	/**
	 * @effects save report to a file pcs.txt in the same directory as the program's
	 */
	public void saveReport(String report) {
		String fileName = "pcs.txt";
		writeFile(fileName);
		putln(report);
		writeStandardOutput();
	}

	/**
	 * The run method
	 * 
	 * @effects initialise an instance of PCProg create objects from data entered by
	 *          the user display a report on the objects prompt user to save report
	 *          to file if user answers "Y" save report else end
	 */
	public static void main(String[] args) {
		//
		PCProg prog = new PCProg();

		// create objects
		try {
			prog.createObjects();
			// display report
			String report = prog.displayReport();
			System.out.println(report);
			if (report != null) {
				// prompt user to save report
				putln("Save report to file? [Y/N]");
				String toSave = getln();
				if (toSave.equals("Y")) {
					prog.saveReport(report);
					putln("report saved");
				}
			}

		} catch (NotPossibleException e) {
			System.err.printf("%s: %s%n", e, e.getMessage());
		}
		putln("~END~");
	}

}
