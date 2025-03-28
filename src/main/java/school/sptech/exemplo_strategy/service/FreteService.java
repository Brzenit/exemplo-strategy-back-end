package school.sptech.exemplo_strategy.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.exemplo_strategy.controller.dto.FreteRequestDto;
import school.sptech.exemplo_strategy.controller.dto.FreteResponseDto;
import school.sptech.exemplo_strategy.entity.Frete;
import school.sptech.exemplo_strategy.exception.FreteInvalidoException;
import school.sptech.exemplo_strategy.exception.SemFretesException;
import school.sptech.exemplo_strategy.repository.FreteRepository;

import java.util.List;

@Service
public class FreteService {

    private final FreteRepository freteRepository;

    public FreteService(FreteRepository freteRepository) {
        this.freteRepository = freteRepository;
    }

    public FreteResponseDto registrarCotacao(FreteRequestDto frete) {
        Frete novoFrete = new Frete(1,frete);
        if (freteRepository.existsById(novoFrete.getId())) {
            throw new FreteInvalidoException("Frete com ID:" + novoFrete.getId() + " Já existe no banco de dados");
        }

        freteRepository.save(novoFrete);
        System.out.println("Frete registrado com sucesso");
        return FreteResponseDto.toResponse(novoFrete);
    }

    public List<Frete> listarCotacoes() {
        List<Frete> fretesEncontrados = freteRepository.findAll();

        if (fretesEncontrados.isEmpty()) {
            throw new SemFretesException("Não existe fretes cadastrados");
        }

        return freteRepository.findAll();
    }
}
