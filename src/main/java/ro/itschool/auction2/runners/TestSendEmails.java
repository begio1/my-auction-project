package ro.itschool.auction2.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import ro.itschool.auction2.service.EmailService;

public class TestSendEmails implements CommandLineRunner {
    @Autowired
    private EmailService emailService;

    @Override
    public void run(String... args) throws Exception {

        this.emailService.sendEmailWithTemplate("oancae123@gmail.com", "Test template", "Test test test");
    }
}
