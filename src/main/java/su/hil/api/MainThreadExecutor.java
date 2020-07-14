package su.hil.api;

//import javax.annotation.Nonnull;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public class MainThreadExecutor implements Executor {
    private Queue<Runnable> pendingTasks = new ConcurrentLinkedQueue<>();

    // Тут дожна быть аннотация @Nonnull возле Runnable, но в javax.annotation такого нет :C
    @Override
    public void execute(Runnable command) {
        pendingTasks.add(command);
    }

    public void runPendingTasks() {
        Runnable r;
        while ((r = pendingTasks.poll()) != null) {
            r.run();
        }
    }
}
