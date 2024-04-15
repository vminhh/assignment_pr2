package a2_2201040110;

import java.util.*;

public class PC {
    private String model;
    private int year;
    private String manufacturer;
    private Set<String> comps;

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

    public void setModel(String newModel) {
        if (!isModel(newModel)) {
            throw new IllegalArgumentException("Model name's should not be empty or shorter than 20 characters!");
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

    private boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

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
        if (getComps().getElements() == null)
            return String.format("%20s %6d %15s %s", getModel(), getYear(), getManufacturer(),
                    Arrays.toString(new String[0]));

        StringBuilder components = new StringBuilder();
        components.append("[");

        for (String comp : getComps().getElements()) {
            components.append(comp).append(", ");
            if (components.length() > 47) {
                components = new StringBuilder(components.substring(0, 47));
                components.append("...]");
                break;
            }
        }

        return String.format("%20s %6d %15s %s", getModel(), getYear(), getManufacturer(), components.toString());
    }
}
