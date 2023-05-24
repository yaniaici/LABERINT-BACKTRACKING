import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner keyboard = new Scanner(System.in);
        int iteracio = 0;
        System.out.println("Introdueix quin laberint desitges");
        int eleccio = keyboard.nextInt();
        keyboard.close();
        String laberint = null;
        double timeElapsed[] = new double[2];

        switch(eleccio) {
            case 1: laberint = "laberint1.txt";
            break;
            case 2: laberint = "laberint2.txt";
            break;
            case 3: laberint = "laberint3.txt";
            break;
            default: System.out.println("Error en el primer switch");
            break;
        }

        File file = new File(laberint);
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();

        str = str.replaceAll(" ", "");
        String[] strValors = str.split(",");
        int[] valors = new int [strValors.length];

        for(int i=0; i< strValors.length; i++) {
            valors[i] = Integer.parseInt(strValors[i]);
        }

        ValorsLaberint vl = new ValorsLaberint();

        vl.setNfiles(valors[0]);
        vl.setNcolumnes(valors[1]);
        vl.setFilaIn(valors[2]);
        vl.setColumnaIn(valors[3]);
        vl.setFilaOut(valors[4]);
        vl.setColumnaOut(valors[5]);

        String[][] taula = new String[vl.getNfiles()][vl.getNcolumnes()];

        for(int i = 0; i < vl.getNfiles(); i++) {
            str = sc.nextLine();
            str = str.replaceAll(" ", "");
            String[] strLinia = str.split(",");

            for (int j = 0; j < vl.getNcolumnes(); j++){
                taula[i][j] = strLinia[j];
            }

        }

        vl.setTaula(taula);

        String stringInicial = taula[vl.getFilaIn()][vl.getColumnaIn()];
        stringInicial = stringInicial.replaceAll("[+-/*]", "");
        int valorInicial = Integer.parseInt(stringInicial);
        vl.setValorInicial(valorInicial);

        System.out.println(Arrays.deepToString(vl.getTaula()));

        sc.close();


        LaberintBack prova1 = new LaberintBack(vl);

        long startNanoTime = System.nanoTime();

        prova1.resuelve(vl.getFilaIn(), vl.getColumnaIn());

        timeElapsed[iteracio] = (System.nanoTime() - startNanoTime) / 1.0e9;
        System.out.printf("Temps empleat: %f\n", timeElapsed[iteracio]);

        iteracio++;

        LaberintGreedy prova2 = new LaberintGreedy(vl);

        startNanoTime = System.nanoTime();


        prova2.resuelve(vl.getFilaIn(), vl.getColumnaIn());

        timeElapsed[iteracio] = (System.nanoTime() - startNanoTime) / 1.0e9;
        System.out.printf("Temps empleat: %f\n", timeElapsed[iteracio]);






    }
}
