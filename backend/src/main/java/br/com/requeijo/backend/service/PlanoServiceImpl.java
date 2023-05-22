package br.com.requeijo.backend.service;

import br.com.requeijo.backend.model.BeneficiarioModel;
import br.com.requeijo.backend.model.PlanoModel;
import br.com.requeijo.backend.repository.BeneficiarioRepository;
import br.com.requeijo.backend.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoServiceImpl {

    @Autowired
    private PlanoRepository repository;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

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

        Optional<BeneficiarioModel> beneficiario = Optional.of(plano.getBeneficiario());
        final BeneficiarioModel beneficiarioModel = beneficiario.orElseThrow();

        plano.setBeneficiario(beneficiarioRepository.findById(beneficiarioModel.getId()));

        return repository.insert(plano);
    }

    public void atualizar(PlanoModel plano) {
        repository.update(plano);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
