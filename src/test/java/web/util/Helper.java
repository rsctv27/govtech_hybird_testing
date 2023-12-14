package web.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

public class Helper {
    public static BigDecimal parse(final String amount, final Locale locale) throws ParseException {
        final NumberFormat format = NumberFormat.getNumberInstance(locale);
        if (format instanceof DecimalFormat) {
            ((DecimalFormat) format).setParseBigDecimal(true);
        }
        return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]",""));
    }

    public static <T extends Comparable<? super T>> boolean isSorted(ArrayList<T> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i).compareTo(arrayList.get(i + 1)) < 0) {
                return false; // ArrayList is not sorted
            }
        }
        return true; // ArrayList is sorted
    }
}
