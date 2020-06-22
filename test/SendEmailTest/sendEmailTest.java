/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SendEmailTest;

import Controller.SendMailBySite;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author DELL
 */
public class sendEmailTest {
    @Test
    public void sendSuccessTest() {
        String user = "cloneforfun1998@gmail.com";
        String pass = "S2YoshinoS2";
        String sub = "Yêu cầu thanh toán tiền nước:";
        String to = "zhaoyun2nd1998@gmail.com";
        String msg = "Demo test";
        String s = SendMailBySite.send(to, sub, msg, user, pass);
        Assert.assertEquals("Đã gửi xong", s);
    }
    
    @Test
    public void sendNotSubTest() {
        String user = "cloneforfun1998@gmail.com";
        String pass = "S2YoshinoS2";
        String sub = "";
        String to = "conbothaimeyen@gmail.com";
        String msg = "Demo test";
        String s = SendMailBySite.send(to, sub, msg, user, pass);
        Assert.assertEquals("Đã gửi xong", s);
    }
    
    @Test
    public void sendToNonExistEmail() {
        String user = "cloneforfun1998@gmail.com";
        String pass = "S2YoshinoS2";
        String sub = "Yêu cầu thanh toán tiền nước:";
        String to = "asdfghj@xcvbnm,fdfghjk.com.com";
        String msg = "Demo test";
        String s = SendMailBySite.send(to, sub, msg, user, pass);
        Assert.assertEquals("Có lỗi xảy ra", s);
    }

    @Test
    public void sendNotToTest() {
        String user = "cloneforfun1998@gmail.com";
        String pass = "S2YoshinoS2";
        String sub = "Yêu cầu thanh toán tiền nước:";
        String to = "";
        String msg = "Demo test";
        String s = SendMailBySite.send(to, sub, msg, user, pass);
        Assert.assertEquals("Không có người nhận", s);
    }
    @Test
    public void sendNotUserTest() {
        String user = "";
        String pass = "S2YoshinoS2";
        String sub = "Yêu cầu thanh toán tiền nước:";
        String to = "conbothaimeyen@gmail.com";
        String msg = "Demo test";
        String s = SendMailBySite.send(to, sub, msg, user, pass);
        Assert.assertEquals("Không có người gửi", s);
    }
}
