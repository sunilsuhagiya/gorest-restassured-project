package com.gorest.testsuite;

import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostsAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        response = given()
                .get("https://gorest.co.in/public/v2/posts?page=1&per_page=25%27")
                .then()
                .statusCode(200);

    }

    //        1. Verify the if the total record is 25
    @Test
    public void test01() {
        response.body("JSON", equalTo(25));
    }

    //        2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto centum.”
    @Test
    public void test02() {
        response.body("[2].title", equalTo("Ad ipsa coruscus ipsam eos demitto centum."));
    }

    //        3. Check the single user_id in the Array list (5522)
    @Test
    public void test03() {
        response.body("[4].user_id", equalTo(5522));
    }

    //        4. Check the multiple ids in the ArrayList (2693, 2683,2612)
    @Test
    public void test04() {
        response.body("[5].id", equalTo(2693))
                .body("[6].id", equalTo(2683))
                .body("[24].id", equalTo(2611));

    }
/*        5. Verify the body of userid = 2678 is equal “Carus eaque voluptatem. Calcar
         spectaculum coniuratio. Abstergo consequatur deleo. Amiculum advenio dolorem.
        Sollers conservo adiuvo. Concedo campana capitulus. Adfectus tibi truculenter.
        Canto temptatio adimpleo. Ter degenero animus. Adeo optio crapula. Abduco et
        antiquus. Chirographum baiulus spoliatio. Suscipit fuga deleo. Comburo aequus
        cuppedia. Crur cuppedia voluptates. Argentum adduco vindico. Denique undique
        adflicto. Assentator umquam pel."”*/

    @Test
    public void test05() {
        response.body("[10].body", equalTo("Acquiro decens depereo. Delibero somnus creator. Autus defleo consequatur. Et amiculum sint. Valens coma caute. Conor carpo distinctio. Vapulus textilis urbs. Subvenio animi vespillo. Perspiciatis damno agnitio. Verbera est amplus. Laborum textilis vel. Convoco atque illum. Accendo canis terminatio. Enim suffragium supra. Et argentum deleo."));
    }
}
