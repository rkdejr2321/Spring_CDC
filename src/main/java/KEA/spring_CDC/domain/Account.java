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
@ToString
public class Account {

    @Id
    @Column(name = "account_id")
    private String accountId;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_description")
    private String userDescription;

    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @Column(name = "__deleted")
    @ColumnDefault("'false'")
    private String deleted;
}
