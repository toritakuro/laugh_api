package com.c4ccup.laugh.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sesv2.SesV2Client;
import software.amazon.awssdk.services.sesv2.model.Body;
import software.amazon.awssdk.services.sesv2.model.Content;
import software.amazon.awssdk.services.sesv2.model.Destination;
import software.amazon.awssdk.services.sesv2.model.EmailContent;
import software.amazon.awssdk.services.sesv2.model.Message;
import software.amazon.awssdk.services.sesv2.model.SendEmailRequest;
import software.amazon.awssdk.services.sesv2.model.SesV2Exception;

@Component
public class AwsSesUtil {

    @Autowired
    private PropBean prop;

    /** SesClient */
    SesV2Client sesv2Client = null;


    public AwsSesUtil () {
        sesv2Client = SesV2Client.builder()
                .region(Region.AP_NORTHEAST_1)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();
    }


    /**
     *
     * @param recipient 宛先
     * @param subject タイトル
     * @param bodyHTML 本文
     */
    public void send(String recipient,
                          String subject,
                          String bodyHTML) {
        // 送信対象
        Destination destination = Destination.builder()
                .toAddresses(recipient)
                .build();
        // タイトル
        Content sub = Content.builder()
                .data(subject)
                .build();
        // 表示内容
        Content content = Content.builder()
                .data(bodyHTML)
                .build();
        Body body = Body.builder()
                .html(content)
                .build();

        Message msg = Message.builder()
                .subject(sub)
                .body(body)
                .build();

        EmailContent emailContent = EmailContent.builder()
                .simple(msg)
                 .build();
        SendEmailRequest emailRequest = SendEmailRequest.builder()
                .destination(destination)
                .content(emailContent)
                .fromEmailAddress(prop.getEmail())
                .build();
        // メール送信
        try {
            sesv2Client.sendEmail(emailRequest);
        } catch (SesV2Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
        }
    }
}
