package KEA.spring_CDC.sinkRepository;

import KEA.spring_CDC.domain.Account;
import KEA.spring_CDC.domain.SinkAccount;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AccountSinkRepository extends JpaRepository<SinkAccount, String> {


    List<SinkAccount> findAll();
}
