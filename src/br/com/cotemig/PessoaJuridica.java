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
	public void exibirIdentifica�aoENome() {
		System.out.println("Pessoa Juridica: ");
		System.out.println("CNPJ: " + cnpj);
		System.out.println("Nome Empresarial: " + nomeEmpresarial);

	}

	@Override
	public void exibirExtratoBancario() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		for (ContaCorrente contaCorrente : contaCorrenteList) {
			System.out.println("Saldo Atual: " + contaCorrente.getSaldo());
			List<HistoricoDeMovimenta�ao> hList = contaCorrente.getHistoricoDeMovimenta�ao();

			for (HistoricoDeMovimenta�ao h : hList) {
				System.out.println("Tipo de Opera��o: " + h.getTipoOpera�ao());
				System.out.println("Valor da Opera��o: " + h.getValor());
				System.out.println("Hora da Opera��o: " + f.format(h.getData().getTime()));
				System.out.println("- - - - - - - - - - - - - - - - - - - -");
			}

		}
	}

	// INTERFACE IDENTIFICAVEL
	@Override
	public void obterIdentifica�ao(PessoaJuridica c) {
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
