// Class Node: menyimpan data satu pelanggan (kode, nama, total) dan pointer ke node berikutnya
public class Node {
    String kode;   // nomor antrian pelanggan
    String nama;   // nama pelanggan
    long total;    // total belanja pelanggan
    Node next;     // pointer ke node berikutnya

    // Konstruktor: membuat node baru berisi data pelanggan
    public Node(String kode, String nama, long total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }

    // Mengembalikan data pelanggan dalam satu baris
    @Override
    public String toString() {
        return "No. Antrian: " + kode + " | Nama: " + nama + " | Total Belanja: " + total;
    }
}
