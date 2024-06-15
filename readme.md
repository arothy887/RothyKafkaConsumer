# Application 설명


## Java 17
## build

- Mac
> ``$ gradlew build``
- Windows
>``gradlew.bat bootRun``

** 실행안될 시 gradle 설치

## exec (빌드 결과 실행)
``java -jar build/libs/myproject-1.0-SNAPSHOT.jar --spring.profiles.active=local``
- 파일이 제대로 위치해있는지 확인
- 실제 운영시에는 profile 설정으로 환경변수 제어


## exec kafka broker (optional)
> 로컬 테스트를 위해 Broker 를 실행
* ``kafka-broker/readme.md`` 를 참고


## server host 및 topic 설정
application.yml