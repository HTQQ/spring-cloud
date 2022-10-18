package com.ht.service.serviceImp;

import com.ht.service.IMessageProvide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/8/12 10:15
 * @description:
 */
@EnableBinding(Source.class)
public class MessageProvideImpl implements IMessageProvide {
    Logger logger = LoggerFactory.getLogger(MessageProvideImpl.class);

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        logger.info("******--" + s);
        return null;
    }
}
