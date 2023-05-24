public class ValorsLaberint {

    private int nfiles;
    private int ncolumnes;
    private int filaIn;
    private int columnaIn;
    private int filaOut;
    private int columnaOut;
    private int valorInicial;
    private String[][] taula = new String[nfiles][ncolumnes];


    public void setNfiles(int nfiles) {
        this.nfiles = nfiles;
    }

    public int getNfiles(){
        return nfiles;
    }

    public int getNcolumnes(){
        return ncolumnes;
    }

    public void setNcolumnes(int ncolumnes) {
        this.ncolumnes = ncolumnes;
    }

    public int getFilaIn() {
        return filaIn;
    }

    public void setFilaIn(int filaIn) {
        this.filaIn = filaIn;
    }

    public int getColumnaIn() {
        return columnaIn;
    }

    public void setColumnaIn(int columnaIn) {
        this.columnaIn = columnaIn;
    }

    public int getFilaOut() {
        return filaOut;
    }

    public void setFilaOut(int filaOut) {
        this.filaOut = filaOut;
    }

    public int getColumnaOut() {
        return columnaOut;
    }

    public void setColumnaOut(int columnaOut) {
        this.columnaOut = columnaOut;
    }

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String[][] getTaula() {
        return taula;
    }

    public void setTaula(String[][] taula) {
        this.taula = taula;
    }
}
