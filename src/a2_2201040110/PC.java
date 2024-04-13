package a2_2201040110;

import java.util.*;

import utils.*;

/**
 * @overview
 *           PC object with the specified model, year, manufacturer, and
 *           components.
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
    @DomainConstraint(mutable = true, optional = false)
    private String model;

    @DomainConstraint(mutable = false, optional = false)
    private int year;

    @DomainConstraint(mutable = false, optional = false)
    private String manufacturer;

    @DomainConstraint(mutable = true, optional = false)
    private Set<String> comps;

    /**
     * @effects initialize all atributes then validate them
     */
    public PC(String model, int year, String manufacturer, Set<String> comps) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.comps = comps;
        validateData();
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
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
     * 
     *         <pre>
     * if newModel is not valid
     *   throw IllegalAgrumentException
     * else
     *   this.model = newModel
     *         </pre>
     */
    public void setModel(String newModel) {
        if (!isModel(newModel)) {
            throw new IllegalArgumentException("Model name's should not be empty or shorter than 20 characters!");
        }

        this.model = newModel;
    }

    /**
     * @effects add respectively element of newComps to this.comps
     */
    public void setComps(Set<String> newComps) {
        for (String comp : newComps.getElements()) {
            this.comps.insert(comp);
        }
    }

    /**
     * @param model will be validated
     * @effects
     * 
     *          <pre>
     * if model name is not blank and shorter than 20 characters
     *   return true
     * else
     *   return false
     *          </pre>
     */
    private boolean isModel(String model) {
        return !isBlank(model) && model.length() <= 20;
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
     * if manufacturer is not blank and shorter than 15 characters
     *    return true
     * else
     *    return false
     *          </pre>
     */
    private boolean isManufacturer(String manufacturer) {
        return !isBlank(manufacturer) && manufacturer.length() <= 15;
    }

    /**
     * isBlank is a method was introduced in Java 11, but i must use jdk 8 :((
     * 
     * @return string is blank or empty or contains only white spaces
     */
    private boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * @effects
     * 
     *          <pre>
     * the method will validate respectively attributes
     *      if they are not valid
     *          throw IllegalAgurmentException
     *          </pre>
     */
    public void validateData() {
        if (!isModel(this.model))
            throw new IllegalArgumentException("Model name's should not be empty or shorter than 20 characters!");

        if (!isYear(this.year))
            throw new IllegalArgumentException("The year should begin with 1984!");

        if (!isManufacturer(this.manufacturer))
            throw new IllegalArgumentException(
                    "Manufacturer name's should not be empty or shorter than 15 characters!");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Object))
            return false;

        PC pc = (PC) obj;
        return this.year == pc.year
                && this.model.equals(pc.model)
                && this.manufacturer.equals(pc.manufacturer)
                && this.comps.equals(pc.comps);
    }

    @Override
    public String toString() {
        return String.format("%20s %6d %15s %s", this.model, this.year, this.manufacturer,
                this.comps.getElements() != null ? this.comps.getElements() : Arrays.toString(new String[0]));
    }
}
