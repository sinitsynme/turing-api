package ru.sinitsynme.turingapi.engine;

import org.springframework.stereotype.Component;
import ru.sinitsynme.turingapi.entity.Algorythm;
import ru.sinitsynme.turingapi.entity.AlgorythmSolutionStep;
import ru.sinitsynme.turingapi.entity.Command;
import ru.sinitsynme.turingapi.entity.MoveCaretOption;

import java.util.ArrayList;
import java.util.List;

@Component
//@ConfigurationProperties TODO
public class TuringEngine {

//    @Value("${turing.firstState}") final
    private  String firstState = "q0";
//    @Value("${turing.finalState}")
    private  String finalState = "HALT";
    private String currentState;
    private int caretIndex = 0;

//    public TuringEngine(String firstState, String finalState) {
//        this.firstState = firstState;
//        this.finalState = finalState;
//    }

    public List<AlgorythmSolutionStep> solveAlgorythm(Algorythm algorythm, String tape) {
        caretIndex = 0;
        currentState = firstState;
        List<AlgorythmSolutionStep> solutionSteps = new ArrayList<>();

        while (!currentState.equals(finalState)) {
            //TODO add cycle check
            solutionSteps.add(fixStep(tape));
            tape = getTapeAfterOneIteration(algorythm, tape);
        }

        solutionSteps.add(fixStep(tape));
        return solutionSteps;
    }

    private AlgorythmSolutionStep fixStep(String tape) {
        return new AlgorythmSolutionStep(tape, caretIndex, currentState);
    }
    private String getTapeAfterOneIteration(Algorythm algorythm, String tape) {
        char currentSymbol = tape.charAt(caretIndex);

        Command command = algorythm
                .getSymbolStates()
                .stream()
                .filter(it -> it.getSymbol().equals(currentSymbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException()) //TODO
                .getPairsOfStatesAndDedicatedCommands().get(currentState);

        char overwrittenSymbol = command.getWrittenSymbol();
        String newTape = replaceChar(tape, overwrittenSymbol, caretIndex);

        currentState = command.getNextState();
        moveCaret(command.getMoveCaretOption());

        return newTape;
    }

    private void moveCaret(MoveCaretOption moveCaretOption) {
        if (moveCaretOption == MoveCaretOption.RIGHT) {
            caretIndex++;
        }
        else if (moveCaretOption == MoveCaretOption.LEFT) {
            caretIndex--;
        }

        //TODO add borders checking
    }

    private String replaceChar(String str, char newChar, int index) {
        char[] chars = str.toCharArray();
        chars[index] = newChar;
        return String.valueOf(chars);
    }
}
