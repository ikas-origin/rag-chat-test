package com.yupi.airagchat.ai;

import dev.langchain4j.rag.content.Content;
import dev.langchain4j.service.Result;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiCodeServiceHelperTest {

    @Resource
    private AiCodeServiceHelper aiCodeServiceHelper;

    @Test
    void chat() {
        String result = aiCodeServiceHelper.chat("你好，请写一首五言唐诗");
        System.out.println(result);
    }

    @Test
    void charWithMemory() {
        String result = aiCodeServiceHelper.chat("你好，我是程序员ikas");
        System.out.println(result);
        result = aiCodeServiceHelper.chat("你好，你还记得我是谁吗？我的中文名你能对照出来吗？");
        System.out.println(result);
    }

    @Test
    void chatForReport() {
        String userMessage = "你好，我是程序员ikas，学编程两年半，请帮我制定学习报告";
        AiCodeServiceHelper.Report result = aiCodeServiceHelper.chatForReport(userMessage);
        System.out.println(result);
    }

    @Test
    void chatWithRag() {
        Result<String> result = aiCodeServiceHelper.chatWithRag("怎么学习 Java？有哪些常见面试题？");
        System.out.println(result.sources());
        System.out.println(result.content());
//        String content = result.content();
//        List<Content> sources = result.sources();
//        System.out.println(content);
//        System.out.println(sources);
    }

    @Test
    void charWithTools() {
        String result = aiCodeServiceHelper.chat("有哪些常见的计算机网络面试题？");
        System.out.println(result);
    }

    @Test
    void charWithMcp() {
        String result = aiCodeServiceHelper.chat("什么是程序员鱼皮的编程导航？");
        System.out.println(result);
    }

    @Test
    void charWithGuardrail() {
        String result = aiCodeServiceHelper.chat("什么是程序员鱼皮的编程导航？");
        System.out.println(result);
    }
}