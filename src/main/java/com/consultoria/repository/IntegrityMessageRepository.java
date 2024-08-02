package com.consultoria.repository;

import com.consultoria.model.IntegrityMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IntegrityMessageRepository extends JpaRepository<IntegrityMessage, UUID> {
}
