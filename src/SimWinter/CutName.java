package SimWinter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class CutName {

    abstract int cutNum();

    public String isCutName (String name) {
        if (name.length() > cutNum()) {
            return (name.substring(0, cutNum() - 3) + "...");
        }else {
            return name;
        }
    }

}
