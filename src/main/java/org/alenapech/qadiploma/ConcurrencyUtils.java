package org.alenapech.qadiploma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ConcurrencyUtils {

    private static final Logger logger = LoggerFactory.getLogger(ConcurrencyUtils.class);

    //https://howtodoinjava.com/java/multi-threading/executorservice-shutdown/
    public static void shutdownAndAwaitTermination(ExecutorService executorService) {
        // Disable new tasks from being submitted
        executorService.shutdown();
        try {
            // Wait a while for existing tasks to terminate
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                // Cancel currently executing tasks forcefully
                executorService.shutdownNow();
                // Wait a while for tasks to respond to being cancelled
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS))
                    logger.error("ExecutorService did not terminate");
            }
        } catch (InterruptedException ex) {
            // (Re-)Cancel if current thread also interrupted
            executorService.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        } finally {
            logger.info("ExecutorService has been shut down");
        }
    }

}
