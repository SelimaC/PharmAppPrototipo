package com.example.selima.pharmapp.model;

/**
 * Created by selim on 16/02/2017.
 */

public class Medicine {
    private String code;
    private String name;
    private String unit;
    private String instructions;
    private boolean standard;

    public Medicine() {
    }

    public Medicine(String name, String code, String unit, String instructions, boolean standard) {
        this.setName(name);
        this.setCode(code);
        this.setUnit(unit);
        this.setInstructions(instructions);
        this.setStandard(standard);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
