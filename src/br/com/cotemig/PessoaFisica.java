package br.com.cotemig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PessoaFisica extends Pessoa implements Identificavel<PessoaFisica>, Comparavel<PessoaFisica> {

	private String cpf;
	private String nome;

	public PessoaFisica(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}

	@Override
	public void exibirIdentificaçaoENome() {
		System.out.println("Pessoa Fisica: ");
		System.out.println("CPF: " + cpf);
		System.out.println("Nome: " + nome);
	}

	@Override
	public void exibirExtratoBancario() {

		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		for (Conta conta : contaList) {
			System.out.println("Saldo Atual: " + conta.getSaldo());
			List<HistoricoDeMovimentaçao> hList = conta.getHistoricoDeMovimentaçao();

			for (HistoricoDeMovimentaçao h : hList) {
				System.out.println("Tipo de Operação: " + h.getTipoOperaçao());
				System.out.println("Valor da Operação: " + h.getValor());
				System.out.println("Hora da Operação: " + f.format(h.getData().getTime()));
				System.out.println("- - - - - - - - - - - - - - - - - - - -");
			}

		}

	}

	// CONTA PESSOA FISICA
	private ArrayList<Conta> contaList = new ArrayList<>();

	public void adicionarConta(Conta conta) {
		contaList.add(conta);
		conta.setPessoaFisica(this);
	}

	public List<Conta> getConta() {
		return Collections.unmodifiableList(contaList);
	}

	// INTERFACE IDENTIFICAVEL
	@Override
	public void obterIdentificaçao(PessoaFisica c) {
		System.out.println("CPF: " + c.cpf);
		System.out.println("Nome: " + c.nome);
	}

	// INTERFACE COMPARAVEL
	@Override
	public int comparar(PessoaFisica c) {
		if (this.cpf == c.cpf) {
			return 1;
		}
		return 0;
	}

}
