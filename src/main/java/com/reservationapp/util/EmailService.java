package com.reservationapp.util;

import jakarta.activation.DataSource;
import jakarta.mail.internet.MimeMessage;

import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailMailSender;

    /**
     * Sends an email with an attachment.
     * @param to The recipient's email address.
     * @param subject The subject of the email.
     * @param text The content of the email.
     * @param attachment The byte array representing the attachment.
     * @param attachmentName The name of the attachment.
     */
    public void sendEmailWithAttachment(String to,String subject,String text,byte[] attachment,String attachmentName){
        try {
            // Create a MimeMessage object for sending email
            MimeMessage message = emailMailSender.createMimeMessage();

            // Create MimeMessageHelper for handling MIME messages
            MimeMessageHelper helper = new MimeMessageHelper(message,true);

            // Set the recipient's email address
            helper.setTo(to);

            // Set the subject of the email
            helper.setSubject(subject);

            // Set the content of the email
            helper.setText(text);

            // Add attachment to the email
            DataSource dataSource = new ByteArrayDataSource(attachment,"application/pdf");
            helper.addAttachment(attachmentName,dataSource);

            // Send the email
            emailMailSender.send(message);
        }catch (Exception e){
            // Handle any exceptions that occur during email sending
            e.printStackTrace();
        }
    }
}
