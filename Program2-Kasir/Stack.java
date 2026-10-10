// Class Stack: riwayat transaksi berbasis linked list (LIFO)
public class Stack {
    private Node top;   // transaksi paling atas (terbaru)
    private int size;   // jumlah transaksi dalam riwayat

    // Konstruktor: membuat stack kosong
    public Stack() {
        top = null;
        size = 0;
    }

    // Mengecek apakah stack kosong
    public boolean isEmpty() {
        return top == null;
    }

    // Push: menyimpan transaksi baru di posisi paling atas (top)
    public void push(String kode, String nama, long total) {
        Node newNode = new Node(kode, nama, total);
        newNode.next = top;   // node baru menunjuk ke top lama
        top = newNode;        // node baru menjadi top
        size++;
    }

    // Display: menampilkan riwayat dari transaksi terbaru (top) ke terlama
    public void display() {
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Riwayat Transaksi (terbaru ke lama):");
        Node current = top;
        int urutan = 1;
        while (current != null) {
            System.out.println(urutan + ". " + current);
            current = current.next;
            urutan++;
        }
        System.out.println("Jumlah transaksi: " + size);
    }
}
