# Cucumber with Selenium Framework
https://zhuanxxu.github.io/CucumberWithSelenium-OwnFrame/
## To init
- Clone the repo
- Exc "node i"

## Herramientas usadas en este proyecto
- Java + Selenium + Junit5 + Cucumber + MultipleHTMLReporter
## Browser options

### Run headless Chrome

- ChromeOptions options = new ChromeOptions();
  options.addArguments("--headless");

### Maximize Window

- driver.manage().window().maximize(); # Selenium-CleanStructure

# Gradle commands

### Con este envFile podemos decirle que archivo de entorno de pruebas queremos correr
- gradle test -PenvFile=qa.properties  
### Si queremos ejecutar pruebas por defecto
- gradle test

