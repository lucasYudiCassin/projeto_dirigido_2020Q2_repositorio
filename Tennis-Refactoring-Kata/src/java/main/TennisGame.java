/**
 * Class to show a tennis game score
 */
public class TennisGame implements TennisGameInterface {

    protected int playerOnePoints = 0;
    protected int playerTwoPoints = 0;

    protected final String playerOneName;
    protected final String playerTwoName;

    /**
     * Constructor to class.
     * @param playerOneName player one name
     * @param playerTwoName player two name
     */
    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    /**
     * Calculate a tennis game score to show.
     * First test if some one won or have an advantage, if positive show the score and end.
     * Then test if it is a Deuce, if positive show and end.
     * Then check the points to show
     * @return the score
     */
    public String getScore() {
        GetScoresTennis getScoresTennis = new GetScoresTennis(this);
        StringBuilder score = new StringBuilder();
        score.append(getScoresTennis.getAdvantageOrWin());
        if(score.length() != 0) {
            return score.toString();
        }
        if(getScoresTennis.checkDeuce()) {
            return getScoresTennis.getDeuce();
        }
        score.append(getScoresTennis.getPoints(this.playerOnePoints));
        if(getScoresTennis.checkTie()) {
            score.append(getScoresTennis.getEquals());
        } else {
            score.append("-");
            score.append(getScoresTennis.getPoints(this.playerTwoPoints));
        }
        return score.toString();
    }

    private void playerOneScore(){
        playerOnePoints++;
    }

    private void playerTwoScore(){
        playerTwoPoints++;
    }

    /**
     * Add a score.
     * @param player the player to receive the score.
     */
    public void wonPoint(String player) {
        if(player.equals(this.playerOneName)) {
            playerOneScore();
        } else {
            playerTwoScore();
        }
    }
}

