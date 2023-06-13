/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.models;

/**
 *
 * @author muril
 */
public class Banco extends AbstractBaseEntity{
    private int id;
    private String nome;

    public Banco() {
    }

    public Banco(int id, String nome, int idAbst, String registroAcademico) {
        super(idAbst, registroAcademico);
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Banco{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    
    
    

    
}
