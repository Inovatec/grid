/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.entidades.enums;

/**
 *
 * @author zrobe
 */
public enum Turno {
    
    MANHA("Manha"), TARDE("Tarde"), NOITE("Noite");
    
    private final String value;

    private Turno(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
    
}
