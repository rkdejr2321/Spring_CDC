package KEA.spring_CDC.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    private String accountId;

    @Column
    private String roleId;

    @Column
    private String userName;

    @Column
    private String userDescription;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @Column(name = "__deleted")
    @ColumnDefault("'false'")
    private String deleted;
}
