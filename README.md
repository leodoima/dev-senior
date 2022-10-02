# Dev-Senior 🟢
Desafio de desenvolvimento em código **Java**
<br>
<br>
<br>
### Objetivo 🚀
Criar um ambiente para cadastramento de produtos/serviços, pedidos de vendas e itens para os pedidos de venda.
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
Antes de iniciar o consumo desta aplicação, faz-se necessário ter instalado em sua máquina o Java em uma versão 8+, o [Maven](https://maven.apache.org/) para download das dependências e também o [PostgreSQL](https://www.postgresql.org/) para armazenamento das informações geradas.
<br>
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
<br>

### Rotas / Recursos 🔨
<br>

- **<span style="color:green;">Product</span>** <br><br>
[GET] **/products/:id** - exibe produto específico; <br>
[GET] **/products/list** - lista todos os produtos com paginação; <br>
[POST] **/products/** - insere produto; <br>
[PUT] **/products/** - altera produto; <br>
[DELETE] **/products/** - deleta produto; <br><br>

- **<span style="color:green;">SalesOrder</span>** <br><br>
[GET] **/orders/:id** - exibe pedido específico; <br>
[GET] **/orders/list** - lista todos os pedidos com paginação; <br>
[POST] **/orders/** - insere pedido; <br>
[PUT] **/orders/** - altera pedido; <br>
[DELETE] **/orders/** - deleta pedido; <br><br>

- **<span style="color:green;">SalesItens</span>** <br><br>
[GET] **/itens/:id** - exibe item específico; <br>
[GET] **/itens/list** - lista todos os itens com paginação; <br>
[POST] **/itens/** - insere item; <br>
[PUT] **/itens/** - altera item; <br>
[DELETE] **/itens/** - deleta item; <br><br>

Para testes fora adicionado arquivo .json do Insomnia para execução das rotas acima, no menu Main > Resources > Templates.