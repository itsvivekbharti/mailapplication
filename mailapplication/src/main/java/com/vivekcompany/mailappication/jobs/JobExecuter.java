package com.vivekcompany.mailappication.jobs;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Custom thread pool task executor
 * 
 */
public class JobExecuter extends ThreadPoolExecutor {

	/** The Constant defaultCorePoolSize. */
	static final int defaultCorePoolSize = 5;
	
	/** The Constant defaultMaximumPoolSize. */
	static final int defaultMaximumPoolSize = 50;
	
	/** The Constant defaultKeepAliveTime. */
	static final long defaultKeepAliveTime = 1;
	
	/** The Constant defaultTimeUnit. */
	static final TimeUnit defaultTimeUnit = TimeUnit.MINUTES;
	
	/** The Constant workQueue. */
	static final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
	
	/** The instance. */
	private static ThreadPoolExecutor instance;

	/**
	 * Instantiates a new job executer.
	 */
	private JobExecuter() {
		super(defaultCorePoolSize, defaultMaximumPoolSize,
				defaultKeepAliveTime, defaultTimeUnit, workQueue);
	}

	/**
	 * Gets the single instance of OPSJobExecuter.
	 *
	 * @return single instance of OPSJobExecuter
	 */
	 synchronized static ThreadPoolExecutor getInstance() {
		if (instance == null) {
			instance = new JobExecuter();
		}
		return instance;
	}

	/**
	 * Queue job.
	 *
	 * @param runnable runnable
	 */
	public static void queueJob(Runnable runnable) {
		getInstance().execute(runnable);
	}
}
