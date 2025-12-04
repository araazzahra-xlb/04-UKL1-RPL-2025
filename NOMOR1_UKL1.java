
import java.util.Scanner;

public class NOMOR1_UKL1 {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            /*
             * Buat program yang meminta pengguna memasukkan sebuah bilangan, kemudian
             * menentukan apakah bilangan tersebut adalah bilangan prima atau bukan.
             */

            /*
             * jika n <= 1 -> bukan prima
             * jika n == 2 -> prima
             * jika n genap (>2) -> bukan prima
             */

            for (int o = 0; o <= 70; o++) {
                System.out.print("=");
            }

            System.out.println("\n                        CEK BILANGAN PRIMA");

            for (int o = 0; o <= 70; o++) {
                System.out.print("=");
            }

            System.out.print("\nMasukkan Bilangan (Bulat): ");
            int n = input.nextInt();

            if (n < 100) {
                System.out.println("Maaf saya tidak bisa menghitung bilangan dibawah 100");
                return;
            } else if (n > 500) {
                System.out.println("Maaf saya tidak bisa menghitung bilangan diatas 500");
                return;
            }
            System.out.println("=========================");

            boolean prima = true;

            if (n <= 1) {
                prima = false;
            } else if (n == 2) {
                prima = true;
            } else if (n % 2 == 0) {
                prima = false;
            } else {

                int limit = (int) Math.sqrt(n);
                for (int i = 3; i <= limit; i += 2) { // karena bilangan prima kurang dari akar bilangan itu
                    if (n % i == 0) {
                        prima = false;
                        break; // supaya kalau sudah tau ada yg salah, stop.
                    }
                }
            }

            if (prima) {
                System.out.println(n + " adalah bilangan prima :) \n");
            } else {
                System.out.println(n + " bukan bilangan prima :( \n");
            }
        }

    }
}

/*
 * while (n > 50) {
 * System.out.println("Maaf, saya hanya bisa mendeteksi bilangan kurang dari 50"
 * );
 * 
 * n = input.nextInt();
 * }
 */
