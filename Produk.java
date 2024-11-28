public class Produk {
    private String kodeBarang;
    private String namaBarang;
    private int hargaBarang; 
    // Konstruktor
    public Produk(String kodeBarang, String namaBarang, int hargaBarang2) { 
        if (kodeBarang == null || kodeBarang.isEmpty()) {
            throw new IllegalArgumentException("Kode barang tidak boleh kosong"); // Exception Handling
        }
        if (namaBarang == null || namaBarang.isEmpty()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong"); // Exception Handling
        }
        if (hargaBarang2 <= 0) {
            throw new IllegalArgumentException("Harga barang harus lebih besar dari 0"); // Exception Handling
        }
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = (int) hargaBarang2;
    }
    // Getter dan Setter
    public String getKodeBarang() {
        return kodeBarang;
    }
    public String getNamaBarang() {
        return namaBarang;
    }
    public int getHargaBarang() { 
        return hargaBarang;
    }
    @Override
    public String toString() {
        return "Kode: " + kodeBarang + "\nNama Barang: " + namaBarang + "\nHarga: Rp." + hargaBarang; 
    }
}
