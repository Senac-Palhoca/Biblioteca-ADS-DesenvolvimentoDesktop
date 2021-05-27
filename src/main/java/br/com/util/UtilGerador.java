/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

/**
 * @author Felipe
 */
public class UtilGerador {

    public static String gerarCaracter(int qtdLetra) {
        String palavra = "";
        int indice;
        String[] minusculas = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        String[] maiusculas = {"A", "B", "C",
            "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

        indice = (int) (Math.random() * maiusculas.length);
        palavra += maiusculas[indice];

        for (int i = 0; i < qtdLetra - 1; i++) {
            indice = (int) (Math.random() * minusculas.length);
            palavra += minusculas[indice];
        }
        return palavra;
    }

    public static String gerarNome() {
        String nome;
        int indice;
        String[] nomes = {"João", "Maria", "Beatriz", "Antonio", "Jefferson", ""
            + "Silvio", "Tatiana", "Sueli", "Joana", "Camilla", "Kelly",
            "Felipe", "Vinicius", "Marcos", "Pedro", "Marcelo", "Henrique"};
        indice = (int) (Math.random() * nomes.length);
        nome = nomes[indice] + " " + gerarSobreNome();
        return nome;
    }

    private static String gerarSobreNome() {
        String sobrenome;
        int indice;
        String[] nomes = {"Silva", "Motto", "Ribeiro", "Souza", "Araujo", "May",
            "junior", "Cionette", "Aurelio", "Pereira", "Oliveira", "Matos",
            "Barbosa", "Nascimento"};
        indice = (int) (Math.random() * nomes.length);
        sobrenome = nomes[indice];
        return sobrenome;
    }

    public static String gerarCodigoLivro() {
        return gerarCaracter(3) + gerarNumero(6);
    }

    public static String gerarTitulo() {
        String sobrenome;
        int indice;
        String[] nomes = {"Use a Cabeça - Java", "Pequenos incêndios por toda parte", "Dom Quixote", "Guerra e Paz", "A Montanha Mágica", "Cem Anos de Solidão",
            "Em Busca do Tempo Perdido", "A Divina Comédia", "O Homem sem Qualidades", "O Som e a Fúria", "Orgulho e Preconceito", "Os Lusíadas"};
        indice = (int) (Math.random() * nomes.length);
        sobrenome = nomes[indice];
        return sobrenome;
    }

    public static String gerarEditora() {
        String sobrenome;
        int indice;
        String[] nomes = {"Companhia da Letras", "Aleph", "Suma", "Editora Intrínseca", "Grupo Editorial Record", "Editora Rocco",
            "Globo Livros", "Darkside Books", "Harper Collins"};
        indice = (int) (Math.random() * nomes.length);
        sobrenome = nomes[indice];
        return sobrenome;
    }

    public static String gerarCidade() {
        String cidade;
        int indice;
        String[] cidades = {"Florianópolis", "São José", "Palhoça", "São Bento",
            "Biguaçu", "Curitiba", "Urupema", "Tijucas", "Balneário", "Santo Antonio"};
        indice = (int) (Math.random() * cidades.length);
        cidade = cidades[indice];
        return cidade;
    }

    public static String gerarNumero(int qtd) {
        String numero = "";
        for (int i = 0; i < qtd; i++) {
            numero += (int) (Math.random() * 10);
        }
        return numero;
    }

    public static String gerarEmail() {
        return gerarCaracter(8) + "@email.com";
    }

    public static String gerarTelefoneFixo() {
        // (48)3541-1132
        return "(48)3" + gerarNumero(3) + "-" + gerarNumero(4);
    }

    public static int criarNumeroEntre2Valores(int menor, int maior) {
        int numero = (int) (Math.random() * (maior - menor));

        if (numero == 0) {
            numero++;
        }
        numero = numero + menor;

        return numero;
    }

    private static String gerarLetraPlaca() {
        String letra = "";
        String[] maiusculas = {"A", "B", "C",
            "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};
        for (int i = 0; i < 3; i++) {
            letra += maiusculas[(int) (Math.random() * maiusculas.length)];
        }
        return letra;
    }

    public static String gerarTipoVeiculo() {
        String[] tipos = {"Moto", "Automóvel", "Caminhão", "Ônibus"};
        String tipoVeiculo = tipos[(int) (Math.random() * tipos.length)];
        return tipoVeiculo;
    }

    public static String gerarPlaca() {
        String placa = gerarLetraPlaca() + "-" + gerarNumero(4);
        return placa;
    }
}
