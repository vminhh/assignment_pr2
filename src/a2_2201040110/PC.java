package a2_2201040110;

import utils.*;

/**
 * @overview Represents basic attributes of personal computers (PCs).
 * 
 * @attributes
 *             model String
 *             year Integer
 *             manufacturer
 *             String comps Set(String)
 * 
 * @object A typical PC is {model, year, manufacturer, comps}, where model is
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
     * 
     *          <pre>
     * if data of all attributes are valid
     *   initialize them
     * else
     *   throws NotPossibalException
     *          </pre>
     */
    public PC(String model, int year, String manufacturer, Set<String> comps) throws NotPossibleException {
        if (!repOK()) {
            throw new NotPossibleException("Invalid data!");
        }

        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.comps = comps;
    }

    /**
     * @return model data
     */
    public String getModel() {
        return this.model;
    }

    /**
     * @return year data
     */
    public int getYear() {
        return this.year;
    }

    /**
     * @return manufacturer data
     */
    public String getManufacturer() {
        return this.manufacturer;
    }

    /**
     * @return Set(String) comps data
     */
    public Set<String> getComps() {
        return this.comps;
    }

    /**
     * @modify this.model
     * 
     *         <pre>
     * if newModel is valid
     *   model = newModel
     *   return true
     * else
     *   return flase
     *         </pre>
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
     * 
     *         <pre>
     * if newYear is valid
     *   year = newYear
     *   return true
     * else
     *   return flase
     *         </pre>
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
     * 
     *         <pre>
     * if newManufacturer is valid
     *    manufacturer = newManufacturer
     *    return true
     * else
     *    return flas
     *         </pre>
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
     * 
     *         <pre>
     * if newComps is valid
     *      comps = newComps
     *      return true
     * else
     *      return flase
     *         </pre>
     */
    public boolean setComps(Set<String> newComps) {
        if (validComps(newComps)) {
            this.comps = newComps;
            return true;
        }

        return false;
    }

    /**
     * @param model will be validated
     * @effects
     * 
     *          <pre>
     * if model name is not empty and shorter than 20 characters
     *   return true
     * else
     *   return false
     *          </pre>
     */
    private boolean validModel(String model) {
        return model != null && model.length() <= 20;
    }

    /**
     * @param year will be validated
     * @effects
     * 
     *          <pre>
     * if year of released since 1984
     *   return true
     * else
     *   return false
     *          </pre>
     */
    private boolean validYear(int year) {
        return year >= 1984;
    }

    /**
     * @param manufacturer will be validated
     * @effects
     * 
     *          <pre>
     * if manufacturer is not empty and shorter than 15 characters
     *    return true
     * else
     *    return false
     *          </pre>
     */
    private boolean validManufacturer(String manufacturer) {
        return manufacturer != null && manufacturer.length() <= 15;
    }

    /**
     * @param comps will be validated
     * @effects
     * 
     *          <pre>
     * if comps is not null and not empty 
     *   return true
     * else
     *  return false
     *          </pre>
     */
    private boolean validComps(Set<String> comps) {
        return comps != null && comps.size() != 0;
    }

    /**
     * @effects
     * 
     *          <pre>
     *    if this satisfies abstract properties
     *          return true
     *    else
     *          return false
     * 
     *          </pre>
     */
    public boolean repOK() {
        return validModel(this.model)
                && validYear(this.year)
                && validManufacturer(this.manufacturer)
                && validComps(this.comps);
    }

    @Override
    public String toString() {
        return String.format("%20s %6d %15s %s", getModel(), getYear(), getManufacturer(),
                getComps().getElements().toString());
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
}
