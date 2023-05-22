package br.com.requeijo.backend.controller;

import br.com.requeijo.backend.model.PlanoModel;
import br.com.requeijo.backend.service.PlanoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plano")
public class PlanoController {


    @Autowired
    private PlanoServiceImpl service;

    @GetMapping
    public List<PlanoModel> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<PlanoModel> buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping("/pesquisar")
    public ResponseEntity<List<PlanoModel>> pesquisar(@RequestBody String nome) {
        return ResponseEntity.ok(service.pesquisar(nome));
    }

    @PostMapping
    public int salvar(@RequestBody PlanoModel plano) {
        return service.salvar(plano);
    }

//    @PutMapping
//    public void atualizar(@RequestBody PlanoModel plano) {
//        service.atualizar(plano);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deletar(@PathVariable Long id) {
//        service.deletar(id);
//    }
}
