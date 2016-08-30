package supersimplestocks.stock;

import java.math.BigDecimal;

/**
 * Created by yarbong on 21/04/2016.
 */
public class VolumePrice {
    private BigDecimal tradePrice;
    private long tradeQuantity;

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public long getTradeQuantity() {
        return tradeQuantity;
    }

    public void setTradeQuantity(long tradeQuantity) {
        this.tradeQuantity = tradeQuantity;
    }

    public VolumePrice() {
    }

    public VolumePrice(BigDecimal tradePrice, long tradeQuantity) {
        this.tradePrice = tradePrice;
        this.tradeQuantity = tradeQuantity;
    }
}
