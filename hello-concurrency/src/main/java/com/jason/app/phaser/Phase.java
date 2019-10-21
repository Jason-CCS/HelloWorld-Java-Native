package com.jason.app.phaser;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Created by jc6t on 2015/8/21.
 * Define common functions when running ETL phases.
 */
public interface Phase extends Callable{
    /**
     * Initialize everything that main work needs, i.e., ETL.
     * Put or get bqLists from bqListMap by name when next phase might get things from these blocking queues.
     * @param bqListMap
     */
    void init(Map<String, List<BlockingQueue>> bqListMap);

    void mainwork();

    /**
     * Cleanup or recycle your object here; eg., connection.close(), redis.close(), kafka.close(), etc.
     * ETLRunner will do this finish() function after any of extract, transform or load process finished.
     */
    void finish();
}
