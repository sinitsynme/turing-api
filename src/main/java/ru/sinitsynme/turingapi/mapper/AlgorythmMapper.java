package ru.sinitsynme.turingapi.mapper;

import org.springframework.stereotype.Component;
import ru.sinitsynme.turingapi.entity.Algorythm;
import ru.sinitsynme.turingapi.entity.Command;
import ru.sinitsynme.turingapi.entity.MoveCaretOption;
import ru.sinitsynme.turingapi.entity.SymbolStates;
import ru.sinitsynme.turingapi.rest.dto.AlgorythmRequestDto;
import ru.sinitsynme.turingapi.rest.dto.CommandDto;
import ru.sinitsynme.turingapi.rest.dto.SymbolStatesDto;

import java.util.*;

@Component
public class AlgorythmMapper {

    public Algorythm mapAlgorythmFromDto(AlgorythmRequestDto requestDto) {
        Algorythm algorythm = new Algorythm();
        algorythm.setName(requestDto.getName());
        algorythm.setBasic(requestDto.isBasic());
        algorythm.setAlphabet(requestDto.getAlphabet().split(""));

        List<SymbolStates> symbolStates = requestDto
                .getSymbols()
                .stream()
                .map(this::mapSymbolStatesFromDto)
                .toList();

        algorythm.setSymbolStates(symbolStates);
        algorythm.setStates(getAllStates(requestDto));

        return algorythm;
    }

    private SymbolStates mapSymbolStatesFromDto(SymbolStatesDto symbolStatesDto) {
        SymbolStates symbolStates = new SymbolStates();
        symbolStates.setSymbol(symbolStatesDto.getSymbol());

        Map<String, Command> statesCommands = new HashMap<>();

        symbolStatesDto.getStates().forEach((key, value) -> {
            statesCommands.put(key, mapCommandFromDto(value));
        });

        symbolStates.setPairsOfStatesAndDedicatedCommands(statesCommands);
        return symbolStates;
    }

    private Command mapCommandFromDto(CommandDto commandDto) {
        Command command = new Command();
        command.setNextState(commandDto.getNextState());
        command.setWrittenSymbol(commandDto.getSymbol());
        command.setMoveCaretOption(MoveCaretOption.parseFromAlias(commandDto.getMove()));

        return command;
    }

    private Set<String> getAllStates(AlgorythmRequestDto algorythmRequestDto) {
        Set<String> statesSet = new HashSet<>();

        algorythmRequestDto.getSymbols().forEach(
                it -> it.getStates().forEach((key, value) -> {
                            statesSet.add(key);
                            statesSet.add(value.getNextState());
                        }
                )
        );
        return statesSet;
    }
}
