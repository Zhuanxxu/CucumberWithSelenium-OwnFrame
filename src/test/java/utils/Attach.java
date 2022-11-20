package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import singletonSession.Session;

public class Attach {
    static public byte[] attach(){
        // tomar captura de pantalla - adjuntarlo en el reporte
        return ((TakesScreenshot) Session.getInstance().getBrowser()).getScreenshotAs(OutputType.BYTES);
    }
}
