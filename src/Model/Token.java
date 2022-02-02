/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Yann Dihl e Cícero Wendorff

 */
public class Token {
    public TipoToken nome;
    public String valor;
    public String position;
    public boolean impressed;

    public Token(TipoToken nome, String valor, String position) {
        this.nome = nome;
        this.valor = valor;
        this.position = position;
        this.impressed = false;
    }

    public void setNome(TipoToken nome) {
        this.nome = nome;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TipoToken getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }

    public Token(TipoToken tipo) {
        this.nome = tipo;
        this.impressed = false;
    }

    public boolean isImpressed() {
        return impressed;
    }

    public void setImpressed(boolean impressed) {
        this.impressed = impressed;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
 
    @Override
    public String toString() {
      return "<"+valor+"\t"+nome+">";  
    }
}
