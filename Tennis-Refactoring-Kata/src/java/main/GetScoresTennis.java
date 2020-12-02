/**
 * Class that show the possibles scores of a tennis game.
 */
public class GetScoresTennis extends CheckScoresTennis{

    private static final String POINT_ONE = "Love";
    private static final String POINT_TWO = "Fifteen";
    private static final String POINT_THREE = "Thirty";
    private static final String POINT_FOUR = "Forty";
    private static final String POINT_EQUALS = "-All";
    private static final String DEUCE = "Deuce";

    public GetScoresTennis(TennisGame tennisGame) {
        super(tennisGame);
    }

    /**
     * Show if there is a advantage or win to some one.
     * @return the score
     */
    protected String getAdvantageOrWin() {
        StringBuilder string = new StringBuilder();
        if(checkWin()) {
            string.append("Win for ");
        } else if(checkAdvantage()) {
            string.append("Advantage ");
        } else {
            return "";
        }

        if(this.tennisGame.playerOnePoints > this.tennisGame.playerTwoPoints) {
            string.append(this.tennisGame.playerOneName);
        } else {
            string.append(this.tennisGame.playerTwoName);
        }
        return string.toString();
    }
    /**
     * Get the points name.
     * @param points the value
     * @return the name
     */
    protected String getPoints(int points) {
        switch(points) {
            case 0:
                return POINT_ONE;
            case 1:
                return POINT_TWO;
            case 2:
                return POINT_THREE;
            case 3:
                return POINT_FOUR;
            default:
                return "";
        }
    }
    protected String getDeuce() {
        return DEUCE;
    }
    protected String getEquals() {
        return POINT_EQUALS;
    }
}

