package bdd;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lab3.enums.Genres;
import lab3.interfaces.IDbConector;
import lab3.interfaces.IFilmService;
import lab3.models.Film;
import lab3.services.DbConector;
import lab3.services.FilmService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeleteByTest {
	
    private IDbConector conector;
    private IFilmService filmService;
    private Film cache;
    
	private Film prepareData(int num)
	{
		Film f = new Film();
		f.setTitle("title "+num);
		f.setGenre(Genres.Horror);
		f.setProduction("prod "+num);
		f.setDirection("dir "+num);
		return f;
	}    
    
    @Before
    public void setUp() {
        conector = new DbConector();
        filmService = new FilmService(conector);
        
        for(int i=1; i<=5; i++){
        	filmService.getConector().insert(this.prepareData(i));
        }
    }

    @Given("^there is a film service object$")
    public void there_is_a_film_service_object() throws Throwable {
        assertNotNull(conector);
        assertNotNull(filmService);
    }

    @When("^(.*?) are removed$")
    public void records_are_deleted(String expression) throws Throwable {
    	filmService.getConector()
    		.delete(filmService.findByExpression(expression));
    }

    @Then("^the result after remove should be ([-]*\\d+)$")
    public void the_result_should_be(int size) throws Throwable {
        assertEquals(size, filmService.getConector().getAll().size());
    }

}