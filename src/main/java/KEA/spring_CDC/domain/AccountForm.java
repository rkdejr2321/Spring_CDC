package KEA.spring_CDC.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class AccountForm {

    private String accountId;
    private String roleId;
    private String userName;
    private String userDescription;
}
