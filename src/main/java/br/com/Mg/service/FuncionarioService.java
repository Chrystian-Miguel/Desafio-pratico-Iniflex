package br.com.Mg.service;

import br.com.Mg.model.Funcionario;
import br.com.Mg.model.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {


    public void removerFuncionario(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(f -> f.getNome().equals(nome));
    }


    public void aplicarAumento(List<Funcionario> funcionarios, BigDecimal fatorAumento) {
        funcionarios.forEach(f -> f.setSalarioBruto(f.getSalarioBruto().multiply(fatorAumento)));
    }


    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncaoExercida));
    }


    public List<Funcionario> filtrarAniversariantes(List<Funcionario> funcionarios, Month... meses) {
        List<Month> mesesList = Arrays.asList(meses);
        return funcionarios.stream()
                .filter(f -> mesesList.contains(f.getDataNascimento().getMonth()))
                .collect(Collectors.toList());
    }


    public Optional<Funcionario> obterFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .min(Comparator.comparing(Pessoa::getDataNascimento));
    }


    public List<Funcionario> ordenarPorNome(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .collect(Collectors.toList());
    }


    public BigDecimal calcularTotalSalarios(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(Funcionario::getSalarioBruto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<Funcionario, BigDecimal> calcularQuantidadeSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        return funcionarios.stream()
                .collect(Collectors.toMap(funcionario -> funcionario,
                        funcionario -> funcionario.getSalarioBruto().divide(salarioMinimo, 2, RoundingMode.HALF_UP),
                        (valorExistente, novoValor) -> valorExistente,
                        LinkedHashMap::new
                ));

    }
}

