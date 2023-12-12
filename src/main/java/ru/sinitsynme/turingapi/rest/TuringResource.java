package ru.sinitsynme.turingapi.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sinitsynme.turingapi.entity.Algorythm;
import ru.sinitsynme.turingapi.entity.AlgorythmSolutionStep;
import ru.sinitsynme.turingapi.rest.dto.AlgorythmRequestDto;
import ru.sinitsynme.turingapi.rest.dto.AlgorythmResponseDto;
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

    @Operation(summary = "Получить данные обо всех алгоритмах")
    @GetMapping
    public ResponseEntity<List<AlgorythmResponseDto>> getAllAlgoIds() {
        return ResponseEntity.ok(turingService.getAllAlgosData());
    }

    @Operation(summary = "Сохранить алгоритм")
    @PostMapping
    public ResponseEntity<AlgorythmResponseDto> saveAlgorythm(@RequestBody AlgorythmRequestDto algorythmRequestDto) {
        return ResponseEntity.ok(turingService.saveAlgorythm(algorythmRequestDto));
    }

    @Operation(summary = "Исполнить алгоритм по ID")
    @GetMapping("{id}/execute")
    public ResponseEntity<List<AlgorythmSolutionStep>> executeAlgorythm(@PathVariable("id") String algorythmId, @RequestParam String tape) {
        return ResponseEntity.ok(turingService.executeAlgorythm(algorythmId, tape));
    }

    @Operation(summary = "Получить алгоритм по ID")
    @GetMapping("/{id}")
    public ResponseEntity<Algorythm> getAlgorythmById(@PathVariable("id") String algorythmId) {
        return ResponseEntity.ok(turingService.getAlgorythm(algorythmId));
    }

    @Operation(summary = "Отредактировать алгоритм")
    @PostMapping("/{id}")
    public ResponseEntity<Algorythm> editAlgorythm(@PathVariable("id") String algorythmId, @RequestBody  AlgorythmRequestDto algorythmRequestDto) {
        return ResponseEntity.ok(turingService.editAlgorythm(algorythmId, algorythmRequestDto));
    }

}
