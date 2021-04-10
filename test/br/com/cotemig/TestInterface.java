package br.com.cotemig;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestInterface {

	// Teste Tributavel
	@Test
	void test1() {
		// setup
		ContaCorrente cc = new ContaCorrente(1000.0);
		// execution
		cc.cobrarTributo(10.0);
		// assert
		assertEquals(cc.getSaldo(), 990.0, 0.0001);
	}

	// Teste identifica��o pessoa fisica
	@Test
	void test2() {
		// setup
		PessoaFisica pf = new PessoaFisica("111", "aaa");
		// execution
		pf.obterIdentifica�ao(pf);
		// assert
	}

	// Teste identifica��o pessoa juridica
	@Test
	void test3() {
		// setup
		PessoaJuridica pj = new PessoaJuridica("111", "aaaa", "bbbb");
		// execution
		pj.obterIdentifica�ao(pj);
		// assert
	}

	// Teste comparavel pessoa fisica
	// Resultado n�o sao a mesma pessoa
	@Test
	void test4() {
		// setup
		PessoaFisica pf1 = new PessoaFisica("111", "aaa");
		PessoaFisica pf2 = new PessoaFisica("222", "bbb");
		// execution
		// assert
		if (pf1.comparar(pf2) == 1) {
			System.out.println("S�o a mesma pessoa");
		} else {
			System.out.println("N�o sao a mesma pessoa");
		}
	}

	// Teste comparavel pessoa fisica
	// Resultado sao a mesma pessoa
	@Test
	void test5() {
		// setup
		PessoaFisica pf1 = new PessoaFisica("111", "aaa");
		PessoaFisica pf2 = new PessoaFisica("111", "bbb");
		// execution
		// assert
		if (pf1.comparar(pf2) == 1) {
			System.out.println("S�o a mesma pessoa");
		} else {
			System.out.println("N�o sao a mesma pessoa");
		}
	}

	// Teste comparavel pessoa juridica
	// Resultado n�o s�o a mesma pessoa
	@Test
	void test6() {
		// setup
		PessoaJuridica pj1 = new PessoaJuridica("111", "aaa", "aaa");
		PessoaJuridica pj2 = new PessoaJuridica("222", "bbb", "aaa");
		// execution
		// assert
		if (pj1.comparar(pj2) == 1) {
			System.out.println("S�o a mesma pessoa");
		} else {
			System.out.println("N�o sao a mesma pessoa");
		}
	}

	// Teste comparavel pessoa juridica
	// Resultado s�o a mesma pessoa
	@Test
	void test7() {
		// setup
		PessoaJuridica pj1 = new PessoaJuridica("111", "aaa", "aaa");
		PessoaJuridica pj2 = new PessoaJuridica("111", "bbb", "aaa");
		// execution
		// assert
		if (pj1.comparar(pj2) == 1) {
			System.out.println("S�o a mesma pessoa");
		} else {
			System.out.println("N�o sao a mesma pessoa");
		}
	}

}
