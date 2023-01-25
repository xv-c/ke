package mm.tg.kubernetesexample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StartupLog {
    @Id
    private UUID id;

    private OffsetDateTime startedAt;

    @JdbcTypeCode(SqlTypes.JSON)
    private LogData data;

    @Getter
    @Setter
    @Builder
    public static class LogData implements Serializable {
        private Map<String, String> data;

        private Map<String, String> env;

        private Map<String, String> properties;
    }
}
