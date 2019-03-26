import java.math.BigDecimal;

public class BigDecimalTests {

    public static void main (String[] args) {

        float v1 = 1.20f;
        float v2 = 1.05f;

        BigDecimal literal = new BigDecimal(String.valueOf(v1)).subtract(new BigDecimal(String.valueOf(v2)));
        BigDecimal number = new BigDecimal(v1).subtract(new BigDecimal(v2));

        if (literal.compareTo(number) != 0) {
            System.out.println("$" + number);
            System.out.println("#" + literal);
        }

    }

}
