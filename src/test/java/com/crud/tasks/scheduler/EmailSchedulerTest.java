package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTest {
    @InjectMocks
    private EmailScheduler emailScheduler;
    @Mock
    private SimpleEmailService simpleEmailService;
    @Mock
    private TaskRepository taskRepository;
    @Mock
    private AdminConfig adminConfig;

    @Test
    public void testSendInformationEmail() {
        //Given
        //When
        emailScheduler.sendInformationEmail();
    }
}
