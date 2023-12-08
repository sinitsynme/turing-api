package ru.sinitsynme.turingapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sinitsynme.turingapi.entity.AlgorythmSolutionStep;
import ru.sinitsynme.turingapi.rest.dto.AlgorythmRequestDto;
import ru.sinitsynme.turingapi.service.TuringService;

import java.util.List;

@RestController
@RequestMapping("/algorythm")
public class TuringResource {

    private final TuringService turingService;

    @Autowired
    public TuringResource(TuringService turingService) {
        this.turingService = turingService;
    }

    @GetMapping("/ids")
    public List<Integer> getAllAlgoIds() {
        return null;
    }

    @PostMapping
    public List<AlgorythmSolutionStep> saveAlgorythm(@RequestBody AlgorythmRequestDto algorythmRequestDto, @RequestParam String tape) {
        return turingService.executeAlgorythm(algorythmRequestDto, tape);
    }

}
