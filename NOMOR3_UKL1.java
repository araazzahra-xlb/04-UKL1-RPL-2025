import java.util.Scanner;
import java.util.Random;

public class NOMOR3_UKL1 {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    Random acak = new Random();

    /*
     * Buat program kuis perkalian, pembagian dan modulus dengan ketentuan sebagai
     * berikut:
     * a. Ketika dijalankan akan muncul 3 bagian sebagai berikut :
     * [bilangan pertama] [operator] [bilangan kedua] =
     * b. 3 bagian ini akan muncul secara acak
     * c. Kemudian user akan menjawab pertanyaan tersebut
     * d. Hasilnya akan otomatis keluar setelah user menjawab pertanyaan tersebut
     * e. Program akan berhenti memberikan kuis apabila user ingin menghentikan
     * kuis.
     */
    for (int o = 0; o <= 70; o++) {
      System.out.print("=");
    }

    System.out.println("\n                       PERHATIKAN SOAL BERIKUT!");

    for (int o = 0; o <= 70; o++) {
      System.out.print("=");
    }

    int nomorSoal = 1;

    while (true) { // loop sampai user bilang stop

      int a = acak.nextInt(10) + 1; // angka 1 dari 1-10
      int b = acak.nextInt(10) + 1; // angka 2 dari 1-10
      int op = acak.nextInt(3); // bagian operasi

      int HasilBenar = 0;
      String operator = "";

      if (op == 0) { // perkalian
        operator = " x ";
        HasilBenar = a * b;
      } else if (op == 1) { // pembagian
        operator = " / ";
        b = acak.nextInt(9) + 1; // b : 1..9
        HasilBenar = acak.nextInt(10) + 1; // hasil : 1..10
        a = HasilBenar * b; // a dibuat supaya pembagian exact
      } else { // modulus
        operator = " % ";
        HasilBenar = a % b;
      }

      // Tampilin Soal
      System.out.print("\n" + nomorSoal + ". " + a + operator + b + " = ");
      int jawaban = input.nextInt();
      nomorSoal++; // biar nomornya urut

      for (int o = 0; o <= 70; o++) {
        System.out.print("-");
      }

      if (jawaban == HasilBenar) {
        System.out.println("\n\nYay, jawaban kamu benar!" + "\n");
      } else {
        System.out.println("\n\nMaaf, jawaban kamu belum tepat!");
        System.out.println("Jawaban yang benar adalah: " + HasilBenar + "\n");
      }

      for (int o = 0; o <= 70; o++) {
        System.out.print("-");
      }

      System.out.print("\n\nLanjut kuis ga? (no/yes): ");
      input.nextLine();
      String lagi = input.nextLine();

      System.out.println();
      for (int o = 0; o <= 70; o++) {
        System.out.print("=");
      }

      System.out.println();

      if (lagi.equalsIgnoreCase("no")) {
        break;
      }
    }

    input.close();

  }
}