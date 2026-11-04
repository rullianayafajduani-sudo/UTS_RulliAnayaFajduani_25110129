package dao;

import UTS_Inventori_25110129.Koneksi;
import model.Barang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangDAO {

    // 1. Simpan Data (Insert) menggunakan PreparedStatement (Tugas 5)
    public boolean insertData(Barang b) {
        String sql = "INSERT INTO barang (kode_barang, nama_barang, kategori, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getKodeBarang());
            ps.setString(2, b.getNamaBarang());
            ps.setString(3, b.getKategori());
            ps.setInt(4, b.getStok());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // 2. Ubah Data (Update) berdasarkan kode_barang (Tugas 7)
    public boolean updateData(Barang b) {
        String sql = "UPDATE barang SET nama_barang = ?, kategori = ?, stok = ? WHERE kode_barang = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getNamaBarang());
            ps.setString(2, b.getKategori());
            ps.setInt(3, b.getStok());
            ps.setString(4, b.getKodeBarang());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // 3. Hapus Data (Delete) berdasarkan kode_barang (Tugas 7)
    public boolean deleteData(String kodeBarang) {
        String sql = "DELETE FROM barang WHERE kode_barang = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kodeBarang);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // 4. Ambil Semua Data untuk ditampilkan di JTable (Tugas 6)
    public List<Barang> getAllBarang() {
        List<Barang> list = new ArrayList<>();
        String sql = "SELECT * FROM barang";
        try (Connection conn = Koneksi.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Barang b = new Barang();
                b.setKodeBarang(rs.getString("kode_barang"));
                b.setNamaBarang(rs.getString("nama_barang"));
                b.setKategori(rs.getString("kategori"));
                b.setStok(rs.getInt("stok"));
                list.add(b);
            }
        } catch (SQLException e) {
        }
        return list;
    }
}