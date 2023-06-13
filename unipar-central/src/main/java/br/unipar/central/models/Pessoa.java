/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.models;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author andersonbosing
 */
public class Pessoa extends AbstractBaseEntity{
    
    private int id;
    private String Email;
    private ArrayList<Endereco> enderecos;
    private ArrayList<Telefone> telefones;

    public Pessoa() {
    }

    public Pessoa(int id, String Email, ArrayList<Endereco> enderecos, ArrayList<Telefone> telefones, int idAbst, String registroAcademico) {
        super(idAbst, registroAcademico);
        this.id = id;
        this.Email = Email;
        this.enderecos = enderecos;
        this.telefones = telefones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", Email=" + Email + ", enderecos=" + enderecos + ", telefones=" + telefones + '}';
    }
    
    
    
    


}
