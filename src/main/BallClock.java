package main;

public class BallClock {

    private final int MINUTESINDAY = 1440;

    private MainBallTrack mainTrack;
    private BallTrack minuteTrack;
    private BallTrack fiveMinuteTrack;
    private BallTrack hourTrack;
    private int cycleCount;
    private int ballCount;


    public BallClock(int ballCount) {
        this.cycleCount = 0;
        this.ballCount = ballCount;

        this.mainTrack = new MainBallTrack(ballCount);
        this.minuteTrack = new BallTrack(4);
        this.fiveMinuteTrack = new BallTrack(11);
        this.hourTrack = new BallTrack(11);

        this.minuteTrack.setMainTrack(this.mainTrack);
        this.minuteTrack.setNextTrack(fiveMinuteTrack);

        this.fiveMinuteTrack.setMainTrack(this.mainTrack);
        this.fiveMinuteTrack.setNextTrack(hourTrack);

        this.hourTrack.setMainTrack(this.mainTrack);
        this.hourTrack.setNextTrack(this.mainTrack);

        this.mainTrack.setMinuteTrack(minuteTrack);
    }

    public void cycleOneHour() {
        mainTrack.pushBall();
        cycleCount++;
        while (mainTrack.getTrackCount() != this.ballCount) {
            mainTrack.pushBall();
            cycleCount++;
        }
    }

    public int cycleToOriginalOrder() {
        do {
            cycleOneHour();
        } while(!mainTrack.trackIsInOrder());

        return cycleCount / MINUTESINDAY;
    }
} 
