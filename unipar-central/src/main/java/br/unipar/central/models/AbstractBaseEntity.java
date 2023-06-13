/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.models;

/**
 *
 * @author andersonbosing
 */
public abstract class AbstractBaseEntity {
    
    private int idAbst;
    private String registroAcademico;

    public AbstractBaseEntity() {
    }

    public AbstractBaseEntity(int idAbst, String registroAcademico) {
        this.idAbst = idAbst;
        this.registroAcademico = registroAcademico;
    }

    public int getIdAbst() {
        return idAbst;
    }

    public void setIdAbst(int idAbst) {
        this.idAbst = idAbst;
    }

    public String getRegistroAcademico() {
        return registroAcademico;
    }

    public void setRegistroAcademico(String registroAcademico) {
        this.registroAcademico = registroAcademico;
    }

 
}
