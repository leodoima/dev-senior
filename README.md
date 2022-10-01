# Dev-Senior 🟢
Desafio de desenvolvimento em código **Java**
<br>
<br>
<br>
### Objetivo 🚀
Criar um ambiente para cadatramento de produtos/serviços, pedidos de vendas e itens para os pedidos de venda.
<br>
<br>
<br>
**Classes / Tabelas** <br>
- **Product** - armazenamento de informações de produtos e serviços
- **SalesOrder** - pedidos de venda realizados
- **SalesItem** - itens contidos nos pedidos de vendas
<br>
<br>
### Tecnologias 🔧
Os seguintes recursos foram utilizados para construção desta aplicação:

- Java 8+
- Maven 
- Spring
- PostgreSQL
- JPA
<br>
<br>
### Pré-requisitos 🗒️
Antes de iniciar o consumo desta aplicação, faz-se necessário ter instalado em sua máquina o Java em uma versão 8+, ter instalado o [Maven](https://maven.apache.org/) para download das dependências e também o [PostgreSQL](https://www.postgresql.org/).
<br>
<br>

### Rodando a aplicação 🏈

```bash
# Clonar o repositório
$ git clone https://github.com/leodoima/dev-senior.git

# Ir para a pasta raiz do projeto
$ cd dev-senior

# Instalando as dependências
$ mvn install

# Executar a aplicação
$ mvn spring-boot:run

# Caso queira saber se a aplicação está rodando
$ http://localhost:8080/
```
<br>

### Rotas / Recursos 🔨
<br>

- **<span style="color:green;">Product</span>** <br><br>
**[GET] /products/:id** - exibe item específico da lista de itens; <br>
**[GET] /products/list** - lista todos os itens armazenados no sistema; <br>
**[POST] /products/** - insere um novo produto; <br><br>

- **<span style="color:green;">SalesOrder</span>** <br><br>
    **[GET] /products/:id** - exibe item específico da lista de itens; <br>
    **[GET] /products/list** - lista todos os itens armazenados no sistema; <br>
    **[POST] /products/** - insere um novo produto; <br><br>

- **<span style="color:green;">SalesOrder</span>** <br><br>
  **[GET] /products/:id** - exibe item específico da lista de itens; <br>
  **[GET] /products/list** - lista todos os itens armazenados no sistema; <br>
  **[POST] /products/** - insere um novo produto; <br><br>