package main;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Stream;

public class BallTrack implements IBallTrack {

    private Stack<IBall> balls;
    private int capacity;
    private IBallTrack nextTrack;
    private IBallTrack mainTrack;

    public BallTrack(int capacity) {
        this.capacity = capacity;
        this.balls = new Stack<>();
    }

    @Override
    public void addBall(IBall ball) {
        if (balls.size() == capacity) {
            while (!balls.empty()) {
                mainTrack.addBall(balls.pop());
            }
            nextTrack.addBall(ball);
        } else {
            balls.push(ball);
        }
    }

    public void setNextTrack(IBallTrack track) {
        this.nextTrack = track;
    }

    public void setMainTrack(IBallTrack track) {
        this.mainTrack = track;
    }
}
