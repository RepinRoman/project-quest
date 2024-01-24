package com.repin.quest.servlets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

class LogicServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    private LogicServlet logicServlet;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        logicServlet = new LogicServlet();
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testDoGet() throws IOException {
        logicServlet.doGet(request, response);

        assertAll("Тест: Ожидаемые doGet методы LogicServlet должны были вызваться нужное число раз!",
                () -> verify(request, times(1)).getSession(),
                () -> verify(request, times(1)).getParameter("button"),
                () -> verify(session, times(3)).setAttribute(anyString(), any())
        );
    }

    @Test
    public void testDoPost() throws IOException {
        when(request.getParameter("name")).thenReturn("Roman");
        logicServlet.doPost(request, response);

        assertAll("Тест: Ожидаемые doPost методы LogicServlet должны были вызваться нужное число раз!",
                () -> verify(request, times(1)).getSession(),
                () -> verify(request, times(1)).getParameter("name"),
                () -> verify(session, times(3)).setAttribute(anyString(), any()),
                () -> verify(response, times(1)).sendRedirect("/logic")
        );
    }
}
