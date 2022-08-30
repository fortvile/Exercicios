public class Cifra {

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String cifrar(String s){
        String cifra = "";
        for (int i = 0; i < s.length(); i++){
            cifra = cifra + (char)(s.charAt(i) + 3);
        }
        return cifra;
    }

    public static void main(String[] args){
        String s = "";

        do{
            s = MyIO.readLine();
            MyIO.println(cifrar(s));

        }while(isFim(s) == false);
    }
}
