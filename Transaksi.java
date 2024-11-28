public class Transaksi extends Produk { //inheritance
    private String noFaktur; // Nomor faktur transaksi
    private int jumlahBeli;  // Jumlah barang yang dibeli
    private int total;    // Total harga transaksi

    // Konstruktor
    public Transaksi(String kodeBarang, String namaBarang, int hargaBarang, String noFaktur, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang); // Memanggil konstruktor superclass (Produk)
        if (noFaktur == null || noFaktur.isEmpty()) {
            throw new IllegalArgumentException("No Faktur tidak boleh kosong"); //Exception Handling
        }
        if (jumlahBeli <= 0) {
            throw new IllegalArgumentException("Jumlah beli harus lebih besar dari 0"); //Exception Handling
        }
        this.noFaktur = noFaktur;
        this.jumlahBeli = jumlahBeli;
        this.total = 0; // Inisialisasi total awal
    }

    // Metode untuk menghitung total transaksi
    public void hitungTotal() {
        this.total = jumlahBeli * getHargaBarang(); // Menggunakan getter dari superclass
    }

    // Getter untuk nomor faktur
    public String getNoFaktur() {
        return noFaktur;
    }

    // Getter untuk jumlah beli
    public int getJumlahBeli() {
        return jumlahBeli;
    }

    // Getter untuk total transaksi
    public int getTotal() {
        return total;
    }

    // Metode untuk menampilkan invoice transaksi
    public String displayInvoice() {
        return "No Faktur: " + noFaktur + "\n"
                + super.toString() + "\n" // Memanggil metode toString() dari kelas Produk
                + "Jumlah Beli: " + jumlahBeli + " buah\n"
                + "Total: Rp." + total;
    }
}
