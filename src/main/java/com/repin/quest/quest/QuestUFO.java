package com.repin.quest.quest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class QuestUFO {
    private final Map<String, AnswersPair> questContent = new HashMap<>();
    private final Map<String, String> questAnswers = new HashMap<>();

    {
        questContent.put("Ты потерял память. Принять вызов НЛО?",
                new AnswersPair("Принять вызов", "Отклонить вызов"));
        questContent.put("Ты отклонил вызов. Поражение!", null);
        questContent.put("Ты принял вызов. Поднимешься на мостик к капитану?",
                new AnswersPair("Подняться на мостик", "Отказаться подняться на мостик"));
        questContent.put("Ты не пошёл на переговоры. Поражение!", null);
        questContent.put("Ты поднялся на мостик. Капитан спрашивает тебя: \"Кто ты?\"",
                new AnswersPair("Рассказать правду о себе", "Солгать о себе"));
        questContent.put("Тебя вернули домой. Победа!", null);
        questContent.put("Твою ложь разоблачили. Поражение!", null);

        questAnswers.put("Принять вызов", "Ты принял вызов. Поднимешься на мостик к капитану?");
        questAnswers.put("Отклонить вызов", "Ты отклонил вызов. Поражение!");
        questAnswers.put("Подняться на мостик", "Ты поднялся на мостик. Капитан спрашивает тебя: \"Кто ты?\"");
        questAnswers.put("Отказаться подняться на мостик", "Ты не пошёл на переговоры. Поражение!");
        questAnswers.put("Рассказать правду о себе", "Тебя вернули домой. Победа!");
        questAnswers.put("Солгать о себе", "Твою ложь разоблачили. Поражение!");
    }

    public Map<String, AnswersPair> getQuestContent() {
        return questContent;
    }

    public Map<String, String> getQuestAnswers() {
        return questAnswers;
    }

    public static class AnswersPair {
        private final String answerOne;
        private final String answerTwo;

        public AnswersPair(String answerOne, String answerTwo) {
            this.answerOne = answerOne;
            this.answerTwo = answerTwo;
        }

        public String getAnswerOne() {
            return answerOne;
        }

        public String getAnswerTwo() {
            return answerTwo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof AnswersPair answersPair)) return false;
            return Objects.equals(answerOne, answersPair.answerOne) && Objects.equals(answerTwo, answersPair.answerTwo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(answerOne, answerTwo);
        }
    }
}
