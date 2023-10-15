public class Amount {
    private int cents;
    private String amount;
    private boolean isNegative;

    public Amount(int cents, boolean isNegative) throws IllegalArgumentException {
        if (cents < 1000000 && cents >= 0) {
            this.cents = cents;
            this.isNegative = isNegative;
            this.amount = formAmount(cents, isNegative);
        } else {
            throw new IllegalArgumentException("Amount exceeds it's limitations");
        }
    }

    public void add(int cents) {
        if (cents < 1000000) {
            this.cents += cents;
            this.amount = this.cents < 0
                ? formAmount(Math.abs(this.cents), true)
                : formAmount(Math.abs(this.cents), false);
        } else {
            throw new IllegalArgumentException("Amount exceeds it's limitations");
        }
    }

    public String formAmount(int cents, boolean isNegative) {
        String centsStr = Integer.toString(cents);

        if (cents == 0) {
            return "0.00";
        }
        else if (cents < 10) {
            return isNegative
                ? "-0.0" + centsStr
                : "0.0" + centsStr;

        } else if (cents < 100) {
            return isNegative
                ? "-0." + centsStr
                : "0." + centsStr;

        } else {
            double euros = cents / 100.0;
            String eurosStr = String.format("%.2f", euros);
            return isNegative
                ? "-" + eurosStr.replace(",", ".")
                : eurosStr.replace(",", ".");
        }
    }

    public int getCents() {
        return this.cents;
    }

    public String getAmount() {
        return this.amount;
    }
}
