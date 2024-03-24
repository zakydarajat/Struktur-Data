package Strukdat_Modul1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum JenisBarang {

    SANDANG,
    PANGAN,
    PAPAN
}

class Barang<T1, T2, T3> {
    private T1 jenis;
    private T2 nama;
    private T3 harga;

    public Barang(T1 jenis, T2 nama, T3 harga) {
        this.jenis = jenis;
        this.nama = nama;
        this.harga = harga;
    }

    public T1 getJenis() {
        return jenis;
    }

    public T2 getNama() {
        return nama;
    }

    public T3 getHarga() {
        return harga;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Barang<JenisBarang, String, Integer>> daftarBarang = new ArrayList<>();

        boolean lanjutkan = true;
        while (lanjutkan) {
            System.out.println("Menu:");
            System.out.println("1. Input barang");
            System.out.println("2. Daftar barang");
            System.out.println("3. Keluar");
            System.out.println("----------------------");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    inputBarang(scanner, daftarBarang);
                    break;
                case 2:
                    tampilkanDaftarBarang(daftarBarang);
                    break;
                case 3:
                    lanjutkan = false;
                    System.out.println("----------------------");
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("----------------------");
                    System.out.println("Menu tidak valid.");
                    break;
            }
        }
    }

    private static void inputBarang(Scanner scanner, List<Barang<JenisBarang, String, Integer>> daftarBarang) {
        System.out.println("----------------------\nMasukkan jenis barang\n1: SANDANG\n2: PANGAN\n3: PAPAN\n----------------------");
        System.out.print("Masukan pilihan :");
        int jenisInput = scanner.nextInt();
        JenisBarang jenisBarang = null;
        switch (jenisInput) {
            case 1:
                jenisBarang = JenisBarang.SANDANG;
                break;
            case 2:
                jenisBarang = JenisBarang.PANGAN;
                break;
            case 3:
                jenisBarang = JenisBarang.PAPAN;
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        System.out.print("Masukkan nama barang: ");
        String namaBarang = scanner.next();

        System.out.print("Masukkan harga barang: ");
        int hargaBarang = 0;
        boolean inputHargaValid = false;
        while (!inputHargaValid) {
            try {
                hargaBarang = Integer.parseInt(scanner.next());
                inputHargaValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan harga dalam bentuk angka.");
            }
        }

        Barang<JenisBarang, String, Integer> barang = new Barang<>(jenisBarang, namaBarang, hargaBarang);
        daftarBarang.add(barang);


        System.out.println("Informasi barang : ");
        System.out.println("----------------------");
        System.out.println("Jenis: " + barang.getJenis());
        System.out.println("Nama : " + barang.getNama());
        System.out.println("Harga: " + barang.getHarga());
        System.out.println("----------------------");
    }


    private static void tampilkanDaftarBarang(List<Barang<JenisBarang, String, Integer>> daftarBarang) {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang yang dimasukkan.");
        } else {
            System.out.println("Daftar barang yang sudah dimasukkan:");
            System.out.println("------------------------------------");
            for (Barang<JenisBarang, String, Integer> barang : daftarBarang) {
                System.out.println("Jenis: " + barang.getJenis() + "\nNama: " + barang.getNama() + "\nHarga: " + barang.getHarga() + "\n----------------------");
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tekan enter untuk kembali ke menu sebelumnya");
        scanner.nextLine(); // Tunggu sampai pengguna menekan enter
    }
}
