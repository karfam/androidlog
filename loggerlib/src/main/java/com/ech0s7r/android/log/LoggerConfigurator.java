/*
 * Copyright 2011 ech0s7r
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ech0s7r.android.log;

import android.os.Environment;

import com.ech0s7r.android.log.appender.LogAppender;

import java.util.ArrayList;

/**
 * @author ech0s7r
 */

public class LoggerConfigurator {

    public static String APP_DIR_PATH;
    public static String APP_NAME;
    public static int APP_ID;
    public static String VERSION_NAME;
    public static String DEVICE_ID;
    public static String LOG_FILE_NAME_PREFIX;

    private static ArrayList<LogAppender> mLogAppenderList;

    static {
        mLogAppenderList = new ArrayList<LogAppender>();
    }

    private LoggerConfigurator() {

    }

    /**
     * Init the Logger library with custom device id
     *
     * @param logLevel      log level
     * @param id            Application ID
     * @param appName       Application Name
     * @param versionName   Application Version
     * @param deviceId      Device ID
     * @param logNamePrefix Log name prefix used for the log file, if null appName will be used
     */
    public static void init(Logger.Level logLevel, int id, String appName, String versionName, String deviceId, String logNamePrefix) {
        APP_ID = id;
        APP_NAME = appName;
        DEVICE_ID = deviceId;
        VERSION_NAME = versionName;
        LOG_FILE_NAME_PREFIX = logNamePrefix;
        APP_DIR_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "logs" + "/" + APP_NAME;

        Logger.logLevel = logLevel;
    }

    /**
     * Init the Logger library
     *
     * @param logLevel      log level
     * @param appName       Application Name
     * @param versionName   Application Version
     * @param logNamePrefix Log name prefix used for the log file, if null appName will be used
     */
    public static void init(Logger.Level logLevel, String appName, String versionName, String logNamePrefix) {
        init(logLevel, 0, appName, versionName, "", logNamePrefix);
    }

    /**
     * Add a custom appender to the Logger
     * {@link com.ech0s7r.android.log.appender.FileAppender}
     * {@link com.ech0s7r.android.log.appender.LogcatAppender}
     *
     * @param logAppender
     */
    public static void addAppender(LogAppender logAppender) {
        mLogAppenderList.add(logAppender);
    }

    static ArrayList<LogAppender> getLogAppenderList() {
        return mLogAppenderList;
    }

}
