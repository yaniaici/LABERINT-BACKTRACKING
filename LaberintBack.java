

public class LaberintBack {

    public ValorsLaberint vl = new ValorsLaberint();
    double contValor = 0;
    int contadorPas = 0;
    int[] solucioActual;
    String[][] taula;

    public LaberintBack (ValorsLaberint vl){
       this.vl = vl;
       taula = vl.getTaula();

    }



    public int simbolint(int x, int y) {

        int simbolint = 0;

        String simbol = taula[x][y];

        simbol = simbol.replaceAll("[A-Za-z0-9]","");


        switch(simbol) {
            case "+": simbolint = 1;
            break;
            case "*": simbolint = 2;
            break;
            case "/": simbolint = 3;
            break;
            case "-": simbolint = 4;
            break;
            default:
            break;
        }

        return simbolint;

    }



    public int valor(int x, int y) {

        String num = taula[x][y];

        num = num.replaceAll("[+/*-]","");

        int valor = Integer.parseInt(num);

        return valor;

    }

    public String valorstring(int x, int y) {

        String xd = taula[x][y];

        xd = xd.replaceAll("[+/*-]", "");


        return xd;

    }



    public void resuelve(int x, int y){
        if (paso(x, y)) {
            System.out.println("El laberint ha sigut resolt");
        } else {
            System.out.println("No hi ha solució");
        }
    }


    public boolean paso(int x, int y) {
        contadorPas++;
        if (esSolucio(x,y)) {

            for (int i=0; i < taula.length; i++) {
                System.out.print("|");
                for (int j=0; j < taula[i].length; j++) {
                    System.out.print (taula[i][j]);
                    if (j!=taula[i].length-1) System.out.print("\t");
                }
                System.out.println("|");
            }
                return true;
        }

        if (!esFactible(x,y,contValor)) {
            return false;
        }

        switch(simbolint(x,y)) {
            case 1: contValor = contValor + valor(x,y);
                break;
            case 2: contValor = contValor * valor(x,y);
                break;
            case 3: contValor = contValor / valor(x,y);
                break;
            case 4: contValor = contValor - valor(x,y);
                break;
            default: System.out.println("Error en el switch del backtracking");
                break;
        }

        String aux = valorstring(x,y);

        taula[x][y] = "X";
        if (paso(x, y+1)) return true; //dreta
        if (paso(x+1, y)) return true; //abaix
        if (paso(x, y-1)) return true; //esquerra
        if (paso(x-1, y)) return true; //amunt

        taula[x][y] = aux;

        return false;


    }



    public boolean esFactible(int x, int y, double cont) {
        if (simbolint(x,y) == 0){
            return false;
        }
        else if ((valor(x,y) >= 0 && simbolint(x, y) != 4) || (simbolint(x,y) == 4 && cont - valor(x,y)>0)){
            return true;
        }

        return false;
    }

    public boolean esSolucio(int x, int y) {return ((vl.getFilaOut() == x) && (vl.getColumnaOut() == y));}

}
