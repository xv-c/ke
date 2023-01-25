package mm.tg.kubernetesexample.repo;

import mm.tg.kubernetesexample.model.StartupLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StartupLogRepo extends JpaRepository<StartupLog, UUID> {
}
