package user;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import util.ApiSpecBuilder;

import java.util.Objects;

import static util.ApiForTest.*;


public class UserSteps {

    @Step("User create")
    public static Response createUser (User user) {
        Response response = ApiSpecBuilder.requestSpec()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(REG_PATH);
        return response;
    }

    @Step("Sing in user")
    public static Response signInUser (User user) {
        Response response = ApiSpecBuilder.requestSpec().log().all()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(LOGIN_PATH);
        return response;
    }

    @Step("Delete user")
    public static void deleteUser (String accessToken) {
        if (Objects.nonNull(accessToken)) {
            ApiSpecBuilder.requestSpec()
            .auth().oauth2(accessToken)
            .delete(USER_PATH);
        }
    }
}
