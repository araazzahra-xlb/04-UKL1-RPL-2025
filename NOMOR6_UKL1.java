import java.util.Scanner;

public class NOMOR6_UKL1 {

    public static void main(String[] args) {

        /*
         * PEMINJAMAN BUKU
         * 1. Input nama, judul, kategori, hari
         * 2. Program menentukan tarif berdasarkan kategori (if/else)
         * 3. Program menghitung biaya awal (tarif x hari)
         * 4. Cek pinjam > 10 hari? (Kalau iya: denda 500 di hari ke =>7)
         * 5. Program hitung total biaya
         * 6. Program menampilan semua (scr lengkap)
         * - Nama
         * - Judul
         * - Kategori
         * - Lama pinjam
         * - Biaya awal
         * - Denda
         * - Total biaya
         */
        // 1.) Persiapan Alat
        Scanner Input = new Scanner(System.in);

        for (int q = 0; q <= 70; q++) {
            System.out.print("=");
        }
        System.out.println("\n                       PEMINJAMAN PERPUSTAKAAN");
        for (int q = 0; q <= 70; q++) {
            System.out.print("=");
        }

        // 2.) Input data
        System.out.print("\nMasukkan nama peminjam            : ");
        String nama = Input.next();

        System.out.print("Masukkan Judul Buku               : ");
        String judul = Input.next();

        System.out.print("Masukkan Kategori(A/B/C)          : ");
        String kategori = Input.next();

        System.out.print("Masukkan Durasi Peminjaman (Hari) : ");
        int hari = Input.nextInt();

        // 3.) Penentuan Harga Kategori
        int tarifPerHari = 0;

        if (kategori.equals("A")) {
            tarifPerHari = 2000;
        } else if (kategori.equals("B")) {
            tarifPerHari = 1500;
        } else if (kategori.equals("C")) {
            tarifPerHari = 1000;
        } else {
            System.out.println("Kateori tidak valid");
            return;
        }

        // 4.) Hitung Biaya Dasar
        int BiayaAwal = tarifPerHari * hari;

        // 5.) Denda Keterlambatan
        int denda = 0;
        if (hari > 7) {
            int hariTerlambat = hari - 7;
            denda = hariTerlambat * 500;
        }

        // 6.) Biaya Akhir
        int TotalBiaya = BiayaAwal + denda;

        for (int q = 0; q <= 70; q++) {
            System.out.print("=");
        }

        // 7.) Output Hasil
        System.out.println("\n ===== DETAIL PEMINJAMAN ===");
        System.out.println("Nama Peminjam          : " + nama);
        System.out.println("Judul buku             : " + judul);
        System.out.println("Kategori buku          : " + kategori);
        System.out.println("Lama Peminjaman        : " + hari + " hari");
        System.out.println("Biaya Peminjaman awal  : Rp. " + BiayaAwal);
        System.out.println("Denda Keterlambatan    : Rp. " + denda);
        System.out.println("Total biaya akhir      : Rp. " + TotalBiaya);

        Input.close();

    }
}