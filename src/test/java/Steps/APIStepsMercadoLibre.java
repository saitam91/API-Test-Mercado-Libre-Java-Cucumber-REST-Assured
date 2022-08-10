package Steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import static io.restassured.RestAssured.given;



public class APIStepsMercadoLibre {

    private static RequestSpecification request;
    private Response response;
    private static final Logger log = LogManager.getLogger(APIStepsMercadoLibre.class);

    @Given("^I send a get request to (.+) URI$")
    public void sendRequest(String uri){
        request=given()
                .baseUri(uri)
                .contentType(ContentType.JSON);

    }

    @Then("^I validate that the result search matches with the search criteria (.+) in the endpoint (.+)")
        public void criteriaMatchesWithResult(String criteria,String endpoint){
            response=request
                    .when()
                    .get(endpoint+criteria);
                    String[] resultSearch= response.jsonPath().getString("results.title").split(",");
                    String[] searchCriteria = criteria.split(",");

                    for (int i = 0; i < resultSearch.length; i++) {
                        for (int j =0; j< searchCriteria.length; j++){
                            Boolean upperCaseResultSearch = resultSearch[i].contains(searchCriteria[j].substring(0, 1).toUpperCase() + searchCriteria[j].substring(1));
                            Boolean lowerCaseResultSearch = resultSearch[i].contains(searchCriteria[j].substring(0, 1).toLowerCase() + searchCriteria[j].substring(1));
                            Assert.assertTrue("The result search "+resultSearch[i]+" not match with the search criteria: "+searchCriteria[j],(upperCaseResultSearch || lowerCaseResultSearch));
                            log.info("The result search "+resultSearch[i]+" matches with the search criteria: "+searchCriteria[j]);
                        }
                    }
    }
}




