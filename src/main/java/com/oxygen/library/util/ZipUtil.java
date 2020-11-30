package com.oxygen.library.util;

import org.slf4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class ZipUtil {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ZipUtil.class);

    /**
     * 解压到指定目录
     */
    public static List<String> unZipFiles(String zipPath,String descDir)throws IOException
    {
        return unZipFiles(new File(zipPath), descDir);
    }

    /**
     * 解压文件到指定目录
     */
    @SuppressWarnings("rawtypes")
    public static List<String> unZipFiles(File zipFile,String descDir)throws IOException {
        List<String> path = new ArrayList<>();
        File pathFile = new File(descDir);
        if(!pathFile.exists())
        {
            pathFile.mkdirs();
        }
        // 解决zip文件中有中文目录或者中文文件
        ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));
        for(Enumeration entries = zip.entries(); entries.hasMoreElements();)
        {
            ZipEntry entry = (ZipEntry)entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir+zipEntryName).replaceAll("\\*", "/");;
            // 判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if(!file.exists())
            {
                file.mkdirs();
            }
            // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if(new File(outPath).isDirectory())
            {
                continue;
            }
//            log.info(outPath);
            path.add(outPath);
            OutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while((len=in.read(buf1))>0)
            {
                out.write(buf1,0,len);
            }
            in.close();
            out.close();
        }
        log.info("******************解压完毕********************");
        return path;
    }


    public static void main(String[] args) throws IOException {
        /**
         * 解压文件
         */
        File zipFile = new File("d:/颜色提取工具.zip");
        String path = "d:/zipfile/";
        System.out.println(unZipFiles(zipFile, path));
    }
}