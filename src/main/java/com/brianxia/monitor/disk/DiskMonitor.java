package com.brianxia.monitor.disk;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DiskMonitor {

    public List<DiskData> visitDisk(){
        List<DiskData> datas = new ArrayList<DiskData>();
        File[] roots = File.listRoots();

        if (roots != null) {
            for (File root : roots) {
                DiskData data = new DiskData();
                data.setFreeSpace(root.getFreeSpace());
                data.setPath(root.getAbsolutePath());
                data.setTotalSpace(root.getTotalSpace());
                data.setUsableSpace(root.getUsableSpace());
                datas.add(data);
            }
        }

        return datas;
    }

    public static void main(String[] args) {
        DiskMonitor monitor = new DiskMonitor();
        List<DiskData> datas = monitor.visitDisk();
        for(DiskData data : datas)
            System.out.println(data);
    }
}
