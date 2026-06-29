class Menu {
    // Encapsulation
    private String namaMenu;
    private int harga;

    public Menu(String namaMenu, int harga) {
        this.namaMenu = namaMenu;
        this.harga = harga;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public int getHarga() {
        return harga;
    }

    public void tampilMenu() {
        System.out.println(namaMenu + " - Rp" + harga);
    }
}