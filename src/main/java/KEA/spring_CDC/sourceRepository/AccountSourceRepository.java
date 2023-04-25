package KEA.spring_CDC.sourceRepository;

import KEA.spring_CDC.domain.Account;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AccountSourceRepository extends JpaRepository<Account, String> {

    Account save(Account account);

    List<Account> findAll();

    Account findByAccountId(String id);
    void delete(Account account);
}
