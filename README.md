# spring-snippet #
My Spring Configuration Snippet

## Context ##
- AnnotationConfigApplicationContext
- AnnotationConfigWebApplicationContext
- ClassPathXmlApplicationContext
- FileSystemXmlApplicationContext
- XmlWebApplicationContext

## Bean ##

### Basic Configuration Mechanism ###

```XML
- XML
    + <beans>
    + <bean>
    + <import>
    + <constructor-arg>
    + <c:*-ref>
    + <property>
    + <p:*-ref>
    + <util:list id="trackList"> <value>A</value></util:list>
        * list
        * constant
        * map
        * properties
        * property-path
        * set
 - Java
    + @Component
    + @Bean
    + @ComponentScan
        * @Configuration
        * (basePackages={"package1", "package2"})
    + @Autowired / @Inject
        * Field
        * Setter
        * Constructor
    + @Rule 
        * public final StandardOutputStreamLog log = new StandardOutputStreamLog();
    + @ContextConfiguration(classed=CDPlayerConfig.class)
    + @Import
    + @ImportResources
- Auto
    + component scanning
        * <context:component-scan base-package="base.package"/>
        * @ComponentScan
    + autowiring
        * @Autowired
- Mixed
    + RootConfiguration
        * <bean class="Config"/>
        * <import resource="config.xml"/>
    + @Import -- Java - Java
    + @ImportResources -- Java - XML
    + <import> -- XML - XML
    + <bean> -- XML - JAVA       
```

### Advanced Bean Configuration ###

```xml
- Profile Set
    + @Profile("dev")
    + <beans profile="dev"/>
- Profile Activate
    + DispatcherServlet
    + WebContext Param
    + JNDI
    + ENV
    + JVM
    + Test: @ActiveProfiles
- Conditinal Bean
    + @Conditional(MagicExistsCondition.class)
```


