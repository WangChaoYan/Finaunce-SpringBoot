package com.qf.config;

import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author 杨小柒丶
 * @Date 2019/10/9
 * @Time 19:41
 */
@Configuration
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101200671591";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCSrNa3MPgVsVbSK9kaaJsfmlHl2eNoVFv+YJXL5F+SiZaJlEDDympm2NBft28hibDhZk5W1XZoBNKpWh4cs/o/ozJUzrKQZTpr+UerzN5PelZEturbcex4sYhEBaZ9zpWsRIOMdi2Kfon2ktv00gP6/r51nVJpec3b1Pux7SehcnpA/UWlC+1TGO1damlKa4oXWxpGPi0TVsOTi/wDHC8/VSuOB0lHTaRBfZTyiFYkSR9RzYo9hwCjexfOOk4DMGoylsP0wJMh2OgoGZ0zFb7Ks5la41xGZf6QS77QJEdHiGiojttAO5hDZdoJ5vDR4c3sUIYVx3wrmUtSv5wCRB9HAgMBAAECggEAWZ20ytTmnwptS5hy24nSTarSIyfPo+z3ECMfIyZzpmreSU0FjRrdi90o43KGOe2Q3wbNEoz1/XQE6mgfQdZNLhieJebsfwD6gwIZ4kQYCGNs1isUr+OZYdzGrxjssq1IEasC3Q1PofDSho8QSTMQL4j6AY6PzdYYCxrEdd+6eQ81cAy4f6B4abUN1bItNasBao7zbIOsIoJiHHYydLY2G4nxe8mNlmnKJmm0F+PvS3j3+3ZOv9iFIyEhY+c0ovnprpM0AO1mAe39Rlzg1OX7aTg8TjUdYQr4UEY3yZcpahAIYihvDrqpIAYLaW8L5WzNRT54fY3+DXn44qgWVT12EQKBgQDQNu0oFG3KJ+3WEPAmKXWG0BAhzb/3oZiR/eITKbXsI6Ku2/dAf/8eJS1dOtDCBgXAV5lUuUhDXmrw515a3HcsrTYR+CBsRfLCF4fXq7nicUM82e1EIusRJsfFdCn3KuwYKm9aWicp43VujixgN8Hqnh5z+6gSOIH1zBwNNqRbmwKBgQC0VlV3Y2x8opksbh52LHr17p2Y+J7I6SQCW8BYGXFx9bU+EZJb6sSUJiJmbfoMZHw/ycQ8VLJMUL+RUV4Wjl44pW2RUPg7hsDUa5ILlnrq13c0h7Qa/S6iTwSyNAbF/wNiV2z4NzMbaT2DgztHXs2dWY09nVXf2F32/aMns5lzxQKBgQCXH3asQ3+YXbjLSYn0ON07lyJOVrbBdkF1nQ8Ml5aaKRc30SG5Z+10JMmzRDAm0xYzj6ETlFN1yj7WUSfzzNaWz7VR/4UQ8QgMheWrzNFjIJALx6Tlcm6pCTuv/etDoZywwYQG0S5hwd0G/BwLTgzqTA+QYRSQ/QCetaGamZFbhwKBgQCBM+Gj2d3eJfisNnEopZGrJbxP3sCUnUSpU+cot4Hp7epef+RmantQ0UmQLXca7dt/MCWiO+RKfQfjK3LHolSrLQqlNGfE7jS1fCR0nOmP27OSNS+6rm585zQsIM5BiQV5rb1q0NGS8AGceac86RVTiNeCr3jZGYGo9euxBCILKQKBgFZBDOkl5RicY20/6CqjGiS2hHeHK5n0zXJzg5m23fCy3LPzg1HhXS/DNjXujB97QoJDfGRBOkWxziMl5oLad80Sb3g5K0siZNlr039f+qpLg+wl47eXDR8rRs4cWx8Z5pCpLpf37ORTjA00+bQcoss34aoT7nTKqDMPIW8KCPEF";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥
    public static String alipay_public_key =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzl0FWh+wHh4SFXOHVVHA7Mmf97Js+5/tCxURXqoAs9CkWvp0vHFO6j0u10gnsqbtDtRVfyoJvEE1yJYhPWaaZzkU+EgHA83p98j0JY7Z9T7+o9rAccuw0IT71CBMUzDUuunIvn4q7IbJHaqK6rDtVhOOJ17/KE53Zq7UcaoyfPEpgpbXvUpxvM8E5h8fgFElzdrBRA+UcpWjXNG+RBqpyuUZwN/LaUg6EynFpJ3unPnRY34MFOZmgwh2dcT19c/rYoq2zOW44UjCzGeW68gGItLS1ZfckAm+zEx/gZANDU15tm1PsPQDAZf0lykWxCDQtqGnhVkdyCjcR8SjQ+gGiQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/pay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/pay/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}