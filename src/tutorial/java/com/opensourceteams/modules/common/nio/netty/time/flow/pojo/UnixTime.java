package com.opensourceteams.modules.common.nio.netty.time.flow.pojo;

import java.util.Date;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/1/22  下午7:45
 * 功能描述:
 */

public class UnixTime {
    private final long value;

    public UnixTime() {
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public UnixTime(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    @Override
    public String toString() {
        return new Date((value() - 2208988800L) * 1000L).toString();
    }
}
