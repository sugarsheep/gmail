package com.sugar.gmail.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GmailManageWebApplicationTest {

    @Test
    public void test01() throws IOException, MyException {
        String file = this.getClass().getResource("/tracker.conf").getFile();
        ClientGlobal.init(file);
        TrackerClient trackerClient=new TrackerClient();
        TrackerServer trackerServer=trackerClient.getConnection();
        StorageClient storageClient=new StorageClient(trackerServer,null);
        String orginalFilename="C:\\Users\\13784\\Desktop\\images\\2a4f662f4ca3d043d4ee15dba359c239.jpeg";
        String[] upload_file = storageClient.upload_file(orginalFilename, "jpeg", null);

        StringBuilder url = new StringBuilder("http:192.168.19.11");

        for (String s : upload_file) {
            url.append("/").append(s);
            System.out.println("s = " + s);
        }

        System.out.println(url.toString());


    }
}
