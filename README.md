# Selenium
# 🧪 Selenium QA Automation Framework

Proiect de automatizare teste QA folosind **Java**, **Selenium WebDriver**, **TestNG** si **Page Object Model (POM)**.

Creat in cadrul cursului de QA Engineering - SkillBrain.

---

## 📁 Structura Proiectului

```
src/test/java/
├── pages/                    # Page Objects (POM)
│   ├── BasePage.java         # Clasa parinte - driver + wait
│   ├── LoginPage.java        # Pagina de login Hapiflix
│   ├── HomePage.java         # Pagina principala Hapiflix
│   └── SearchPage.java       # Pagina de cautare Hapiflix
│
├── tests/                    # Clase de test
│   ├── BaseTest.java         # Setup/teardown + screenshot
│   ├── UserJourneyTests.java # Teste Hapiflix (search, navigare)
│   ├── ComplexFormTest.java   # Formular complex demoqa.com
│   ├── TemaSesiunea4.java    # Login cu DataProvider
│   ├── WindowHandles.java    # Tab-uri multiple
│   ├── AlertTests.java       # Alerte JavaScript
│   └── PhoneScrapperTests.java # Web scraping + CSV export
│
├── utils/                    # Utilitare
│   └── ExtentReportListener.java # Rapoarte HTML ExtentReports
│
├── testng.xml                # Configurare suite de teste
└── pom.xml                   # Dependinte Maven
```

---

## 🛠 Tehnologii

| Tehnologie | Utilizare |
|---|---|
| Java | Limbaj de programare |
| Selenium WebDriver | Automatizare browser |
| TestNG | Framework de testare |
| Page Object Model | Design pattern |
| ExtentReports | Rapoarte HTML |
| Maven | Management dependinte |
| Git | Version control |

---

## 🏗 Design Patterns

### Page Object Model (POM)

Testele nu contin `findElement()` direct. Fiecare pagina web are propria clasa Java:

- **BasePage** → `driver` + `wait` (mostenita de toate paginile)
- **LoginPage** → locatori + `performLogin()`
- **HomePage** → `goToSearch()` + `goToShows()`
- **SearchPage** → `searchFor()` + `isResultDisplayed()`

### BaseTest Pattern

Clasa parinte pentru toate testele - gestioneaza `setup()` si `tearDown()` automat cu `@BeforeMethod` / `@AfterMethod`.

---

## 📋 Ce Acopera Testele

### Hapiflix (UserJourneyTests)
- ✅ Login + cautare film + validare rezultate
- ✅ Login + navigare TV Shows + validare URL

### DemoQA (ComplexFormTest)
- ✅ Completare formular complex (text, radio, checkbox, upload, dropdown)
- ✅ JavascriptExecutor pentru scroll si click
- ✅ 5 assertions pe modal de confirmare (assertEquals)

### HerokuApp (TemaSesiunea4)
- ✅ Login valid + invalid cu DataProvider

### Tab-uri Multiple (WindowHandles)
- ✅ Deschidere tab nou + switchTo().window() + verificare text

### Alerte JavaScript (AlertTests)
- ✅ JS Alert - accept
- ✅ JS Confirm - getText + accept + verificare rezultat
- ✅ JS Prompt - sendKeys + accept + verificare rezultat

### Web Scraping (PhoneScrapperTests)
- ✅ Extragere date produse (nume, pret, descriere)
- ✅ Salvare in fisier CSV
- ✅ Filtrare produse sub 200$

---

## 📊 Raportare

Proiectul foloseste **ExtentReports** cu TestNG Listener:

- Raport HTML interactiv generat automat la fiecare rulare
- Capturi de ecran automate la testele care pica
- Fisierul generat: `extent-report.html`

---

## ⚡ Rulare Teste

### Rulare din IntelliJ
- Click dreapta pe `testng.xml` → **Run**

### Rulare paralela
Testele ruleaza in paralel (4 browsere simultan) - configurat in `testng.xml`:
```xml
<suite name="Teste" parallel="methods" thread-count="4">
```

---

## 🔧 Concepte Tehnice Acoperite

- **Locatori**: id, name, className, cssSelector, xpath, linkText
- **Wait-uri**: ExplicitWait cu ExpectedConditions
- **Elemente speciale**: radio buttons (label click), checkboxes, autocomplete, div dropdowns, file upload
- **JavascriptExecutor**: scrollIntoView, JS click
- **XPath avansat**: following-sibling, text()
- **TestNG**: @Test, @BeforeMethod, @AfterMethod, @DataProvider, groups, testng.xml
- **Window Handles**: getWindowHandle, getWindowHandles, switchTo().window()
- **Alerte JS**: switchTo().alert(), accept(), dismiss(), sendKeys(), getText()
- **Screenshots**: TakesScreenshot la esec
- **Web Scraping**: findElements, List<WebElement>, for-each, FileWriter, CSV export

---

## 👤 Autor

**Cosmin Cringasu** - Junior QA Engineer

📍 Bucuresti, Romania
