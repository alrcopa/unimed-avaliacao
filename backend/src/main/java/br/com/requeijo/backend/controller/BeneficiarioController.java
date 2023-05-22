package br.com.requeijo.backend.controller;

import br.com.requeijo.backend.model.BeneficiarioModel;
import br.com.requeijo.backend.service.BeneficiarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioServiceImpl service;

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
