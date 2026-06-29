class CashPayment extends Payment {

    private int uangBayar;

    public CashPayment(int totalBayar, int uangBayar) {
        super(totalBayar);
        this.uangBayar = uangBayar;
    }

    // Polymorphism (Override)
    @Override
    public void prosesPembayaran() {

        int kembalian = uangBayar - totalBayar;

        System.out.println("\n===== PEMBAYARAN =====");
        System.out.println("Total Bayar : Rp" + totalBayar);
        System.out.println("Uang Bayar  : Rp" + uangBayar);
        System.out.println("Kembalian   : Rp" + kembalian);
    }
}