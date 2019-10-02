package codingChallenge.handlers;

import codingChallenge.models.Transaction;
import codingChallenge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class AccountTransactionsHandler {

    @Autowired
    private TransactionService transactionService;

    public Mono<ServerResponse> transactionList(ServerRequest request) {
        String accountId = request.pathVariable("account");
        Iterable<Transaction> transactionList = transactionService.getTransactionsByAccountId(accountId);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(transactionList));
    }
}