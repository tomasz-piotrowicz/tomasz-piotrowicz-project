package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ValidatorTest {
    @InjectMocks
    private TrelloValidator validator;
    @Test
    public void testPositiveCardValdation(){
        //Given
        TrelloCard card = new TrelloCard("name1", "desc1", "1", "ID1");
        //When
        validator.validateCard(card);
    }

    @Test
    public void testNegativeCardValidation(){
        //Given
        TrelloCard card = new TrelloCard("test1", "desc1", "1", "ID1");
        //When
        validator.validateCard(card);
    }

    @Test
    public void testValidateTrelloBoards() {
        //Given
        TrelloList list = new TrelloList("1", "list1", true);
        ArrayList<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(list);

        ArrayList<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("1", "board1", trelloLists));

        ArrayList<TrelloBoard> anotherTrelloBoard = new ArrayList<>();
        anotherTrelloBoard.add(new TrelloBoard("1", "test", trelloLists));
        //When
        System.out.println("Positive validation");
        List<TrelloBoard> boardWithProperName = validator.validateTrelloBoards(trelloBoard);
        System.out.println("Negative validation");
        List<TrelloBoard> boardWithTestName = validator.validateTrelloBoards(anotherTrelloBoard);

    }

}
