package br.com.requeijo.backend.service;

import br.com.requeijo.backend.model.PlanoModel;
import br.com.requeijo.backend.repository.PlanoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlanoServiceImpl {

    private final PlanoRepository repository;

    public List<PlanoModel> listar() {
        return repository.findAll();
    }

    public Optional<PlanoModel> buscar(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    public List<PlanoModel> pesquisar(String nome) {
        return repository.findByName(nome);
    }

    public int salvar(PlanoModel plano) {
        return repository.insert(plano);
    }

    public void atualizar(PlanoModel plano) {
        repository.update(plano);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
