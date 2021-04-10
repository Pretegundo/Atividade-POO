package br.com.cotemig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PessoaJuridica extends Pessoa implements Identificavel<PessoaJuridica>, Comparavel<PessoaJuridica> {

	private String cnpj;
	private String nomeEmpresarial;
	private String nomeFantasia;

	public PessoaJuridica(String cnpj, String nomeEmpresarial, String nomeFantasia) {
		super();
		this.cnpj = cnpj;
		this.nomeEmpresarial = nomeEmpresarial;
		this.nomeFantasia = nomeFantasia;
	}

	// CONTA CORRENTE PESSOA JURIDICA
	private ArrayList<ContaCorrente> contaCorrenteList = new ArrayList<>();

	public void adicionarContaCorrente(ContaCorrente contaCorrente) {
		contaCorrenteList.add(contaCorrente);
		contaCorrente.setPessoaJuridica(this);
	}

	public List<ContaCorrente> getContaCorrente() {
		return Collections.unmodifiableList(contaCorrenteList);
	}

	@Override
	public void exibirIdentificaçaoENome() {
		System.out.println("Pessoa Juridica: ");
		System.out.println("CNPJ: " + cnpj);
		System.out.println("Nome Empresarial: " + nomeEmpresarial);

	}

	@Override
	public void exibirExtratoBancario() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		for (ContaCorrente contaCorrente : contaCorrenteList) {
			System.out.println("Saldo Atual: " + contaCorrente.getSaldo());
			List<HistoricoDeMovimentaçao> hList = contaCorrente.getHistoricoDeMovimentaçao();

			for (HistoricoDeMovimentaçao h : hList) {
				System.out.println("Tipo de Operação: " + h.getTipoOperaçao());
				System.out.println("Valor da Operação: " + h.getValor());
				System.out.println("Hora da Operação: " + f.format(h.getData().getTime()));
				System.out.println("- - - - - - - - - - - - - - - - - - - -");
			}

		}
	}

	// INTERFACE IDENTIFICAVEL
	@Override
	public void obterIdentificaçao(PessoaJuridica c) {
		System.out.println("CNPJ: " + c.cnpj);
		System.out.println("Nome Empresarial: " + c.nomeEmpresarial);
	}

	// INTERFACE COMPARAVEL
	@Override
	public int comparar(PessoaJuridica c) {
		if (this.cnpj == c.cnpj) {
			return 1;
		}
		return 0;
	}
}
