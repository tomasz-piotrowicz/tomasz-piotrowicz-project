package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {
    @InjectMocks
    private TrelloMapper mapper;

    @Test
    public void testMapToBoards(){
        //Given
        TrelloListDto listDto = new TrelloListDto("1", "list1", true);
        ArrayList<TrelloListDto>  trelloListDtos = new ArrayList<>();
        trelloListDtos.add(listDto);
        ArrayList<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("1", "board1", trelloListDtos));
        //When
        List<TrelloBoard> testedBoard = mapper.mapToBoards(trelloBoardDtos);
        //Then
        assertEquals(1, testedBoard.size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloList list = new TrelloList("1", "list1", true);
        ArrayList<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(list);
        ArrayList<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "board1", trelloLists));
        //When
        List<TrelloBoardDto> testedBoard = mapper.mapToBoardsDto(trelloBoards);
        //Then
        assertEquals(1, testedBoard.size());
    }

    @Test
    public void testMapToList() {
        //Given
        TrelloListDto listDto = new TrelloListDto("1", "list1", true);
        ArrayList<TrelloListDto>  trelloListDtos = new ArrayList<>();
        trelloListDtos.add(listDto);
        //When
        List<TrelloList> testedList = mapper.mapToList(trelloListDtos);
        //Then
        assertEquals(1, testedList.size());
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloList list = new TrelloList("1", "list1", true);
        ArrayList<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(list);
        //When
        List<TrelloListDto> testedList = mapper.mapToListDto(trelloLists);
        //Then
        assertEquals(1, testedList.size());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("trello1", "tested card", "1", "id1");
        //When
        TrelloCardDto testedCard = mapper.mapToCardDto(card);
        //Then
        assertEquals(card.getName(), testedCard.getName());
    }

    public void testMapToCard() {
        //Given
        TrelloCardDto card = new TrelloCardDto("trello1", "tested card", "1", "id1");
        //Then
        TrelloCard testedCard = mapper.mapToCard(card);
        //Then
        assertEquals(card.getName(), testedCard.getName());
    }
}
