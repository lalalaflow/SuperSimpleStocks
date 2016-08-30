package supersimplestocks.stock;

import java.math.BigDecimal;

/**
 * Created by yarbong on 20/04/2016.
 */
public class Stock implements Comparable<Stock>{

    private int SCALE_FIXED_DIVIDEND = -2;

    private StockSymbol stockSymbol;
    private StockType stockType;
    private BigDecimal lastDividend;
    private BigDecimal fixedDividend;
    private BigDecimal parValue;

    public BigDecimal getParValue() {
        return parValue;
    }

    public void setParValue(BigDecimal parValue) {
        this.parValue = parValue;
    }

    public StockSymbol getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(StockSymbol stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public StockType getStockType() {
        return stockType;
    }

    public void setStockType(StockType stockType) {
        this.stockType = stockType;
    }

    public BigDecimal getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(BigDecimal lastDividend) {
        this.lastDividend = lastDividend;
    }

    public BigDecimal getFixedDividend() {
        return fixedDividend;
    }

    /**
     * Fixed value is offered with % value so we need to scale
     * @param fixedDividend
     */
    public void setFixedDividend(BigDecimal fixedDividend) {
        this.fixedDividend = fixedDividend.scaleByPowerOfTen(SCALE_FIXED_DIVIDEND);
    }

    /**
     * To compare object
     * @param o
     * @return
     */
    public int compareTo(Stock o) {

        return this.getStockSymbol().compareTo(o.stockSymbol);
    }

    public Stock(StockSymbol stockSymbol, StockType stockType, BigDecimal lastDividend, BigDecimal fixedDividend, BigDecimal parValue) {
        setStockSymbol(stockSymbol);
        setStockType(stockType);
        setLastDividend(lastDividend);
        setFixedDividend(fixedDividend);
        setParValue(parValue);
    }

}
