<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Start</title>
        <link rel="shortcut icon" href="https://cdn-icons-png.flaticon.com/512/620/620834.png">
        <link rel="stylesheet" href="static/css/style.css">
    </head>
    <body class="narrative">
        <h2>В далёкой-далёкой галактике...</h2>
        <h3>Вы просыпаетесь в незнакомом для вас месте. Встаёте и идёте обследовать местность.
            Вы наталкиваетесь на НЛО, что же вы будете делать?</h3>
        <div>
            <form action="/logic" method="post">
                <input type="input" class="type-1" name="name" id="name" placeholder="Введите своё имя:" required>
            </form>
        </div>
    </body>
</html>
