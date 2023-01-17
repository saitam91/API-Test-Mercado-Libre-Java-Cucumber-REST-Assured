package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class APIStepsMercadoLibreChallenge {

    private static RequestSpecification request;
    private Response response;
    private static final Logger log = LogManager.getLogger(APIStepsMercadoLibre.class);

    @Given("^I send get request to (.+) URI$")
    public void sendMeliRequest(String uri){
        request=given()
                .baseUri(uri)
                .contentType(ContentType.JSON);
    }

    @When("^I search for (.+) in the endpoint (.+)$")
    public void searchProduct(String criteria, String endpoint){
        response=request
        .when()
        .get(endpoint+criteria);

    }

    @Then("^I can validate the number of products found for (.+) and that it does not exceed the page limit$")
    public void validateProducts(String criteria){
        String totalResults = response.jsonPath().getString("paging.total");
        String limitItems = response.jsonPath().getString("paging.limit");
        int intLimitItems = Integer.parseInt(limitItems);

        List<String> searchResults = response.jsonPath().getList("results.title");
        List <String> containsCriteria = new ArrayList<>();

        for (int i = 0; i < searchResults.size(); i++) {
            Boolean searchCriteria = searchResults.get(i).contains(criteria);
            if (searchCriteria){
                containsCriteria.add(searchResults.get(i));
            }
        }
        log.info("Total results for this product: "+totalResults);
        log.info("Limit items for this page: "+limitItems);
        log.info("Number of items that contains search criteria: "+containsCriteria.size());
        Assert.assertTrue("Number of items that contains search criteria exceed pagination limit",containsCriteria.size()<=intLimitItems);

    }
}


