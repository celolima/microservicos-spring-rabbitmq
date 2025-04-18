### Cadastro de proposta e envio para as filas de notificação e análise de crédito

![Modelo de negócio](misc/modelo-de-negocio.png)

### Gerenciamento de Contêineres Docker para Aplicação "Proposta"

Os comandos abaixo demonstram a criação e execução de contêineres Docker para uma aplicação web chamada "proposta", um banco de dados PostgreSQL e uma ferramenta de administração de banco de dados Adminer, todos interconectados em uma rede Docker personalizada.

**1. Cria uma rede docker para os containers:**

```bash    
docker network create minha-rede-banco
```

**2. Execução do Contêiner da Aplicação Web:**

```bash
docker run --name proposta-web-container \
    --network minha-rede-banco \
    -p 80:80 \
    -d matheuspieropan/proposta-web
```

**2. Execução do Contêiner do banco POSTGRES:**

```bash
docker run --name propostadb \
    --network minha-rede-banco \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=123 \
    -e POSTGRES_DB=propostadb \
    -p 5432:5432 \
    -d postgres
```

**3. Execução do Contêiner da interface web para acesso ao POSTGRES:**

```bash
docker run --name adminer-web \
    --network minha-rede-banco \
    -p 9000:8080 \
    -d adminer
```

**4. Execução do Contêiner do RabbitMQ:**

```bash
docker run --name my-rabbit \
    --network minha-rede-banco \
    -p 15672:15672 \
    -p 5672:5672 \
    -d rabbitmq:3-management
```