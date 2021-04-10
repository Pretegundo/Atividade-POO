package br.com.cotemig;

import java.util.Calendar;

public class HistoricoDeMovimenta�ao {

	private Conta conta;
	private Calendar data;
	private Enum tipoOpera�ao;
	private Double valor;

	public HistoricoDeMovimenta�ao(Calendar data, Enum tipoOpera�ao, Double valor) {
		super();
		this.data = data;
		this.valor = valor;
		this.tipoOpera�ao = tipoOpera�ao;
	}

	// CONTA HISTORICO DE MOVIMENTA��O
	public final Conta getConta() {
		return conta;
	}

	public final void setConta(Conta conta) {
		this.conta = conta;
	}

	public final Calendar getData() {
		return data;
	}

	public final Enum getTipoOpera�ao() {
		return tipoOpera�ao;
	}

	public final Double getValor() {
		return valor;
	}

}
