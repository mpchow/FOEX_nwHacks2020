package com.hfad.nwhacks_food_expiration_app;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testJson() {
        String str = "";
        try {
            str = new String(Files.readAllBytes(Paths.get("C:\\Users\\codyl\\StudioProjects\\NWHacks_Food_Expiration_App\\app\\src\\test\\java\\com\\hfad\\nwhacks_food_expiration_app\\exampletoparse.json")));
            JsonObject obj = new JsonParser().parse(str).getAsJsonObject();
            Azure_Scanner as = new Azure_Scanner();
            FoodItem food = as.jsonToFood(obj);
            System.out.println(food);

        } catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void testFoodList() {

    }
}