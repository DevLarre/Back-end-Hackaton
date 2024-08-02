package com.consultoria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

 /**
  * Cliente Depoimento
 * Representa um depoimento de um cliente/parceiro,
 * contendo o nome da empresa, o depoimento e a URL da imagem da empresa.
 */

@Entity
public class ClienteDepoimento {
    @Id
    @GeneratedValue
    private UUID id;
    private String nomeEmpresa;
    private String depoimento;
    private String imagemUrl; //Essa parte aqui talvez podemos tirar, é um campo que deixei para importar a imagem da empresa parceira no campo depoimentos

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getDepoimento() {
        return depoimento;
    }

    public void setDepoimento(String depoimento) {
        this.depoimento = depoimento;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

     public void setNome(String cliente) {

     }
 }
