import java.io.*;
import java.net.*;

public class HTML {
    public static String getHtml(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;
  
        try {
           url = new URL(endereco);
           is = url.openStream();  // throws an IOException
           br = new BufferedReader(new InputStreamReader(is));
  
           while ((line = br.readLine()) != null) {
              resp += line + "\n";
           }
        } catch (MalformedURLException mue) {
           mue.printStackTrace();
        } catch (IOException ioe) {
           ioe.printStackTrace();
        } 
  
        try {
           is.close();
        } catch (IOException ioe) {
           // nothing to see here
  
        }
  
        return resp;
     }


    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isConsoante(char c){
        return (c == 'b' || c == 'c' || c == 'd' || c == 'f' || c == 'g' || c == 'h' || c == 'j' || c == 'k' || c == 'l'
        || c == 'm' || c == 'n' || c == 'p' || c == 'q' || c == 'r' || c == 's' || c == 't' || c == 'v'
        || c == 'x' || c == 'w' || c == 'y' || c == 'z');
    }

    public static String tratar(String s){

        //VOGAIS NORMAIS
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        //ACENTO AGUDO
        int aA = 0, eE = 0, iI = 0, oO = 0, uU = 0; 
        //ACENTO GRAVE
        int Aa = 0, Ee = 0, Ii = 0, Oo = 0, Uu = 0; 
        //TIL
        int A_til = 0, O_til = 0;
        //CIRCUNFLEXO
        int Ac = 0, Ec = 0, Ic = 0, Oc = 0, Uc = 0;
        //CONSOANTE
        int consoante = 0;
        //HTML
        int br = 0, table = 0;

        for(int j = 0; j < s.length(); j++){
        //VERIFICAR VOGAL
            if(s.charAt(j) == 'a'){
                a++;
            }
            if(s.charAt(j) == 'e'){
                e++;
            }
            if(s.charAt(j) == 'i'){
                i++;
            }
            if(s.charAt(j) == 'o'){
                o++;
            }
            if(s.charAt(j) == 'u'){
                u++;
            }
        //VERIFICAR VOGAL COM AGUDO
            if(s.charAt(j) == '??'){
                aA++;
            }
            if(s.charAt(j) == '??'){
                eE++;
            }
            if(s.charAt(j) == '??'){
                iI++;
            }
            if(s.charAt(j) == '??'){
                oO++;
            }
            if(s.charAt(j) == '??'){
                uU++;
            }
        //VERIFICAR VOGAL COM GRAVE
            if(s.charAt(j) == '??'){
                Aa++;
            }
            if(s.charAt(j) == '??'){
                Ee++;
            }
            if(s.charAt(j) == '??'){
                Ii++;
            }
            if(s.charAt(j) == '??'){
                Oo++;
            }
            if(s.charAt(j) == '??'){
                Uu++;
            }
        //VERIFICAR SE TEM TIL
            if(s.charAt(j) == '??'){
                A_til++;
            }
            if(s.charAt(j) == '??'){
                O_til++;
            }
        //VERIFICA SE TEM CIRCUNFLEXO
        if(s.charAt(j) == '??'){
            Ac++;
        }
        if(s.charAt(j) == '??'){
            Ec++;
        }
        if(s.charAt(j) == '??'){
            Ic++;
        }
        if(s.charAt(j) == '??'){
            Oc++;
        }
        if(s.charAt(j) == '??'){
            Uc++;
        }

        //VERIFICAR SE ?? CONSOANTE
            if(isConsoante(s.charAt(j)) == true){
                consoante ++;
            }
        }
        //VERIFICA SE TEM o HTML <br>
        if(s.indexOf("<br>") != -1){
            br++;
            consoante = consoante - 2;
        }
        //VERIFICA SE TEM o HTML <table>
        if(s.indexOf("<table>") != -1){
            table++;
            consoante = consoante - 3;
            a--;
            e--;
        }
        return("a("+a+") e("+e+") i("+i+") o("+o+") u("+u+") ??("+aA+") ??("+eE+") ??("+iI+") ??("+oO+") ??("+uU+") ??("+Aa+") ??("+Ee+") ??("+Ii+") ??("+Oo+") ??("+Uu+") ??("+A_til+") ??("+O_til+") ??("+Ac+") ??("+Ec+") ??("+Ic+") ??("+Oc+") ??("+Uc+") consoante("+consoante+") <br>("+br+") <table>("+table+") ");
    }

    public static void main (String[] args){
        MyIO.setCharset("utf-8");
        //pesquisar ISO = ISO-8859-1
        String nome = "";
        String endereco = "";
        String site = "";
        do{
            nome = MyIO.readLine();
            if(isFim(nome) == true){
                break;
            }
            endereco = MyIO.readLine();
            site = getHtml(endereco);
            MyIO.println(tratar(site) + nome);
        }while(isFim(nome) == false);
    }
}
