package KEA.spring_CDC.Repository;

import KEA.spring_CDC.domain.Account;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountRepository {

    private final EntityManager em;

    public void save(Account account) {
        account.setDeleted("false");
        em.persist(account);
    }


    public List<Account> findAll() {

        return em.createQuery("select a from Account a", Account.class)
                .getResultList();
    }
}
