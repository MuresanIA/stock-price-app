import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

class WebClientStockClientIntegrationTest {

    @Test
    void shouldRetrieveStockPricesFromTheService() {
        WebClientStockClient webClientStockClient = new WebClientStockClient(webClient);
        Flux<StockPrice> prices = webClientStockClient.pricesFor("SYMBOL");

        Assertions.assertNotNull(prices);
        Assertions.assertTrue(prices.take(5).count().block() > 0);
    }
}