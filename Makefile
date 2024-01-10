buy@start: docker@up spring@start

docker@up: src/main/resources/docker-compose.yaml
	cd src/main/resources && docker compose up &

spring@start:
	mvn spring-boot:run