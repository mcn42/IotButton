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
import java.util.List;
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
        List<String> list = NotificationList.getNotificationList();

        StringBuilder sb = new StringBuilder();
        String message = String.format("Received event data: %s ", data);
        sb.append(message);
        sb.append("\n");
        
        Map<String, MessageAttributeValue> smsAttributes
                = new HashMap<>();
        //<set SMS attributes>
        smsAttributes.put("AWS.SNS.SMS.SenderID", new MessageAttributeValue()
                .withStringValue("mcn42-IoT") // The sender ID shown on the device.
                .withDataType("String"));
        
        for (String phoneNumber : list) {
            PublishResult res = sendSMSMessage(snsClient, message, phoneNumber, smsAttributes);
            sb.append(String.format("Notified %s", phoneNumber));
        }

        ctx.getLogger().log(sb.toString());
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
