package com.yupi.airagchat;

import com.yupi.airagchat.ai.AiCodeHelper;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiRagChatApplicationTests {

    @Resource
    private AiCodeHelper aiCodeHelper;



    @Test
    void chat() {
        aiCodeHelper.chat("你好，请简单介绍一下你自己");
    }


    void testChatWithMessage() {
        UserMessage userMessage = UserMessage.from(
                TextContent.from("描述图片"),
                ImageContent.from("https://www.codefather.cn/logo.png")
        );
        aiCodeHelper.chatWithMessage(userMessage);

    }

}
