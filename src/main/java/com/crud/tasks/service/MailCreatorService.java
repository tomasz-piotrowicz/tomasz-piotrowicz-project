package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalTime.now;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manager your tasks");
        functionality.add("Provides connection with Trello account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit webstite");
        context.setVariable("admin_name", adminConfig.getAdminMail());
        context.setVariable("owner", adminConfig.getOwnerName() + " " + adminConfig.getOwnerSurname());
        context.setVariable("company", adminConfig.getCompanyName());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildTaskInfoEmail(String message) {

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("admin_name", adminConfig.getAdminMail());
        context.setVariable("welcome_message", "Your daily tasks report: ");
        context.setVariable("localdate", now());
        return templateEngine.process("mail/tasks-information-mail", context);
    }
}
