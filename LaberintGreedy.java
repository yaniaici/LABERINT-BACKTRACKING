public class LaberintGreedy {
    public ValorsLaberint vl = new ValorsLaberint();
    double contValor = 0;
    String[][] taula;

    public LaberintGreedy(ValorsLaberint vl){
        this.vl = vl;
        taula = vl.getTaula();
    }

    public void resuelve(int x, int y){
        if (greedy(x,y)){
            System.out.print("El laberint ha sigut resolt");
        } else System.out.println("No té solució el laberint");
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

        String valor = taula[x][y];

        valor = valor.replaceAll("[+/*-]", "");


        return valor;

    }

    private boolean greedy(int x, int y){
        while(!esSolucio(x,y)) {
            contValor = actValor(x,y);
            taula[x][y] = "X";

            int pi, pj, absI, absJ;
            if(Math.abs(vl.getColumnaOut()-x)>Math.abs(vl.getFilaOut()-y))
            {
                pi = 1;
                pj = 0;
            } else {
                pi = 0;
                pj = 1;
            }

            if(vl.getColumnaOut()<x)absI=1;
            else absI=1;
            if(vl.getFilaOut()<y)absJ=-1;
            else absJ=1;

            if(esFactible(x+(pi*absI),y+(pj*absJ),contValor)) { //eix óptim en direcció óptima
                x+=(pi*absI);
                y+=(pj*absJ);
            }
            else if(esFactible(x+(pj*absI),y+(pi*absJ),contValor)) { //eix alternatiu en direccio óptima
                x+=(pj*absI);
                y+=(pi*absJ);
            }
            else if(esFactible(x-(pj*absI),y-(pi*absJ),contValor)) {//eix alternatiu en direcció alternativa
                x-=(pj*absI);
                y-=(pi*absJ);
            }
            else if(esFactible(x-(pi*absI),y-(pj*absJ),contValor)) { //eix óptim en direcció alternativa
                x-=(pi*absI);
                y-=(pj*absJ);
            }
            else { //si res d'aixo ha estat possible, significa que ens em trobat sense sortida i per tant aquest algorisme es incapaç de trobar solució.
                System.out.println("No s'ha trobat la solució amb l'algorisme greedy.");
                printar(taula);
                return false;
            }

        }

        taula[x][y] = "X";
        printar(taula);
        System.out.println("contValor: "+contValor);
        return true;
    }

    private double actValor(int x, int y) {
        switch (simbolint(x,y)) {
            case 1: contValor = contValor + valor(x,y);
                break;
            case 2: contValor = contValor * valor(x,y);
                break;
            case 3: contValor = contValor / valor(x,y);
                break;
            case 4: contValor = contValor - valor(x,y);
                break;
            default:
                break;
        }
        return contValor;
    }

    private void printar (String taula[][]){

        for (int i=0; i < taula.length; i++) {
            System.out.print("|");
            for (int j=0; j < taula[i].length; j++) {
                System.out.print (taula[i][j]);
                if (j!=taula[i].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }

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
