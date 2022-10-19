o Web-Ornithology é uma aplicação criada em Angluar.js e SpringBoot durante o StartDb



acesse a wiki para saber mais sobre a estrutura, recursos e fontes de pesquisa:
https://gitlab.com/DRodrigues17/web-ornithology/-/wikis/Home

Atenção

caso você pretenda rodar essa aplicação na sua maquina, você precisara de um jdk (recomendamos o 17),
uma IDE que compile código java (recomendamos o Intellij, pois com ele você pode até instalar o jdk se não tiver instalado),
docker e o node e angular instalado.

Antes de Rodar a aplicação vá na pasta backend\src\main\resources, 
abra um terminal e rode o seguinte comando:
> docker-compose up

isso irá habilitar o banco de dados. 

Após isso rode a aplicação normalmente na sua IDE de preferencia e acesse via browser a seguinte url:
> http://localhost:8080/swagger-ui/index.html

Com isso você verá uma tela com os métodos e seus parametros

Agora, se você quiser acessar a aplicação via browser com o frontend em agular, vá ao terminal e rode o seguinte comando
>ng serve -o --poll=2000

Nisso você vai no browser (caso ele não tenha sido aberto automaticamente) e acessa a seguinte url:
> http://localhost:4200/