package enums;

public enum MessageSubject {

    CUSTOMER_SERVICE("Customer Service"), WEBMASTER(  "Webmaster");

    private String value;

    MessageSubject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
