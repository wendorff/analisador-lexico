/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Yann Dihl
 */
public class LerArquivo {
     InputStream is;
     
     public LerArquivo(String arquivo){
         try {
             is = new FileInputStream(new File(arquivo));
         } catch (FileNotFoundException ex) {
             ex.printStackTrace();
         }
     }
     
     public int readNextChar(){
         try {
             int ret = is.read();
             
             return ret;
         } catch (IOException ex) {
             ex.printStackTrace();
             return -1;
         }
     }
}
