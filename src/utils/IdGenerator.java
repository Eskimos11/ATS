package utils;

public class IdGenerator {
    private static Long cardId = 1L;

    public static Long generateCardId(){
        return cardId ++;
    }

}
