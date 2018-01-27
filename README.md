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
    + Spring Environment
    + JVM
    + Test: @ActiveProfiles
- Conditinal Bean
    + @Conditional(MagicExistsCondition.class)
- Bean Selection During Auto Construction
    + @Primary / primary=true
    + @Qualifier
    + Self Define Qualifier: An interface with @Qualifier
- @Scope
    + Singleton
    + Propertype
    + Session
    + Request
- Injection In Runtime
    + Spring Environment
        * @PropertySource("classpath:main.properties")
    + Property PlaceHolder
        * PropertySourcesPlaceholderConfigurer Bean
        * ${...}
    + SpEL (Spring Expression Language)
        * ref bean using bean ID
        * call method and access object's property
        * do calculate
        * match using regex
        * collection operation
        * #{...}
        * #{T(System).currentTimeMillis()}
        * #{sgtPeppers.artlist}
        * #{systemProperties['a.b']}
        * #{artistSelector.selectArtist()?.toUpperCase()}
        * #{2 * T(java.lang.Math).PI * circle.radius}
        * #{T(java.lang.Math).PI * (circle.radius ^ 2})
        * #{disc.title ?: 'asdf'}}
        * #{admin.email matches '[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com'}
        * #{}
```


