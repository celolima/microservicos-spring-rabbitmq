```
docker network create minha-rede-banco

docker run --name propostadb \
    --network minha-rede-banco \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=123 \
    -e POSTGRES_DB=propostadb \
    -p 5432:5432 \
    -d postgres

docker run --name adminer-web \
    --network minha-rede-banco \
    -p 9000:8080 \
    -d adminer
```    