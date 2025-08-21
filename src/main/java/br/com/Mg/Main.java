package br.com.Mg;

import br.com.Mg.model.Funcionario;
import br.com.Mg.service.FuncionarioService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Main {
        public static void main(String[] args) {


            List<Funcionario> funcionarios = criarListaFuncionarios();
            FuncionarioService service = new FuncionarioService();


            System.out.println("3.1 – Lista inicial de funcionários:\n");
            funcionarios.forEach(System.out::println);
            printSeparator();

            System.out.println("3.2 – Removendo funcionário 'João' da lista.\n");
            service.removerFuncionario(funcionarios, "João");
            printSeparator();

            System.out.println("3.3 – Imprimir todos os funcionários com todas suas informações:\n");
            funcionarios.forEach(System.out::println);
            printSeparator();

            System.out.println("3.4 – Os funcionários receberam 10% de aumento de salário:\n");
            service.aplicarAumento(funcionarios, new BigDecimal("1.10"));
            funcionarios.forEach(System.out::println);
            printSeparator();

            System.out.println("3.5 e 3.6 – Funcionários agrupados por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários:\n");
            Map<String, List<Funcionario>> funcionariosPorFuncao = service.agruparPorFuncao(funcionarios);
            funcionariosPorFuncao.forEach((funcao, lista) -> {
                System.out.println("\nFunção: " + funcao);
                lista.forEach(System.out::println);
            });
            printSeparator();

            System.out.println("3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12:\n");
            List<Funcionario> aniversariantes = service.filtrarAniversariantes(funcionarios, Month.OCTOBER, Month.DECEMBER);
            aniversariantes.forEach(System.out::println);
            printSeparator();

            System.out.println("3.9 – Imprimir o funcionário com a maior idade:\n");
            service.obterFuncionarioMaisVelho(funcionarios).ifPresent(maisVelho -> {
                int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
                System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + idade);
            });
            printSeparator();

            System.out.println("3.10 – Imprimir a lista de funcionários por ordem alfabética:\n");
            List<Funcionario> funcionariosOrdenados = service.ordenarPorNome(funcionarios);
            funcionariosOrdenados.forEach(System.out::println);
            printSeparator();

            System.out.println("3.11 – Imprimir o total dos salários dos funcionários:\n");
            BigDecimal totalSalarios = service.calcularTotalSalarios(funcionarios);

            DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
            DecimalFormat formatarSalario = new DecimalFormat("#,##0.00", symbols);
            System.out.println("Total: " + formatarSalario.format(totalSalarios));
            printSeparator();

            System.out.println("3.12 – Imprimir quantos salários mínimos ganha cada funcionário (base: R$1212.00):\n");
            BigDecimal salarioMinimo = new BigDecimal("1212.00");
            Map<Funcionario, BigDecimal> mapaSalariosMinimos = service.calcularQuantidadeSalariosMinimos(funcionarios, salarioMinimo);
            mapaSalariosMinimos.forEach((funcionario, quantidade) -> {
                System.out.println(funcionario.getNome() + " ganha " + quantidade + " salários mínimos.");
            });
            printSeparator();
        }

    private static List<Funcionario> criarListaFuncionarios() {
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

        return funcionarios;
    }

    private static void printSeparator() {
        System.out.println("----------------------------------------------------------------\n");
    }
}
