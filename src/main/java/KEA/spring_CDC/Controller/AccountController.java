package KEA.spring_CDC.Controller;

import KEA.spring_CDC.domain.AccountForm;
import KEA.spring_CDC.domain.SinkAccount;
import KEA.spring_CDC.sinkRepository.AccountSinkRepository;
import KEA.spring_CDC.sourceRepository.AccountSourceRepository;
import KEA.spring_CDC.domain.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountSourceRepository accountSourceRepository;
    private final AccountSinkRepository accountSinkRepository;


    @GetMapping("/account-form")
    public String accountForm(Model model) {
        model.addAttribute("form", new AccountForm());
        return "createAccountForm";
    }

    @PostMapping("/account")
    public String insertAccount(AccountForm form) {

        Account account = Account.builder()
                .accountId(form.getAccountId())
                .roleId(form.getRoleId())
                .userName(form.getUserName())
                .userDescription(form.getUserDescription())
                .updateTime(LocalDateTime.now())
                .build();

        accountSourceRepository.save(account);

        return "redirect:/";
    }

    @GetMapping("/account-list")
    public String accountList(Model model) {
        List<Account> sourceList = accountSourceRepository.findAll();
        List<SinkAccount> sinkList = accountSinkRepository.findAll();

        model.addAttribute("sourceList", sourceList);
        model.addAttribute("sinkList", sinkList);

        return "account";
    }
}