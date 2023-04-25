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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("account/{id}/edit")
    public String updateItemForm(@PathVariable("id") String accountId, Model model) {

        Account account = accountSourceRepository.findByAccountId(accountId);

        AccountForm form = new AccountForm();
        form.setAccountId(account.getAccountId());
        form.setRoleId(account.getRoleId());
        form.setUserName(account.getUserName());
        form.setUserDescription(account.getUserDescription());

        model.addAttribute("form", form);
        return "updateAccountForm";

    }

    @PostMapping("/account")
    public String insertAccount(AccountForm form) {
        log.info(form.toString());
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

    @GetMapping("/")
    public String accountList(Model model) {
        List<Account> sourceList = accountSourceRepository.findAll();
        List<SinkAccount> sinkList = accountSinkRepository.findAll();

        model.addAttribute("sourceList", sourceList);
        model.addAttribute("sinkList", sinkList);

        return "account";
    }

    @PostMapping("/account/delete")
    public String deleteAccount(@RequestParam(name = "id") String accountId) {
        log.info(accountId);
        Account byAccountId = accountSourceRepository.findByAccountId(accountId);
        accountSourceRepository.delete(byAccountId);

        return "redirect:/";
    }
}