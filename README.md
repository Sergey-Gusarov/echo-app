# Эхо сервер - отвечает на пришедший запрос описанием содежимого запроса.

---
## Описание
Возврат примаемых параметров по REST

## Минимальные требования к окружению
1. Java 1.8.0_192
2. Maven 3.6.0

## Сборка 
```
mvn package -B
```

## Запуск
```
java -jar echo-app.jar
```

## CI/CD 
Для GitLab CI/CD сборки из .gitlab-ci.yml, необходимые переменные для загрузки проекта на сервера:

1. Для разработческого сервера:
    - DEV_SSH_USER
    - DEV_SSH_PASSWORD
    - DEV_SSH_HOST
2. Для использования в других окружениях (staging, test, prod), например:
    - PROD_SSH_USER
    - PROD_SSH_PASSWORD
    - PROD_SSH_HOST
