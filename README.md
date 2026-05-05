# Teste Prático de Programação 

### Descrição
Considerando que uma indústria possui as pessoas/funcionários abaixo, você deve desenvolver um projeto Java para gerenciar seus dados.

### Tabela de Funcionários

| Nome      | Data de Nascimento | Salário      | Função        |
| :-------- | :----------------- | -----------: | :------------ |
| Maria     | 18/10/2000         | R$ 2.009,44  | Operador      |
| João      | 12/05/1990         | R$ 2.284,38  | Operador      |
| Caio      | 02/05/1961         | R$ 9.836,14  | Coordenador   |
| Miguel    | 14/10/1988         | R$ 19.119,88 | Diretor       |
| Alice     | 05/01/1995         | R$ 2.234,68  | Recepcionista |
| Heitor    | 19/11/1999         | R$ 1.582,72  | Operador      |
| Arthur    | 31/03/1993         | R$ 4.071,84  | Contador      |
| Laura     | 08/07/1994         | R$ 3.017,45  | Gerente       |
| Heloísa   | 24/05/2003         | R$ 1.606,85  | Eletricista   |
| Helena    | 02/09/1996         | R$ 2.799,93  | Gerente       |

---

### Requisitos

**1. Classes de Modelo**
- **Classe `Pessoa`** com os atributos: `nome` (String) e `dataNascimento` (LocalDate).
- **Classe `Funcionario`** que estenda `Pessoa`, com os atributos: `salario` (BigDecimal) e `funcao` (String).

**2. Classe Principal**
- Deve conter uma classe `Principal` para executar as seguintes ações:
    - **3.1 – Inserir** todos os funcionários, na mesma ordem e informações da tabela.
    - **3.2 – Remover** o funcionário “João” da lista.
    - **3.3 – Imprimir** todos os funcionários com todas as suas informações, sendo que:
        - Informação de data deve ser exibida no formato `dd/mm/aaaa`.
        - Informação de valor numérico deve ser exibida no formato com separador de milhar (ponto) e decimal (vírgula).
    - **3.4 – Aumentar o salário** dos funcionários em 10%.
    - **3.5 – Agrupar** os funcionários por função em um `MAP`.
    - **3.6 – Imprimir** os funcionários agrupados por função.
    - **3.8 – Imprimir** os funcionários que fazem aniversário nos meses 10 e 12.
    - **3.9 – Imprimir** o funcionário com a maior idade (nome e idade).
    - **3.10 – Imprimir** a lista de funcionários por ordem alfabética.
    - **3.11 – Imprimir** o total dos salários dos funcionários.
    - **3.12 – Imprimir** quantos salários mínimos ganha cada funcionário (salário mínimo: R$1212.00).

---

### Orientações Gerais
- Você poderá utilizar a ferramenta que tem maior domínio (exemplos: Eclipse, NetBeans, etc.).

**Boa sorte!**

---
### 🚀 Tecnologias Utilizadas
- **Java 21:** Versão da linguagem utilizada no projeto.
- **Maven:** Ferramenta de automação e gerenciamento de dependências.
- **Lombok:** Biblioteca para reduzir código boilerplate (getters, setters, construtores).


### ▶️ Como Executar o Projeto
Siga os passos abaixo para executar a aplicação a partir do terminal.

1. Clone o repositório (se estiver no Git) ou navegue até a pasta raiz do projeto.

2. Abra um terminal na pasta raiz do projeto (onde o arquivo **`pom.xml`** está localizado).

3. Compile o projeto usando o Maven:
   ```sh
   mvn compile
   ```

4. Execute a classe principal com o seguinte comando Maven:
   ```sh
   mvn exec:java
   ```

*Após a execução, todos os resultados das operações serão impressos diretamente no seu console.*
