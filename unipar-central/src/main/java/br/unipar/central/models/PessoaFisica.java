/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.models;

import java.sql.Date;

/**
 *
 * @author muril
 */
public class PessoaFisica extends AbstractBaseEntity{
    
    private int id;
    private String nome;
    private String cpf;
    private String Rg;
    private Date DataNasc;
    private Pessoa PessoaId;

    public PessoaFisica() {
    }

    public PessoaFisica(int id, String nome, String cpf, String Rg, Date DataNasc, Pessoa PessoaId, int idAbst, String registroAcademico) {
        super(idAbst, registroAcademico);
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.Rg = Rg;
        this.DataNasc = DataNasc;
        this.PessoaId = PessoaId;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public Date getDataNasc() {
        return DataNasc;
    }

    public void setDataNasc(Date DataNasc) {
        this.DataNasc = DataNasc;
    }

    public Pessoa getPessoaId() {
        return PessoaId;
    }

    public void setPessoaId(Pessoa PessoaId) {
        this.PessoaId = PessoaId;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", Rg=" + Rg + ", DataNasc=" + DataNasc + ", PessoaId=" + PessoaId + '}';
    }
    
    

    
    
 
}
