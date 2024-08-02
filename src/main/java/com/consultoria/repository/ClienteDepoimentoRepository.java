package com.consultoria.repository;


import com.consultoria.model.ClienteDepoimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 *Criado uma interface que estende do JpaRepository para gerenciar toda entidade de ClienteDepoimento.
 * Esse arquivo interface sera o responsavel por se comunicar atraves da extensão com o cliente.
 */

public interface ClienteDepoimentoRepository extends JpaRepository<ClienteDepoimento, UUID> {
}
