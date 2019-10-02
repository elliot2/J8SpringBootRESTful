package codingChallenge.routers;

import codingChallenge.handlers.AccountTransactionsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AccountTransactionsRouter {

    @Bean
    public RouterFunction<ServerResponse> routeTransactions(AccountTransactionsHandler accountTransactionsHandler) {

        return RouterFunctions
                .route(RequestPredicates.GET("/transactions/{account}").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), accountTransactionsHandler::transactionList);
    }
}