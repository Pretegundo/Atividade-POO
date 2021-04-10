package br.com.cotemig;

import java.util.Calendar;

public class ContaPoupança extends Conta {

	public ContaPoupança(Double saldo) {
		super(saldo);
	}

	public void renderJuro(Double juro) {
		TipoDeOperaçao tipo = TipoDeOperaçao.RenderJuro;
		Calendar c = Calendar.getInstance();
		double valor = getSaldo() + (getSaldo() * juro / 100);
		setSaldo(valor);
		HistoricoDeMovimentaçao a = new HistoricoDeMovimentaçao(c, tipo, valor);
		this.adicionarHistorico(a);

	}

	@Override
	public void sacar(Double valor) {
		TipoDeOperaçao tipo = TipoDeOperaçao.Saque;
		Calendar c = Calendar.getInstance();
		if (getSaldo() > valor) {
			HistoricoDeMovimentaçao a = new HistoricoDeMovimentaçao(c, tipo, valor);
			setSaldo(getSaldo() - valor);
			this.adicionarHistorico(a);
		}
	}

	@Override
	public void depositar(Double valor) {
		TipoDeOperaçao tipo = TipoDeOperaçao.Deposito;
		Calendar c = Calendar.getInstance();
		HistoricoDeMovimentaçao a = new HistoricoDeMovimentaçao(c, tipo, valor);
		setSaldo(getSaldo() + valor);
		this.adicionarHistorico(a);
	}

}
