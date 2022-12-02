public class Code {

    private int[] code;
    private int lgCode;
    public Code(){
        for (int i = 0; i < lgCode; i++) {
            code[i]=0;
        }
    }

    public void setCode(int[] code) {
        this.code = code;
    }
}
