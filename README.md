# Consultoria Application 📊💼

Bem-vindo ao projeto Consultoria Application! Este projeto é uma aplicação Spring Boot desenvolvida para gerenciar formulários de contato e mensagens de integridade para uma empresa de consultoria. 🚀

## Estrutura do Projeto 🏗️

O projeto está organizado nas seguintes camadas:

- **configs**: Configurações de inicialização e configuração do Swagger.
    - `swagger/WebConfig`

- **controller**: Controladores responsáveis por lidar com as requisições HTTP.
    - `BlogController`
    - `FormController`
    - `IntegrityMessageController`
    - `LandController`
    - `TrabalheConoscoController`

- **exception**: Tratamento de exceções personalizadas.
    - `ErrorResponse`
    - `GlobalExceptionHandler`
    - `ResourceNotFoundException`

- **model**: Modelos de dados utilizados pela aplicação.
    - `Form`
    - `IntegrityMessage`
    - `LandingPage`
    - `TrabalheConosco`

- **repository**: Interfaces de repositório para acesso aos dados.
    - `FormRepository`
    - `IntegrityMessageRepository`

- **service**: Serviços que contêm a lógica de negócios.
    - `BlogService`
    - `EmailService`
    - `FormService`
    - `IntegrityMessageService`

- **validation**: Classes de validação e anotações personalizadas.
    - `ConsultoriaApplication`

- **resources**: Recursos estáticos e arquivos de configuração.
    - `uploads/logo.png`
    - `application.properties`
    - `messages.properties`

## Aplication Properties.
    - `Lembre-se de alterar os campos para o seu de uso pessoal.
    - `spring.mail.username= email@email.com
    - `spring.mail.password=sua chave aqui
    - `blogger.api.key=aqui vai sua api key
    - `blogger.blog.id=00000

## Funcionalidades do Projeto 🛠️ e segurança 🔒

- **Sistema XSS Prevention**: Implementado para prevenir ataques XSS através de formulários no site da empresa. 🔒
- **Blog**: A parte do blog é gerenciada por um aplicativo paralelo externo. 🔒
- **Segurança**: O blog é acessado atraves de uma API KEY do próprio usuario diretamente no google, dessa forma se mantém a integridade do cliente e de seus dados pessoais. 🔒

## Testes 🧪

O projeto conta com uma cobertura de testes abrangente para garantir a qualidade e a robustez do sistema. Os testes incluem: (A parte dos testes deve que ser removida, mais continua no privado, a ferramente RENDER não autorizava seu uso para o deploy) 

- `FormControllerTest`
- `FormRepositoryTest`
- `EmailServiceTest`
- `FormServiceTest`
- `TrabalheConoscoControllerTest`

## Como Rodar o Projeto com Docker 🐳

Para executar o projeto utilizando Docker, siga os passos abaixo:

### Pré-requisitos

- `Docker`
- `Docker Compose`

### Passos para Rodar

1. **Clone o repositório**:

```
git clone https://github.com/seu-usuario/consultoria-application.git
cd consultoria-application
```

2. **Construa a imagem Docker**:
```
docker build -t consultoria-application .
```

3. **Suba o container Docker**:

```
docker run -p 8080:8080 consultoria-application
```

4. **Acesse a aplicação**:
   
Abra seu navegador e vá para http://localhost:8080


## Configuração com Docker Compose

Se você estiver usando Docker Compose, pode usar o arquivo docker-compose.yml para simplificar o processo. Certifique-se de que o Docker Compose está instalado.

1. **Crie um arquivo docker-compose.yml na raiz do projeto com o seguinte conteúdo**:

```
version: '3.8'
services:
  app:
    image: consultoria-application
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://dpg-cqhlcgg8fa8c73bu74e0-a.oregon-postgres.render.com/domus
      - SPRING_DATASOURCE_USERNAME=root
      - SPRING_DATASOURCE_PASSWORD=a8QWvTmCgv0nAvgMcOBBPv1sVVsp81Rq
      - SPRING_MAIL_HOST=smtp.gmail.com
      - SPRING_MAIL_PORT=587
      - SPRING_MAIL_USERNAME=bakendteste@gmail.com
      - SPRING_MAIL_PASSWORD=luih qbqx fxsn wmsp
```

2. **Suba os serviços com Docker Compose**:
```
docker-compose up
```

3. **Acesse a aplicação**:
Abra seu navegador e vá para `http://localhost:8080`

## Configurações de Ambiente

Você pode configurar as propriedades da aplicação no arquivo application.properties localizado em src/main/resources. Certifique-se de ajustar as configurações de acordo com o seu ambiente.

## Variáveis de Ambiente

Para configurar variáveis de ambiente, você pode criar um arquivo .env na raiz do projeto com as seguintes variáveis:

```
# Exemplo de variáveis de ambiente
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/consultoria
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=1234
EMAIL_SERVICE_API_KEY=your-email-service-api-key
```

## Como Rodar o Projeto em Outra Máquina 🖥️

Para executar o projeto em outra máquina, siga os passos abaixo:

### Pré-requisitos

- Java 11 ou superior
- Maven 3.6.0 ou superior
- Git
- IDE Utilizada Intelij Ultimate (Pode ser uma IDE de sua preferência)
- Postman (Ou outra de sua preferência)
- Beekeper (Para simular o banco de dados no projeto usei o banco de dados postgres virtual)

### Passos para Rodar

1. **Clone o repositório**:

    ```bash
    git clone https://github.com/seu-usuario/consultoria-application.git
    cd consultoria-application
    ```

2. **Compile o projeto**:

    ```bash
    mvn clean install
    ```

3. **Execute a aplicação**:

    ```bash
    mvn spring-boot:run
    ```

4. **Acesse a aplicação**:

   Abra seu navegador e vá para `http://localhost:8080`

### Configurações de Ambiente

Você pode configurar as propriedades da aplicação no arquivo `application.properties` localizado em `src/main/resources`. Certifique-se de ajustar as configurações de acordo com o seu ambiente.

### Variáveis de Ambiente

Para configurar variáveis de ambiente, você pode criar um arquivo `.env` na raiz do projeto com as seguintes variáveis:

```
# Exemplo de variáveis de ambiente
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/consultoria
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=1234
EMAIL_SERVICE_API_KEY=your-email-service-api-key

```

Feito e desenvolvido por Douglas Larré

### Como rodar o projeto:
```
- **Clonar o repositório**:

  bash
  git clone https://github.com/seu-usuario/consultoria-application.git
  cd consultoria-application
```

- **Compilar o projeto:**
```
  mvn clean install
```

- **Executar a aplicação:**
```
  mvn spring-boot:run
```

- **Acessar a aplicação:**

  Abra seu navegador e vá para http://localhost:8080.

Seguindo esses passos, você poderá rodar o projeto em outra máquina sem problemas. Boa sorte! 🚀✔️

## Observação.

A ferramenta blogger utilizada no projeto é opcional, ela é uma ferramenta de administração de blog, para postagens e compartilhamento. Fica a criterio do cliente ou usuário o seu uso.

Abaixo deixarei alguns tópicos do seu uso.

- Ganho de tempo
- Facilidade para postar em qualquer lugar do planeta, com acesso a internet
- Automação nas postagens
- Manutenção rápida e fácil
- Gerenciamento de postagens e exclusão em somente 1 local
- Rápida integração entre o site e o blog
- Segurança de dados e informação
- Utilizado API KEY google para vincular o site a API do blog
- Sem burocracia no gerencimento de e-mail
- Possibilidade de ganhar dinheiro com seu blog $$$
- Entre outras opções.
