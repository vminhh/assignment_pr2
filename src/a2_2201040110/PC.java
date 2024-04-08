package a2_2201040110;

import utils.*;

/**
 * @overview Represents personal computers (PCs).
 * 
 * @attributes model String year Integer manufacturer String comps Set<String>
 * 
 * @object A typical PC is {<model, year, manufacturer, comps>}, where model is
 *         String, year is Integer, manufacturer is String, and comps is a set
 *         of Strings.
 * 
 * @abstract_properties mutable(model)=false /\ mutable(year)=false /\
 *                      mutable(manufacturer)=false /\ mutable(comps)=true /\
 *                      optional(model)=false /\ optional(year)=false /\
 *                      optional(manufacturer)=false /\ optional(comps)=false
 * 
 */

public class PC {
    private String model;
    private int year;
    private String manufacturer;
    private Set<String> comps;

    /**
     * @effects
     *          if model year manufacturer comps is valid
     *          initial it
     *          else
     *          throws NotPossibalException
     */
    public PC(String model, int year, String manufacturer, Set<String> comps) throws NotPossibleException {
        if (validModel(model) && validYear(year) && validManufacturer(manufacturer) && validComps(comps)) {
            this.model = model;
            this.year = year;
            this.manufacturer = manufacturer;
            this.comps = comps;
        }

        else {
            throw new NotPossibleException("Invalid data!");
        }
    }

    /**
     * @getter
     * @return model, year, manufacturer and Set comps
     */

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @setter
     *         return comps
     */
    public Set<String> getComps() {
        return comps;
    }

    /**
     * @Validation
     *             if model year manufacturer comps is valid
     *             return true
     *             else
     *             return fasle
     */
    private boolean validModel(String model) {
        return model != null && model.length() <= 20;
    }

    private boolean validYear(int year) {
        return year >= 1984;
    }

    private boolean validManufacturer(String manufacturer) {
        return manufacturer != null && manufacturer.length() <= 15;
    }

    private boolean validComps(Set<String> comps) {
        return comps != null && comps.size() != 0;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-5d %-15s %s", model, year, manufacturer, comps);
    }
    // cái toString này chắc sửa sau vậy



    /**
     * hàm main này chỉ để test thử thôi
     */
    public static void main(String[] args) {
        Set<String> comps = new Set<>();
        comps.insert("hii");
        comps.insert("uuu");

        PC test = new PC("TUF Gaming A15", 2024, "ASUS", comps);
        System.out.println(test);
    }
}
