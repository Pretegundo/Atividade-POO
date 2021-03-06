package br.com.cotemig;

import java.util.Calendar;

public class ContaPoupanša extends Conta {

	public ContaPoupanša(Double saldo) {
		super(saldo);
	}

	public void renderJuro(Double juro) {
		TipoDeOperašao tipo = TipoDeOperašao.RenderJuro;
		Calendar c = Calendar.getInstance();
		double valor = getSaldo() + (getSaldo() * juro / 100);
		setSaldo(valor);
		HistoricoDeMovimentašao a = new HistoricoDeMovimentašao(c, tipo, valor);
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

}
