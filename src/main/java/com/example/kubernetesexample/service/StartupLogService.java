package com.example.kubernetesexample.service;

import com.example.kubernetesexample.model.StartupLog;
import com.example.kubernetesexample.model.StartupLog.LogData;
import com.example.kubernetesexample.repo.StartupLogRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StartupLogService {
    private final StartupLogRepo startupLogRepo;

    @PostConstruct
    private void onStartup() throws UnknownHostException {
        startupLogRepo.save(StartupLog.builder()
                .id(UUID.randomUUID())
                .startedAt(OffsetDateTime.now())
                .data(LogData.builder()
                        .data(getData())
                        .env(getEnv())
                        .properties(getProperties())
                        .build())
                .build()
        );
    }

    private Map<String, String> getData() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();

        return Map.of(
                "hostname", localHost.getHostAddress(),
                "hostAddress", localHost.getHostName()
        );
    }

    private Map<String, String> getEnv() {
        return new HashMap<>(System.getenv());
    }

    private Map<String, String> getProperties() {
        return System.getProperties().entrySet().stream()
                .collect(
                        HashMap::new,
                        (map, entry) -> map.put(entry.getKey().toString(), entry.getValue().toString()),
                        HashMap::putAll
                );
    }
}
