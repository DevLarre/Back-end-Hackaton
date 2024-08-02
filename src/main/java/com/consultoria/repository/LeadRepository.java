package com.consultoria.repository;

import com.consultoria.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

//Interface de gerenciar o Lead de postagens,

public interface LeadRepository extends JpaRepository<Lead, UUID> {
}
