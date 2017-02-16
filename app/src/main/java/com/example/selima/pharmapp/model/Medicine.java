package com.example.selima.pharmapp.model;

/**
 * Created by selim on 16/02/2017.
 */

public class Medicine {
    private int id;
    private String name;
    private String unit;
    private String instructions;
    private boolean standard;

    public Medicine() {
    }

    public Medicine(String name, int id, String unit, String instructions, boolean standard) {
        this.setName(name);
        this.setId(id);
        this.setUnit(unit);
        this.setInstructions(instructions);
        this.setStandard(standard);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public boolean isStandard() {
        return standard;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }
}
