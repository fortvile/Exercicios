import javax.imageio.stream.MemoryCacheImageInputStream;

class Palindromo{

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isPalindromo(String s){
        //girafarig
        boolean palindrome = true;
        int aux = s.length() - 1;
        for(int i = 0; i < s.length(); i++, aux--){
            if(s.charAt(i) != s.charAt(aux)){
                palindrome = false;
            }
        }
        return palindrome;
    }
    public static void main(String[] args){
        String s = "";
        
        do{
            s = MyIO.readLine();
            if(isPalindromo(s) == true){
                MyIO.println("SIM");
            }
            else{
                MyIO.println("NAO");
            }
        }while(isFim(s) == false);
    }
}