package com.springboot.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-06 17:05
 */
public class Dict {
    private static Logger logger = LoggerFactory.getLogger(Dict.class);

    public static final String IMG_URL_PREFIX;

    static  {
        Properties props = new Properties();
        InputStreamReader in;
        try {
            in = new InputStreamReader(Dict.class.getClassLoader().getResourceAsStream("dict.properties"),"UTF-8");
            props.load(in);
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            logger.error("load wechat setting error,pleace check the file path:wechat.properties");
            logger.error(e.toString(), e);
        }

        IMG_URL_PREFIX = props.getProperty("img.url.prefix");
    }

}
