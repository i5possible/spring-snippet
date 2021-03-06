package mokito;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;


/**
 * @author lianghong
 * @date 2019/5/31
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({DependedClass.class, NormalClass.class})
public class NormalClassTest {
    @InjectMocks
    private NormalClass normalClass;

    @Mock
    private DependedClass dependedClass;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Before
    public void setUp() throws Exception {
        normalClass.setName("name");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSomething() throws Exception {
        PowerMockito.mockStatic(DependedClass.class);
        PowerMockito.when(DependedClass.getSomething()).thenReturn("OK");
        /*
        The following one is not work
         */
//        PowerMockito.doReturn("OK").when(DependedClass.getSomething());
        String something = normalClass.getSomething();
        assertEquals("OK", something);
        /**
         * verifyStatic(Class clazz)
         * Class.staticMethod();
         */
        verifyStatic(DependedClass.class);
        DependedClass.getSomething();

    }

    @Test
    public void finalMethod() throws Exception {
    }

    @Test
    public void privateMethod() throws Exception {
        String privateName = normalClass.getPrivateName();
        assertEquals("name-privately", privateName);
    }
}