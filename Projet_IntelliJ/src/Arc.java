public class Arc {
    private String dest;
    private double cout;

    public Arc(String dest, double cout) {
        this.dest = dest;
        if (cout < 0) {
            this.cout = cout;
        }
    }

    public String getDest() {
        return dest;
    }

    public double getCout() {
        return cout;
    }
}
