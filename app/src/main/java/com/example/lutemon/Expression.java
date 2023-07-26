package com.example.lutemon;

public class Expression { //In battle lutemon will show an expression when attacks or defends
    protected int thumbsUp;
    protected int thumbsDown;

    protected int thunder;
    protected int smile;

    protected int sad;

    protected int neutral;
    protected int kick;

    protected int sick;


    public Expression(){
        this.thumbsDown = R.drawable.baseline_thumb_down_alt_24;
        this.thumbsUp = R.drawable.baseline_thumb_up_24;
        this.thunder = R.drawable.baseline_thunderstorm_24;
        this.smile = R.drawable.baseline_mood_24;
        this.sad = R.drawable.baseline_mood_bad_24;
        this.neutral = R.drawable.baseline_sentiment_neutral_24;
        this.kick = R.drawable.baseline_sports_martial_arts_24;
        this.sick = R.drawable.baseline_sick_24;



    }

    public int getThumbsUp() {
        return thumbsUp;
    }

    public int getThumbsDown() {
        return thumbsDown;
    }

    public void setThumbsUp(int thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public void setThumbsDown(int thumbsDown) {
        this.thumbsDown = thumbsDown;
    }

    public int randomSad(){ //Chooses a random negative emotion
        int i = (int)(Math.random()*3);
        int emotion = thumbsDown;
        if(i == 0){
            emotion = thumbsDown;
        } else if(i == 1){
            emotion = sad;

        } else if(1 == 2){
            emotion = sick;
        }
        return emotion;

    }

    public int randomHappy(){ // Chooses a random happy emotion
        int i = (int)(Math.random()*3);
        int emotion = thumbsUp;
        if(i == 0){
            emotion = thumbsUp;

        } else if(i == 1){
            emotion = kick;
        } else if(1 == 2){
            emotion = smile;

        }
        return emotion;

    }

    public int getNeutral() {
        return neutral;
    }
}
