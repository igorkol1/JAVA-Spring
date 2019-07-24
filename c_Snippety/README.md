<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java Spring
> Krótkie kawałki kodu, które pokazują zależności, rozwiązują popularne problemy oraz pokazują jak używać niektórych funkcji.

#### Podstawowa zależność Maven dla Spring.

```xml
<dependencies>
<properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <spring-framework.version>4.3.7.RELEASE
    </spring-framework.version>
</properties>
    <dependency>
        <groupid>org.springframework</groupid>
        <artifactid>spring-context</artifactid>
        <version>${spring-framework.version}</version>
    </dependency>
</dependencies>
```



#### Jak utworzyć kontekst na podstawie konfiguracji w pliku xml
```java
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
```

#### Jak zdefiniować ziarno w konfiguracji xml

```xml
<bean id="helloWorld" class="pl.coderslab.beans.HelloWorld">
```
#### Jak pobrać ziarno od kontektsu


```java
HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
```

#### Jak wstrzyknąć zależność prostą za pomocą konstruktora
```xml
<bean id="helloWorld" class="pl.coderslab.beans.HelloWorld">
<constructor-arg name="message" value="Hello World">
</constructor-arg></bean>
```


#### Jak wstrzyknąć zależność prostą za pomocą settera

```xml
<bean id="helloWorld" class="pl.coderslab.beans.HelloWorld">
<property name="message" value="Hello World!" />
</bean>
```

#### Jak wstrzyknąć zależność za pomocą konstruktora
```xml
<bean id="messageService" class="pl.coderslab.beans.EmailService" />
<bean id="messageSender" class="pl.coderslab.beans.MessageSender">
            <constructor-arg ref="messageService"/>
</bean>
```

#### Jak utworzyć kontekst na podstawie konfiguracji w klasie javy
```java
AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
```

#### Przykład definicji ziarna w konfiguracji javy
```java
@Configuration
public class AppConfig {
 
	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
}
```

#### Jak wskazać pakiety, które mają być automatycznie skanowane
```java
@ComponentScan("pl.coderslab.beans")
```
lub
```java
@ComponentScan(basePackages="pl.coderslab.beans")
```
możemy wskazać kilka pakietów
```java
@ComponentScan(basePackages={"pl.coderslab.beans", "pl.coderslab.repositories"})
```
możemy wskazać pakiety w oparciu o znajdujące się w nim klasy lub interfejsy
```java
@ComponentScan(basePackageClasses={MyFirstClass.class, MySecondClass.class})
```
#### Jak wskazać pakiety do skanowania za pomocą xml
```xml
<context:component-scan base-package="pl.coderslab"/>
```

#### Podstawowa zależność Maven dla Spring MVC
```xml
<dependencies>
    <dependency>
        <groupid>org.springframework</groupid>
        <artifactid>spring-webmvc</artifactid>
        <version>${org.springframework-version}</version>
    </dependency>
    <dependency>
        <groupid>javax.servlet</groupid>
        <artifactid>javax.servlet-api</artifactid>
        <version>3.1.0</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupid>javax.servlet</groupid>
        <artifactid>jstl</artifactid>
        <version>1.2</version>
    </dependency>
</dependencies>
```
#### Przykład pliku konfiguracji
```java
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
public class AppConfig extends WebMvcConfigurerAdapter {
 
 
}
```

#### Jak utworzyć kontroler
```java
@Controller
public class HomeController {
 
}
```
#### Jak utworzyć akcję
```java
@RequestMapping("/hello")
	public String hello() {
		return "index.jsp";
	}
```
#### Jak utworzyć ViewResolver
```java
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
        new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
```

#### Jak utworzyć ViewResolver za pomocą xml
```xml
<bean id="viewResolver"
      class="org.springframework.web.servlet.
    view.InternalResourceViewResolver"
      p:prefix="/WEB-INF/views/"
      p:suffix=".jsp" />
```
