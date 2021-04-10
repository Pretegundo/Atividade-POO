package br.com.cotemig;

import java.util.Calendar;

public class ContaPoupan�a extends Conta {

	public ContaPoupan�a(Double saldo) {
		super(saldo);
	}

	public void renderJuro(Double juro) {
		TipoDeOpera�ao tipo = TipoDeOpera�ao.RenderJuro;
		Calendar c = Calendar.getInstance();
		double valor = getSaldo() + (getSaldo() * juro / 100);
		setSaldo(valor);
		HistoricoDeMovimenta�ao a = new HistoricoDeMovimenta�ao(c, tipo, valor);
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

}
