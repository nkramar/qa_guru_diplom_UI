
<h2 align="center"> Проект по автоматизации тестирования для компании <a target="_blank" href="https://www.t1-consulting.ru">Т1 Консалтинг</a> </h2>

<p align="center">
<img title="Т1 Консалтинг" src="images/T1-Consulting.png">
</p>

<a name="cодержание"></a>
# :green_book: *Содержание*

+ [Технологии и инструменты](#Technology)
+ [Примеры автоматизированных тест кейсов](#TestCases)
+ [Запуск тестов в Jenkins](#Jenkins)
+ [Команды для запуска из терминала](#SystemProperty)
+ [Отчет о результатах тестирования в Allure Report](#AllureReport)
+ [Интеграция с Allure TestOps](#AllureTestOps)
+ [Интеграция с Jira](#Jira)
+ [Уведомление в Telegram при помощи Alert bot](#Telegram)
+ [Примеры видео выполнения тестов на Selenoid](#Selenoid)


<h1 align="left">
<a name="Technology"><i>Технологии и инструменты</i></a>
</h1>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="https://github.com/allure-framework/allure2"><img src="images/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="images/AllureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="images/Jira.svg" width="50" height="50"  alt="Jira"/></a>  
</p>


<h1 align="left">
<a name="TestCases"><i>Примеры автоматизированных тест кейсов</i></a>
</h1>

- :white_check_mark: Проверка названия страницы
- :white_check_mark: Проверка видимости текстовых элементов в навигационной панели страницы
- :white_check_mark: Проверка лога консоли страницы на наличие ошибок
- :white_check_mark: Проверка кликабельности элементов навигационной панели
- :white_check_mark: Проверка навигации по страницам с предоставляемыми услугами


<h1 align="left">
<img src="images/Jenkins.svg" width="25" height="25" alt="Jenkins"/>  <a name="Jenkins"><i>Запуск тестов в Jenkins</i></a>
</h1>

<a target="_blank" href="https://jenkins.autotests.cloud/job/qa_guru_diplom_UI_tests/">**Сборка в Jenkins**</a>
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/qa_guru_diplom_Mobile_tests/"><img src="images/JenkinsJob.png" alt="Jenkins"/></a>  
</p>




# *Параметры сборки в Jenkins:*

- *BROWSER (браузер, по умолчанию chrome)*
- *BROWSER_VERSION (версия браузера, по умолчанию 100.0)*
- *BROWSER_SIZE (размер окна браузера, по умолчанию 1920x1080)*
- *HOST (адрес удаленного сервера Selenoid с логином и паролем)*

<h1 align="left">
<a name="SystemProperty"><i>Команды для запуска из терминала</i></a>
</h1>

***Локальный запуск:***
```bash  
gradle clean test
-Dhost=local
```

***Удалённый запуск через Jenkins:***
```bash  
clean test
-Dbrowser=${BROWSER}
-DbrowserSize=${SIZE}
-Dhost=remote
```

<h1 align="left">
<img src="images/Allure_Report.svg" width="25" height="25" alt="Allure_Report"/>  <a name="AllureReport"><i>Отчет в Allure Report</i></a>
</h1>

<a target="_blank" href="https://jenkins.autotests.cloud/job/qa_guru_diplom_UI_tests">**Отчёт в Jenkins**</a>
<p align="center"> 


### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/Allure_Report_Overview.png">  
</p>  

### *Тест кейсы*

<p align="center">  
<img title="Allure Tests" src="images/Test_cases.png">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="images/Allure_Charts.png">  
</p>


<h1 align="left">
<img src="images/AllureTestOps.svg" width="25" height="25" alt="AllureTestOps"/> <a name="AllureTestOps"><i>Интеграция с Allure TestOps</i></a>
</h1>

<a target="_blank" href="https://allure.autotests.cloud/launch/15392/tree?treeId=0">**Проект в TestOps**</a>
<p align="center">  


## *Allure TestOps Dashboard*

<p align="center">  
<img title="Allure TestOps Dashboard" src="images/Allure_Test_Ops_Dashboard.png">  
</p> 

## *Тест кейсы*

<p align="center">  
<img title="Allure TestOps Tests" src="images/Allure_TestOps_Test_Cases.png">  
</p>

<h1 align="left">
<img src="images/Jira.svg" width="25" height="25" alt="Jira"/> <a name="Jira"><i>Интеграция с Jira</i></a>
</h1>

<a target="_blank" href="https://jira.autotests.cloud/browse/AUTO-1313">**Тикет в Jira**</a>
<p align="center">  


<p align="center">  
<img title="Jira" src="images/Jira_Ticket.png">  
</p>

<h1 align="left">
<img src="images/Telegram.svg" width="25" height="25"  alt="Allure"/> <a name="Telegram"><i>Уведомление в Telegram при помощи Alert bot</i></a>
</h1>

<p align="center">  
<img title="Telegram notification" src="images/Telegram_bot.png">  
</p>


<h1 align="left">
<img src="images/Selenoid.svg" width="25" height="25" alt="Selenoid"/> <a name="Selenoid"><i>Примеры видео выполнения тестов на Selenoid</i></a>
</h1>

<p align="center"> 
<img title="Browserstack Video" src="images/Selenoid_Video.gif" width="850" height="550"  alt="video">   
</p>

[К содержанию ⬆](#содержание)
