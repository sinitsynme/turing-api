package ru.sinitsynme.turingapi.entity;

import java.util.List;
import java.util.Set;

public class Algorythm {
    private int id;
    private String name;
    private String[] alphabet;
    private boolean isBasic;
    private Set<String> states;
    private List<SymbolStates> symbolStates;

    public Algorythm() {
    }

    public Algorythm(int id, String name, String[] alphabet, boolean isBasic, Set<String> states, List<SymbolStates> symbolStates) {
        this.id = id;
        this.name = name;
        this.alphabet = alphabet;
        this.isBasic = isBasic;
        this.states = states;
        this.symbolStates = symbolStates;
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

    public boolean isBasic() {
        return isBasic;
    }

    public void setBasic(boolean basic) {
        isBasic = basic;
    }

    public Set<String> getStates() {
        return states;
    }

    public void setStates(Set<String> states) {
        this.states = states;
    }

    public List<SymbolStates> getSymbolStates() {
        return symbolStates;
    }

    public void setSymbolStates(List<SymbolStates> symbolStates) {
        this.symbolStates = symbolStates;
    }

    public String[] getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String[] alphabet) {
        this.alphabet = alphabet;
    }
}
