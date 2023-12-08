package ru.sinitsynme.turingapi.entity;

public class Command {

    private Character writtenSymbol;
    private String nextState;
    private MoveCaretOption moveCaretOption;

    public Command() {
    }

    public Command(Character writtenSymbol, String nextState, MoveCaretOption moveCaretOption) {
        this.writtenSymbol = writtenSymbol;
        this.nextState = nextState;
        this.moveCaretOption = moveCaretOption;
    }

    public Character getWrittenSymbol() {
        return writtenSymbol;
    }

    public void setWrittenSymbol(Character writtenSymbol) {
        this.writtenSymbol = writtenSymbol;
    }

    public String getNextState() {
        return nextState;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    public MoveCaretOption getMoveCaretOption() {
        return moveCaretOption;
    }

    public void setMoveCaretOption(MoveCaretOption moveCaretOption) {
        this.moveCaretOption = moveCaretOption;
    }
}
