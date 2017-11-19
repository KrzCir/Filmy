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

public class FindBySteps {

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
    }

    @Given("^id ([-]*\\d+) to prepare data$")
    public void prepare_data(int id) throws Throwable {
        assertNotNull(conector);
        assertNotNull(filmService);
        filmService.getConector().insert(this.prepareData(id));
    }

    @When("^(.*?) are searched$")
    public void expression_are_searched(String expression) throws Throwable {
        cache = filmService.findByExpression(expression);
        assertNotNull(cache);
    }

    @Then("^the result title using expression should be (.*?)$")
    public void the_result_of_title_should_be(String title) throws Throwable {
        assertEquals(title, cache.getTitle());
    }

}