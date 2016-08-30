package coding.interview.supersimplestocks.calculator;

import coding.interview.supersimplestocks.stock.VolumePrice;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/**
 * Created by yarbong on 19/04/2016.
 * Calculate Volume Weighted Trade Price based on trades in past 15 minutes
 */
public class VolumeWeightedStockPrice {

    public BigDecimal calculate(List<VolumePrice> volumePriceList) {
        return (calculateTotalPrice(volumePriceList)
                .divide(calculateTotalVolume(volumePriceList), MathContext.DECIMAL32));
    }

    private BigDecimal calculateTotalVolume(List<VolumePrice> volumePriceList) {
        BigDecimal totlaVolume = BigDecimal.ZERO;
        for (VolumePrice volumePrice : volumePriceList) {
            totlaVolume = totlaVolume.add(new BigDecimal(volumePrice.getTradeQuantity()), MathContext.DECIMAL32);
        }
        return totlaVolume;
    }

    private BigDecimal calculateTotalPrice(List<VolumePrice> volumePriceList){
        BigDecimal totalTradedPrice = BigDecimal.ZERO;
        for (VolumePrice volumePrice : volumePriceList) {
            totalTradedPrice = totalTradedPrice
                    .add(calculateEachTradedPrice(volumePrice.getTradePrice(), volumePrice.getTradeQuantity()), MathContext.DECIMAL32);
        }
        return totalTradedPrice;
    }

    private BigDecimal calculateEachTradedPrice(BigDecimal price, long quantity){
        return price.multiply(new BigDecimal(quantity), MathContext.DECIMAL32);
    }
}
