package br.com.requeijo.backend.repository;

import br.com.requeijo.backend.model.BeneficiarioModel;
import br.com.requeijo.backend.model.PlanoModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BeneficiarioRepository {

    @Select("SELECT beneficiario.*, plano.* FROM beneficiario " +
            "LEFT JOIN plano ON beneficiario.plano_id = plano.id")
    @Results(value = {
            @Result(property = "plano", column = "plano_id", one=@One(select = "br.com.requeijo.backend.repository.PlanoRepository.findById"))
    })
    List<BeneficiarioModel> findAll();

    @Select("SELECT * FROM beneficiario WHERE id = #{id}")
    @Results(value = {
            @Result(property = "plano", column = "plano_id", one=@One(select = "br.com.requeijo.backend.repository.PlanoRepository.findById"))
    })
    BeneficiarioModel findById(long id);

    @Delete("DELETE FROM beneficiario WHERE id = #{id}")
    int deleteById(long id);

    @Insert("INSERT INTO beneficiario (nome, cpf, email, idade, plano_id) VALUES (#{nome}, #{cpf}, #{email}, #{idade}, #{plano_id})")
    int insert(BeneficiarioModel beneficiario);

    @Update("Update beneficiario set nome=#{nome}, cpf=#{cpf}, email=#{email}, idade=#{idade}, plano_id = #{plano.id} where id=#{id}")
    int update(BeneficiarioModel beneficiario);

//    @Select("SELECT * FROM beneficiario WHERE UPPER(nome) like UPPER('%#{nome}%') ")
//    BeneficiarioModel findByName(String nome);
    @Select({"<script>",
            "SELECT beneficiario.*, plano.* FROM beneficiario " +
            "LEFT JOIN plano ON beneficiario.plano_id = plano.id" +
            "WHERE upper(nome) like upper('%${nome}%') ",
            "</script>"})
    @Results(value = {
        @Result(property = "plano", column = "plano_id", one=@One(select = "br.com.requeijo.backend.repository.PlanoRepository.findById"))
    })
    List<BeneficiarioModel> findByName(String nome);
}

