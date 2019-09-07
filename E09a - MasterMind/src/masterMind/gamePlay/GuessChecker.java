package masterMind.gamePlay;

public interface GuessChecker {
    int i = 5;
    boolean shouldTry(String guess);

    void addScore(String guess, Score score);
}
