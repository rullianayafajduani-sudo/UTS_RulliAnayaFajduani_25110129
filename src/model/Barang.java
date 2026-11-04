package model;

public class Barang {
    // Atribut private sesuai soal (Tugas 3)
    private String kodeBarang;
    private String namaBarang;
    private String kategori;
    private int stok;

    // Constructor dengan parameter
    public Barang(String kodeBarang, String namaBarang, String kategori, int stok) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.kategori = kategori;
        this.stok = stok;
    }

    // Constructor kosong
    public Barang() {}

    // Getter dan Setter (Tugas 3)
    public String getKodeBarang() { return kodeBarang; }
    public void setKodeBarang(String kodeBarang) { this.kodeBarang = kodeBarang; }

    public String getNamaBarang() { return namaBarang; }
    public void setNamaBarang(String namaBarang) { this.namaBarang = namaBarang; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }
}