package br.com.cotemig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Conta {
	private Double saldo;
	private PessoaFisica pessoaFisica;

	public final Double getSaldo() {
		return saldo;
	}

	public final void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Conta(Double saldo) {
		this.saldo = saldo;
	}

	public abstract void sacar(Double valor);

	public abstract void depositar(Double valor);

	// CONTA HISTORICO DE MOVIMENTAă┬O
	private ArrayList<HistoricoDeMovimentašao> historicoList = new ArrayList<>();

	public void adicionarHistorico(HistoricoDeMovimentašao historico) {
		historicoList.add(historico);
		historico.setConta(this);
	}

	public List<HistoricoDeMovimentašao> getHistoricoDeMovimentašao() {
		return Collections.unmodifiableList(historicoList);
	}

	// CONTA PESSOA FISICA
	public final PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public final void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}



	
}
