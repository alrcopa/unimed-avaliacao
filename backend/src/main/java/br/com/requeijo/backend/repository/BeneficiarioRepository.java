package br.com.requeijo.backend.repository;

import br.com.requeijo.backend.model.BeneficiarioModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BeneficiarioRepository {

    @Select("select * from beneficiario")
    List<BeneficiarioModel> findAll();

    @Select("SELECT * FROM beneficiario WHERE id = #{id}")
    BeneficiarioModel findById(long id);

    @Delete("DELETE FROM beneficiario WHERE id = #{id}")
    int deleteById(long id);

    @Insert("INSERT INTO beneficiario(nome, cpf, email, idade) VALUES (#{nome}, #{cpf}, #{email}, #{idade})")
    int insert(BeneficiarioModel beneficiario);

    @Update("Update beneficiario set nome=#{nome}, cpf=#{cpf}, email=#{email}, idade=#{idade} where id=#{id}")
    int update(BeneficiarioModel beneficiario);

    @Select("SELECT * FROM beneficiario WHERE UPPER(nome) like UPPER('%#{nome}%') ")
    BeneficiarioModel findByName(String nome);
}

