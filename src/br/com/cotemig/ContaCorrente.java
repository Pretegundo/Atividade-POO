package br.com.cotemig;

import java.util.Calendar;

public class ContaCorrente extends Conta implements Tributavel<ContaCorrente>{

	private PessoaJuridica pessoaJuridica;

	public ContaCorrente(Double saldo) {
		super(saldo);
		// TODO Auto-generated constructor stub
	}

	public void cobrarTaxa(int taxa) {
		TipoDeOpera�ao tipo = TipoDeOpera�ao.CobrarTaxa;
		Calendar c = Calendar.getInstance();
		HistoricoDeMovimenta�ao a = new HistoricoDeMovimenta�ao(c, tipo, (double) taxa);
		setSaldo(getSaldo() - taxa);
		this.adicionarHistorico(a);
	}

	@Override
	public void sacar(Double valor) {
		TipoDeOpera�ao tipo = TipoDeOpera�ao.Saque;
		Calendar c = Calendar.getInstance();
		if (getSaldo() > valor) {
			HistoricoDeMovimenta�ao a = new HistoricoDeMovimenta�ao(c, tipo, valor);
			setSaldo(getSaldo() - valor);
			this.adicionarHistorico(a);
		}
	}

	@Override
	public void depositar(Double valor) {
		TipoDeOpera�ao tipo = TipoDeOpera�ao.Deposito;
		Calendar c = Calendar.getInstance();
		HistoricoDeMovimenta�ao a = new HistoricoDeMovimenta�ao(c, tipo, valor);
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
