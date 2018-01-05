package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloListDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {
    @Mock
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
        System.out.println(testedBoard);
        assertEquals(1, testedBoard.size());
    }
}
