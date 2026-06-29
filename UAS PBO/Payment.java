abstract class Payment {
    protected int totalBayar;

    public Payment(int totalBayar) {
        this.totalBayar = totalBayar;
    }

    // Abstraction
    public abstract void prosesPembayaran();
}