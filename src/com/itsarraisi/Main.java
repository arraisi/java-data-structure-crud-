package com.itsarraisi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayData data = new ArrayData();
        String dataX = "";


        Scanner in = new Scanner(System.in);
        char pilihan;
        do {
            pilihan = data.pilihMenu();
            switch (pilihan) {
                case '1':
                    System.out.println("Masukan data baru : ");
                    dataX = in.nextLine();
                    if (!data.tambahData(dataX)) {
                        System.out.println("Maaf data penuh");
                    }
                    break;
                case '2':
                    System.out.println("Masukan data yang akan dihapus : ");
                    dataX = in.nextLine();
                    if (!data.hapusData(dataX)) {
                        System.out.println("Maaf data tidak ditemukan");
                    }
                    break;
                case '3':
                    System.out.println("Selesai ***");
            }

        } while (pilihan != '3');

        in.close();
    }
}

class ArrayData {
    final Integer MAKSDATA = 10;
    private String[] data = new String[10];
    private Integer jumlahData;

    public ArrayData() {
        jumlahData = 0;
    }

    // MENU
    public char pilihMenu() {
        Character pilihan;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Menu");
            System.out.println("1. Tambah data");
            System.out.println("2. Hapus data");
            System.out.println("3. Selesai");
            String baris = in.nextLine();

            if (baris.isEmpty()) {
                pilihan = '0';
            } else{
                pilihan = baris.charAt(0);
            }
        } while (pilihan < '1' || pilihan > '3');
        return pilihan;
    }

    // TAMBAH DATA
    public boolean tambahData(String newData) {
        if (jumlahData == MAKSDATA) {
            return false;
        }

        Integer posisi = -1;
        for (int i = 0; i < jumlahData; i++) {
            if (newData.compareTo(data[i]) < 0) {
                posisi = i;
                break;
            }
        }

        if (posisi == -1) {
            data[jumlahData] = newData;
            jumlahData += 1;
        } else{
            for (int i = jumlahData - 1; i >= posisi; i--) {
                data[i + 1] = data[i];
            }
            data[posisi] = newData;
            jumlahData += 1;
        }

        System.out.println("Jumlah data : " + jumlahData);
        for (int i = 0; i < jumlahData; i++) {
            System.out.print(data[i]);
            if (i != jumlahData - 1) {
                System.out.print(" - ");
            } else{
                System.out.println();
            }
        }
        return true;
    }

    // HAPUS DATA
    public boolean hapusData(String dataX) {
        Integer posisi = -1;
        for (int i = 0; i < jumlahData; i++) {
            if (dataX.compareTo(data[i]) == 0) {
                posisi = i;
                break;
            }
        }

        if (posisi == -1) {
            System.out.println("Failed, data tidak ditemukan");
            return false;
        }

        if (posisi == jumlahData - 1) {
            jumlahData -= 1;
        } else{
            for (int i = posisi + 1; i < jumlahData; i++) {
                data[i - 1] = data[i];
            }
            jumlahData -= 1;
        }

        System.out.println("Jumlah data : " + jumlahData);
        for (int i = 0; i < jumlahData; i++) {
            System.out.print(data[i]);
            if (i != jumlahData - 1) {
                System.out.print(" - ");
            } else{
                System.out.println();
            }
        }
        return true;
    }
}
