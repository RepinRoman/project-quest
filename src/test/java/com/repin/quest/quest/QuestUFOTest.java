package com.repin.quest.quest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestUFOTest {
    static Map<String, QuestUFO.AnswersPair> expectedQuestContent = new HashMap<>();
    static Map<String, String> expectedQuestAnswers = new HashMap<>();

    @BeforeAll
    static void init() {
        expectedQuestContent.put("Ты потерял память. Принять вызов НЛО?",
                new QuestUFO.AnswersPair("Принять вызов", "Отклонить вызов"));
        expectedQuestContent.put("Ты отклонил вызов. Поражение!", null);
        expectedQuestContent.put("Ты принял вызов. Поднимешься на мостик к капитану?",
                new QuestUFO.AnswersPair("Подняться на мостик", "Отказаться подняться на мостик"));
        expectedQuestContent.put("Ты не пошёл на переговоры. Поражение!", null);
        expectedQuestContent.put("Ты поднялся на мостик. Капитан спрашивает тебя: \"Кто ты?\"",
                new QuestUFO.AnswersPair("Рассказать правду о себе", "Солгать о себе"));
        expectedQuestContent.put("Тебя вернули домой. Победа!", null);
        expectedQuestContent.put("Твою ложь разоблачили. Поражение!", null);

        expectedQuestAnswers.put("Принять вызов", "Ты принял вызов. Поднимешься на мостик к капитану?");
        expectedQuestAnswers.put("Отклонить вызов", "Ты отклонил вызов. Поражение!");
        expectedQuestAnswers.put("Подняться на мостик", "Ты поднялся на мостик. Капитан спрашивает тебя: \"Кто ты?\"");
        expectedQuestAnswers.put("Отказаться подняться на мостик", "Ты не пошёл на переговоры. Поражение!");
        expectedQuestAnswers.put("Рассказать правду о себе", "Тебя вернули домой. Победа!");
        expectedQuestAnswers.put("Солгать о себе", "Твою ложь разоблачили. Поражение!");
    }

    @Test
    void testShouldReturnQuestContentAndAnswers() {
        assertAll("Тест: Должны были вернуться содержание и ответы квеста!",
                () -> assertEquals(expectedQuestContent, new QuestUFO().getQuestContent()),
                () -> assertEquals(expectedQuestAnswers, new QuestUFO().getQuestAnswers())
        );
    }

    @Test
    void testShouldReturnAnswerPairs() {
        expectedQuestContent.forEach((key, value) -> {
            if (value != null) {
                String expectedAnswerOne = expectedQuestContent.get(key).getAnswerOne();
                String expectedAnswerTwo = expectedQuestContent.get(key).getAnswerTwo();
                String actualAnswerOne = new QuestUFO().getQuestContent().get(key).getAnswerOne();
                String actualAnswerTwo = new QuestUFO().getQuestContent().get(key).getAnswerTwo();

                assertAll("Тест: Должны были вернуться пары ответов на вопросы квеста!",
                        () -> assertEquals(expectedAnswerOne, actualAnswerOne),
                        () -> assertEquals(expectedAnswerTwo, actualAnswerTwo)
                );
            }
        });
    }
}
