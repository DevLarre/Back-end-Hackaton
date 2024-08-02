package com.consultoria.repository;

import com.consultoria.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FormRepository extends JpaRepository<Form, UUID> {
}
