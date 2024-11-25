import java.util.*;

public class MyResults {
    static Scanner fer = new Scanner(System.in);
    static int jmlhM;
    static int jmlhL;

    static String[] nama;
    static float[][] nilai;
    static boolean urutPilihan = false;
    
    public static void main(String[] args) {
        System.out.println("=========================================================================");
        System.out.println("-----------------------Selamat datang di MyResults-----------------------");
        System.out.println("=========================================================================");
    
        System.out.println("");
        System.out.print("Masukan jumlah mahasiswa: ");
        jmlhM = fer.nextInt();
        System.out.print("Masukan jumlah nilai: ");
        jmlhL = fer.nextInt();
    
        nama = new String[jmlhM];
        nilai = new float[jmlhM][jmlhL];
    
        boolean selesai = false;

        while (!selesai) {
            System.out.println("\n==================== MENU ====================");
            System.out.println("1. Masukan data mahasiswa");
            System.out.println("2. Tampilkan rata-rata mahasiswa");
            System.out.println("3. Tampilkan mahasiswa dengan nilai tertinggi");
            System.out.println("4. Tampilkan grade mahasiswa");
            System.out.println("5. Tampilkan peringkat mahasiswa");
            System.out.println("6. Keluar");
            System.out.println("==============================================");
            System.out.print("Masukan pilihan anda: ");
            int pilihan = fer.nextInt();

            if ((pilihan > 1 && pilihan < 6) && !urutPilihan) {
                System.out.println(" ");
                System.out.println("Silahkan masukan data mahasiswa terlebih dahulu!!");
                continue;
            }
    
            switch (pilihan) {
                case 1:
                    tampilkanDataMahasiswa();
                    break;
                case 2:
                    tampilkanRatarata();
                    break; 
                case 3:
                    tampikanNilaiTertinggi();
                    break;
                case 4:
                    tampilkanGrade();
                    break;
                case 5:
                    tampilkanRangking();
                    break;
                case 6:
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Terimakasih sudah menggunakan MyResults. Sampai jumpa :)");
                    System.out.println("--------------------------------------------------------");
                    selesai = true;
                    break;
                default:
                    System.out.println("");
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi!!");
                    break;
            }
        }
    }

    public static void tampilkanDataMahasiswa() {
        System.out.println("\nMasukan data mahasiswa");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < jmlhM; i++) {
            System.out.println("Nama mahasiswa ke-" + (i + 1) + ": ");
            nama[i] = fer.next();
        
            System.out.println("Masukan nilai untuk " + nama[i] + ": ");
            for (int j = 0; j < jmlhL; j++) {
                System.out.println("Nilai ke-" + (j + 1) + ": ");
                float nilaiInput = fer.nextFloat();
                while (nilaiInput < 0 || nilaiInput > 100) {
                    System.out.println("Nilai tidak valid!!");
                    System.out.println("Masukan ulang nilai ke-" + (j + 1) + ": ");
                    nilaiInput = fer.nextFloat();
                }
                nilai[i][j] = nilaiInput;
            }
            System.out.println("----------------------------------------------");
        }
        urutPilihan = true;
        System.out.println("Data berhasil dimasukan!");
    }

    public static void tampilkanRatarata() {
        System.out.println("");
        float tKelas = 0;
        for (int i = 0; i < jmlhM; i++) {
            float tNilai = 0;
            for (int j = 0; j < jmlhL; j++) {
                tNilai += nilai[i][j];
            }
            float rata = tNilai / jmlhL;
            tKelas += rata;
            System.out.printf("Rata-rata nilai mahasiswa %s adalah %.2f\n", nama[i], rata);
            System.out.println("-----------------------------");
        }
        float rataK = tKelas / jmlhM;
        System.out.printf("Rata-rata nilai kelas: %.2f\n", rataK);
    }

    public static void tampikanNilaiTertinggi() {
        String namaT = "";
        float nilaiT = 0;
        for (int i = 0; i < jmlhM; i++) {
            float tNilai = 0;
            for (int j = 0; j < jmlhL; j++) {
                tNilai += nilai[i][j];
            }
            float rata = tNilai / jmlhL;
            if (rata > nilaiT) {
            nilaiT = rata;
            namaT = nama[i];
            }
        }
        System.out.println("");
        System.out.printf("Mahasiswa yang memiliki nilai rata-rata tertinggi adalah %s dengan nilai %.2f\n", namaT, nilaiT);
    }

    public static void tampilkanGrade() {
        System.out.println("");
        String grade = "";
        for (int i = 0; i < jmlhM; i++) {
            float tNilai = 0;
            for (int j = 0; j < jmlhL; j++) {
                tNilai += nilai[i][j];
            }
            float rata = tNilai / jmlhL;
            if (rata >= 80) {
                System.out.printf("Grade mahasiswa %s adalah A: Sangat baik\n", nama[i]);
                System.out.println("---------------------------------------------");
            } else if (rata >= 68) {
                System.out.printf("Grade mahasiswa %s adalah B: Baik\n", nama[i]);
                System.out.println("---------------------------------------------");
            } else if (rata >= 56) {
                System.out.printf("Grade mahasiswa %s adalah C: Cukup\n", nama[i]);
                System.out.println("---------------------------------------------");
            } else if (rata >= 45) {
                System.out.printf("Grade mahasiswa %s adalah D: Kurang\n", nama[i]);
                System.out.println("---------------------------------------------");
            } else {
                System.out.printf("Grade mahasiswa %s adalah E: Tidak Lulus\n", nama[i]);
                System.out.println("---------------------------------------------");
            }
        }
    }

    public static void tampilkanRangking() {
        float[] rataN = new float[jmlhM];
        String[] nama1 = Arrays.copyOf(nama, jmlhM);

        for (int i = 0; i < jmlhM; i++) {
            float tNilai = 0;
            for (int j = 0; j < jmlhL; j++) {
                tNilai += nilai[i][j];
            }
            rataN[i] = tNilai / jmlhL;
        }
        for (int i = 0; i < jmlhM - 1; i++) {
            for (int j = 0; j < jmlhM - i - 1; j++) {
                if (rataN[j] < rataN[j + 1]) {
                    float tukarR = rataN[j];
                    rataN[j] = rataN[j + 1];
                    rataN[j + 1] = tukarR;

                    String tukarN = nama1[j];
                    nama1[j] = nama1[j + 1];
                    nama1[j + 1] = tukarN;
                }
            }
        }
        System.out.println("");
        System.out.println("Peringkat mahasiswa berdasarkan nilai rata-rata: ");
        for (int i = 0; i < jmlhM; i++) {
            System.out.printf("%d. %s dengan nilai rata-rata %.2f\n", i + 1, nama1[i], rataN[i]);
        }
    }
}
