# TestTask

### Инструкция для запуска:
(Предварительно создать папку, например, через mkdir)
1. Клонируем репозиторий
```
git clone https://github.com/raralinar/TestTask.git
```
2. Перейдем в склонированную папку
```
cd TestTask
```
3. Компилируем проект
```
mvn package
```
4. Создадим образ
```
docker image build -t docker-java-jar:latest .
```
5. Запустим контейнер
```
docker run docker-java-jar:latest   
```

### Готово! Ответ отображается в консоли в тектовом виде
