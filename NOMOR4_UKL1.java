import java.util.Scanner;

public class NOMOR4_UKL1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /*
         * Buat program Java yang mengecek apakah ada elemen duplikat dalam array.
         * Contoh input :
         * Array: {1, 2, 3, 4, 2, 5}
         * 
         * Contoh output :
         * Array memiliki elemen duplikat: 2
         */
        for (int q = 0; q <= 70; q++) {
            System.out.print("=");
        }

        System.out.println("\n" + "                   MENGANALISIS ARRAY");

        for (int q = 0; q <= 70; q++) {
            System.out.print("=");
        }

        System.out.println("\n\n" + "Masukkan Array (pisahkan dengan spasi): ");
        String jawaban = input.nextLine(); // baca seluruh baris
        // pakai data "string" soalnya inputnya bakal pake spasi

        for (int q = 0; q <= 70; q++) {
            System.out.print("-");
        }

        // sistem harus nge split input jadi "x" biar bisa dibaca java -> dipotong
        // berdasarkan spasi
        String[] parts = jawaban.split(" ");

        // kita suruh sistem bikin array sesuai jumlah elemen
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]); // biar array string berubah jd array int (ParseInt->ngubah)
        }

        boolean adaDuplikat = false; // bikin variabel
        boolean[] sudahDicek = new boolean[arr.length];
        int Duplikat = -1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    adaDuplikat = true;
                    Duplikat = arr[i];
                    break;
                }
            }
            if (adaDuplikat) {
                break;
            }
        }
        if (adaDuplikat) {
            System.out.println("\nArray memiliki elemen duplikat: " + Duplikat);
            System.out.println("\n");
        } else {
            System.out.println("\nArray tidak ada duplikat\n");
        }

        input.close();

    }
}
