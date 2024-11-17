package SimWinter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Formater {

    public static String isBigDecimalFormat(BigDecimal sharesIssued) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(sharesIssued);
    }

    public static String isLongFormat(long quantity) {
        BigDecimal updateQuantity = new BigDecimal(quantity);
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(updateQuantity);
    }

    public static String isUnitPriceFormat(BigDecimal unitPrice) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        return decimalFormat.format(unitPrice);
    }
}
