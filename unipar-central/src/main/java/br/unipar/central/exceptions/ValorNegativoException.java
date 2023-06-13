/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.exceptions;

/**
 *
 * @author muril
 */
public class ValorNegativoException extends Exception{
    
        public ValorNegativoException(String campo,double valorNeg) {
        super("O campo " + campo + " foi informado com valor ("+ valorNeg+") caracteres." + 
        " Verifique e tente novamente! ");
    }
    
}
