#API de cadastro de anuncio
Calcule a quantidade max. de cliques, visualização e compartilhamento a partir de um determinado valor investido.

Rodando a aplicação:

```sh
Vá até o arquivo "CadastroApplication.java" que se encontra na pasta main e aperte a tecla F5.
```

Banco de dados H2:

```sh
Digite "http://localhost:8080/h2/login" em sua barra de endereço.
```

Login no banco de dados:

```sh
Drive Class: org.h2.Driver
JDBC URL: jdbc:h2:./data/anunciodb
User Name: sa
Password: 
```

##Testando a API:
| Endpoint | Método | Descrição | 
| -------- | ------ | --------- |
|/anuncio  |  POST  | Cadastre o anuncio e receba um relatório com uma especulação de alcance máximo que seu anuncio ira ter.

No corpo(body) do método POST:
```sh
{ "nome_anuncio": "Anuncio Teste", "cliente": "Cliente teste", "data_inicio": "2021-05-12","data_termino": "2021-05-15", "investimento_por_dia": 100 }
```		
Retorno esperado:
```sh
{ "id": 1, "nome_anuncio": "Anuncio Teste", "cliente": "Cliente teste", "data_inicio":"2021-05-11", "data_termino": "2021-05-14", "investimento_por_dia": 100.0, "relatorio": {"id": 2,"total_investido": 300.0, "qtd_max_visualizacao": 41400.0, "qtd_max_clique": 1080.0,"qtd_max_compartilhamento": 810.0, "qtd_vis_anuncio_original": 9000.0, qtd_clique_anuncio_original": 1080.0, "qtd_compartilhamento_original": 162.0,
    "qtd_novas_visualizacoes": 6480.0,"qtd_seq_compartilhamento": 648.0, "qtd_visu_por_anuncio":25920.0 } }
```

| Endpoint | Método | Descrição | 
| -------- | ------ | --------- |
| /anuncio/buscaCliente?cliente=cliente teste | GET | Busque no banco de dados pelo nome do cliente cadastrado.

