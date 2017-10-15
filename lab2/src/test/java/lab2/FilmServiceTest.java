package lab2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import lab2.models.Film;

import lab2.interfaces.IFilmService;
import lab2.exceptions.RecordNotFoundException;
import lab2.interfaces.IDbConector;
import lab2.services.FilmService;

@RunWith(MockitoJUnitRunner.class)
public class FilmServiceTest 
{
	@Mock
	IDbConector	conector;
	
	IFilmService fs;
	
	@Before
	public void setup()
	{
		fs = new FilmService(conector);
	}
	
	@Test
	public void testRemovePartsOfList() throws RecordNotFoundException
	{
		List<Film> list = new ArrayList<Film>();
		
		fs.removeList(list);
	}
	
	@Test
	public void testFindByTitle()
	{
		fs.findByTitle("");
	}
	
	@Test
	public void testFindByExpression()
	{
		fs.findByExpression( Pattern.compile("") );
	}
	
	/*
	@Test
	public void testInsert()
	{
		
	}
	
	@Test
	public void testDelete()
	{
		
	}
	
	@Test
	public void testUpdate()
	{
		
	}
	
	@Test
	public void testRemove()
	{
		
	}
	*/
}
