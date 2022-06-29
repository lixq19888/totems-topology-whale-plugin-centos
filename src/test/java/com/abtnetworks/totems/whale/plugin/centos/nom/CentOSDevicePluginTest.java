package com.abtnetworks.totems.whale.plugin.centos.nom;

import com.abtnetworks.totems.whale.common.domain.ids.GenericHostPO;
import com.abtnetworks.totems.whale.common.domain.obj.GenericDevicePO;
import com.abtnetworks.totems.whale.common.domain.routing.GenericDeviceRoutingPO;
import com.abtnetworks.totems.whale.common.domain.routing.RoutingTablePO;
import com.abtnetworks.totems.whale.common.plugin.DevicePlugin;
import com.abtnetworks.totems.whale.common.plugin.DeviceRoutingSupport;
import com.abtnetworks.totems.whale.common.plugin.HostPlugin;
import com.abtnetworks.totems.whale.common.utils.IOUtil;
import com.abtnetworks.totems.whale.common.utils.JacksonObjectMapper;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class CentOSDevicePluginTest {

    private static JacksonObjectMapper MAPPER = JacksonObjectMapper.GLOBAL_DEFAULT_MAPPER;

    @Test
    public void getDevice() throws Exception {
        HostPlugin devicePlugin = new CentOSDevicePlugin();
        String fileName = "centos-test6.conf";
        URL path = CentOSDevicePluginTest.class.getClassLoader().getResource(fileName);
        String pathStr = path.getPath();
        int a = pathStr.indexOf(":");
        pathStr = pathStr.substring(a +1);
        String content = IOUtil.getFileContent(pathStr, 0);
        long before = System.currentTimeMillis();
        GenericHostPO genericDevicePO = devicePlugin.getHost(content, null);
        long after = System.currentTimeMillis();
        System.out.println("Finished parsing, time taken: " + (after-before));
        Writer writer = new OutputStreamWriter(new FileOutputStream(pathStr + ".json"), StandardCharsets.UTF_8);
        MAPPER.writeValue( writer, genericDevicePO);

    }

//
//    @Test
//    public void getDeviceRouting() throws Exception {
//        DeviceRoutingSupport deviceRoutingSupport = new CentOSDevicePlugin();
//        String fileName = "citrix-test1.rt.conf";
//        URL path = CentOSDevicePluginTest.class.getClassLoader().getResource(fileName);
//        String pathStr = path.getPath();
//        int a = pathStr.indexOf(":");
//        pathStr = pathStr.substring(a +1);
//        String content = IOUtil.getFileContent(pathStr, 0);
//        long before = System.currentTimeMillis();
//        List<GenericDeviceRoutingPO> genericDeviceRoutingPOS = deviceRoutingSupport.getDeviceRouting(content, null);
//        for(GenericDeviceRoutingPO po : genericDeviceRoutingPOS){
//            for(Map.Entry<String, RoutingTablePO> entry : po.getRoutingTables().entrySet()){
//                System.out.println(entry.getKey() + " 路由大小：" + entry.getValue().getRoutingEntries().size());
//            }
//
//        }
//        long after = System.currentTimeMillis();
//        System.out.println("Finished parsing, time taken: " + (after-before));
//        Writer writer = new OutputStreamWriter(new FileOutputStream(pathStr + ".json"), StandardCharsets.UTF_8);
//        MAPPER.writeValue( writer, genericDeviceRoutingPOS);
//    }

}
