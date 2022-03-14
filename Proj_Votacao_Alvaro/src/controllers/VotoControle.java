/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.CandidatoControle.REGISTRONOME;
import static controllers.CandidatoControle.REGISTRONUMERO;
import static controllers.CandidatoControle.numeroDoRegistro;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Sciencegamer
 */
public class VotoControle {

    public static int validaVoto(String voto) throws Exception {

        try {
            int aux = 0;
            if (voto.isEmpty()) {
                throw new Exception("O campo do voto está vazio");
            }
            if (!voto.matches("[0-9]+")) {
                throw new Exception("Número digitado apresenta caracteres inválidos, apenas dígitos são permitidos");
            }
            if (voto.length() != 2) {
                throw new Exception("O voto deve conter 2 dígitos");
            }
            aux = Integer.parseInt(voto);
            boolean achei = false;
            int c = 0;
            while (REGISTRONUMERO[c] != 0 && c < 100) {
                if (REGISTRONUMERO[c] == aux) {
                    achei = true;
                }
                c++;
            }

            if (achei == true) {
                return aux;
            } else {
                VOTOSEMBRANCO++;
                return 00;
            }

        } catch (Exception erro) {
            throw erro;
        }
    }

    public static void incluirVoto(int voto) throws Exception {
        if (voto != 0) {
            REGISTROVOTOS[numeroDoRegistro(REGISTROVOTOS)] = voto;
        }

    }

    public static int contaVotosDoCandidato(int numeroCandidato) {
        int votos = 0;
        for (int i = 0; i < numeroDoRegistro(REGISTROVOTOS); i++) {
            if (REGISTROVOTOS[i] == numeroCandidato) {
                votos++;
            }
        }

        return votos;
    }

    public static int contaVotosValidos() {
        int votosValidos = 0;
        for (int i = 0; i < REGISTROVOTOS.length; i++) {
            boolean achei = false;
            for (int i2 = 0; i2 < numeroDoRegistro(REGISTRONUMERO); i2++) {
                if (REGISTRONUMERO[i2] == REGISTROVOTOS[i]) {
                    achei=true;
                    break;
                }
            }
            if (achei == true) {
                votosValidos++;
            }

        }

        return votosValidos;
    }

    public static int VOTOSEMBRANCO = 0;
    final public static int REGISTROVOTOS[] = new int[100];

}
