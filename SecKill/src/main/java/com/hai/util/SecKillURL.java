package com.hai.util;

public class SecKillURL {
    private boolean enable;
    private String md5;
    private int productId;
    private Long now;
    private Long start;
    private Long end;

    public SecKillURL() {
    }

    public SecKillURL(boolean enable, String md5, int productId, Long now, Long start, Long end) {
        this.enable = enable;
        this.md5 = md5;
        this.productId = productId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }
}
