package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallClockTest {
    @Test
    public void TestCycleTime30Balls() {
        BallClock clock = new BallClock(30);
        int days = clock.cycleToOriginalOrder();
        assertEquals(15, days);
    }

    @Test
    public void TestCycleTime45Balls() {
        BallClock clock = new BallClock(45);
        int days = clock.cycleToOriginalOrder();
        assertEquals(378, days);
    }
}