package com.atguigu.elastic;

import com.atguigu.elastic.bean.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;




@RunWith(SpringRunner.class)
@SpringBootTest
class Springboot03ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    @Test
    public void contextLoads() {
        //给ES索引保存一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("zhangsan");
        article.setContent("Hello World");

        //构建一个索引功能
        Index index = new Index.Builder(article).index("atguigu").type("news").build();

        try{//客户端执行索引
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
