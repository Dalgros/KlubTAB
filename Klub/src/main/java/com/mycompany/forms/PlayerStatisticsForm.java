package com.mycompany.forms;

public class PlayerStatisticsForm {
    
    private String scoredGoals;
    private String lostGoals;
    private String yellowCards;
    private String redCards;
    private String minutesPlayed;
    private String faulsCommited;
    private String season;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
    

    public String getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(String scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public String getLostGoals() {
        return lostGoals;
    }

    public void setLostGoals(String lostGoals) {
        this.lostGoals = lostGoals;
    }

    public String getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(String yellowCards) {
        this.yellowCards = yellowCards;
    }

    public String getRedCards() {
        return redCards;
    }

    public void setRedCards(String redCards) {
        this.redCards = redCards;
    }

    public String getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(String minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public String getFaulsCommited() {
        return faulsCommited;
    }

    public void setFaulsCommited(String faulsCommited) {
        this.faulsCommited = faulsCommited;
    }
    
    
}
