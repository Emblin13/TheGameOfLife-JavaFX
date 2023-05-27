package com.example.thegameoflife;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.*;
public class GameSpeed {

    GameGrid gameGrid;
    ScheduledFuture<?> cycleHandle;

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public GameSpeed(GameGrid gameGrid) {
        this.gameGrid = gameGrid;
    }

    public void shutdownCycle() {
        if(this.cycleHandle != null) {
            this.cycleHandle.cancel(false);
        }
    }

    public void gameSpeed(int delay) {
        final Runnable cycle = () -> gameGrid.nextCycle();
        this.cycleHandle = scheduler.scheduleWithFixedDelay(cycle, delay, delay, MILLISECONDS);
    }


}
