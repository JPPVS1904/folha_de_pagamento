package FolhaDePagamento.adapters.in.web;

import FolhaDePagamento.application.usecases.GerarFolhaUseCase;
import FolhaDePagamento.domain.entities.ResultadoFolha;
import FolhaDePagamento.domain.entities.Funcionario;
import FolhaDePagamento.repositories.FuncionarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/folha")
public class FolhaPagamentoController {

    private final GerarFolhaUseCase gerarFolhaUseCase;
    private final FuncionarioRepository funcionarioRepository;

    public FolhaPagamentoController(GerarFolhaUseCase gerarFolhaUseCase, FuncionarioRepository funcionarioRepository) {
        this.gerarFolhaUseCase = gerarFolhaUseCase;
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping("/gerar")
    public ResponseEntity<ResultadoFolha> gerarFolha(@RequestBody GerarFolhaRequest request) {
        try {
            ResultadoFolha resultado = gerarFolhaUseCase.executar(
                    request.getFuncionarioId(),
                    request.getMesFolha(),
                    request.getAnoFolha(),
                    request.isFeriasNoMes()
            );
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/funcionario")
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario salvo = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(salvo);
    }
    
    @GetMapping("/funcionarios")
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        return ResponseEntity.ok(funcionarioRepository.findAll());
    }
}
