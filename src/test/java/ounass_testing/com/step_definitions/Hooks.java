package ounass_testing.com.step_definitions;


import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ounass_testing.com.utilities.Driver;
import ounass_testing.com.utilities.MyScreenRecorder;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        try {
            MyScreenRecorder.deleteRecorded();
        }catch (Exception e){
            System.out.println(e);
        }

        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
        MyScreenRecorder.startRecording("test");
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        scenario.write("Complete scenario: "+ scenario.getName());
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", scenario.getName());
        }


        Driver.closeDriver();
        MyScreenRecorder.stopRecording();

    }
}