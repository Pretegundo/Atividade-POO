package br.com.cotemig;

import java.util.Calendar;

public class HistoricoDeMovimentaçao {

	private Conta conta;
	private Calendar data;
	private Enum tipoOperaçao;
	private Double valor;

	public HistoricoDeMovimentaçao(Calendar data, Enum tipoOperaçao, Double valor) {
		super();
		this.data = data;
		this.valor = valor;
		this.tipoOperaçao = tipoOperaçao;
	}

	// CONTA HISTORICO DE MOVIMENTAÇÃO
	public final Conta getConta() {
		return conta;
	}

	public final void setConta(Conta conta) {
		this.conta = conta;
	}

	public final Calendar getData() {
		return data;
	}

	public final Enum getTipoOperaçao() {
		return tipoOperaçao;
	}

	public final Double getValor() {
		return valor;
	}

}
