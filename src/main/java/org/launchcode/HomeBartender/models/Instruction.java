package org.launchcode.HomeBartender.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Instruction {


    private int id;

    private static int nextId = 1;

    @NotBlank
    @Size(min = 2, max = 100, message = "Step must be between 2–100 characters.")
    private String instruction;

    public Instruction(String instruction) {
        this();
        this.instruction = instruction;
    }

    public Instruction() {
        this.id = nextId;
        nextId++;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction() {
        this.instruction = instruction;
    }
}
