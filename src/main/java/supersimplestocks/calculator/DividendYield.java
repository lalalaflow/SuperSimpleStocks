package supersimplestocks.calculator;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by yarbong on 19/04/2016.
 */
public class DividendYield {


    /**
     * Dividend Yield for Common Trade Type
     * @param lastDividend
     * @param price
     * @return
     */
    public BigDecimal calculate(BigDecimal lastDividend, BigDecimal price) {

        return lastDividend.divide(price, MathContext.DECIMAL32);
    }

    /**
     * Dividend Yield for Preferred Trade Type
     * @param fixedDividend
     * @param price
     * @param parValue
     * @return
     */
    public BigDecimal calculate(BigDecimal fixedDividend, BigDecimal price, BigDecimal parValue) {
        return fixedDividend.multiply(parValue).divide(price, MathContext.DECIMAL32);
    }

}
