/**
 * Class to check the possibles states of a tennis game.
 */
public class CheckScoresTennis {
    protected final TennisGame tennisGame;
    public CheckScoresTennis(TennisGame tennisGame) {
        this.tennisGame = tennisGame;
    }
    protected boolean checkTie() {
        return this.tennisGame.playerOnePoints ==
                this.tennisGame.playerTwoPoints;
    }
    protected boolean checkDeuce() {
        return this.checkTie() &&
                this.tennisGame.playerOnePoints >= 3;
    }
    protected boolean checkAdvantage() {
        return !this.checkTie() && (this.tennisGame.playerOnePoints >= 3 && this.tennisGame.playerTwoPoints >= 3) && !this.checkWin();
    }
    protected boolean checkWin() {
        if(this.checkTie()) {
            return false;
        }
        if(this.tennisGame.playerOnePoints < 4 && this.tennisGame.playerTwoPoints < 4) {
            return false;
        }

        return Math.abs(this.tennisGame.playerOnePoints - this.tennisGame.playerTwoPoints) >= 2;
    }
}


