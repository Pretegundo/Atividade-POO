package br.com.cotemig;

import java.util.Calendar;

public class ContaCorrente extends Conta implements Tributavel<ContaCorrente>{

	private PessoaJuridica pessoaJuridica;

	public ContaCorrente(Double saldo) {
		super(saldo);
		// TODO Auto-generated constructor stub
	}

	public void cobrarTaxa(int taxa) {
		TipoDeOperašao tipo = TipoDeOperašao.CobrarTaxa;
		Calendar c = Calendar.getInstance();
		HistoricoDeMovimentašao a = new HistoricoDeMovimentašao(c, tipo, (double) taxa);
		setSaldo(getSaldo() - taxa);
		this.adicionarHistorico(a);
	}

	@Override
	public void sacar(Double valor) {
		TipoDeOperašao tipo = TipoDeOperašao.Saque;
		Calendar c = Calendar.getInstance();
		if (getSaldo() > valor) {
			HistoricoDeMovimentašao a = new HistoricoDeMovimentašao(c, tipo, valor);
			setSaldo(getSaldo() - valor);
			this.adicionarHistorico(a);
		}
	}

	@Override
	public void depositar(Double valor) {
		TipoDeOperašao tipo = TipoDeOperašao.Deposito;
		Calendar c = Calendar.getInstance();
		HistoricoDeMovimentašao a = new HistoricoDeMovimentašao(c, tipo, valor);
		setSaldo(getSaldo() + valor);
		this.adicionarHistorico(a);
	}

	// CONTA CORRENTE PESSOA JURIDICA
	public final PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public final void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	// INTERFACE TRIBUTAVEL
	@Override
	public void cobrarTributo(double valor) {
		setSaldo(getSaldo() - valor);
	}


}
