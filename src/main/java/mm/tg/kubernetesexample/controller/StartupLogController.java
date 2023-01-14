package mm.tg.kubernetesexample.controller;

import mm.tg.kubernetesexample.model.StartupLog;
import lombok.RequiredArgsConstructor;
import mm.tg.kubernetesexample.service.StartupLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StartupLogController {
    private final StartupLogService service;

    @GetMapping
    public List<StartupLog> list() {
        return service.findAll();
    }
}
