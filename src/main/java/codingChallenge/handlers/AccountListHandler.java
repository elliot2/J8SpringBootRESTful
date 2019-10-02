package codingChallenge.handlers;

import codingChallenge.models.Account;
import codingChallenge.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;


@Component
public class AccountListHandler {

    @Autowired
    private AccountService accountService;

    public Mono<ServerResponse> accountList(ServerRequest request) {
        Iterable<Account> accountList = accountService.getAllAccounts();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(accountList));
    }
}