# Gestão de Tarefas - Automação de Testes

Este projeto contém testes automatizados para uma aplicação de gestão de tarefas, focando nos módulos de Login, Registro e Projetos.

## 🔗 Tecnologias Utilizadas

  * **Java**
  * **Maven**
  * **Selenium Java**
  * **WebDriverManager**
  * **JUnit 5 (Jupiter API)**

## 🛠️ Configuração do Projeto

### 1\. Pré-requisitos

Certifique-se de ter o seguinte software instalado:

  * **Java Development Kit (JDK) 17 ou superior**
  * **Apache Maven 3.x ou superior**
  * **Um navegador compatível com Selenium WebDriver**

### 2\. Clone o Repositório

```bash
git clone https://github.com/Sayonarakeroll/Gestao_Tarefas_Test_bot.git
cd GestaoTarefas-automation
```

### 3\. Instalar Dependências

Navegue até o diretório raiz do projeto (`GestaoTarefas-automation`) e execute o Maven para baixar as dependências:

```bash
mvn clean install
```

### 4\. Executar os Testes

Para executar todos os testes, utilize o seguinte comando Maven no diretório raiz do projeto:

```bash
mvn test
```

Os testes executados no Google Chrome (gerenciado automaticamente pelo WebDriverManager).



## 🌐 URL da Aplicação Testada

Os testes são configurados para interagir com uma aplicação web local, geralmente acessível em:

```
http://localhost:5173/login
```
