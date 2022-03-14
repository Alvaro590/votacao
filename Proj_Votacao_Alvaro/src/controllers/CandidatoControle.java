/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.regex.Pattern;
import models.Candidato;

/**
 *
 * @author Sciencegamer
 */
public class CandidatoControle {

    public void incluir(Candidato objeto) throws Exception {
        try {
            int c = 0;
            while (REGISTRONUMERO[c] != 0) {
                if (REGISTRONOME[c].equals(objeto.getNome())) {
                    throw new Exception("Nome já registrado, registre outro nome");
                } else if (REGISTRONUMERO[c] == objeto.getNumero()) {
                    throw new Exception("Número já registrado, registre outro número");
                }
                c++;
            }           
            REGISTRONOME[numeroDoRegistro(REGISTRONUMERO)] = objeto.getNome();
            REGISTRONUMERO[numeroDoRegistro(REGISTRONUMERO)] = objeto.getNumero();
        } catch (Exception erro) {
            throw erro;
        }
    }

    public void validaEntradaCandidato(String nome, String numero) throws Exception {
        try {
            if (nome.isEmpty()) {
                throw new Exception("O campo do nome está vazio");
            }
//            if (!nome.matches("[A-Z][a-z]+( [A-Z][a-z]+)?")) {
//                throw new Exception("O nome não foi digitado corretamente");
//            }
//            String regex = "[A-Z][a-z]+( [A-Z][a-z]+)?";
//            boolean validaNome = Pattern.matches(regex, nome);
//            if (validaNome == false) {
//                throw new Exception("O nome não foi digitado corretamente");
//            }
            
            if (numero.isEmpty()) {
                throw new Exception("O campo do número está vazio");
            }
            if (numero.equals("00")) {
                throw new Exception("O número não pode ser 00");
            }
            if (!numero.matches("[0-9]+")) {
                throw new Exception("O número apresenta caracteres inválidos, apenas dígitos são permitidos");
            }
            if (numero.length() != 2) {
                throw new Exception("O candidato deve registrar 2 dígitos");
            }

        } catch (Exception erro) {
            throw erro;
        }

    }

    public static int numeroDoRegistro(int[] x) {
        int contador = 0;
        while (x[contador] != 0) {
            contador++;
        }
        return contador;
    }

    final public static String REGISTRONOME[] = new String[100];
    final public static int REGISTRONUMERO[] = new int[100];
    

}
