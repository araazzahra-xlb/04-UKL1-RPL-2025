import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NOMOR7_UKL1 {

    static class Cookie {
        String nama;
        long hargaProduksi;
        long hargaJual;
        int jumlahTerjual;

        Cookie(String nama, long hargaProduksi, long hargaJual, int jumlahTerjual) {
            this.nama = nama;
            this.hargaProduksi = hargaProduksi;
            this.hargaJual = hargaJual;
            this.jumlahTerjual = jumlahTerjual;
        }

        long totalBiaya() {
            return hargaProduksi * (long) jumlahTerjual;
        }

        long totalPendapatan() {
            return hargaJual * (long) jumlahTerjual;
        }

        long labaRugi() {
            return totalPendapatan() - totalBiaya();
        }

        String status() {
            long lr = labaRugi();
            if (lr > 0)
                return "Laba";
            if (lr < 0)
                return "Rugi";
            return "Impas";
        }
    }

    // Format angka ke Rp dengan pemisah
    static String formatRp(long x) {
        return "Rp" + String.format("%,d", x).replace(',', '.'); // format Indonesia
    }

    public static void main(String[] args) {

        for (int o = 0; o <= 70; o++) {
            System.out.print("=");
        }
        System.out.println("\n                      ANALISIS LABA DAN RUGI PENJUALAN");
        for (int o = 0; o <= 70; o++) {
            System.out.print("=");
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\nMasukkan jumlah jenis cookies: ");
        int n;
        // validasi input jumlah
        while (true) {
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine(); // buang newline
                if (n > 0)
                    break;
                System.out.print("Masukkan angka > 0: ");
            } else {
                sc.nextLine();
                System.out.print("Input tidak valid. Masukkan angka: ");
            }
        }

        List<Cookie> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nCookies ke-" + i + ":");

            System.out.print("Nama cookies: ");
            String nama = sc.nextLine().trim();
            while (nama.isEmpty()) {
                System.out.print("Nama tidak boleh kosong. Masukkan lagi: ");
                nama = sc.nextLine().trim();
            }

            System.out.print("Harga produksi per bungkus: ");
            long hp;
            while (true) {
                if (sc.hasNextLong()) {
                    hp = sc.nextLong();
                    sc.nextLine();
                    if (hp >= 0)
                        break;
                    System.out.print("Harga tidak boleh negatif. Masukkan lagi: ");
                } else {
                    sc.nextLine();
                    System.out.print("Input tidak valid. Masukkan angka untuk harga produksi: ");
                }
            }

            System.out.print("Harga jual per bungkus: ");
            long hj;
            while (true) {
                if (sc.hasNextLong()) {
                    hj = sc.nextLong();
                    sc.nextLine();
                    if (hj >= 0)
                        break;
                    System.out.print("Harga tidak boleh negatif. Masukkan lagi: ");
                } else {
                    sc.nextLine();
                    System.out.print("Input tidak valid. Masukkan angka untuk harga jual: ");
                }
            }

            System.out.print("Jumlah terjual: ");
            int jt;
            while (true) {
                if (sc.hasNextInt()) {
                    jt = sc.nextInt();
                    sc.nextLine();
                    if (jt >= 0)
                        break;
                    System.out.print("Jumlah tidak boleh negatif. Masukkan lagi: ");
                } else {
                    sc.nextLine();
                    System.out.print("Input tidak valid. Masukkan angka untuk jumlah terjual: ");
                }
            }

            list.add(new Cookie(nama, hp, hj, jt));
        }

        // Hitung total keseluruhan dan cari laba terbesar
        long totalKeseluruhan = 0;
        long maxLaba = Long.MIN_VALUE;
        Cookie cookieMax = null;

        for (Cookie c : list) {
            long lr = c.labaRugi();
            totalKeseluruhan += lr;
            if (lr > maxLaba) {
                maxLaba = lr;
                cookieMax = c;
            }
        }

        // Tampilkan tabel hasil
        System.out.println("\n------------------------------------------------------------------------------------");
        System.out.printf("%-20s | %-14s | %-16s | %-12s | %-6s\n",
                "Nama Cookies", "Total Biaya", "Total Pendapatan", "Laba/Rugi", "Status");
        System.out.println("------------------------------------------------------------------------------------");
        for (Cookie c : list) {
            System.out.printf("%-20s | %-14s | %-16s | %-12s | %-6s\n",
                    truncate(c.nama, 20),
                    formatRp(c.totalBiaya()),
                    formatRp(c.totalPendapatan()),
                    (c.labaRugi() >= 0 ? " " + formatRp(c.labaRugi()) : "-" + formatRp(Math.abs(c.labaRugi()))),
                    c.status());
        }

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Total Laba/Rugi Keseluruhan: "
                + (totalKeseluruhan >= 0 ? formatRp(totalKeseluruhan) : "-" + formatRp(Math.abs(totalKeseluruhan))));

        if (cookieMax != null) {
            System.out.println("Cookies dengan Laba Tertinggi: " + cookieMax.nama + " (" +
                    (cookieMax.labaRugi() >= 0 ? formatRp(cookieMax.labaRugi())
                            : "-" + formatRp(Math.abs(cookieMax.labaRugi())))
                    + ")");
        } else {
            System.out.println("Tidak ada data cookies.");
        }

        sc.close();
    }

    // helper supaya nama panjang tidak merusak tampilan tabel
    private static String truncate(String s, int max) {
        if (s.length() <= max)
            return s;
        return s.substring(0, max - 3) + "...";
    }
}
