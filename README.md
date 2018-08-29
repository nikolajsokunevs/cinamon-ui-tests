Selenium / Allure / JUnit5 / Selenoid  [![Build Status](https://travis-ci.com/nokunev/cinamon-ui-tests.svg?branch=master)](https://travis-ci.com/nokunev/cinamon-ui-tests)
=======================
### How to run test?
        mvn clean install test    - execute all tests
        mvn clean install test -Dselenium.remoteDriver=true -Dselenium.seleniumGridURL=http://46.101.239.132:4444   - execute on selenoid hub
        mvn allure:serve          - generate allure report and start jetty webserver for quick access

### Configuration

Configuration defined in ApplicationProperties.java

You can specify environment to run
-Dapplication.env=local
-Dapplication.env=dev

You can specify browser by using one of the following switches:
- -Dbrowser=FIREFOX
- -Dbrowser=CHROME

Also you can specify where to run tests, on lochal machine, or grid:
- -Dselenium.remoteDriver=true 
- -Dselenium.seleniumGridURL=http://http://46.101.239.132:4444 

docker-compose file is created, you can setup local grid with docker command: 
- docker-compose -f docker-compose.yaml up

### DriverFactory
Main idea: static method getDriver(), returns 1 browser instance per thread

### Selenoid
Selenoid is a powerful implementation of Selenium hub using Docker containers to launch browsers.
Live Browser Screen and Logs: http://46.101.239.132:8080/#/
Video Recording: any browser session can be saved to H.264 video (set capability 'enableVideo=true')
