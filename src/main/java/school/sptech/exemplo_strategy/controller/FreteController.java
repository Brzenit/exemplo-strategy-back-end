package school.sptech.exemplo_strategy.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.exemplo_strategy.controller.dto.FreteRequestDto;
import school.sptech.exemplo_strategy.controller.dto.FreteResponseDto;
import school.sptech.exemplo_strategy.entity.Frete;
import school.sptech.exemplo_strategy.service.FreteService;

import java.util.List;

@RestController
@RequestMapping("/fretes")
public class FreteController {

    private final FreteService freteService;

    public FreteController(FreteService freteService) {
        this.freteService = freteService;
    }

    @PostMapping
    public ResponseEntity<FreteResponseDto> calcularFrete(@Valid @RequestBody FreteRequestDto request) {
        FreteResponseDto freteResponseDto  = freteService.registrarCotacao(request);
        return ResponseEntity.status(200).body(freteResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<Frete>> listarFretes() {
        List<Frete> fretes = freteService.listarCotacoes();
        return ResponseEntity.status(200).body(fretes);
    }
}
