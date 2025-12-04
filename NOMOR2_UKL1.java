import java.util.Scanner;

public class NOMOR2_UKL1 {
  public static void main(String[] args) {

    try (Scanner input = new Scanner(System.in)) {
      /*
       * Buat program yang dapat menentukan banyaknya uang pecahan yang dibutuhkan,
       * urut dari
       * pecahan terbesar
       * (100000,50000,20000,10000,5000,2000,1000)
       * Input: Jumlah uang dalam rupiah (misal: 189000)
       * Output:
       * 1 Lembar 100000
       * 1 Lembar 50000
       * 1 Lembar 20000
       * 1 Lembar 10000
       * 1 Lembar 5000
       * 2 Lembar 2000
       */
      for (int q = 0; q <= 70; q++) {
        System.out.print("=");
      }
      System.out.println("\n                       HITUNG PECAHAN UANG RUPIAH");
      for (int q = 0; q <= 70; q++) {
        System.out.print("=");
      }
      System.out.println("\nMasukkan jumlah uang (Rupiah): ");
      int uang = input.nextInt();

      int[] pecahan = { 100000, 50000, 20000, 10000, 5000, 2000, 1000 };

      for (int q = 0; q <= 70; q++) {
        System.out.print("=");
      }

      System.out.println("\n\nPECAHAN UANG DARI RP." + uang + " ADALAH:\n");

      for (int p : pecahan) {
        int lembar = uang / p;
        if (lembar > 0)
          uang = uang % p;

        if (lembar > 0) {
          System.out.println("- " + lembar + " Lembar " + p + "\n");

        }
      }
    }
  }
}
