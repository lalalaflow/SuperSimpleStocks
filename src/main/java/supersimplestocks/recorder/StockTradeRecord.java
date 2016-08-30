package supersimplestocks.recorder;

import supersimplestocks.stock.StockSymbol;

import java.math.BigDecimal;


/**
 * Created by yarbong on 19/04/2016.
 */
public class StockTradeRecord {

    private long tradeTime;
    private StockSymbol stockSymbol;
    private long quantity;
    private String indicator;
    private BigDecimal price;

    public long getTradeTime() {
        return tradeTime;
    }

    public StockSymbol getStockSymbol() {
        return stockSymbol;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getIndicator() {
        return indicator;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public StockTradeRecord(StockSymbol stockSymbol, long quantity, String indicator, BigDecimal price){
        this.tradeTime = System.currentTimeMillis();
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.indicator = indicator;
        this.price = price;
    }
}
