import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver"
                , "C:\\Users\\user\\OneDrive\\שולחן העבודה\\chromedriver_win32\\chromedriver.exe");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your userName: ");
        String userName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");

        // get to personal info
        List<WebElement> elementList = driver.findElements(By.id("global-menu"));
        WebElement menu = elementList.get(0);
        List<WebElement> menuItems = menu.findElements(By.tagName("li"));
        WebElement personalInfo = menuItems.get(20);
        personalInfo.click();

        // input password and user name
        WebElement user = driver.findElement(By.id("Ecom_User_ID"));
        user.sendKeys(userName);
        WebElement userPassword = driver.findElement(By.id("Ecom_Password"));
        userPassword.sendKeys(password);

        //login to the user
        List<WebElement> account = driver.findElements(By.id("wp-submit"));
        WebElement login = account.get(0);
        login.click();

        // press on moodle button
        List<WebElement> options = driver.findElements(By.className("row"));
        WebElement moodle = options.get(5);
        moodle.findElement(By.tagName("a")).click();


        //print all //div[@class='card dashboard-card']
        List<WebElement> circlesList = driver.findElements(By.className("multiline"));
        for (int i = 0; i < circlesList.size(); i++) {
            System.out.println(i + ":" + circlesList.get(i).getText());
        }


        //enter the chosen circle
        System.out.println("Please enter your chosen circle");
        int chosenCircle = scanner.nextInt();
        scanner.nextLine();
        WebElement circle = circlesList.get(chosenCircle);
        circle.click();


        //logout
        WebElement list = driver.findElement(By.className("userbutton"));
        list.click();
        WebElement logoutButton = driver.findElement(By.id("actionmenuaction-6"));
        logoutButton.click();




    }
}







