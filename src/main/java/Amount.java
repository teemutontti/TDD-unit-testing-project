package main.java;

public class Amount {
    private int euros;
    private int cents;
    private String wholeAmount;

    public Amount(int euros, int cents) throws IllegalArgumentException {
        if (cents < 100 && cents >= 0 && euros < 10000 && euros >= 0) {
            this.euros = euros;
            this.cents = cents;
            this.wholeAmount = formWholeAmount(euros, cents);
        } else {
            throw new IllegalArgumentException("Amount exceeds it's limitations");
        }
    }

    public String formWholeAmount(int euros, int cents) {
        if (cents < 10) {
            return Integer.toString(euros) + ".0" + Integer.toString(cents) + " €";
        } else {
            return Integer.toString(euros) + "." + Integer.toString(cents) + " €";
        }
    }

    public int getEuros() {
        return this.euros;
    }

    public int getCents() {
        return this.cents;
    }
}
