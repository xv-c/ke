package com.example.kubernetesexample.repo;

import com.example.kubernetesexample.model.StartupLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StartupLogRepo extends JpaRepository<StartupLog, UUID> {
}
