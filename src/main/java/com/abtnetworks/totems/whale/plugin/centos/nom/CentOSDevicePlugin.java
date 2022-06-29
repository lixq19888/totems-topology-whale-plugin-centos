package com.abtnetworks.totems.whale.plugin.centos.nom;

import com.abtnetworks.totems.whale.common.domain.filter.RuleListTypePO;
import com.abtnetworks.totems.whale.common.domain.ids.GenericHostPO;
import com.abtnetworks.totems.whale.common.domain.metadata.DeviceMetadata;
import com.abtnetworks.totems.whale.common.domain.obj.DevicePO;
import com.abtnetworks.totems.whale.common.domain.obj.GenericDevicePO;
import com.abtnetworks.totems.whale.common.domain.routing.GenericDeviceRoutingPO;
import com.abtnetworks.totems.whale.common.enums.SystemRuleListTypeEnum;
import com.abtnetworks.totems.whale.common.exceptions.WhalePluginRuntimeException;
import com.abtnetworks.totems.whale.common.plugin.*;
import com.abtnetworks.totems.whale.plugin.centos.nom.device.CentOSLexer;
import com.abtnetworks.totems.whale.plugin.centos.nom.device.CentOSParser;
import com.abtnetworks.totems.whale.plugin.centos.nom.device.impl.CentOSVisitorOverall;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;

/**
 * @author luwei
 * @date 2020/9/16
 */
@Slf4j
public class CentOSDevicePlugin implements HostPlugin {

    public static final String DEVICE_METADATA_NAME = "CentOS.se";
    private static DeviceMetadata deviceMetadata = null;

    public static final String DEVICE_FAMILY = "CentOS_SE";

//    public CentOSDevicePlugin() {
//        DeviceMetadata mydm = new DeviceMetadata(DEVICE_METADATA_NAME, this.getRuleListTypes(), this.getRuleListOrder());
//
//        try {
////            DevicePredefinedService myobj = VisitorHelper.loadServiceCSV(this.getClass(), "/cisco-nxos/services.csv");
////            mydm.setPredefinedService(myobj);
//        } catch (Exception var3) {
//            throw new WhalePluginRuntimeException("Failed to load services.csv file.", var3);
//        }
//
//        deviceMetadata = mydm;
//    }


//    @Override
//    public List<GenericDevicePO> getDevices(String configText, Map<String, Object> options) throws Exception {
//        GenericHostPO po = new GenericHostPO();
//        List<GenericDevicePO> list = new ArrayList<>();
//        list.add(getDevice(configText, options));
//        return list;
//    }

    @Override
    public List<DeviceMetadata> getDeviceMetadata() {
        return Collections.singletonList(deviceMetadata);
    }

    @Override
    public GenericHostPO getHost(String configText, Map<String, Object> var2) throws Exception {
        CodePointCharStream input = CharStreams.fromString(configText);
        CentOSLexer lexer = new CentOSLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CentOSParser parser = new CentOSParser(tokens);
        CentOSVisitorOverall visitor = new CentOSVisitorOverall(deviceMetadata);
        GenericHostPO myResult = visitor.createDeviceData(parser, configText);
        return myResult;
    }

//    @Override
//    public Set<String> getSupportedDeviceFamily() {
//        return Collections.singleton(DEVICE_FAMILY);
//    }
//
//    @Override
//    public GenericDevicePO getDevice(String configText, Map<String, Object> var2) throws Exception {
//        CodePointCharStream input = CharStreams.fromString(configText);
//        CentOSLexer lexer = new CentOSLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        CentOSParser parser = new CentOSParser(tokens);
//        CentOSVisitorOverall visitor = new CentOSVisitorOverall(deviceMetadata);
//        GenericDevicePO myResult = visitor.createDeviceData(parser, configText);
//        DevicePO device = myResult.getDevice();
//        device.setDeviceMetadataName(DEVICE_METADATA_NAME);
//        device.setManufacturer("Citrix Systems, Lb.");
//        return myResult;
//    }
//
//    @Override
//    public boolean canProcess(String configText) throws Exception {
//        BufferedReader reader = new BufferedReader(new StringReader(configText));
//        String line = null;
//        int count = 0;
//
//        while((line = reader.readLine()) != null) {
//            ++count;
//            if (count > 20) {
//                break;
//            }
//
//            if (line.startsWith("!Command: show running-config")) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    @Override
//    public List<GenericDeviceRoutingPO> getDeviceRouting(String configText, Map<String, Object> options) throws Exception {
//        CodePointCharStream input = CharStreams.fromString(configText);
//        CentOSRoutingLexer lexer = new CentOSRoutingLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        CentOSRoutingParser parser = new CentOSRoutingParser(tokens);
//        CentOSRoutingVisitorOverall visitor = new CentOSRoutingVisitorOverall(deviceMetadata, options);
//        return visitor.createDeviceRoutingData(parser);
//        return null;
//    }

    @Override
    public PluginMetadata getPluginMetadata() {
        return new PluginMetadata(PluginType.DEVICE, DEVICE_METADATA_NAME, "Cisco NXOS", "Cisco NXOS plugin");
    }
}
