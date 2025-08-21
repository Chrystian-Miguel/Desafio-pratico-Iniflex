package br.com.Mg.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Getter
@Setter
public class Funcionario extends Pessoa{

    private BigDecimal salarioBruto;
    private String funcaoExercida;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salarioBruto, String funcaoExercida) {

        super(nome, dataNascimento);
        this.salarioBruto = salarioBruto;
        this.funcaoExercida = funcaoExercida;
    }

    public String toString() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = super.getDataNascimento().format(formatoData);

        DecimalFormatSymbols Simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat formatterSalario = new DecimalFormat("#,##0.00", Simbolos);
        String salarioFormatado = formatterSalario.format(this.salarioBruto);

        return "Funcionario {" +
                "nome = '" + super.getNome() + '\'' +
                ", dataNascimento = " + dataFormatada +
                ", salario = " + salarioFormatado +
                ", funcao = '" + this.funcaoExercida + '\'' +
                '}';
    }
}
