package lab2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import lab2.models.Film;

import lab2.interfaces.IFilmService;
import lab2.enums.Genres;
import lab2.exceptions.RecordNotFoundException;
import lab2.interfaces.IDbConector;
import lab2.services.FilmService;

@RunWith(MockitoJUnitRunner.class)
public class FilmServiceTest 
{
	@Mock
	IDbConector conector;
	
	IFilmService fs;
	
	@Before
	public void setup()
	{
		assertNotNull(conector);
		fs = new FilmService(conector);
	}
	
	private Film prepareData(int num)
	{
		Film f = new Film();
		f.setId(num);
		f.setTitle("title "+num);
		f.setGenre(Genres.Horror);
		f.setProduction("prod "+num);
		f.setDirection("dir "+num);
		return f;
	}
		
	@Test
	public void testRemovePartsOfList() throws RecordNotFoundException
	{		
		Film f1 = this.prepareData(1),
			f2 = this.prepareData(2),
			f3 = this.prepareData(3);
		
		assertNotNull(conector);
        InOrder inOrder = inOrder(conector);
        List<Film> films = new ArrayList<Film>();
        films.add(f1);
        films.add(f2);
        films.add(f3);
        
        fs.removeList(films);
        
        inOrder.verify(conector, times(1)).delete(f1);
        inOrder.verify(conector, times(1)).delete(f2);
        inOrder.verify(conector, times(1)).delete(f3);
	}
		
	@Test//(expected = RecordNotFoundException.class)
	public void testFindByExpression() throws RecordNotFoundException
	{
		Film f1 = this.prepareData(1),
			f2 = this.prepareData(2);
	
		List<Film> list = new ArrayList<Film>();
		list.add(f1);
		list.add(f2);
		
		when(conector.getAll()).thenReturn(list);
		/*
		doThrow(new RecordNotFoundException())
			.when(conector)
			.get("not exists record");
		*/
		assertNotNull(fs.findByExpression("title 2"));
		assertNull(fs.findByExpression("title 3"));
	}
}
