class Order {
    private Menu menu;
    private int jumlah;

    public Order(Menu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getSubtotal() {
        return menu.getHarga() * jumlah;
    }

    public void displayOrder() {
        System.out.println(
            menu.getNamaMenu() +
            " x" + jumlah +
            " = Rp" + getSubtotal()
        );
    }
}