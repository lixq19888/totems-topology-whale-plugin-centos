package com.abtnetworks.totems.whale.plugin.centos.nom.device.impl;

import com.abtnetworks.totems.whale.common.plugin.VisitorHelper;
import com.abtnetworks.totems.whale.plugin.centos.nom.device.CentOSParser;

/**
 * @author zc
 * @date 2021/03/19
 */
public class CentOSVisitorDisk extends CentOSVisitorMemory {

    @Override
    public Void visitDiskInfo(CentOSParser.DiskInfoContext ctx) {
        if(ctx.diskSub()!=null){
            for(CentOSParser.DiskSubContext subContext : ctx.diskSub()){
                if(subContext.name != null){
                    String name = VisitorHelper.getText(subContext.name);
                    String size = VisitorHelper.getText(subContext.si);
                    String unit = VisitorHelper.getText(subContext.unit);
                    this.deviceInfo.setDiskName(name + size + unit.substring(0,unit.length()-1));
                    break;
                }
            }
        }
        return null;
    }

    @Override
    public Void visitDiskUse(CentOSParser.DiskUseContext ctx) {
        Long totalblocks = 0L;
        Long usedblocks = 0L;
        Double rate = 0.0;
        if(ctx.diskUseSub()!=null){
            for(CentOSParser.DiskUseSubContext subContext : ctx.diskUseSub()){
                if(subContext.total!=null){
                    Long total = VisitorHelper.getLong(subContext.total);
                    Long used = VisitorHelper.getLong(subContext.used);
                    totalblocks += total;
                    usedblocks += used;
                }
            }
            rate = usedblocks.doubleValue()/totalblocks.doubleValue() * 100;
        }
        this.deviceInfo.setDiskUse(rate);
        return null;
    }

}
