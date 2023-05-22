package br.com.requeijo.backend.service;

import br.com.requeijo.backend.model.BeneficiarioModel;
import br.com.requeijo.backend.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioServiceImpl {

    @Autowired
    private BeneficiarioRepository repository;

    public List<BeneficiarioModel> listar() {
        return repository.findAll();
    }

    public Optional<BeneficiarioModel> buscar(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    public int salvar(BeneficiarioModel beneficiario) {
        return repository.insert(beneficiario);
    }

    public void atualizar(BeneficiarioModel beneficiario) {
        repository.update(beneficiario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
