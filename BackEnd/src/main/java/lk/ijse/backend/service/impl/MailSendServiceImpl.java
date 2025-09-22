package lk.ijse.backend.service.impl;

import jakarta.mail.internet.MimeMessage;
import lk.ijse.backend.service.MailSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSendServiceImpl implements MailSendService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    private String loginAlert(String userName) {
        return String.format("""
    <html>
      <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <style>
          body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #000000;
            color: #ffffff;
          }
          .container {
            max-width: 650px;
            margin: 40px auto;
            background-color: #141414;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 8px 20px rgba(0,0,0,0.7);
            border: 1px solid #e50914;
          }
          .header {
            background: #e50914;
            color: #fff;
            text-align: center;
            padding: 30px 20px;
            font-size: 26px;
            font-weight: 700;
            letter-spacing: 1px;
          }
          .content {
            padding: 35px 30px;
            line-height: 1.7;
            color: #e5e5e5;
          }
          .content p {
            margin-bottom: 18px;
            font-size: 16px;
          }
          .button {
            display: inline-block;
            padding: 14px 28px;
            background: #e50914;
            color: #fff !important;
            text-decoration: none;
            border-radius: 5px;
            font-weight: 600;
            box-shadow: 0 5px 15px rgba(229,9,20,0.5);
            transition: transform 0.2s ease, box-shadow 0.2s ease;
          }
          .button:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 20px rgba(229,9,20,0.7);
          }
          .alert-box {
            padding: 20px;
            border-left: 5px solid #e50914;
            background-color: #1f1f1f;
            border-radius: 6px;
            margin: 25px 0;
            color: #ffffff;
          }
          .footer {
            padding: 20px;
            font-size: 13px;
            color: #aaaaaa;
            text-align: center;
            background-color: #0a0a0a;
          }
          .footer a {
            color: #e50914;
            text-decoration: none;
          }
          hr {
            margin: 30px 0;
            border: none;
            border-top: 1px solid #333;
          }
          @media only screen and (max-width: 600px) {
            .content { padding: 25px 20px; }
            .header { font-size: 22px; padding: 25px 15px; }
            .button { padding: 12px 24px; font-size: 15px; }
          }
        </style>
      </head>
      <body>
        <div class="container">
          <div class="header">Netflix Login Alert</div>
          <div class="content">
            <p>Hi <strong>%s</strong>,</p>
            <div class="alert-box">
              <p>We noticed a new login to your Netflix account.</p>
              <p>If this was you, there’s nothing else you need to do.</p>
            </div>
            <p>If you did <strong>NOT</strong> log in, we strongly recommend securing your account now:</p>
            <a href="https://www.netflix.com/LoginHelp" class="button">Secure Your Account</a>
            <hr>
            <p>Enjoy watching the latest movies and TV shows anytime, anywhere.<br>
            Stay safe, stay entertained 🎬🍿</p>
          </div>
          <div class="footer">
            &copy; %s Netflix | All rights reserved | 
            <a href="https://www.netflix.com/privacy">Privacy Policy</a>
          </div>
        </div>
      </body>
    </html>
    """, userName, java.time.Year.now());
    }

    private String registeredAlert(String userName) {
        String dateTime = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return String.format("""
    <html>
      <head>
        <style>
          body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #000000;
            color: #ffffff;
          }
          .container {
            max-width: 650px;
            margin: 40px auto;
            background-color: #141414;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 8px 20px rgba(0,0,0,0.7);
            border: 1px solid #e50914;
          }
          .header {
            background: #e50914;
            color: #fff;
            text-align: center;
            padding: 30px 20px;
            font-size: 28px;
            font-weight: 700;
            letter-spacing: 1px;
          }
          .content {
            padding: 35px 30px;
            line-height: 1.7;
            color: #e5e5e5;
          }
          .content p {
            margin-bottom: 18px;
            font-size: 16px;
          }
          .button {
            display: inline-block;
            padding: 14px 28px;
            background: #e50914;
            color: #fff !important;
            text-decoration: none;
            border-radius: 5px;
            font-weight: 600;
            box-shadow: 0 5px 15px rgba(229,9,20,0.5);
            transition: transform 0.2s ease, box-shadow 0.2s ease;
          }
          .button:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 20px rgba(229,9,20,0.7);
          }
          .alert-box {
            padding: 20px;
            border-left: 5px solid #e50914;
            background-color: #1f1f1f;
            border-radius: 6px;
            margin: 25px 0;
            color: #ffffff;
          }
          .footer {
            padding: 20px;
            font-size: 13px;
            color: #aaaaaa;
            text-align: center;
            background-color: #0a0a0a;
          }
          .footer a {
            color: #e50914;
            text-decoration: none;
          }
          @media only screen and (max-width: 600px) {
            .content { padding: 25px 20px; }
            .header { font-size: 24px; padding: 25px 15px; }
            .button { padding: 12px 24px; font-size: 15px; }
          }
        </style>
      </head>
      <body>
        <div class="container">
          <div class="header">Welcome to Netflix</div>
          <div class="content">
            <p>Hi <strong>%s</strong>,</p>
            <p>Your Netflix journey begins now! 🎬<br>
            You can explore unlimited movies, TV shows, and exclusive originals right away.</p>
            
            <div class="alert-box">
              <p><strong>Account Created On:</strong> %s</p>
            </div>
            
            <p>Grab your popcorn and start streaming the stories you love.</p>
            <a href="https://www.netflix.com" class="button">Start Watching</a>
          </div>
          <div class="footer">
            &copy; %s Netflix | All rights reserved | 
            <a href="https://www.netflix.com/privacy">Privacy Policy</a>
          </div>
        </div>
      </body>
    </html>
    """, userName, dateTime, java.time.Year.now());
    }


    public void sendLoggedInEmail(String userName, String toEmail, String subject) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(loginAlert(userName), true);

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sendRegisteredEmail(String name, String email, String subject) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(registeredAlert(name), true);

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
