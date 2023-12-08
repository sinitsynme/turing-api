package ru.sinitsynme.turingapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sinitsynme.turingapi.engine.TuringEngine;
import ru.sinitsynme.turingapi.entity.Algorythm;
import ru.sinitsynme.turingapi.entity.AlgorythmSolutionStep;
import ru.sinitsynme.turingapi.mapper.AlgorythmMapper;
import ru.sinitsynme.turingapi.rest.dto.AlgorythmRequestDto;

import java.util.List;

@Service
public class TuringService {

    private final AlgorythmMapper algorythmMapper;
    private final TuringEngine turingEngine;

    public TuringService(AlgorythmMapper algorythmMapper, TuringEngine turingEngine) {
        this.algorythmMapper = algorythmMapper;
        this.turingEngine = turingEngine;
    }

    public int saveAlgorythm(AlgorythmRequestDto requestDto){
        Algorythm algorythm = algorythmMapper.mapAlgorythmFromDto(requestDto);
        return 1;
    }

    public List<AlgorythmSolutionStep> executeAlgorythm(AlgorythmRequestDto requestDto, String tape){
        Algorythm algorythm = algorythmMapper.mapAlgorythmFromDto(requestDto);
        return turingEngine.solveAlgorythm(algorythm, tape);
    }


}
