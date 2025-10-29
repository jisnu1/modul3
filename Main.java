import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("====================================");
        System.out.println("              test KALKULATOR ");
        System.out.println("====================================");

        while (isRunning) {
            tampilkanMenu();
            System.out.print("Pilih operasi (1-5): ");
            int pilihan = scanner.nextInt();

            if (pilihan == 5) {
                isRunning = false;
                System.out.println("Terima kasih telah menggunakan kalkulator!");
                continue;
            }

            if (pilihan < 1 || pilihan > 5) {
                System.out.println("Pilihan tidak valid! Silakan pilih 1-5.");
                continue;
            }

            System.out.print("Masukkan angka pertama: ");
            double angka1 = scanner.nextDouble();

            System.out.print("Masukkan angka kedua: ");
            double angka2 = scanner.nextDouble();

            double hasil = hitung(pilihan, angka1, angka2);
            tampilkanHasil(pilihan, angka1, angka2, hasil);
        }

        scanner.close();
    }


    public static void tampilkanMenu() {
        System.out.println("\nPilih operasi:");
        System.out.println("1. Penjumlahan (+)");
        System.out.println("2. Pengurangan (-)");
        System.out.println("3. Perkalian (×)");
        System.out.println("4. Pembagian (÷)");
        System.out.println("5. Keluar");
    }


    public static double hitung(int pilihan, double angka1, double angka2) {
        switch (pilihan) {
            case 1:
                return penjumlahan(angka1, angka2);
            case 2:
                return pengurangan(angka1, angka2);
            case 3:
                return perkalian(angka1, angka2);
            case 4:
                return pembagian(angka1, angka2);
            default:
                return 0;
        }
    }


    public static double penjumlahan(double a, double b) {
        return a + b;
    }


    public static double pengurangan(double a, double b) {
        return a - b;
    }


    public static double perkalian(double a, double b) {
        return a * b;
    }


    public static double pembagian(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: Pembagian dengan nol tidak diperbolehkan!");
        }
        return a / b;
    }



    public static void tampilkanHasil(int pilihan, double angka1, double angka2, double hasil) {
        String operator = "";
        switch (pilihan) {
            case 1: operator = "+"; break;
            case 2: operator = "-"; break;
            case 3: operator = "×"; break;
            case 4: operator = "÷"; break;
        }

        System.out.println("\n════════ HASIL ════════");
        System.out.printf("%.2f %s %.2f = %.2f%n", angka1, operator, angka2, hasil);
        System.out.println("═══════════════════════");
    }
}