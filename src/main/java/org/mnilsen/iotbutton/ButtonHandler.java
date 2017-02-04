/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mnilsen.iotbutton;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author michaeln
 */
public class ButtonHandler {

    public ButtonHandler() {
    }

    public void handleEvent(String data, Context ctx) {
        
        AmazonSNSClient snsClient = new AmazonSNSClient();
        
        String phoneNumber = "+1xxxxxxxxx";
        Map<String, MessageAttributeValue> smsAttributes
                = new HashMap<>();
        //<set SMS attributes>
        String message = String.format("Received event data: %s ", data);
        PublishResult res = sendSMSMessage(snsClient, message, phoneNumber, smsAttributes);
        
        ctx.getLogger().log(message + res);
    }

    public static PublishResult sendSMSMessage(AmazonSNSClient snsClient, String message,
            String phoneNumber, Map<String, MessageAttributeValue> smsAttributes) {
        PublishResult result = snsClient.publish(new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber)
                .withMessageAttributes(smsAttributes));
        return result;
    }
}
