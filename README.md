<div id="top"></div>
  <h2 align="center">Desafio Pub Future </h2>
  <p align="center"> Projeto de finanças pessoais desenvolvido para o desafio Pub Future </p
 


### Ferramentas utilizadas: 
- Java 17+
- PostgreSQL 12+
- Spring Boot 2.6.2+
- Maven 3.8.4+
- Docker
- Docker Compose 3.6+



## Requisitos do desafio:
### Receitas
- [x] Cadastrar receitas 
- [x] Editar receitas 
- [x] Remover receitas 
- [x] Listar receitas 
    - [x] Filtro por período (dataInicial – dataFinal) 
    - [x] Filtro por tipo de receita 
- [x] Listar total de receitas 
### Despesas
- [x] Cadastrar despesas 
- [x] Editar despesas 
- [x] Remover despesas 
- [x] Listar despesas 
    - [x] Filtro por período (dataInicial – dataFinal) 
    - [x] Filtro por tipo de despesa 
- [x] Listar total de despesas 
### Contas
- [x] Cadastrar conta 
- [x] Editar conta 
- [x] Remover conta 
- [x] Listar contas 
- [x] Transferir saldo entre contas 
- [x] Listar saldo total 


## Endpoints
### Contas
`GET /contas/getall`
Lista todas as contas salvas.

`POST /contas/new`
Cria uma nova conta com os dados do corpo da requisição.

**Body:**
```json
{
    "saldo": 1000,
    "instituicaoFinanceira": "INTER",
    "tipoConta": "CONTA_CORRENTE"
}
```

`POST /contas/update/{id}`
Atualiza os dados da conta {id} com os dados do corpo da requisição.

**Body:**
```json
{
    "saldo": 800,
    "instituicaoFinanceira": "NUBANK",
    "tipoConta": "CONTA_CORRENTE"
}
```


`DELETE /contas/delete/{id}`
Deleta a conta {id}.

`PUT /contas/transferir/{idOrigem}/{idDestino}/{valor}`
transfere {valor} entre duas contas {idOrigem} e {idDestino}.
- `idOrigem` a conta de onde irá sair o dinheiro.
- `idDestino` a conta para onde irá o dinheiro.
- `valor` o valor da transferencia.

`GET /contas/total`
Retorna o saldo total.


### Receitas
`GET /receitas/getall`
Lista todas as receitas salvas.

`GET /receitas/total`
Retorna o total de receitas.

`GET /receitas/findByPeriod/{dataInicio}/{dataFim}`
Listas as receitas que estão entre o período {dataInicio} e {dataFim}.
- `dataInicio` a data inicial do período da busca.
- `dataFim` a data final do período da busca.

`GET /receitas/type={tipoReceita}`
Listas as receitas que são do {tipoReceita}.
- `tipoReceita` O tipo da receita (salário, presente, prêmio, outros).

`POST /receitas/new`
Cria uma nova receita com os dados do corpo da requisição.

**Body:**
```json
{
	"valor": 1000.00,
	"dataRecebimento": "16/01/2022",
	"dataRecebimentoEsperado": "20/01/2022",
	"descricao":"Aluguel",
	"contaId": 1,
	"tipoReceita": "OUTROS"
}
```

`POST /receitas/update/{id}`
Atualiza os dados da receita {id} com os dados do corpo da requisição.

**Body:**
```json
{
	"valor": 1000.00,
	"dataRecebimento": "15/01/2022",
	"dataRecebimentoEsperado": "20/01/2022",
	"descricao":"Aluguel",
	"contaId": 2,
	"tipoReceita": "OUTROS"
}
```


`DELETE /receitas/delete/{id}`
Deleta a receita {id}.

### Despesas
`GET /despesas/getall`
Lista todas as despesas salvas.

`GET /despesas/total`
Retorna o total de despesas.

`GET /despesas/findByPeriod/{dataInicio}/{dataFim}`
Listas as despesas que estão entre o período {dataInicio} e {dataFim}.
- `dataInicio` a data inicial do período da busca.
- `dataFim` a data final do período da busca.

`GET /despesas/type={tipoDespesa}`
Listas as despesas que são do {tipoDespesa}.
- `tipoDespesa` O tipo da receita (alimentação, educação, lazer, moradia, roupa, saúde, transporte, outros).

`POST /despesas/new`
Cria uma nova despesa com os dados do corpo da requisição.

**Body:**
```json
{
	"valor": 21.49,
	"dataPagemento": "16/01/2022",
	"dataPagementoEsperado": "20/01/2022",
	"contaId": 1,
	"tipoDespesa": "alimentação"
}
```

`POST /despesas/update/{id}`
Atualiza os dados da despesa {id} com os dados do corpo da requisição.

**Body:**
```json
{
	"valor": 22.49,
	"dataPagemento": "16/01/2022",
	"dataPagementoEsperado": "16/01/2022",
	"contaId": 1,
	"tipoDespesa": "alimentação"
}
```

`DELETE /despesas/delete/{id}`
Deleta a despesa {id}.

