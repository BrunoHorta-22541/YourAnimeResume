package pt.estig.twdm.pdm.youranimeresume;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BackgroundTasks {

    private static Executor executor = Executors.newSingleThreadExecutor();

    public static void execute(Runnable runnable) {
        executor.execute(runnable);
    }
}
