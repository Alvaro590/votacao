/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Sciencegamer
 */
public class Candidato {
    
    private String nome;
    private int numero;

    

    public void Candidato(){
        
    }
    
    public Candidato(String nome, int numero){
        this.nome=nome;
        this.numero=numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
}
