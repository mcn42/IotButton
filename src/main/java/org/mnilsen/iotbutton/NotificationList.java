/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mnilsen.iotbutton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michaeln
 */
public class NotificationList {
    private static final List<String> list = new ArrayList<>();
    
    static
    {
        list.add("+1xxxxxxx");
    }
    
    public static List<String> getNotificationList()
    {       
        return list;   
    }
}
