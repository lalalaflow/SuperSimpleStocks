package supersimplestocks.trader;

import supersimplestocks.stock.VolumePrice;
import supersimplestocks.stock.StockSymbol;

import java.math.BigDecimal;

import java.lang.String;
/**
 * Created by yarbong on 19/04/2016.
 */
public class Trade extends VolumePrice {
    private StockSymbol stockSymbol;
    private String indicator;
    private BigDecimal dividendYield;
    private BigDecimal peRatio;
    private BigDecimal volumeWeightedStockPrice;
    private BigDecimal geometricMean;


    public StockSymbol getStockSymbol() {
        return stockSymbol;
    }

    public BigDecimal getTradePrice() {
        return super.getTradePrice();
    }

    public long getTradeQuantity() {
        return super.getTradeQuantity();
    }

    public String getIndicator() {
        return indicator;
    }

    public BigDecimal getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(BigDecimal dividendYield) {
        this.dividendYield = dividendYield;
    }

    public BigDecimal getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(BigDecimal peRatio) {
        this.peRatio = peRatio;
    }

    public BigDecimal getVolumeWeightedStockPrice() {
        return volumeWeightedStockPrice;
    }

    public void setVolumeWeightedStockPrice(BigDecimal volumeWeightedStockPrice) {
        this.volumeWeightedStockPrice = volumeWeightedStockPrice;
    }

    public BigDecimal getGeometricMean() {
        return geometricMean;
    }

    public void setGeometricMean(BigDecimal geometricMean) {
        this.geometricMean = geometricMean;
    }


    public Trade(StockSymbol stockSymbol,  BigDecimal tradePrice, long tradeQuantity, String indicator) {
        this.stockSymbol = stockSymbol;
        super.setTradePrice(tradePrice);
        super.setTradeQuantity(tradeQuantity);
        this.indicator = indicator;
    }
}
