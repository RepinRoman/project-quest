<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Quest(UFO)</title>
        <link rel="shortcut icon" href="https://cdn-icons-png.flaticon.com/512/620/620834.png">
        <link rel="stylesheet" href="static/css/style.css">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <c:set var="win" value="win"/>
        <c:set var="lose" value="lose"/>

        <%-- QUESTIONS --%>
        <div class="narrative">
            ${question}
        </div>

        <!-- ANSWERS BUTTONS -->
        <br>
            <div class="container">
                    <%-- Использую переменную, чтобы при победе или поражении, кнопки ответов не появлялись! --%>
                    <c:if test="${buttonOne != win && buttonOne != lose}">
                        <a href="#" class="btn" onclick="window.location='logic?button=${buttonOne}'">${buttonOne}</a>
                        <a href="#" class="btn" onclick="window.location='logic?button=${buttonTwo}'">${buttonTwo}</a>
                    </c:if>
            </div>
        <br>

        <%-- RESTART --%>
        <a href="restart" class="btn" id="bottomRight">Начать заново</a>

        <%-- STATISTIC --%>
        <div id="bottomLeft">
            Статистика:<br>
            IP address: ${ipAddress}<br>
            Имя пользователя: ${name}<br>
            Количество игр: ${gameCounter}<br>
        </div>
    </body>
</html>
