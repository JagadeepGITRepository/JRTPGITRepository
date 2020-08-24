
package com.his.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.his.model.User;

@Configuration
public class EmailSenderUtility {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendUserAccUnlockMail1(User  user) {
		boolean isSent = false;
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(user.getEmail());
			msg.setSubject("Account Creation Email");
			msg.setText(getUnlockAccUserBody(user));
			mailSender.send(msg);
			isSent = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
		
	}
	
	
	public boolean sendUserAccUnlockMail2(User  user) {
		boolean isSent = false;
		try {
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setTo(user.getEmail());
			helper.setSubject("unlock your Account for Varification ");
			helper.setText(getUnlockAccUserBody(user), true);
			mailSender.send(msg);
			isSent = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
		
	}
	
	
	
	private String getUnlockAccUserBody(User user) throws IOException {
		StringBuffer sb = new StringBuffer();
		//file reader read data char by char
		FileReader fr = new FileReader("UNLOCK-EMAIL-ACC-BODY-TEMPLATE.txt");
		//Buffer reader read data line by line
		BufferedReader br = new BufferedReader(fr);
		String readLine = br.readLine();
		
		while(readLine != null) {
			sb.append(readLine);
			readLine = br.readLine();
		}
		br.close();
		
		// format mail body
				String mailBody = sb.toString();
				mailBody = mailBody.replace("{FNAME}", user.getFirstName());
				mailBody = mailBody.replace("{LNAME}", user.getLastName());
				mailBody = mailBody.replace("{TEMP-PWD}", user.getPassword());
				mailBody = mailBody.replace("{EMAIL}", user.getEmail());
				mailBody = mailBody.replace("{ROLE}", user.getRole());

		return mailBody;
		
	};


}
