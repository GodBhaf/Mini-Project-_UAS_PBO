class Customer extends Person {
    private String noMeja;

    public Customer(String nama, String noMeja) {
        super(nama);
        this.noMeja = noMeja;
    }

    public String getNama() {
        return nama;
    }

    public String getNoMeja() {
        return noMeja;
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama Customer : " + nama);
        System.out.println("No Meja       : " + noMeja);
    }
}