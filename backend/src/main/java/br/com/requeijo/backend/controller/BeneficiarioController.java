package br.com.requeijo.backend.controller;

import br.com.requeijo.backend.model.BeneficiarioModel;
import br.com.requeijo.backend.service.BeneficiarioServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioController {

    private final BeneficiarioServiceImpl service;

    @GetMapping
    public List<BeneficiarioModel> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<BeneficiarioModel> buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public int salvar(@RequestBody BeneficiarioModel beneficiario) {
        return service.salvar(beneficiario);
    }

    @PutMapping
    public void atualizar(@RequestBody BeneficiarioModel beneficiario) {
        service.atualizar(beneficiario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
