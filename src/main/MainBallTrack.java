package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MainBallTrack implements IBallTrack {

    private IBallTrack minuteTrack;
    private Queue<IBall> track;
    private int size;

    public MainBallTrack(int count) {
        this.size = count;
        this.track = new LinkedList<>(BallFactory.CreateBalls(count));
    }
    @Override
    public void addBall(IBall ball) {
        track.offer(ball);
    }

    public void setMinuteTrack(IBallTrack minuteTrack) {
        this.minuteTrack = minuteTrack;
    }

    public void pushBall() {
        minuteTrack.addBall(track.poll());
    }

    public int getTrackCount() {
        return track.size();
    }
    public boolean trackIsInOrder() {
       if (track.peek().getId() != 0) {
           return false;
       }

       Iterator<IBall> iterator = track.iterator();
       Iterator<IBall> plusOneIterator = track.iterator();
       plusOneIterator.next();
       while (plusOneIterator.hasNext()) {
           int n = iterator.next().getId();
           int nPlusOne = plusOneIterator.next().getId();
           if (nPlusOne - n != 1) {
               return false;
           }
       }
       return true;
    }
}
