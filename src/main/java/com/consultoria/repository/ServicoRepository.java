package com.consultoria.repository;

import com.consultoria.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Interface que estende o JpaRepository para gerenciar a entidade de serviço
 */

public interface ServicoRepository extends JpaRepository<Servico, UUID> {
}
