package com.project.init.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mail")
public class MailController {

	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@ResponseBody
	@RequestMapping(value = "joinCert", method = RequestMethod.GET)
    public String joinCert(HttpServletRequest request) throws Exception {
		logger.info("joinCert() in >>> ");
		// ajax�� ���� �Է��� �����ּҸ� ������ Controller�� ������ȣ�� ������.
		String email = request.getParameter("email");
		
		
		// mail ����
        String subject = "[WAYG] ȸ�������� ���� ������ȣ�Դϴ�.";
        
        
        // mail ���� ����
        String content= "";
        String pinNum = "";
        for ( int i = 0; i < 6; i++ ) {
        	int pin = (int)(Math.random() * 10);
        	
        	if ( i == 0 && pin == 0 ) {
        		pinNum += pin + 1;
        	}
        	
        	pinNum += pin;
        }
        
        
        content += "�ȳ��ϼ���, WAYG�Դϴ�.<br/>"; 
        content += "�̸��� ������ ���� PIN ��ȣ�Դϴ�.<br/> �Ʒ��� ��ȣ�� Ȯ���Ͻð� ȸ�� ����â�� ��Ȯ�� �Է����ּ���.<br/><br/>";
        content += "<hr/>";
        content += "<br/>ȸ������ ������ȣ�� " + pinNum + "�Դϴ�.<br/>";
        content += "ȸ������ ���������� PIN ��ȣ�� ��Ȯ�� �Է����ּ���.";
        
        
        // ������ ���
        String from = "WAYG <wayg.superad@gmail.com>";
        
        // �޴� ���
        String to = email;
        
        
	    try {
	        MimeMessage mail = mailSender.createMimeMessage();
	        MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
	            
	        mailHelper.setFrom(from);
	        mailHelper.setTo(to);
	        mailHelper.setSubject(subject);
	        mailHelper.setText(content, true);
	        // html�±׸� ����Ϸ��� true           
	        mailSender.send(mail);
	        return pinNum;
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	        return "error";
	    }        
	}
	
}
