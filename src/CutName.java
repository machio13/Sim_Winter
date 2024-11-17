package NewSimSummer;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class CutName {

    abstract int cutNum();

    public String isBigDecimalFormat(BigDecimal sharesIssued) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(sharesIssued);
    }

    public String isLongFormat(long quantity) {
        BigDecimal updateQuantity = new BigDecimal(quantity);
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(updateQuantity);
    }

    public String isUnitPriceFormat(BigDecimal unitPrice) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        return decimalFormat.format(unitPrice);
    }

    public String isCutName (String name) {
        if (name.length() > cutNum()) {
            return (name.substring(0, cutNum() - 3) + "...");
        }else {
            return name;
        }
    }

}
