package com.abtnetworks.totems.whale.plugin.centos.nom.device.impl;

import com.abtnetworks.totems.whale.common.domain.deviceInterface.DeviceInterfacePO;
import com.abtnetworks.totems.whale.common.domain.ids.ChainRuleListPO;
import com.abtnetworks.totems.whale.common.domain.ids.ChainRulePO;
import com.abtnetworks.totems.whale.common.domain.ip.IP4AddressPO;
import com.abtnetworks.totems.whale.common.domain.obj.FilterServicePO;
import com.abtnetworks.totems.whale.common.domain.obj.IPItemPO;
import com.abtnetworks.totems.whale.common.enums.FilterRuleActionEnum;
import com.abtnetworks.totems.whale.common.plugin.VisitorHelper;
import com.abtnetworks.totems.whale.common.utils.TwoMemberObject;
import com.abtnetworks.totems.whale.plugin.centos.nom.device.CentOSParser;
import io.swagger.models.auth.In;

import java.util.ArrayList;

public class CentOSVisitorRule  extends CentOSVisitorAccess{

    @Override
    public Void visitIptablesSubInfo(CentOSParser.IptablesSubInfoContext ctx) {
        if(ctx.name!=null){
            ChainRuleListPO listPO = new ChainRuleListPO();
            listPO.setName(VisitorHelper.getText(ctx.name));
            listPO.setRulist(new ArrayList<>());
            if(ctx.chainRule()!=null){
                for(CentOSParser.ChainRuleContext subContext : ctx.chainRule()){
                    if(subContext.target!=null){
                        ChainRulePO po = new ChainRulePO();
                        String target = VisitorHelper.getText(subContext.target);
                        if(target.equals("ACCEPT") || target.equals("REJECT") || target.equals("DROP")){
                            String in = VisitorHelper.getText(subContext.in);
                            String out = VisitorHelper.getText(subContext.out);
                            String prot = VisitorHelper.getText(subContext.prot);

                            po.setAction(target);
                            po.setIn(in);
                            po.setOut(out);
                            po.setServicePO(prot);

                            if(subContext.mask!=null){
                                String mask = VisitorHelper.getText(subContext.mask);
                                po.setDescreption(mask);
                            }
                            if(subContext.srcIp4!=null){
                                po.setSourceAddress(VisitorHelper.getText(subContext.srcIp4));
                            }else if(subContext.srcIp4L!=null){
                                po.setSourceAddress(VisitorHelper.getText(subContext.srcIp4L));
                            }

                            if(subContext.dstIp4!=null){
                                po.setDestinationAddress(VisitorHelper.getText(subContext.dstIp4));
                            }else if(subContext.dstIp4L!=null){
                                po.setDestinationAddress(VisitorHelper.getText(subContext.dstIp4L));
                            }
                        }else{
                            po.setChain(true);
                            po.setChainName(target);
                        }
                        listPO.getRulist().add(po);
                    }
                }
            }
            if(this.deviceInfo.getChainList()==null){
                this.deviceInfo.setChainList(new ArrayList<>());
            }
            this.deviceInfo.getChainList().add(listPO);
        }
        return null;
    }

}
