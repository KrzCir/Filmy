package lab1;

import static org.junit.Assert.*;

import java.util.List;

import lab1.interfaces.IFilmService;
import lab1.models.Film;
import lab1.services.FilmService;

import org.junit.Test;

public class FilmServiceTest 
{
	IFilmService fs = new FilmService();
	
	public Film PrepareFilmData()
	{
		return new Film();
	}
	
	@Test
	public void testInsert()
	{
		Film f = PrepareFilmData();
		f = fs.insert(f);
		assertNotNull(fs.find(f.getId()));
	}
	
	@Test
	public void testRemove()
	{
		Film f = PrepareFilmData();
		f = this.fs.insert(f);
		assertEquals(true, this.fs.delete(f));
		assertNull(this.fs.find(f.getId()));
	}
	
	@Test
	public void testUpdate()
	{
		Film f = this.fs.find(0);
		
		if (f == null)
			f = this.fs.insert(this.PrepareFilmData());
		
		assertNotNull("Nie znaleziono pierwszego rekordu",f);
		
		f.setTitle("Nowy tytul");
		fs.update(f);
		Film f2 = this.fs.find(0);
		
		assertNotNull("Nie znaleziono f2?",f2);
		assertEquals(f.getTitle(), f2.getTitle());
	}
	
	@Test
	public void testGet()
	{
		List<Film> films = this.fs.records();
		for(Film f : films)
		{
			assertNotNull(this.fs.find(f.getId()));
		}
	}
}
