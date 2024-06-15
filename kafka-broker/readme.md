# kafka broker 실행
1. docker 설치
2. docker compose 설치
3. docker compose 실행(현재 위치에서)
> ``$ docker-compose up -d``
4. kafka 브로커 확인
> ``$ docker-compose logs kafka``
5. kafka 토픽 생성 (sample_topic)
> ``$ docker-compose exec kafka kafka-topics.sh --create --topic sample_topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1``
6. Kafka 프로듀서 실행:
> ``$ docker-compose exec kafka kafka-console-producer.sh --broker-list localhost:9092 --topic sample_topic``
7. Kafka 메세지 발행
> command 창에 메세지를 입력 후 Enter