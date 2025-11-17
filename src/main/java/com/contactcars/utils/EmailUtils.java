package com.contactcars.utils;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class EmailUtils {

    public static void sendExtentReport(String reportPath, String recipient) throws IOException {
        Email from = new Email(System.getenv("REPORT_SENDER"));
        String subject = "Automation Test Report";
        Email to = new Email(recipient);
        Content content = new Content("text/plain", "Please find the attached Extent Report.");
        Mail mail = new Mail(from, subject, to, content);

        // Attach HTML report
        Attachments attachments = new Attachments();
        attachments.setContent(java.util.Base64.getEncoder()
                .encodeToString(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(reportPath))));
        attachments.setType("text/html");
        attachments.setFilename("extentReport.html");
        attachments.setDisposition("attachment");
        mail.addAttachments(attachments);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println("Report email sent. Status: " + response.getStatusCode());
        } catch (IOException ex) {
            throw ex;
        }
    }

}
