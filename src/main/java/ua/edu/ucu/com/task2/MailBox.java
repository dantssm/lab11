package ua.edu.ucu.com.task2;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MailBox {
    private List<MailInfo> mailInfoList = new ArrayList<>();

    public void addMailInfo(MailInfo mailInfo) {
        mailInfoList.add(mailInfo);
    }

    public void sendAll(MailSender mailSender) {
        for (MailInfo mailInfo : mailInfoList) {
            mailSender.sendMail(mailInfo);
        }
        mailInfoList.clear();
    }
    
}
