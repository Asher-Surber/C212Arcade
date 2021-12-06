package edu.iu.c212.models;

public enum Item {

    TSHIRT("T-Shirt", 30.00), POSTER("Poster", 15.00), CANDYBAR("Large Candy Bar", 3.0),
    PHONECASE("Phone Case", 20.00), BRACELET("Bracelet", 7.00),
    PLUSHTOY("Plush Toy", 10.00), BALL("Ball", 5.00), STRINGBAG("Drawstring Bag", 12.00),
    FIGURINE("Figurine", 8.00), HAT("Hat", 15.00);

    public String getReadableName() {
        return readableName;
    }

    public void setReadableName(String readableName) {
        this.readableName = readableName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private String readableName;
    private double value;

    Item(String readableName, double value){
        this.readableName = readableName;
        this.value = value;
    }

    @Override
    public String toString(){
        return readableName + ": $" + value;
    }
}
