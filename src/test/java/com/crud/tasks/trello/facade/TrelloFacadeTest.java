package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloFacadeTest {
    @InjectMocks
    private TrelloFacade trelloFacade;
    @Mock
    private TrelloService trelloService;
    @Mock
    private TrelloMapper trelloMapper;
    @Mock
    private TrelloValidator trelloValidator;

    @Test
    public void testCreateCard(){
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name1", "desc1", "1", "ID1");
        //When
        CreatedTrelloCardDto testedCard = trelloFacade.createCard(trelloCardDto);
    }

    @Test
    public void testFetchTrelloBoards() {
        //Given
        //When
        trelloFacade.fetchTrelloBoards();

    }
}
