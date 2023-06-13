/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.models;

/**
 *
 * @author andersonbosing
 */
public class Cidade extends AbstractBaseEntity{
    
    private int id;
    private String nome;
    private String Sigla;
    private Estado estado;

    public Cidade() {
    }



    public Cidade(int id, String nome, String Sigla, Estado estado, int idAbst, String registroAcademico) {
        super(idAbst, registroAcademico);
        this.id = id;
        this.nome = nome;
        this.Sigla = Sigla;
        this.estado = estado;
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

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String Sigla) {
        this.Sigla = Sigla;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cidade{" + "id=" + id + ", nome=" + nome + ", Sigla=" + Sigla + ", estado=" + estado + '}';
    }

    

    
}
