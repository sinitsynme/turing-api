package ru.sinitsynme.turingapi.rest.dto;

public class CommandDto {
    private String nextState;
    private Character symbol;
    private Character move;

    public CommandDto() {
    }

    public CommandDto(String nextState, Character symbol, Character move) {
        this.nextState = nextState;
        this.symbol = symbol;
        this.move = move;
    }

    public String getNextState() {
        return nextState;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public Character getMove() {
        return move;
    }

    public void setMove(Character move) {
        this.move = move;
    }


}
