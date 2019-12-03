package com.sugar.gmail.web.util;

import org.apache.commons.lang3.StringUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class PmsFileuploadUtil {

    private static Logger logger = LoggerFactory.getLogger(PmsFileuploadUtil.class);

    /**
     * 图片双穿
     *
     * @param file 文件对象
     * @return 文件url
     */
    public static String uploafImg(MultipartFile file) {
        StringBuilder url = new StringBuilder("http:192.168.19.11");
        try {
            String trackerConfPath = PmsFileuploadUtil.class.getResource("/tracker.conf").getFile();
            ClientGlobal.init(trackerConfPath);
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageClient storageClient = new StorageClient(trackerServer, null);

            //获取文件字节数组
            byte[] bytes = file.getBytes();
            String originalFilename = file.getOriginalFilename();

            String[] upload_file = storageClient.upload_file(bytes, getFileSufix(originalFilename), null);

            for (String s : upload_file) {
                url.append("/").append(s);
            }

            return url.toString();

        } catch (Exception e) {
            logger.error(e.getMessage());
            return "";
        }
    }

    /**
     * 获取文件后缀名
     *
     * @param fileName 文件名
     * @return 文件后缀名
     */
    public static String getFileSufix(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return "";
        }
        String s = fileName.substring(fileName.lastIndexOf("."));
        return StringUtils.isEmpty(s) ? "" : s;
    }


}
