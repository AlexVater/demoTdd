package com.projetocomtdd.demoTdd;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoasTest {


    @Test
    public void canary(){
        Assertions.assertThat(true).isTrue();
    }

    @Test
    public void shouldCreateCadastroDePessoaas(){
        CadastroPessoas cadastro = new CadastroPessoas();
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    public void shouldAddOnePessoa(){
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Alex");
        cadastro.adicionar(pessoa);

        Assertions.assertThat(cadastro.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test(expected = PessoaSemNomeException.class)
    public void naoDeveAdicionarPessoaComNomeVazio(){
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        cadastro.adicionar(pessoa);
    }

    @Test
    public void  deveRemoverUmaPessoa(){
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Carlos");

        cadastro.adicionar(pessoa);

        cadastro.remover(pessoa);

        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test(expected = CadastroVazioException.class)
    public void deveLancarErrAoTentarRemoverPessoaInexistente(){
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        cadastro.remover(pessoa);
    }

 }
