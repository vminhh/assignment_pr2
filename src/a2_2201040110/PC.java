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
        if (!isValidModel(newModel)) {
            throw new NotPossibleException("Model name's cannot be empty or exceed 20 characters!!");
        }

        this.model = newModel;
    }

    public void addComp(String newComp) {
        this.comps.insert(newComp);
    }

    private boolean isValidModel(String model) {
        return !isBlank(model) && model.length() <= 20;
    }

    private boolean isValidYear(int year) {
        return year >= 1984;
    }

    private boolean isValidManufacturer(String manufacturer) {
        return !isBlank(manufacturer) && manufacturer.length() <= 15;
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public void validateData() throws NotPossibleException {
        if (!isValidModel(this.model))
            throw new NotPossibleException("Model name's cannot be empty or exceed 20 characters!!");
    
        if (!isValidYear(this.year))
            throw new NotPossibleException("The year should begin with 1984!!");
    
        if (!isValidManufacturer(this.manufacturer))
            throw new NotPossibleException("Manufacturer name's cannot be empty or exceed 15 characters!!");
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
