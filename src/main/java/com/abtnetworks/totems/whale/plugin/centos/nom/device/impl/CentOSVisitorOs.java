package com.abtnetworks.totems.whale.plugin.centos.nom.device.impl;

import com.abtnetworks.totems.whale.common.domain.ids.GenericAccessPO;
import com.abtnetworks.totems.whale.common.domain.ids.GenericHostPO;
import com.abtnetworks.totems.whale.common.domain.ids.GenericNetstatInfoPO;
import com.abtnetworks.totems.whale.common.domain.ids.GenericProcessPO;
import com.abtnetworks.totems.whale.common.domain.metadata.DeviceMetadata;
import com.abtnetworks.totems.whale.common.plugin.VisitorHelper;
import com.abtnetworks.totems.whale.plugin.centos.nom.device.CentOSBaseVisitor;
import com.abtnetworks.totems.whale.plugin.centos.nom.device.CentOSParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author luwei
 * @date 2020/9/16
 */
public class CentOSVisitorOs extends CentOSBaseVisitor<Void> {

    protected GenericHostPO deviceInfo = new GenericHostPO();
    protected Map<String,GenericProcessPO> processPOMap = new HashMap<>();
    protected List<GenericProcessPO> processPOList = new ArrayList<>();
    protected List<GenericProcessPO> allProcessPOList = new ArrayList<>();
    protected List<GenericAccessPO> accessPOList = new ArrayList<>();
    protected List<String> listenPort = new ArrayList<>();
    protected List<GenericNetstatInfoPO> netstatInfoPOList=new ArrayList<>();

    protected void initialize(DeviceMetadata dm) throws Exception {
    }

    @Override
    public Void visitHostname(CentOSParser.HostnameContext ctx) {
        String osName = VisitorHelper.getText(ctx.hostName);
        this.deviceInfo.setHostName(osName);
        return null;
    }

    @Override
    public Void visitHostOs(CentOSParser.HostOsContext ctx) {
        String osName = VisitorHelper.getText(ctx.osName);
        this.deviceInfo.setOsName(osName);
        return null;
    }

}
