package br.com.Mg;

import br.com.Mg.model.Funcionario;
import br.com.Mg.model.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
        public static void main(String[] args) {

            List<Funcionario> funcionarios = new ArrayList<>();


            funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, Month.OCTOBER, 18), new BigDecimal("2009.44"), "Operador"));
            funcionarios.add(new Funcionario("João", LocalDate.of(1990, Month.MAY, 12), new BigDecimal("2284.38"), "Operador"));
            funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, Month.MAY, 2), new BigDecimal("9836.14"), "Coordenador"));
            funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, Month.OCTOBER, 14), new BigDecimal("19119.88"), "Diretor"));
            funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, Month.JANUARY, 5), new BigDecimal("2234.68"), "Recepcionista"));
            funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, Month.NOVEMBER, 19), new BigDecimal("1582.72"), "Operador"));
            funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, Month.MARCH, 31), new BigDecimal("4071.84"), "Contador"));
            funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, Month.JULY, 8), new BigDecimal("3017.45"), "Gerente"));
            funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, Month.MAY, 24), new BigDecimal("1606.85"), "Eletricista"));
            funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, Month.SEPTEMBER, 2), new BigDecimal("2799.93"), "Gerente"));

            System.out.println("3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.\n");
            funcionarios.forEach(System.out::println);
            System.out.println("----------------------------------------------------------------\n");


            System.out.println("3.2 – Removendo funcionário 'João' da lista.");
            funcionarios.removeIf(f -> f.getNome().equals("João"));
            System.out.println("----------------------------------------------------------------\n");


            System.out.println("3.3 – Imprimir todos os funcionários com todas suas informações. \n");
            funcionarios.forEach(System.out::println);
            System.out.println("----------------------------------------------------------------\n");


            System.out.println("3.4 – Os funcionários receberam 10% de aumento de salário.\n");
            BigDecimal aumento = new BigDecimal("1.10");
            funcionarios.forEach(f -> f.setSalarioBruto(f.getSalarioBruto().multiply(aumento)));
            funcionarios.forEach(System.out::println);
            System.out.println("----------------------------------------------------------------\n");


            System.out.println("3.5 e 3.6 – Funcionários agrupados por função MAP, sendo a chave a “função” e o valor a “lista de funcionários.” \n");

            Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                    .collect(Collectors.groupingBy(Funcionario::getFuncaoExercida));

            funcionariosPorFuncao.forEach((funcao, lista) -> {
                System.out.println("\nFunção: " + funcao);
                lista.forEach(System.out::println);
            });
            System.out.println("----------------------------------------------------------------\n");


            System.out.println("3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.\n");
            funcionarios.stream()
                    .filter(f -> f.getDataNascimento()
                            .getMonth() == Month.OCTOBER || f.getDataNascimento().getMonth() == Month.DECEMBER)
                    .forEach(System.out::println);
            System.out.println("----------------------------------------------------------------\n");


            System.out.println("3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.\n");
            Funcionario maisVelho = funcionarios.stream()
                    .min(Comparator.comparing(Pessoa::getDataNascimento))
                    .orElse(null);

            if (maisVelho != null) {
                int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
                System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + idade);
            }
            System.out.println("----------------------------------------------------------------\n");


            System.out.println("3.10 – Imprimir a lista de funcionários por ordem alfabética.\n");
            funcionarios.stream()
                    .sorted(Comparator.comparing(Pessoa::getNome))
                    .forEach(System.out::println);
            System.out.println("----------------------------------------------------------------\n");


            System.out.println("3.11 – Imprimir o total dos salários dos funcionários.\n");
            BigDecimal totalSalarios = funcionarios.stream()
                    .map(Funcionario::getSalarioBruto)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);


            DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
            DecimalFormat formatterSalario = new DecimalFormat("#,##0.00", symbols);
            System.out.println("Total: " + formatterSalario.format(totalSalarios));
            System.out.println("----------------------------------------------------------------\n");


            System.out.println("3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.\n");
            BigDecimal salarioMinimo = new BigDecimal("1212.00");
            funcionarios.forEach(f -> {
                BigDecimal quantidadeSalariosMinimos = f.getSalarioBruto().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
                System.out.println(f.getNome() + " ganha " + quantidadeSalariosMinimos + " salários mínimos.");
            });
            System.out.println("----------------------------------------------------------------\n");

        }
    }