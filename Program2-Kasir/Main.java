//Nama        : Amelia Rizqi Fadila
//NIM         : 2902824546

import java.util.Scanner;

// Class Main: program sistem kasir toko menggunakan Queue (antrian) dan Stack (riwayat)
public class Main {
    static final int MIN_PELANGGAN = 5;   // jumlah minimal pelanggan dalam antrian

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Queue antrian = new Queue();      // antrian pelanggan (FIFO)
        Stack riwayat = new Stack();      // riwayat transaksi (LIFO)
        int totalPelanggan = 0;           // jumlah pelanggan yang sudah masuk antrian

        // Menampilkan menu utama
        System.out.println("=== SISTEM KASIR TOKO ===");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Layani Pelanggan");
        System.out.println("3. Tampilkan Antrian");
        System.out.println("4. Lihat Riwayat Transaksi");
        System.out.println("5. Keluar");

        boolean jalan = true;
        while (jalan) {
            System.out.print("Pilih menu: ");
            int pilihan = bacaPilihan();

            switch (pilihan) {
                case 1: // Tambah antrian pelanggan (enqueue)
                    System.out.println();
                    String kode = inputTidakKosong("Masukkan Nomor Antrian: ", "Nomor Antrian");
                    String nama = inputTidakKosong("Masukkan Nama Pelanggan: ", "Nama Pelanggan");
                    long total = inputTotalBelanja();
                    antrian.enqueue(kode, nama, total);
                    totalPelanggan++;
                    System.out.println("Data pelanggan ditambahkan ke antrian!");
                    break;

                case 2: // Layani pelanggan: dequeue dari antrian lalu push ke riwayat
                    Node pelanggan = antrian.dequeue();
                    if (pelanggan == null) {
                        System.out.println("Antrian kosong, tidak ada pelanggan yang dilayani.");
                    } else {
                        System.out.println("Melayani pelanggan " + pelanggan.kode + " (" + pelanggan.nama + ")");
                        riwayat.push(pelanggan.kode, pelanggan.nama, pelanggan.total);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;

                case 3: // Tampilkan antrian saat ini
                    antrian.display();
                    break;

                case 4: // Lihat riwayat transaksi dari terbaru ke lama
                    riwayat.display();
                    break;

                case 5: // Keluar, dengan validasi minimal 5 pelanggan dalam antrian
                    if (totalPelanggan < MIN_PELANGGAN) {
                        System.out.println("Minimal " + MIN_PELANGGAN + " pelanggan dalam antrian. Saat ini baru "
                                + totalPelanggan + " pelanggan, silakan tambah antrian terlebih dahulu.");
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

    // Input teks yang tidak boleh kosong (nomor antrian dan nama pelanggan)
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

    // Input total belanja dengan validasi: harus angka bulat lebih dari 0
    static long inputTotalBelanja() {
        while (true) {
            System.out.print("Masukkan Total Belanja: ");
            try {
                long total = Long.parseLong(sc.nextLine().trim());
                if (total > 0) {
                    return total;
                }
            } catch (NumberFormatException e) {
                // input bukan angka, akan diminta ulang
            }
            System.out.println("Total Belanja harus berupa angka lebih dari 0!");
        }
    }
}