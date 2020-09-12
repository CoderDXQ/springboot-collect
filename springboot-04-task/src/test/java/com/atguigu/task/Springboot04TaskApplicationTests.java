package com.atguigu.task;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
class Springboot04TaskApplicationTests {

    @Autowired //装在一个实现类
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7：30开会");
        message.setTo("xxx@bupt.edu.cn");
        message.setFrom("xxx@qq.com");

        mailSender.send(message);
    }

    @Test
    public void test02() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //邮件设置
        helper.setSubject("通知-今晚开会");
        helper.setText("今晚7：30开会");
        helper.setTo("xxx@bupt.edu.cn");
        helper.setFrom("xxx@qq.com");

        //上传文件
        helper.addAttachment("1.jpeg",new File("/Users/xxx/Desktop/1.jpeg"));
        helper.addAttachment("2.jpeg",new File("/Users/xxx/Desktop/2.jpeg"));
        mailSender.send(mimeMessage);
    }


}
