/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.models;

import br.unipar.central.enums.TipoTransacaoEnum;
import java.sql.Date;

/**
 *
 * @author muril
 */
public class Transacao extends AbstractBaseEntity {
    
    private int id;
    private Date dataHora;
    private double valor;
    private TipoTransacaoEnum TipoTransacao;
    private Conta ContaOrigem;
    private Conta ContaDestino;

    public Transacao() {
    }


    public Transacao(int id, Date dataHora, double valor, TipoTransacaoEnum TipoTransacao, Conta ContaOrigem, Conta ContaDestino, int idAbst, String registroAcademico) {
        super(idAbst, registroAcademico);
        this.id = id;
        this.dataHora = dataHora;
        this.valor = valor;
        this.TipoTransacao = TipoTransacao;
        this.ContaOrigem = ContaOrigem;
        this.ContaDestino = ContaDestino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoTransacaoEnum getTipoTransacao() {
        return TipoTransacao;
    }

    public void setTipoTransacao(TipoTransacaoEnum TipoTransacao) {
        this.TipoTransacao = TipoTransacao;
    }

    public Conta getContaOrigem() {
        return ContaOrigem;
    }

    public void setContaOrigem(Conta ContaOrigem) {
        this.ContaOrigem = ContaOrigem;
    }

    public Conta getContaDestino() {
        return ContaDestino;
    }

    public void setContaDestino(Conta ContaDestino) {
        this.ContaDestino = ContaDestino;
    }

    @Override
    public String toString() {
        return "Transacao{" + "id=" + id + ", dataHora=" + dataHora + ", valor=" + valor + ", TipoTransacao=" + TipoTransacao + ", ContaOrigem=" + ContaOrigem + ", ContaDestino=" + ContaDestino + '}';
    }
    
    
    
    

            
    
}
