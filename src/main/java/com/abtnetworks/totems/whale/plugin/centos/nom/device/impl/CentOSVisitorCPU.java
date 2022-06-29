package com.abtnetworks.totems.whale.plugin.centos.nom.device.impl;


import com.abtnetworks.totems.whale.common.plugin.VisitorHelper;
import com.abtnetworks.totems.whale.plugin.centos.nom.device.CentOSParser;

/**
 * @author luwei
 * @date 2020/9/16
 */
public class CentOSVisitorCPU extends CentOSVisitorOs {

    @Override
    public Void visitCpuInfo(CentOSParser.CpuInfoContext ctx) {
        String cpuName = VisitorHelper.getText(ctx.cpuName);
        this.deviceInfo.setCpuName(cpuName);
        return null;
    }
    @Override
    public Void visitCpuUse(CentOSParser.CpuUseContext ctx) {
        String freeCpu =  VisitorHelper.getText(ctx.freeCpu);
        Double free = Double.valueOf(freeCpu);
        Double use = 100-free;

        this.deviceInfo.setCpuUse(use);
        return null;
    }

}
