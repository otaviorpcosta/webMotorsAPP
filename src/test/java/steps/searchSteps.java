package steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class searchSteps {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    protected Boolean isElementPresent(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }

    }

    @Dado("que o usuário esteja no sistema do webmotors")
    public void setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "RXCN8008KDY");//DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "hands.android.webmotors");
        caps.setCapability("appActivity", "hands.android.webmotors.legacy.view.activity.SplashActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    //////// CT01 //////////

    @Quando("clicar na opção Pular login")
    public void optionLogin() throws InterruptedException {

        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btSkipLogin")));

        if (isElementPresent(driver.findElement(By.id("btSkipLogin"))))
            driver.findElement(By.id("btSkipLogin")).click();

    }

    @Entao("o sistema direciona o usuário para a tela de home")
    public void screenHome(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String confimationHome = driver.findElement(By.id("largeLabel")).getText();
        Assert.assertEquals("Início",confimationHome);

        driver.resetApp();
        driver.quit();
    }

    //////// CT02 //////////

    @E("clicar no menu Buscar")
    public void menuSearch(){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("largeLabel")));

        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Buscar\"]/android.view.ViewGroup")).click();
    }

    @Entao("o sistema direciona o usuário para a tela filtros")
    public void screenSearch(){

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        Boolean screenSearch = driver.findElement(By.xpath("//android.widget.TextView[@text='Carros']")).isDisplayed();

        Assert.assertTrue(true, String.valueOf(screenSearch));

        driver.resetApp();
        driver.quit();

    }

    //////// CT03 //////////

    @E("selecionar a Marca desejada")
    public void markedDesired(){

        driver.findElement(By.xpath("//android.widget.TextView[@text='Marca']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Chevrolet']")));

        driver.findElement(By.xpath("//android.widget.TextView[@text='Chevrolet']")).click();
    }

    @E("clicar na opção Ver anúncios")
    public void optionSeeAds(){

        driver.findElement(By.id("btnFilter")).click();
    }

    @Entao("o sistema direciona o usuário para a tela de listagem de veículos")
    public void screenListVehicle(){


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btGoFavored")));

        String screenListVehicle = driver.findElement(By.id("btGoFavored")).getText();

        Assert.assertEquals("Ver Favoritos", screenListVehicle);

        driver.resetApp();
        driver.quit();

    }

    //////// CT04 //////////

    @E("clicar no veículo desejado")
    public void vehicleDesired(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btGoFavored")));

        driver.findElement(By.id("touch_outside")).click();

        driver.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup")).click();
    }

    @Entao("o sistema direciona o usuário para a tela de detalhes do veículo")
    public void screenDetailsVehicle(){


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSend")));

        String screenListVehicle = driver.findElement(By.id("btnSend")).getText();

        Assert.assertEquals("Enviar mensagem", screenListVehicle);

        driver.resetApp();
        driver.quit();

    }

    //////// CT05 //////////

    @E("clicar na opção de Enviar mensagem para o vendedor")
    public void optionSendMessage(){

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btOk")));

        driver.findElement(By.id("btOk")).click();
        driver.findElement(By.id("btnSend")).click();
    }

    @E("preencher o formulário com dados válidos")
    public void formComplete(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edtNome")));

        driver.findElement(By.id("edtNome")).sendKeys("Teste Webmotors");
        driver.findElement(By.id("edtEmail")).sendKeys("teste@gmail.com");
        driver.findElement(By.id("edtCelular")).sendKeys("34991060500");
    }

    @E("clicar na opção de Enviar")
    public void optionSend(){

        driver.findElement(By.id("btnSendOffer")).click();
    }

    @Entao("o sistema exibe mensagem informando que a proposta foi enviada")
    public void messagenSending(){

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("snackbar_text")));

        String screenListVehicle = driver.findElement(By.id("snackbar_text")).getText();

        Assert.assertEquals("Sua proposta foi enviada com sucesso", screenListVehicle);

        driver.resetApp();
        driver.quit();

    }
}
