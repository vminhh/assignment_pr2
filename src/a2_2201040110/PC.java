package a2_2201040110;

import utils.NotPossibleException;

/**
 * Represents personal computers (PCs).
 */
public class PC {
    private String model;
    private int year;
    private String manufacturer;
    private Set<String> comps;

    public PC(String model, int year, String manufacturer, Set<String> comps) throws NotPossibleException {
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

    public void setModel(String newModel) {
        if (!isModel(newModel)) {
            throw new NotPossibleException("Model name's should not be empty or bigger than 20 characters!");
        }

        this.model = newModel;
    }

    public void addComp(String newComp) {
        this.comps.insert(newComp);
    }

    private boolean isModel(String model) {
        return !isBlank(model) && model.length() <= 20;
    }

    private boolean isYear(int year) {
        return year >= 1984;
    }

    private boolean isManufacturer(String manufacturer) {
        return !isBlank(manufacturer) && manufacturer.length() <= 15;
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public void validateData() throws NotPossibleException {
        if (!isModel(this.model))
            throw new NotPossibleException("Model name's should not be empty or bigger than 20 characters!");

        if (!isYear(this.year))
            throw new NotPossibleException("The year should begin with 1984!");

        if (!isManufacturer(this.manufacturer))
            throw new NotPossibleException("Manufacturer name's should not be empty or bigger than 15 characters!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Object))
            return false;

        PC pc = (PC) o;
        return this.year == pc.year
                && this.model.equals(pc.model)
                && this.manufacturer.equals(pc.manufacturer)
                && this.comps.equals(pc.comps);
    }

    @Override
    public String toString() {
        return "PC<" + this.model + ", " + this.year + ", " + this.manufacturer + ", " + this.comps + ">";
    }
}
