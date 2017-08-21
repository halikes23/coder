package com.fq.util.timerlogger;

import org.slf4j.Logger;

public class TimerLoggerFactory {

	public final static TimerLogger getLogger( Logger logger ){
		
		return TimerLogger.build(logger) ;
		
	}
	
}
