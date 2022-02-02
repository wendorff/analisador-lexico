/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Yann Dihl e Cícero Wendorff

 */
public class CriaArquivo {
    FileWriter arq;
    PrintWriter gravaArq;
    public CriaArquivo(){
        try {
            arq = new FileWriter("resultado.txt");
            gravaArq = new PrintWriter(arq);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean EscreveArquivo(String c){
        gravaArq.print(c+"\n");
        return true;
    }
    
    public boolean FechaArquivo(){
        try {
            arq.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
