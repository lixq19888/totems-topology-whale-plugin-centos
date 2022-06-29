package com.abtnetworks.totems.whale.plugin.centos.nom.device.impl;

import com.abtnetworks.totems.whale.common.domain.ids.GenericNICPO;
import com.abtnetworks.totems.whale.common.plugin.VisitorHelper;
import com.abtnetworks.totems.whale.plugin.centos.nom.device.CentOSParser;
import org.assertj.core.internal.bytebuddy.description.type.TypeDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luwei
 * @date 2020/9/16
 */
public class CentOSVisitorNIC extends CentOSVisitorDisk {

    @Override
    public Void visitNicInfo(CentOSParser.NicInfoContext ctx) {
        List<GenericNICPO> genericNICPOList = new ArrayList<>();
        if(ctx.nicSub()!=null){
            for(CentOSParser.NicSubContext subContext : ctx.nicSub()){
                String name = VisitorHelper.getText(subContext.name);
                GenericNICPO nicpo = new GenericNICPO();
                if(name!=null){
                    nicpo.setName(name.substring(0,name.length()-1));
                }
                for(CentOSParser.NicOptionContext optionContext : subContext.nicOption()){
                    if(optionContext.ip!=null){
                        nicpo.setIPv4(VisitorHelper.getText(optionContext.ip));
                    }else if(optionContext.ip6!=null){
                        nicpo.setMAC(VisitorHelper.getText(optionContext.ip6));
                    }else if(optionContext.in!=null){
                        nicpo.setInput(VisitorHelper.getLong(optionContext.in));
                    }else if(optionContext.out!=null){
                        nicpo.setOutput(VisitorHelper.getLong(optionContext.out));
                    }
                }
                if(nicpo.getMAC()!=null && !nicpo.getMAC().equals("::1")){
                    genericNICPOList.add(nicpo);
                }
            }
        }
        this.deviceInfo.setNicpoList(genericNICPOList);

        return null;

    }
}
