Este é o resultado final que consegui atingir nesses 7 dias, certamente com um pouco mais de tempo e alguém para tirar as dúvidas teria chegado mais longe.

O maior block que presenciei foi referente ao tratamento das listas de objetos no java, tive um pouco de dificuldade em encontrar documentação sobre, e
por conta disso não consegui uma solução para as perguntas que envolviam filtragem das listas. As lógicas estam todas implementadas: converter String em LocalDate,
data de nascimento em idade, calcular imc, classificar doadores por tipo sanguíneo, porém não consegui devolver esses atributos para as listas a fim de realizar o filtro dos
dados nos parâmetros requeridos.

Infelizmente o front não terá tantos dados para exibir por conta desse block que tive, mas a contagem por estados funcionou perfeitamente, tentei implementar um paginador para
a tabela, mas sem sucesso.
Como não havia um protótipo referente ao design do frontend, optei por algo bem simples, que atendesse as necessidades, principalmente por conta do prazo, que já era escasso
devido ao tempo que passei tentando encontrar uma forma de filtrar as listas.


Bom, para rodar o projeto é bem simples: 

1. Na pasta database há um arquivo docker para subir o banco de dados e criar a tabela de doadores. Uma vez dentro dessa pasta, basta rodar o comando: "docker-compose up -d".

2. Para inicializar o backend, basta entrar na pasta backend e depois na pasta citelsoftware. Uma vez dentro dessa pasta, basta rodar o comando: "./mvnw clean spring-boot:run".

4. Para inserir todos os registros, será necessário chamar o método POST da API de doador: "localhost:8080/criar-lista", passando como Body, o conteúdo do arquivo "data.json",
encontrado na pasta database (Apenas copiar e colar).

5. Uma vez com a lista de doadores, é possível buildar o frontend, para vizualização dos dados. Para isso acesse a pasta frontend e depois a pasta citel. Uma vez dentro dessa pasta,
basta rodar o comando: "npm run start".

6. Para acessar o frontend, agora construído, basta acessar: "http://localhost:4200" (URL padrão do Angular).

![image](https://github.com/Rafael-Maffei/Test_Citel/assets/113271363/df4cbc18-cefa-4628-971b-d89a991d2b4d)
