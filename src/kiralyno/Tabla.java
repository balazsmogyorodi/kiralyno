package kiralyno;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Tabla {

    private char[][] t;
    private char uresCella;

    public Tabla() {
        this('#');
    }

    public Tabla(char uresCella) {
        this.uresCella = uresCella;
        this.t = new char[8][8];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                this.t[i][j] = uresCella;

            }

        }
    }

    public boolean uresOszlop(int oszlop) {
        for (int i = 0; i < t.length; i++) {
            if (t[i][oszlop] == 'K') {
                return false;
            }
        }
        return true;
    }

    public boolean uresSor(int sor) {
        for (int i = 0; i < t.length; i++) {
            if (t[sor][i] == 'K') {
                return false;
            }
        }
        return true;
    }

    public void elhelyez(int n) {
        Random rn = new Random();
        int maximum = t.length - 1;
        int minimum = 0;
        while (n > 0) {
            int x = rn.nextInt((maximum - minimum) + 1) + minimum;
            int y = rn.nextInt((maximum - minimum) + 1) + minimum;
            if (t[x][y] == uresCella) {
                t[x][y] = 'K';
                n--;
            }
           
        }
    }

    public String megjelenit() {
        String txt = "";
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                txt += this.t[i][j];
            }
            txt += "\n";
        }
        return txt;
    }

    public void uresOszlopokSzama() {
        int oszlopokSzama = 0;
        for (int i = 0; i < t.length; i++) {
            if (uresOszlop(i)) {
                oszlopokSzama = oszlopokSzama + 1;
            }
        }
        System.out.println("Oszlopok: " + oszlopokSzama);
    }

    public void uresSorokSzama() {
        int sorokSzama = 0;
        for (int i = 0; i < t.length; i++) {
            if (uresSor(i)) {
                sorokSzama = sorokSzama + 1;
            }
        }
        System.out.println("Sorok: " + sorokSzama);

    }

    public void fajlbaIr() throws IOException {
        FileWriter myObj = new FileWriter("tablak64.txt");
        for (int i = 0; i <= 64; i++) {
            Tabla tabla = new Tabla('*');
            myObj.write("Királynők száma " + i + "\n");
            tabla.elhelyez(i);
            myObj.write(tabla.megjelenit());
            myObj.write("\n");
        }
        myObj.close();
    }
}
