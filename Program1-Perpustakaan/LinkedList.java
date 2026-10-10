// Class LinkedList: Single Linked List untuk menyimpan daftar buku perpustakaan
public class LinkedList {
    private Node head;  // node pertama dalam daftar
    private int size;   // jumlah buku dalam daftar

    // Konstruktor: membuat daftar kosong
    public LinkedList() {
        head = null;
        size = 0;
    }

    // Mengecek apakah daftar kosong
    public boolean isEmpty() {
        return head == null;
    }

    // Mengembalikan jumlah buku dalam daftar
    public int getSize() {
        return size;
    }

    // Push: menambahkan buku baru di AKHIR daftar
    public void push(String kodeBuku, String judul, String penulis) {
        Node newNode = new Node(kodeBuku, judul, penulis);
        if (head == null) {
            head = newNode;                 // daftar kosong: node baru menjadi head
        } else {
            Node current = head;
            while (current.next != null) {  // telusuri sampai node terakhir
                current = current.next;
            }
            current.next = newNode;         // node terakhir menunjuk ke node baru
        }
        size++;
    }

    // Pop: menghapus buku TERAKHIR dari daftar
    // Mengembalikan node yang dihapus, atau null jika daftar kosong
    public Node pop() {
        if (head == null) {
            return null;                    // tidak ada data untuk dihapus
        }
        Node removed;
        if (head.next == null) {            // hanya ada satu node
            removed = head;
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) { // berhenti di node sebelum terakhir
                current = current.next;
            }
            removed = current.next;         // simpan node terakhir
            current.next = null;            // putuskan node terakhir dari daftar
        }
        size--;
        return removed;
    }

    // Search: mencari buku berdasarkan kode buku
    // Mengembalikan node yang ditemukan, atau null jika tidak ada
    public Node search(String kodeBuku) {
        Node current = head;
        while (current != null) {
            if (current.kodeBuku.equals(kodeBuku)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Display: menampilkan seluruh buku sesuai urutan input + total buku
    public void display() {
        System.out.println("Daftar Buku:");
        if (head == null) {
            System.out.println("(Belum ada data buku)");
        }
        Node current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
        System.out.println("Total Buku: " + size);
    }
}
