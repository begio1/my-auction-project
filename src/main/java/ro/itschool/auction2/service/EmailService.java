package ro.itschool.auction2.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.thymeleaf.context.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;


@Component
public class EmailService {
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String message) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(message);

        this.javaMailSender.send(mimeMessage);


    }

    public void sendEmail(String to, String subject, String message, String csvReport) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(message);

        byte[] csvReportBytes = csvReport.getBytes();
        ByteArrayDataSource byteArrayDataSource = new ByteArrayDataSource(csvReportBytes, "text/csv");
        mimeMessageHelper.addAttachment("report.csv", byteArrayDataSource);

        this.javaMailSender.send(mimeMessage);

    }


    public void sendEmailWithTemplate(String to, String subject, String message) throws MessagingException {


        Context context = new Context();
        context.setVariable("title", "my title");
        context.setVariable("message", "my message");

        String htmlContent = templateEngine.process("email-template.html", context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);

        javaMailSender.send(mimeMessage);


    }
}
