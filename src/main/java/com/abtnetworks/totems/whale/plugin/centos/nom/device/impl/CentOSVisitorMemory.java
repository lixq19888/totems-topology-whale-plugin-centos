package com.abtnetworks.totems.whale.plugin.centos.nom.device.impl;


import com.abtnetworks.totems.whale.common.plugin.VisitorHelper;
import com.abtnetworks.totems.whale.plugin.centos.nom.device.CentOSParser;

/**
 * @author luwei
 * @date 2020/9/16
 */
public class CentOSVisitorMemory extends CentOSVisitorCPU {

    @Override
    public Void visitMemInfo(CentOSParser.MemInfoContext ctx) {
        Long total = VisitorHelper.getLong(ctx.total);
        Long used = VisitorHelper.getLong(ctx.used);
//        Long free = VisitorHelper.getLong(ctx.free);
        Double rate = (used.doubleValue()/total.doubleValue() * 100);
        this.deviceInfo.setMemory(String.format("%.2f", total.doubleValue()/(1024*1024) ) + " G");
        this.deviceInfo.setMemUse(rate);

        return null;
    }

}
