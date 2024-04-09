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
        return this.model;
    }

    public Integer getYear() {
        return this.year;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public Set<String> getComps() {
        return this.comps;
    }

    /**
     * @modify this.model
     *         if newModel is valid
     *         model = nModel
     *         return true
     *         else
     *         return flase
     */
    public boolean setModel(String newModel) {
        if (validModel(newModel)) {
            this.model = newModel;
            return true;
        }
        return false;
    }

    /**
     * @modify this.year
     *         if newYear is valid
     *         year = newYear
     *         return true
     *         else
     *         return flase
     */
    public boolean setYear(int newYear) {
        if (validYear(newYear)) {
            this.year = newYear;
            return true;
        }
        return false;
    }

    /**
     * @modify this.manufacturer
     *         if newManufacturer is valid
     *         manufacturer = newManufacturer
     *         return true
     *         else
     *         return flase
     */
    public boolean setManufacturer(String newManufacturer) {
        if (validManufacturer(newManufacturer)) {
            this.manufacturer = newManufacturer;
            return true;
        }
        return false;
    }

    /**
     * @modify this.comps
     *         if newComps is valid
     *         comps = newComps
     *         return true
     *         else
     *         return flase
     */
    public boolean setComps(Set<String> newComps) {
        if (validComps(newComps)) {
            this.comps = newComps;
            return true;
        }
        return false;
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

    /**
     * @effects
     *          if this satisfies abstract properties
     *          return true
     *          else
     *          return false
     */
    public boolean repOK() {
        if (validModel(this.model) && validYear(this.year) && validManufacturer(this.manufacturer)
                && validComps(this.comps)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PC))
            return false;

        PC pc = (PC) o;
        return getYear() == pc.getYear()
                && getModel().equals(pc.getModel())
                && getManufacturer().equals(pc.getManufacturer())
                && getComps().equals(pc.getComps());
    }
    // equals này k biết đúng k

    @Override
    public String toString() {
        return String.format("%15s %5d %10s %s", model, year, manufacturer, comps);
    }
    // cái toString này chắc sửa sau vậy

}
