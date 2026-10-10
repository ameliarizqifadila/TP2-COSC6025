// Class Queue: antrian pelanggan berbasis linked list (FIFO)
public class Queue {
    private Node front;  // pelanggan paling depan (dilayani lebih dulu)
    private Node rear;   // pelanggan paling belakang (yang terakhir masuk)
    private int size;    // jumlah pelanggan dalam antrian

    // Konstruktor: membuat antrian kosong
    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Mengecek apakah antrian kosong
    public boolean isEmpty() {
        return front == null;
    }

    // Mengembalikan jumlah pelanggan dalam antrian
    public int getSize() {
        return size;
    }

    // Enqueue: menambahkan pelanggan di bagian belakang (rear)
    public void enqueue(String kode, String nama, long total) {
        Node newNode = new Node(kode, nama, total);
        if (rear == null) {          // antrian kosong
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;     // sambungkan di belakang rear lama
            rear = newNode;          // node baru menjadi rear
        }
        size++;
    }

    // Dequeue: mengeluarkan pelanggan paling depan (front)
    // Mengembalikan node pelanggan, atau null jika antrian kosong
    public Node dequeue() {
        if (front == null) {
            return null;
        }
        Node dilayani = front;
        front = front.next;          // front bergeser ke pelanggan berikutnya
        if (front == null) {         // antrian menjadi kosong
            rear = null;
        }
        dilayani.next = null;        // lepaskan node dari antrian
        size--;
        return dilayani;
    }

    // Display: menampilkan antrian dari depan (front) ke belakang (rear)
    public void display() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Antrian Saat Ini (depan ke belakang):");
        Node current = front;
        int urutan = 1;
        while (current != null) {
            System.out.println(urutan + ". " + current);
            current = current.next;
            urutan++;
        }
        System.out.println("Jumlah pelanggan dalam antrian: " + size);
    }
}
