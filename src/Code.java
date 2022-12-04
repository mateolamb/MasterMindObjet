public class Code {

    private int[] code;
    private int lgCode;

    public Code(int lgCode) {
        this.lgCode = lgCode;
        code = new int[lgCode];
    }

    public void setCode(int i, int valeur) {

        this.code[i] = valeur;
    }


    public int getLgCode() {
        return this.lgCode;
    }

    public int getCode(int i) {
        return code[i];
    }
}
