package br.com.requeijo.backend.service;

import br.com.requeijo.backend.model.Usuario;
import br.com.requeijo.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Optional<Usuario> buscar(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    public int salvar(Usuario usuario) {
        return repository.insert(usuario);
    }

    public void atualizar(Usuario usuario) {
        repository.update(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
