# Cucumber with Selenium Framework
https://zhuanxxu.github.io/CucumberWithSelenium-OwnFrame/
## To init
- Clone the repo
- Exc "node i"

## Browser options

### Run headless Chrome

- ChromeOptions options = new ChromeOptions();
  options.addArguments("--headless");

### Maximize Window

- driver.manage().window().maximize(); # Selenium-CleanStructure

# Gradle commands

- gradle clean -x test -PenvFile=qa.properties tests
  Ejecuta los test con el @tag SmokeTest y settea
