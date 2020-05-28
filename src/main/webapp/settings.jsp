<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <head>
    <%@ page import="java.util.List" %>
    <%@ page import="app.repository.model.Setting" %>
    <%@ page pageEncoding="utf-8" %>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    </head>
    <body>
    <c:out value="${hello}" />
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Идентификатор</th>
                        <th>Наименование</th>
                        <th>Значение</th>
                        <th colspan='2'>Операция</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="setting" items="${settings}">
                    <tr>
                        <td><c:out value="${setting.id}" /></td>
                        <td><c:out value="${setting.id}" /></td>
                        <td><c:out value="${setting.id}" /></td>
                        <td><a href="/hello/editSetting?id=<c:out value='${setting.id}' />">Редактировать</td>
                        <td><a href="/hello/deleteSetting?id=<c:out value='${setting.id}' />">Удалить</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="container">
            <form>
                <div class="row">
                    <div class="col-4 offset-4">
                        <input class="form-control" type="text" placeholder="enter value" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-4 offset-4">
                        <input class="btn btn-primary" type="submit" value="Сохранить" />
                    </div>
                </div>
            </form>
            </div>
    </body>
</html>