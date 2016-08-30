package supersimplestocks.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/**
 * Created by yarbong on 19/04/2016.
 */
public class GeometricMean {
    public BigDecimal calculate(List<BigDecimal> priceList) {
        BigDecimal geometricMean = BigDecimal.ONE;
        for (BigDecimal price:priceList) {
            geometricMean = geometricMean.multiply(price, MathContext.DECIMAL32);
        }

        //nth square root (Fractional powered value)
        BigDecimal n = new BigDecimal(priceList.size());
        geometricMean =new BigDecimal(Math.pow(geometricMean.doubleValue(), BigDecimal.ONE.divide(n,MathContext.DECIMAL32).doubleValue())
                ,MathContext.DECIMAL32);
        return geometricMean;
    }

}
