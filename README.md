# CFT_2020
Конфигурация приложения.
В файле src/main/resources/application.properies Вы найдете конфигурацию приложения. Рассмотрим ее подробнее:
server.port - номер порта приложения (изначально стоит 8080)
spring.h2.console.enabled=true - говорит Spring стартовать административный инструмент H2, чтобы войти в данный инстурмент в браузере (http://localhost:8080/h2)
spring.h2.console.path=/h2 - путь по которому консоль будет доступна
spring.datasource.url=jdbc:h2:mem:memDb - данная конфигурация говорит Spring, что Вы хотите использовать базу данных H2 в оперативной памяти
spring.datasource.driverClassName=org.h2.Driver - название JDBC драйвера 
spring.datasource.username=sa - имя пользователя базы данных (по умолчанию)
spring.datasource.password= - пароль для входа (по умолчанию)

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect - имя целевой базы данных
spring.jpa.hibernate.ddl-auto=create-drop -Hibernate сначала удаляет сущесвтующие таблицы, а затем создает новые. Hibernate удалит базу данных после завершения операций. ( по умолчанию)
spring.jpa.show-sql=true - включает логирование SQL

Инструкция по запуску приложения.
1. Скачайте проект.
2. Откройте папку с только что скачанным проектом.
3. При необходимости внесите изменения в конфигурационный файл приложения.
4. Перейдите в файл src/main/java/com/example/CFT_2020/Cft2020Application.java
5. Нажмите Run 'CftApplication' 
6. Дождитесь окончания запуска приложения.

Общий вид команд:
curl -X GET localhost:8080/{productName}/all - получение всех productName
curl -X GET localhost:8080/{productName}/{id} - получение productName по id
curl -X POST localhost:8080/{productName}/add -H Content-Type: application/json" -d "{{param}}" - вставка productName с параметрами
curl -X PUT localhost:8080/{productName}/update/{id} -H "Content-Type: application/json" -d "{{param}}" - обновление productName, param - новые значения

Примеры команд для работы с приложением (запуск команд необходимо производить из консоли). Изначально в каждой таблице базы данных находится по 4 элемента.
1. curl -X GET localhost:8080/Desktop/all (просмотре всех Настольных компьютеров)
2. curl -X GET localhost:8080/HardDisk/1 (просмотр Жесткого диска с id=1)
3. curl -X PUT localhost:8080/Monitor/update/3 -H "Content-Type: application/json" -d "{\"serial\": 34582}" (обновить Монитор с id=3)
4. curl -X POST localhost:8080/Desktop/add -H "Content-Type: application/json" -d "{\"serial\": 174392, \"manufacturer\": \"Apple\", \"cost\": 134.2, \"form\": \"Desktop\", \"quantity\": 13"}" (добавление нового Настольного компьютера)
5. curl -X PUT localhost:8080/Notebook/update/2 -H "Content-Type: application/json" -d "{\"manufacturer\": \"Acer\", \"serial\": 93463}"
(обновление Ноутбука с id=2)

Далее будут примеры команд, которые выдают сообщение об ошибке

6. curl -X PUT localhost:8080/Desktop/update/999 -H "Content-Type: application/json" -d "{\"serial\": 13256}" (не сущесвтует Настольный компьютер с id=999)
7. curl -X POST localhost:8080/Notebook/add -H "Content-Type: application/json" -d "{\"serial\": 1345123, \"manufacturer\": \"Asus\", \"cost\": 143.5, \"size\": 1, \"quantity\": 33"}" (неправильный размер Ноутбука)
8. curl -X POST localhost:8080/Desktop/add -H "Content-Type: application/json" -d "{\"serial\": 174392, \"manufacturer\": \"Apple\", \"cost\": 134.2, \"form\": \"Deskktop\", \"quantity\": 13"}" (неправильная форма Настольного комьютера)
9. curl -X POST localhost:8080/HardDisk/add -H "Content-Type: application/json" -d "{\"serial\": 1434123, \"manufacturer\": \"HD\", \"cost\": 0, \"space\": 256, \"quantity\": 3"}" (неправильная стоимость)
10. curl -X PUT localhost:8080/Monitor/update/1 -H "Content-Type: application/json" -d "{\"manufacturer\": \"Acer\", \"cost\": -134.2, \"quantity\": 3"}" (неправильная стоимость)
