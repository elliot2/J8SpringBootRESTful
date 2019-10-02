package codingChallenge.routers;

import codingChallenge.handlers.AccountListHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AccountListRouter {

    @Bean
    public RouterFunction<ServerResponse> route(AccountListHandler accountListHandler) {

        return RouterFunctions
                .route(RequestPredicates.GET("/accountList").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), accountListHandler::accountList);
    }
}