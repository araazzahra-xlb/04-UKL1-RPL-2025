import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NOMOR5_UKL1 {

    public static void main(String[] args) {

        /*
         * PERMAINAN LEMPAR DADU
         * 
         * Start ronde
         * → Komputer generate c (1..6)
         * → Tampilkan “tekan Enter”
         * → Pemain tekan Enter → program generate p (1..6)
         * → Simpan c ke listKomputer, p ke listPemain
         * → Tampilkan c dan p
         * → Bandingkan: p>c → pemain menang (playerWins++), c>p → komputer menang
         * (komputerWins++), else seri
         * → Tampilkan skor sementara
         * → Cek: ada yang sudah 5? Jika ya → selesai; jika tidak → next ronde
         */

        // 1.) Persiapan alat
        Scanner input = new Scanner(System.in); // ngebaca input pemain
        Random randm = new Random(); // mengacak angka

        // 2.) variabel Menyimpan riwayat
        ArrayList<Integer> komputerRolls = new ArrayList<>();
        ArrayList<Integer> pemainRolls = new ArrayList<>();

        // 3.) Variabel yg ngatur kemenangan
        int komputerWins = 0; // dimulai dari awal, which is 0
        int pemainWins = 0;
        int ronde = 0;

        // 4.) Output & informasi ke pemain
        for (int o = 0; o <= 70; o++) {
            System.out.print("=");
        }
        System.out.println("\n                     PERMAINAN LEMPAR DADU");

        for (int o = 0; o <= 70; o++) {
            System.out.print("=");
        }

        for (int o = 0; o <= 70; o++) {
            System.out.print("-");
        }

        // 5.) loop - jalan terus sampai salah satu dapat 5 menang
        while (komputerWins < 5 && pemainWins < 5) {
            ronde++;
            System.out.println("\n======== Ronde " + ronde + "========");

            // 5a.) Komputer melempar acak (1-6)
            int c = randm.nextInt(6) + 1; // nextInt(6) -> 0-5, +1 -> 1-6

            // 5b.) perintah pemain menekan enter untuk melempar
            System.out.println("Tekan Enter untuk melempar dadu pemain");
            input.nextLine(); // nunggu pemain tekan enter

            // 5c.) Pemain "melempar (acak 1-6)
            int d = randm.nextInt(6) + 1;

            // 5d.) hasil disimpan (ke riwayat)
            komputerRolls.add(c);
            pemainRolls.add(d);

            // 5e.) Tampilkan nilai dadu di ronde ini
            System.out.println("Nilai dadu komputer: " + c);
            System.out.println("Nilai dadu Pemain  : " + d);

            for (int o = 0; o <= 70; o++) {
                System.out.print("-");
            }

            // 5f.) Tentukan pemenang di ronde ini
            if (d > c) {
                pemainWins++; // tambah satu poin kalo di ronde itu menang
                System.out.println("\nHasil: Pemain MENANG di ronde ini!");
            } else if (c > d) {
                komputerWins++;
                System.out.println("\nHasil: Komputer MENANG di ronde ini");
            } else {
                System.out.println("\nHasil: Keduanya SERI");
            }

            // 5g.) Tampilkan score (Sementara/per ronde)
            System.out.println("Skor sementara -> Pemain: " + pemainWins);
            System.out.println("Skor sementara -> Komputer: " + komputerWins);
        }
        // 6.) Permainan selesai &tentukan pemenang
        System.out.println("======== PERMAINAN SELESAI ========");
        for (int o = 0; o <= 70; o++) {
            System.out.print("=");
        }
        if (pemainWins > komputerWins) {
            System.out.println("\nPemenangnya adalah: Pemain!");
        } else {
            System.out.println("\nPemenangnya adalah: Komputer!");
        }
        for (int o = 0; o <= 70; o++) {
            System.out.print("=");
        }

        input.close();

    }

}
