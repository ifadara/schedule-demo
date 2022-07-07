package com.example.ScheduleDemo.Service;

import com.example.ScheduleDemo.Entities.Emails;
import com.example.ScheduleDemo.Repository.EmailRepository;
import com.example.ScheduleDemo.Util.JsonToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;


    private Logger logger = Logger.getLogger("com.example.ScheduleDemo.Service.EmailService");

    @Scheduled(cron = "0 0/5 * * * *")
    public void generateEmails() throws Exception{


        try {
            URL url = new URL("https://api.generadordni.es/person/email");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != 200)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader res = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            List<String> emails = List.of(JsonToString.convertJsonToString(res).split(","));

            emails.forEach(email -> emailRepository.save(new Emails(email)));

            logger.info("Executou o Scheduled e Salvou os dados no banco");

        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }

    }
}
