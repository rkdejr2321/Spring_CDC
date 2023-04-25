package KEA.spring_CDC.Controller;

import KEA.spring_CDC.Repository.AccountRepository;
import KEA.spring_CDC.domain.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountRepository accountRepository;

    @PostMapping("/account")
    public void insertAccount(@RequestBody Account account) {
        log.info(account.getAccountId());
        accountRepository.save(account);
    }

    @GetMapping("/account-list")
    public String accountList(Model model) {
        List<Account> accountList = accountRepository.findAll();

        model.addAttribute("accounts", accountList);

        return "account";
    }
}
