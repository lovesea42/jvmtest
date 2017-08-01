package com.brianxia.monitor.disk;

public class DiskData {

    private String path;

    private long totalSpace;
    private long freeSpace;
    private long usableSpace;

    @Override
    public String toString() {
        return "DiskData{" +
                "path='" + path + '\'' +
                ", totalSpace=" + totalSpace +
                ", freeSpace=" + freeSpace +
                ", usableSpace=" + usableSpace +
                '}';
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(long totalSpace) {
        this.totalSpace = totalSpace;
    }

    public long getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(long freeSpace) {
        this.freeSpace = freeSpace;
    }

    public long getUsableSpace() {
        return usableSpace;
    }

    public void setUsableSpace(long usableSpace) {
        this.usableSpace = usableSpace;
    }
}
