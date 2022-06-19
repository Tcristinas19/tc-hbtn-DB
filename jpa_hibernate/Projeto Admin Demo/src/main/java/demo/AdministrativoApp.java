package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.time.LocalDate;
import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();
        List<Produto> produtos = null;
        List<Pessoa> pessoas = null;

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        Produto p2 = new Produto();
        p2.setNome("Violão");
        p2.setPreco(450.0);
        p2.setQuantidade(98);
        p2.setStatus(false);

        // 1) Criando os produto
        System.out.println("Criando Produto");
        produtoModel.create(p1);
        produtoModel.create(p2);
        produtos = produtoModel.findAll();
        printProdutos(produtos);

        //2) Buscando todos os produtos na base de dados
        System.out.println("Buscando Todos os Produtos");
        produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());
        printProdutos(produtos);

        //3) Update produto status to false do p1
        System.out.println("Atualizando Status do Produto 1 de True para False");
        p1.setId(1);
        p1.setStatus(false);
        produtoModel.update(p1);
        produtos = produtoModel.findAll();
        printProdutos(produtos);

        //4) Deletando o produto com ID 2
        System.out.println("Deletando o Produto com ID 2");
        p2.setId(2);
        produtoModel.delete(p2);
        produtos = produtoModel.findAll();
        printProdutos(produtos);

        //5) Buscando o produto com ID 1
        System.out.println("Buscando o Produto com ID 1");
        p1.setId(1);
        Produto p = new Produto();
        p = produtoModel.findById(p1);
        System.out.println("ID: " + p.getId() +
                " Nome: " + p.getNome() +
                " Preco: " + p.getPreco() +
                " Quantidade: " + p.getQuantidade() +
                " Status: " + p.isStatus());

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Gabrielly");
        pessoa1.setEmail("gabs@g.c");
        pessoa1.setIdade(21);
        pessoa1.setCpf("111.111.111-11");
        pessoa1.setdataDeNascimento(LocalDate.of(2001, 1, 23));

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Isabela");
        pessoa2.setEmail("isa@g.c");
        pessoa2.setIdade(28);
        pessoa2.setCpf("222.222.222-22");
        pessoa2.setdataDeNascimento(LocalDate.of(1994, 3, 1));

        // 1) Criando as pessoas
        System.out.println("Criando Pessoa");
        pessoaModel.create(pessoa1);
        pessoaModel.create(pessoa2);
        pessoas = pessoaModel.findAll();
        printPessoas(pessoas);

        //2) Buscando todas as pessoas na base de dados
        System.out.println("Buscando Todas as Pessoas");
        pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());
        printPessoas(pessoas);

        //3) Update pessoa CPF
        System.out.println("Atualizando o CPF da pessoa 2");
        pessoa2.setId(2);
        pessoa2.setCpf("222.222.222-33");
        pessoaModel.update(pessoa2);
        pessoas = pessoaModel.findAll();
        printPessoas(pessoas);

        //4) Deletando a pessoa com ID 1
        System.out.println("Deletando a pessoa com ID 1");
        pessoa1.setId(1);
        pessoaModel.delete(pessoa1);
        pessoas = pessoaModel.findAll();
        printPessoas(pessoas);

        //5) Buscando a pessoa com ID 2
        System.out.println("Buscando a pessoa com ID 2");
        pessoa2.setId(2);
        Pessoa pessoa = new Pessoa();
        pessoa = pessoaModel.findById(pessoa2);
        System.out.println("ID: " + pessoa.getId() +
                " Nome: " + pessoa.getNome() +
                " Idade: " + pessoa.getIdade() +
                " CPF: " + pessoa.getCpf() +
                " Data de Nascimento: " + pessoa.getdataDeNascimento());
    }

    public static void printProdutos(List<Produto> produtos){
        produtos.forEach(produto -> {
            System.out.println("ID: " + produto.getId() +
                    " Nome: " + produto.getNome() +
                    " Preco: " + produto.getPreco() +
                    " Quantidade: " + produto.getQuantidade() +
                    " Status: " + produto.isStatus());
        });
    }

    public static void printPessoas(List<Pessoa> pessoas){
        pessoas.forEach(pessoa -> {
            System.out.println("ID: " + pessoa.getId() +
                    " Nome: " + pessoa.getNome() +
                    " Idade: " + pessoa.getIdade() +
                    " CPF: " + pessoa.getCpf() +
                    " Data de Nascimento: " + pessoa.getdataDeNascimento());
        });
    }
}