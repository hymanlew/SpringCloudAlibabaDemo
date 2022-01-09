package com.hyman.common.util;

import org.springframework.util.DigestUtils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Created by tc on 2018/7/26.
 * image相关工具类
 */
public class ImageUtils {

    public String getFileNameByUrl(String url, String suffix) throws Exception {
        Date date = new Date();
        String fileName1 = DigestUtils.md5DigestAsHex(url.getBytes());
        String path = System.getProperty("java.io.tmpdir") + "/" + fileName1 + "_" + date.getTime() + "." + suffix;
        download(url, path);
        return path;
    }

    public static void download(String urlString, String filename) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        OutputStream os = new FileOutputStream(filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }
}
