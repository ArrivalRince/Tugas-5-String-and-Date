import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login Section
        if (!login(scanner)) {
            System.out.println("Login gagal setelah 3 percobaan. Program keluar.");
            return;
        }

        System.out.println("\nSelamat Datang di Supermarket Budiman");
        System.out.println("Tanggal dan Waktu: " + getCurrentDateTime());

        while (true) {
            try { 
                System.out.println("\n=== Input Data Transaksi ===\n");
                System.out.print("Masukkan No Faktur: ");
                String noFaktur = scanner.nextLine().trim();
                System.out.print("Masukkan Kode Barang: ");
                String kodeBarang = scanner.nextLine().trim();
                System.out.print("Masukkan Nama Barang: ");
                String namaBarang = scanner.nextLine().trim();

                int hargaBarang = 0; 
                while (true) {
                    try { 
                        System.out.print("Masukkan Harga Barang: ");
                        hargaBarang = Integer.parseInt(scanner.nextLine().trim()); 
                        if (hargaBarang <= 0) throw new IllegalArgumentException("Harga barang harus lebih besar dari 0.");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid untuk harga barang.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                int jumlahBeli = 0;
                while (true) {
                    try { 
                        System.out.print("Masukkan Jumlah Beli: ");
                        jumlahBeli = Integer.parseInt(scanner.nextLine().trim());
                        if (jumlahBeli <= 0) throw new IllegalArgumentException("Jumlah beli harus lebih besar dari 0.");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid untuk jumlah beli.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                // Membuat objek Transaksi dan menghitung total
                Transaksi transaksi = new Transaksi(kodeBarang, namaBarang, hargaBarang, noFaktur, jumlahBeli); 
                transaksi.hitungTotal();

                // Menampilkan invoice
                System.out.println("\n--- Faktur Pembelian ---");
                System.out.println(transaksi.displayInvoice());
                System.out.println("Kasir: Arrival");

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }

            System.out.print("\nApakah kamu ingin memasukkan data transaksi lain? (y/n): ");
            if (!konfirmasiUlang(scanner)) {
                System.out.println("Program berhasil diselesaikan. Terima kasih.");
                break;
            }
        }
        scanner.close();
    }

    private static boolean login(Scanner scanner) {//Method untuk melakukan login.
        String username = "Arrival";
        String password = "2311523019";

        for (int i = 0; i < 3; i++) {
            System.out.println("\n=== Log In ===");
            System.out.print("Username: ");
            String inputUser = scanner.nextLine().trim();
            System.out.print("Password: ");
            String inputPass = scanner.nextLine().trim();
            System.out.print("Captcha (ketik '123'): ");
            String captcha = scanner.nextLine().trim();

            if (inputUser.equals(username) && inputPass.equals(password) && captcha.equals("123")) {
                System.out.println("Login berhasil!");
                return true;
            } else {
                System.out.println("Login gagal. Silakan coba lagi.");
            }
        }
        return false;
    }

    private static String getCurrentDateTime() {//String berisi tanggal dan waktu saat ini.
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); //method date
        Date date = new Date();
        return formatter.format(date);
    }

    private static boolean konfirmasiUlang(Scanner scanner) {//Method untuk konfirmasi ulang
        while (true) {
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("y")) {
                return true;
            } else if (response.equals("n")) {
                return false;
            } else {
                System.out.print("Input tidak valid. Masukkan 'y' atau 'n': ");
            }
        }
    }
}
