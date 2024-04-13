package a2_2201040110;

import utils.*;

/**
 * @overview Represent basic attributes of personal computers (PCs).
 * 
 * @attributes
 *             model String
 *             year Integer
 *             manufacturer String
 *             comps Set(String)
 * 
 * @object A typical PC is {model, year, manufacturer, comps}, where model is
 *         String, year is Integer, manufacturer is String, and comps is a set
 *         of Strings.
 * 
 * @abstract_properties
 * 
 *                      <pre>
 *  mutable(model) = true /\ optional (model) = false /\ length (model) = 20
 *  mutable(year) = false /\ optional (year) = false /\ min(year) = 1984
 *  mutable(manufacturer) = false /\ optional (manufacturer) = false /\ length (year) = 15
 *  mutable(comps) = true /\ optional (comps) = false
 *                      </pre>
 */

public class PC {
    @DomainConstraint(type = "String", mutable = true, optional = false)
    private String model;

    @DomainConstraint(type = "Integer", mutable = false, optional = false)
    private int year;

    @DomainConstraint(type = "String", mutable = false, optional = false)
    private String manufacturer;

    @DomainConstraint(type = "Set<String", mutable = true, optional = false)
    private Set<String> comps;

    /**
     * @effects
     * 
     *          <pre>
     * if data of all attributes are valid
     *   initialize them
     * else
     *   throws NotPossibleException
     *          </pre>
     */
    public PC(String model, int year, String manufacturer, Set<String> comps) throws NotPossibleException {

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
     * else
     *   throw IllegalAgrumentException
     *         </pre>
     */
    public void setModel(String newModel) {
        if (!isModel(newModel)) {
            throw new IllegalArgumentException("Model can't be null or bigger than 20 characters!");
        }

        this.model = newModel;
    }

    /**
     * @modify this.comps
     * 
     *         <pre>
     * if newComps is valid
     *      comps = newComps
     * else
     *      throw IllegalAgrumentException
     *         </pre>
     */
    public void setComps(Set<String> newComps) {
        if (!isComponent(newComps)) {
            throw new IllegalArgumentException("Component can't be null or empty!");
        }

        this.comps = newComps;
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
    private boolean isModel(String model) {
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
    private boolean isYear(int year) {
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
    private boolean isManufacturer(String manufacturer) {
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
     *   return false
     *          </pre>
     */
    private boolean isComponent(Set<String> comps) {
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
        return isModel(getModel())
                && isYear(getYear())
                && isManufacturer(getManufacturer())
                && isComponent(getComps());
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
