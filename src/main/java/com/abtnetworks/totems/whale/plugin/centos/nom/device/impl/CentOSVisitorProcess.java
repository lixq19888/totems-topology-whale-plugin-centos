package com.abtnetworks.totems.whale.plugin.centos.nom.device.impl;

import com.abtnetworks.totems.whale.common.domain.ids.GenericNetstatInfoPO;
import com.abtnetworks.totems.whale.common.domain.ids.GenericProcessPO;
import com.abtnetworks.totems.whale.common.plugin.VisitorHelper;
import com.abtnetworks.totems.whale.plugin.centos.nom.device.CentOSParser;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CentOSVisitorProcess extends CentOSVisitorLogin{

    @Override
    public Void visitNetstatInfo(CentOSParser.NetstatInfoContext ctx) {
        List<GenericNetstatInfoPO> netstatInfoList=new ArrayList<>();
        if(ctx.netstatSubInfo()!=null){
            for(CentOSParser.NetstatSubInfoContext subInfoContext : ctx.netstatSubInfo()){
                if(subInfoContext.proto!=null){
                    String info = VisitorHelper.getText(subInfoContext.info);
                    if(info.indexOf("/")>0&& StringUtils.isNotEmpty(info)){
                        GenericProcessPO po = new GenericProcessPO();
                        String PID = info.substring(0,info.indexOf("/"));
                        String name = info.substring(info.indexOf("/") + 1);
                        String ipPort = VisitorHelper.getText(subInfoContext.local);
                        po.setPort(Integer.parseInt(ipPort.substring(ipPort.indexOf(":") + 1)));
                        po.setName(name);
                        processPOMap.put(PID,po);
                    }
                }
                GenericNetstatInfoPO netstatInfoPO=null;
                if(subInfoContext.proto!=null){
                    netstatInfoPO=new GenericNetstatInfoPO();
                    netstatInfoPO.setProto(VisitorHelper.getText(subInfoContext.proto));
                    String text = VisitorHelper.getText(subInfoContext.local);
                    String port = text.substring(text.lastIndexOf(":")+1, text.length());
                    netstatInfoPO.setPort(port);
                }
                if(ObjectUtils.isNotEmpty(netstatInfoPO)){
                    netstatInfoList.add(netstatInfoPO);
                }
            }
        }
        this.deviceInfo.setNetstatInfoList(netstatInfoList);
        return null;
    }

    @Override
    public Void visitProcessInfo(CentOSParser.ProcessInfoContext ctx) {

        if(ctx.processSubInfo()!=null){
            for(CentOSParser.ProcessSubInfoContext subInfoContext : ctx.processSubInfo()){
                if(subInfoContext.pid!=null){
                    String PID = VisitorHelper.getText(subInfoContext.pid);
//                    if(processPOMap.get(PID)!=null){
                        String user = VisitorHelper.getText(subInfoContext.user);

                        Double cpu = Double.valueOf(VisitorHelper.getText(subInfoContext.cpu));
                        Double mem = Double.valueOf(VisitorHelper.getText(subInfoContext.mem));

//                        GenericProcessPO po = processPOMap.get(PID);
                        GenericProcessPO po = new GenericProcessPO();
                        po.setPID(PID);
                        po.setCpu(cpu);
                        po.setMem(mem);
                        po.setUser(user);

                        String time = VisitorHelper.getText(subInfoContext.time);
                        String mon = VisitorHelper.getText(subInfoContext.mon);
                        String day = VisitorHelper.getText(subInfoContext.day);
                        String year = VisitorHelper.getText(subInfoContext.year);
                        Date date = getDateByString(mon,day,time,year);
                        po.setTime(date);
                        this.allProcessPOList.add(po);
//                        this.processPOList.add(po);
//                    }
                }
            }
        }

        return null;
    }

}
