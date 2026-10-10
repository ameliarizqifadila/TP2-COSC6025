// Class Node: menyimpan satu data buku dan referensi ke node berikutnya
public class Node {
    String kodeBuku;   // kode buku (maksimal 5 karakter)
    String judul;      // judul buku
    String penulis;    // nama penulis buku
    Node next;         // pointer ke node berikutnya (null jika node terakhir)

    // Konstruktor: membuat node baru berisi data buku
    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }

    // Mengembalikan data buku dalam satu baris
    @Override
    public String toString() {
        return "Kode: " + kodeBuku + " | Judul: " + judul + " | Penulis: " + penulis;
    }
}
