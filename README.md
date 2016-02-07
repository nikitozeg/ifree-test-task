[firefox]: https://ftp.mozilla.org/pub/firefox/releases/31.0/
[maven]: http://maven.apache.org/
[java]: https://www.java.com/ru/download/help/download_options.xml

## iFree Moneytapp autotests (test task)

### Getting Started
Tests based on PageObject model, which encapsulates all logic of the page on it class, also it helps to reduce the code and its support.

To run tests you need to install [maven][maven], [java][java], git and [firefox][firefox].

To generate Allure Report you should perform following steps:

```bash
$ git clone git@github.com:nikitozeg/ifree-test-task.git
$ mvn clean test
$ mvn site
```

To see a report, run `mvn jetty:run` and open `http://localhost:8080` in your browser, or just open index.html in target\site\allure-maven-plugin

**NOTE: required maven version 3.1.1 or above**

### More
 Please, feel free to contact me: tazg@ya.ru
