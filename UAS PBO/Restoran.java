import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Restoran {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Collection Framework
        ArrayList<Menu> daftarMenu = new ArrayList<>();
        ArrayList<Order> daftarOrder = new ArrayList<>();

        // Tambah menu
        daftarMenu.add(new Menu("Nasi Goreng", 15000));
        daftarMenu.add(new Menu("Mie Ayam", 12000));
        daftarMenu.add(new Menu("Ayam Geprek", 18000));
        daftarMenu.add(new Menu("Es Teh", 5000));

        System.out.println("===== SISTEM RESTORAN =====");

        // Input customer
        System.out.print("Nama Customer : ");
        String nama = input.nextLine();

        System.out.print("No Meja       : ");
        String meja = input.nextLine();

        Customer customer = new Customer(nama, meja);

        char lagi;

        do {

            System.out.println("\n===== MENU =====");

            for (int i = 0; i < daftarMenu.size(); i++) {
                System.out.print((i + 1) + ". ");
                daftarMenu.get(i).tampilMenu();
            }

            try {

                System.out.print("Pilih Menu : ");
                int pilih = input.nextInt();

                if (pilih < 1 || pilih > daftarMenu.size()) {
                    throw new Exception("Menu tidak tersedia!");
                }

                System.out.print("Jumlah Pesan : ");
                int jumlah = input.nextInt();

                if (jumlah <= 0) {
                    throw new Exception("Jumlah harus lebih dari 0!");
                }

                Menu menuDipilih = daftarMenu.get(pilih - 1);

                Order order = new Order(menuDipilih, jumlah);

                daftarOrder.add(order);

                System.out.println("Pesanan berhasil ditambahkan!");

            }

            // Exception Handling
            catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
            }

            catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }

            System.out.print("Tambah pesanan lagi? (y/n) : ");
            lagi = input.next().charAt(0);

        } while (lagi == 'y' || lagi == 'Y');

        // Tampilkan Struk
        System.out.println("\n===== STRUK PEMESANAN =====");

        customer.displayInfo();

        System.out.println("\nPesanan : ");

        int total = 0;

        for (Order order : daftarOrder) {
            order.displayOrder();
            total += order.getSubtotal();
        }

        System.out.println("----------------------------");
        System.out.println("Total Bayar = Rp" + total);

        // Pembayaran
        System.out.print("\nMasukkan uang bayar : Rp");
        int uangBayar = input.nextInt();

        // Polymorphism
        Payment pembayaran = new CashPayment(total, uangBayar);

        pembayaran.prosesPembayaran();

        System.out.println("\nTerima kasih telah datang!");

        input.close();
    }
}