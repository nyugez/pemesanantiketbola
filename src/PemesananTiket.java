import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas Tiket merepresentasikan sebuah tiket yang dipesan oleh pengguna.
 */
class Tiket {
    private final String namaPemesan;
    private final String jenisTiket;
    private final int jumlahTiket;
    private final double hargaTiket;

    /**
     * Konstruktor untuk membuat objek Tiket.
     *
     * @param namaPemesan Nama pemesan tiket.
     * @param jenisTiket  Jenis tiket (VIP atau Reguler).
     * @param jumlahTiket Jumlah tiket yang dipesan.
     * @param hargaTiket  Harga per tiket.
     */
    public Tiket(String namaPemesan, String jenisTiket, int jumlahTiket, double hargaTiket) {
        this.namaPemesan = namaPemesan;
        this.jenisTiket = jenisTiket;
        this.jumlahTiket = jumlahTiket;
        this.hargaTiket = hargaTiket;
    }

    /**
     * Mengembalikan nama pemesan tiket.
     *
     * @return Nama pemesan.
     */
    public String getNamaPemesan() {
        return namaPemesan;
    }

    /**
     * Mengembalikan jenis tiket yang dipesan.
     *
     * @return Jenis tiket (VIP atau Reguler).
     */
    public String getJenisTiket() {
        return jenisTiket;
    }

    /**
     * Mengembalikan jumlah tiket yang dipesan.
     *
     * @return Jumlah tiket.
     */
    public int getJumlahTiket() {
        return jumlahTiket;
    }

    /**
     * Mengembalikan harga per tiket.
     *
     * @return Harga tiket.
     */
    public double getHargaTiket() {
        return hargaTiket;
    }

    /**
     * Menghitung total harga tiket berdasarkan jumlah tiket dan harga per tiket.
     *
     * @return Total harga tiket.
     */
    public double getTotalHarga() {
        return jumlahTiket * hargaTiket;
    }

    /**
     * Mengembalikan representasi string dari objek Tiket.
     *
     * @return String yang berisi informasi tiket.
     */
    @Override
    public String toString() {
        return "Nama Pemesan: " + namaPemesan +
                "\nJenis Tiket: " + jenisTiket +
                "\nJumlah Tiket: " + jumlahTiket +
                "\nHarga per Tiket: Rp" + hargaTiket +
                "\nTotal Harga: Rp" + getTotalHarga();
    }
}

/**
 * Kelas PemesananTiket berfungsi sebagai sistem pemesanan tiket sepak bola.
 */
public class PemesananTiket {
    private static ArrayList<Tiket> daftarPemesanan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Menambah pesanan tiket baru berdasarkan input pengguna.
     */
    public static void tambahPesanan() {
        System.out.print("Masukkan nama pemesan: ");
        String namaPemesan = scanner.nextLine();

        System.out.print("Masukkan jenis tiket (VIP/Reguler): ");
        String jenisTiket = scanner.nextLine();

        System.out.print("Masukkan jumlah tiket: ");
        int jumlahTiket = scanner.nextInt();

        double hargaTiket;
        if (jenisTiket.equalsIgnoreCase("VIP")) {
            hargaTiket = 500000; // Harga tiket VIP
        } else {
            hargaTiket = 250000; // Harga tiket Reguler
        }

        Tiket tiketBaru = new Tiket(namaPemesan, jenisTiket, jumlahTiket, hargaTiket);
        daftarPemesanan.add(tiketBaru);
        System.out.println("Tiket berhasil dipesan!\n");
        scanner.nextLine(); // Membersihkan buffer
    }

    /**
     * Menampilkan semua pesanan tiket yang ada.
     */
    public static void tampilkanPesanan() {
        if (daftarPemesanan.isEmpty()) {
            System.out.println("Belum ada pemesanan tiket.");
        } else {
            for (int i = 0; i < daftarPemesanan.size(); i++) {
                System.out.println("Pesanan " + (i + 1) + ":");
                System.out.println(daftarPemesanan.get(i));
                System.out.println("-------------------------");
            }
        }
    }

    /**
     * Menghapus pesanan tiket berdasarkan nomor pesanan yang dipilih pengguna.
     */
    public static void hapusPesanan() {
        tampilkanPesanan();
        System.out.print("Masukkan nomor pesanan yang akan dihapus: ");
        int indeks = scanner.nextInt() - 1;

        if (indeks >= 0 && indeks < daftarPemesanan.size()) {
            daftarPemesanan.remove(indeks);
            System.out.println("Pesanan berhasil dihapus.");
        } else {
            System.out.println("Nomor pesanan tidak valid.");
        }
        scanner.nextLine(); // Membersihkan buffer
    }

    /**
     * Menampilkan menu utama sistem pemesanan tiket dan menerima input pilihan
     * pengguna.
     */
    public static void menu() {
        while (true) {
            System.out.println("=== Sistem Pemesanan Tiket Sepak Bola ===");
            System.out.println("1. Tambah Pesanan Tiket");
            System.out.println("2. Tampilkan Semua Pesanan");
            System.out.println("3. Hapus Pesanan");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    tambahPesanan();
                    break;
                case 2:
                    tampilkanPesanan();
                    break;
                case 3:
                    hapusPesanan();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem pemesanan tiket.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    /**
     * Fungsi utama untuk menjalankan program.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        menu();
    }
}