package Model;

import java.io.FileWriter;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Analisador anas = new Analisador("C://Users/wenn/Documents/teste.txt");
        Token t = null;
        CriaArquivo ca = new CriaArquivo();
        ArrayList<String> tokensAgrupados = anas.getTokensAgrupados();
        anas.analisadorLexico();
        anas.agrupaTokens();
        
        ca.EscreveArquivo("Token \t Símbolo \t Posição no Código(Linha)\n");
        for (int i = 0; i < tokensAgrupados.size(); i++) {
            //System.out.println(tokensAgrupados.get(i)); 
            ca.EscreveArquivo(tokensAgrupados.get(i));
        }  
        String of = anas.outraForma();
        ca.EscreveArquivo(of);
        System.out.println(of);
        ca.FechaArquivo();
    }
}
