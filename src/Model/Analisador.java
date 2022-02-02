/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;

/**
 *
 * @author Yann Dihl
 */
public class Analisador {
    
    LerArquivo fr;
    StringBuilder valor = new StringBuilder();
    ArrayList<Token> tokens = new ArrayList<Token>();
    ArrayList<String> tokensAgrupados = new ArrayList<String>();
    String idValue = "";
    String numValue = "";
    int countLine = 1;
    
    public Analisador(String arquivo){
        fr = new LerArquivo(arquivo);
    }
    
    public ArrayList<Token> getLista(){
        return tokens;
    }
    
    public ArrayList<String> getTokensAgrupados(){
        return tokensAgrupados;
    }
    
    public void agrupaTokens(){
        for(int i = 0; i<tokens.size(); i++){
            if(!tokens.get(i).isImpressed()){
                System.out.print(tokens.get(i).getValor()+"\t"+tokens.get(i).getNome()+"\t\t"+tokens.get(i).getPosition());
            String temp = tokens.get(i).getValor()+"\t"+tokens.get(i).getNome()+"\t\t"+tokens.get(i).getPosition();
            for(int j = i+1;j<tokens.size();j++){
                if(tokens.get(i).getValor().equals(tokens.get(j).getValor())){
                    System.out.print(", "+tokens.get(j).getPosition());
                    temp += ", "+tokens.get(j).getPosition();
                    tokens.get(j).setImpressed(true);
                }
            }
            tokensAgrupados.add(temp);
            System.out.println("");                
            }            
        }
    }
    
    public String outraForma(){
        String outraForma = "";
        for(int i = 0; i<tokens.size(); i++){
            TipoToken t = tokens.get(i).getNome();
            if(t ==  TipoToken.num  || t ==  TipoToken.id ){
                outraForma+= tokens.get(i).getNome()+ " ";
            }
            else{
                outraForma+= tokens.get(i).getValor()+ " ";
            }
        }
        return outraForma;
    }
    
    public void analisadorLexico(){
        int caractereLido = -1;
        int count = 0;
        Token t = null;
        
        while((caractereLido = fr.readNextChar())!=-1){
            char c = (char)caractereLido;
            if(c == ' '){
                if(idValue.length()>0){
                    t.setValor(idValue);
                    t.setPosition(Integer.toString(countLine));
                    idValue = "";
                    tokens.add(t);
                } else if(numValue.length()>0){
                    t.setValor(numValue);
                    t.setPosition(Integer.toString(countLine));
                    numValue = "";
                    tokens.add(t);
                }
                count = 0;
            }else if(c == '\n'){
                count = 0;
                countLine++;
            }else if(c == '\r'){
                
            
            }else if((c >= 'a' && c <= 'z')||(c >= 'A' && c<= 'Z')){
                if(count == 0){
                    idValue = "";
                    t = new Token(TipoToken.id);
                    idValue+=c;
                    count++;
                }else{
                    idValue+=c;
                    count++;
                }
            }else if(c >= '0' && c <= '9'){
                if(count == 0){
                    numValue = "";
                    t = new Token(TipoToken.num);
                    numValue+=c;
                    count++;
                }else{
                    if(idValue.length()>0){
                        idValue+=c;                        
                    }
                    else if(numValue.length()>0){
                        numValue+=c;
                    }                    
                    count++;
                }
            }else if(c == '.'){
                numValue+=c;
                count++;
            }else if(c == '='){
                t = new Token(TipoToken.opIgual, "=", Integer.toString(countLine));
                count = 0;
                tokens.add(t);
            }else if(c == '+'){
                if(idValue.length()>0){
                    t.setValor(idValue);
                    t.setPosition(Integer.toString(countLine));
                    idValue = "";
                    tokens.add(t);
                }else if(numValue.length()>0){
                    t.setValor(numValue);
                    t.setPosition(Integer.toString(countLine));
                    numValue = "";
                    tokens.add(t);
                }
                t = new Token(TipoToken.opSoma, "+", Integer.toString(countLine));
                count = 0;
                tokens.add(t);
            }else if(c == '-'){
                if(idValue.length()>0){
                    t.setValor(idValue);
                    t.setPosition(Integer.toString(countLine));
                    idValue = "";
                    tokens.add(t);
                }else if(numValue.length()>0){
                    t.setValor(numValue);
                    t.setPosition(Integer.toString(countLine));
                    numValue = "";
                    tokens.add(t);
                }
                t = new Token(TipoToken.opDif, "-", Integer.toString(countLine));
                count = 0;
                tokens.add(t);
            }else if(c == '*'){
                if(idValue.length()>0){
                    t.setValor(idValue);
                    t.setPosition(Integer.toString(countLine));
                    idValue = "";
                    tokens.add(t);
                }else if(numValue.length()>0){
                    t.setValor(numValue);
                    t.setPosition(Integer.toString(countLine));
                    numValue = "";
                    tokens.add(t);
                }
                t = new Token(TipoToken.opMult, "*", Integer.toString(countLine));
                count = 0;
                tokens.add(t);
            }else if(c == '/'){
                if(idValue.length()>0){
                    t.setValor(idValue);
                    t.setPosition(Integer.toString(countLine));
                    idValue = "";
                    tokens.add(t);
                }else if(numValue.length()>0){
                    t.setValor(numValue);
                    t.setPosition(Integer.toString(countLine));
                    numValue = "";
                    tokens.add(t);
                }
                t = new Token(TipoToken.opDiv, "/", Integer.toString(countLine));
                count = 0;
                tokens.add(t);
            }else if(c == ';' || c == '(' || c == ')'){
                if(idValue.length()>0){
                    t.setValor(idValue);                   
                    t.setPosition(Integer.toString(countLine));
                    idValue = "";
                    tokens.add(t);
                }else if(numValue.length()>0){
                    t.setValor(numValue);
                    t.setPosition(Integer.toString(countLine));
                    numValue = "";
                    tokens.add(t);
                }                
                t = new Token(TipoToken.simbEsp);
                if(c == ';'){
                    t.setValor(";");
                    t.setPosition(Integer.toString(countLine));
                }else if(c == '('){
                    t.setValor("(");
                    t.setPosition(Integer.toString(countLine));
                }else if(c == ')'){
                    t.setValor(")");
                    t.setPosition(Integer.toString(countLine));
                }
                count = 0;
                tokens.add(t);
            }else{
                throw new RuntimeException("Símbolo não reconhecido na linha: "+countLine);
            }
        }
    }  
}
