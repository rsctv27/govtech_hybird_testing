package web.data;

public class Buyer {
    private static String productName;
    private static String productDescription;
    private static String productPrice;
    private static String firstName;
    private static String lastName;
    private static String postalCode;

    public static String getProductName() {
        return productName;
    }

    public static void setProductName(String productName) {
        Buyer.productName = productName;
    }

    public static String getProductDescription() {
        return productDescription;
    }

    public static void setProductDescription(String productDescription) {
        Buyer.productDescription = productDescription;
    }

    public static String getProductPrice() {
        return productPrice;
    }

    public static void setProductPrice(String productPrice) {
        Buyer.productPrice = productPrice;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        Buyer.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        Buyer.lastName = lastName;
    }

    public static String getPostalCode() {
        return postalCode;
    }

    public static void setPostalCode(String postalCode) {
        Buyer.postalCode = postalCode;
    }
}
