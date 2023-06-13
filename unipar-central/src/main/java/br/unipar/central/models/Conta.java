/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.models;

import br.unipar.central.enums.TipoContaEnum;

/**
 *
 * @author muril
 */
public class Conta extends AbstractBaseEntity {
    
    private int id;
    private String numero;
    private String digito;
    private double saldo;
    private Agencia AgenciaId;
    private Pessoa PessoaId;
    private TipoContaEnum TipoConta;

    public Conta() {
    }


    public Conta(int id, String numero, String digito, double saldo, Agencia AgenciaId, Pessoa PessoaId, TipoContaEnum TipoConta, int idAbst, String registroAcademico) {
        super(idAbst, registroAcademico);
        this.id = id;
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.AgenciaId = AgenciaId;
        this.PessoaId = PessoaId;
        this.TipoConta = TipoConta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Agencia getAgenciaId() {
        return AgenciaId;
    }

    public void setAgenciaId(Agencia AgenciaId) {
        this.AgenciaId = AgenciaId;
    }

    public Pessoa getPessoaId() {
        return PessoaId;
    }

    public void setPessoaId(Pessoa PessoaId) {
        this.PessoaId = PessoaId;
    }

    public TipoContaEnum getTipoConta() {
        return TipoConta;
    }

    public void setTipoConta(TipoContaEnum TipoConta) {
        this.TipoConta = TipoConta;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", numero=" + numero + ", digito=" + digito + ", saldo=" + saldo + ", AgenciaId=" + AgenciaId + ", PessoaId=" + PessoaId + ", TipoConta=" + TipoConta + '}';
    }
    
    
 
}
 