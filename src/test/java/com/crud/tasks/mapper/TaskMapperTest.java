package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTest {
    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask(){
        //Given
        TaskDto taskDto = new TaskDto(1L, "task1", "tested task");
        //When
        Task testedTask = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(taskDto.getId(), testedTask.getId());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "task1", "tested task");
        //When
        TaskDto testedTask = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(task.getId(), testedTask.getId());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "task1", "tested task"));
        //When
        List<TaskDto> testedList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(1,testedList.size());
    }
}
