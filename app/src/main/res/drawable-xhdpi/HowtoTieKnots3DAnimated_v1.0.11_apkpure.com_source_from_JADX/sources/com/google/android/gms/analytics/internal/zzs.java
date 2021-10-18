package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

class zzs implements Logger {
    private boolean zzKz;
    private int zzMQ = 2;

    zzs() {
    }

    public void error(Exception exception) {
    }

    public void error(String msg) {
    }

    public int getLogLevel() {
        return this.zzMQ;
    }

    public void info(String msg) {
    }

    public void setLogLevel(int level) {
        this.zzMQ = level;
        if (!this.zzKz) {
            Log.i((String) zzy.zzNa.get(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + ((String) zzy.zzNa.get()) + " DEBUG");
            this.zzKz = true;
        }
    }

    public void verbose(String msg) {
    }

    public void warn(String msg) {
    }
}
