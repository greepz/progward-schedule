Создать сервлеты и задеплоить их на сервер приложений tomcat

1. Получение списка параметров url GET /settings
2. Получение списка информации о наставнике по GET /mentor/info?id=1, где id - уникальный идентификатор наставника
3. Получение списка записи на консультации. GET /schedule/list?mentor=1&filter=ALL|PAST|FUTURE&sortDate=ASC|DESC&page=1&count=20
    где:
        mentor -  уникальный идентификатор наставника (необязательный параметр)
        filter - показывать все или прошедшие или предстоящие записи(необязательный параметр, значение по умолчанию - future )
        sortDate - сорировка по возрастанию или убыванию по дате и времени записи
        page - номер страницы
        count - количество записей на странице
4. Отменить запись GET /schedule/remove?id=1, где id - уникальный идентификатор записи

Для пользователя. 
5. Запись на консультации POST /schedule/add
    Параметры передаем в теле запроса
    schedule=11 - уникальный идентификатор записи
6. Список свободных консультаций по ментору на месяц GET /schedule/free?mentor=11 где mentor - уникальный идентификатор наставника
7. Записи клиента GET /schedule/my
8. Отмена записи POST /schedule/my/remove?id=11, где id - уникальный идентификатор записи


