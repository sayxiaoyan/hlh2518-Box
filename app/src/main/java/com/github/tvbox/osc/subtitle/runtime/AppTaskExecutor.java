package com.github.tvbox.osc.subtitle.runtime;


import androidx.annotation.NonNull;

import java.util.concurrent.Executor;

/**
 * @author AveryZhong.
 */

public class AppTaskExecutor extends TaskExecutor {

    private static AppTaskExecutor sInstance;
    private static final Executor sDeskIO = new Executor() {
        @Override
        public void execute(@NonNull final Runnable command) {
            getInstance().executeOnDeskIO(command);
        }
    };
    private static final Executor sMainThread = new Executor() {
        @Override
        public void execute(@NonNull final Runnable command) {
            getInstance().executeOnMainThread(command);
        }
    };
    private final TaskExecutor mDefaultTaskExecutor;
    private TaskExecutor mDelegate;

    private AppTaskExecutor() {
        mDefaultTaskExecutor = new DefaultTaskExecutor();
        mDelegate = mDefaultTaskExecutor;
    }

    @NonNull
    public static TaskExecutor getInstance() {
        if (sInstance == null) {
            synchronized (AppTaskExecutor.class) {
                sInstance = new AppTaskExecutor();
            }
        }
        return sInstance;
    }

    public static Executor deskIO() {
        return sDeskIO;
    }

    public static Executor mainThread() {
        return sMainThread;
    }

    public void setDelegate(final TaskExecutor taskExecutor) {
        mDelegate = taskExecutor == null ? mDefaultTaskExecutor : taskExecutor;
    }

    @Override
    public void executeOnDeskIO(final Runnable task) {
        mDelegate.executeOnDeskIO(task);
    }

    @Override
    public void executeOnMainThread(final Runnable task) {
        mDelegate.executeOnMainThread(task);
    }

    @Override
    public void postToMainThread(final Runnable task) {
        mDelegate.postToMainThread(task);
    }

    @Override
    public boolean isMainThread() {
        return mDelegate.isMainThread();
    }
}
