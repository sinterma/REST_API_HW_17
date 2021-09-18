import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DemoWebShop {
    @Test
    void addToWishlistTest() {
        Response re =
        given().
                contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("product_attribute_28_7_10=25&product_attribute_28_1_11=29" +
                        "&addtocart_28.EnteredQuantity=1")
                .cookie("NOPCOMMERCE.AUTH=9367E63B05347871C9710027B5" +
                        "26C40D8F0D15E390C8344AF4665AC016479DC1A6485" +
                        "E73F3C5B11504F4303B524F3007034EE8398D2ABA68" +
                        "DAD43C8EB50FE09C8BBD288FD663CCF487CE7B4F2A9" +
                        "7C683D1C9C9A49AAC9AB624C5E0B2EB3CFEEA81AC3A" +
                        "BFA02FA7D230138442AAE074C66EB40316754EFB055" +
                        "B50AF77249F534C9E5BF225A08AC46DDDF1540FD5C97" +
                        "F9FCEFE7A1B3D0BCDEC85DB289BB9430CDC;")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/28/2")
                .then()
                .statusCode(200)
                .body("message", is ("The product has been added to your \u003ca href=\"/wishlist\"\u003ewishlist\u003c/a\u003e"))
                .body("success", is (true))
                .extract()
                .response();
        System.out.println(re.asString());
    }
}
