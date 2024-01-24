package com.repin.quest.servlets;

import com.repin.quest.quest.QuestUFO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
    private int gameCounter = 1;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        QuestUFO quest = new QuestUFO();

        // Получаем значение кнопки, на которую нажал пользователь
        String pressedButton = null;
        if (request.getParameter("button") != null) {
            pressedButton = request.getParameter("button");
        }

        // Стартовый вопрос и все последующие (смотря что выберет пользователь)
        String question = "Ты потерял память. Принять вызов НЛО?";
        if (pressedButton != null) {
            question = quest.getQuestAnswers().get(pressedButton);
        }

        // Занесение в сессию текущего вопроса
        session.setAttribute("question", question);

        // Создание кнопок с ответами, они заключены в try-catch блок, так как метод getQuestContent возвращает Map,
        // ...что может содержать value = null (при поражении/победе). Т.е. при поражении/победе, кнопки не будут отображены!
        String buttonOne = null;
        String buttonTwo = null;
        try {
            buttonOne = quest.getQuestContent().get(question).getAnswerOne();
            buttonTwo = quest.getQuestContent().get(question).getAnswerTwo();
        } catch (Exception ignore) {/*Игнорируем*/}

        // Проверка на поражение/победу (иначе квест продолжится)
        if (question.contains("Поражение")) {
            session.setAttribute("buttonOne", "lose");
            session.setAttribute("buttonTwo", "lose");
        } else if (question.contains("Победа")) {
            session.setAttribute("buttonOne", "win");
            session.setAttribute("buttonTwo", "win");
        } else {
            session.setAttribute("buttonOne", buttonOne);
            session.setAttribute("buttonTwo", buttonTwo);
        }

        response.sendRedirect("/quest");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        // Получаем имя, IP-адрес и кол-во перезапусков квеста
        session.setAttribute("name", req.getParameter("name"));
        session.setAttribute("ipAddress", req.getRemoteAddr());
        session.setAttribute("gameCounter", gameCounter);

        resp.sendRedirect("/logic");
    }
}
