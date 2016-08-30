package coding.interview.supersimplestocks.calculator;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by yarbong on 19/04/2016.
 */
public class PERatio {

    public BigDecimal calculate(BigDecimal lastDividend, BigDecimal price) {
        return lastDividend.divide(price, MathContext.DECIMAL32);
    }
}
