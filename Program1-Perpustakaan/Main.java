//Nama        : Amelia Rizqi Fadila
//NIM         : 2902824546

import java.util.Scanner;

// Class Main: program pengelolaan daftar buku perpustakaan (Single Linked List)
public class Main {
    static final int MAKS_KODE = 5;   // panjang maksimal kode buku
    static final int MIN_DATA = 5;    // jumlah minimal data buku

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList daftarBuku = new LinkedList();

        // Menampilkan menu utama
        System.out.println("===== SISTEM DATA BUKU =====");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Hapus Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Lihat Semua Buku");
        System.out.println("5. Keluar");

        boolean jalan = true;
        while (jalan) {
            System.out.print("Pilih menu: ");
            int pilihan = bacaPilihan();

            switch (pilihan) {
                case 1: // Tambah Buku (Push) di akhir daftar
                    System.out.println();
                    String kode = inputKodeBuku();
                    String judul = inputTidakKosong("Masukkan Judul: ", "Judul");
                    String penulis = inputTidakKosong("Masukkan Penulis: ", "Penulis");
                    daftarBuku.push(kode, judul, penulis);
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case 2: // Hapus Buku (Pop) dari akhir daftar
                    Node dihapus = daftarBuku.pop();
                    if (dihapus == null) {
                        System.out.println("Tidak ada data untuk dihapus.");
                    } else {
                        System.out.println("Buku terakhir berhasil dihapus:");
                        System.out.println(dihapus);
                    }
                    break;

                case 3: // Cari Buku berdasarkan kode buku
                    System.out.print("Masukkan Kode Buku yang dicari: ");
                    String kodeCari = sc.nextLine().trim();
                    Node hasil = daftarBuku.search(kodeCari);
                    if (hasil == null) {
                        System.out.println("Buku tidak ditemukan.");
                    } else {
                        System.out.println("Buku ditemukan!");
                        System.out.println("Kode Buku : " + hasil.kodeBuku);
                        System.out.println("Judul     : " + hasil.judul);
                        System.out.println("Penulis   : " + hasil.penulis);
                    }
                    break;

                case 4: // Tampilkan semua buku sesuai urutan input
                    daftarBuku.display();
                    break;

                case 5: // Keluar, dengan validasi jumlah data minimal 5 buku
                    if (daftarBuku.getSize() < MIN_DATA) {
                        System.out.println("Jumlah data minimal " + MIN_DATA + " buku. Saat ini baru "
                                + daftarBuku.getSize() + " buku, silakan tambah data terlebih dahulu.");
                    } else {
                        System.out.println("Terima kasih, program selesai.");
                        jalan = false;
                    }
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Masukkan angka 1-5.");
            }

            if (jalan) {
                System.out.println(); // baris kosong pemisah antar operasi
            }
        }
        sc.close();
    }

    // Membaca pilihan menu; mengembalikan -1 jika input bukan angka
    static int bacaPilihan() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Input kode buku dengan validasi: tidak kosong dan maksimal 5 karakter
    static String inputKodeBuku() {
        while (true) {
            System.out.print("Masukkan Kode Buku: ");
            String kode = sc.nextLine().trim();
            if (kode.isEmpty()) {
                System.out.println("Kode Buku tidak boleh kosong!");
            } else if (kode.length() > MAKS_KODE) {
                System.out.println("Kode Buku maksimal " + MAKS_KODE + " karakter! Silakan input ulang.");
            } else {
                return kode;
            }
        }
    }

    // Input teks yang tidak boleh kosong (judul dan penulis)
    static String inputTidakKosong(String prompt, String namaField) {
        while (true) {
            System.out.print(prompt);
            String teks = sc.nextLine().trim();
            if (!teks.isEmpty()) {
                return teks;
            }
            System.out.println(namaField + " tidak boleh kosong!");
        }
    }
}
