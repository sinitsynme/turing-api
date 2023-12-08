package ru.sinitsynme.turingapi.entity;

import java.util.Map;

public class SymbolStates {

    private Character symbol;
    private Map<String, Command> pairsOfStatesAndDedicatedCommands;

    public SymbolStates() {
    }

    public SymbolStates(Character symbol, Map<String, Command> pairsOfStatesAndDedicatedCommands) {
        this.symbol = symbol;
        this.pairsOfStatesAndDedicatedCommands = pairsOfStatesAndDedicatedCommands;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public Map<String, Command> getPairsOfStatesAndDedicatedCommands() {
        return pairsOfStatesAndDedicatedCommands;
    }

    public void setPairsOfStatesAndDedicatedCommands(Map<String, Command> pairsOfStatesAndDedicatedCommands) {
        this.pairsOfStatesAndDedicatedCommands = pairsOfStatesAndDedicatedCommands;
    }
}
