package mokito;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author lianghong
 * @date 2019/5/31
 */

public class NormalClassMockitoTest {
    /**
     * The @InjectMocks on the target class is required.
     * The @Rule and the MockitoRule is required.
     * The @Mock for the dependedClass is required.
     * Only mock the behavior of the dependedClass is enough.
     */
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
    public void staticMethod() throws Exception {
        NormalClass.staticMethod();
    }

    @Test
    public void finalMethod() throws Exception {
//        NormalClass mock = Mockito.mock(NormalClass.class);
//         org.mockito.exceptions.misusing.UnfinishedStubbingException:
//        doNothing().when(mock).finalMethod();
//        mock.finalMethod();
//        Mockito.verify(mock, Mockito.times(1));
        normalClass.finalMethod();
    }

    @Test
    public void hello() throws Exception {
        String hello = normalClass.hello();
        assertEquals("Hello!false", hello);

        when(dependedClass.doSomething()).thenCallRealMethod();
        hello = normalClass.hello();
        assertEquals("Hello!true", hello);

        when(dependedClass.doSomething()).thenReturn(false);
        hello = normalClass.hello();
        assertEquals("Hello!false", hello);

        verify(dependedClass, times(3)).doSomething();
    }

    @Test
    public void getSomething() {
        String something = normalClass.getSomething();
        System.out.println(something);
    }

    @Test
    public void getName() throws Exception {
        String name = normalClass.getName();
        assertEquals("name", name);
    }

    @Test
    public void setName() throws Exception {
        String name = normalClass.getName();
        assertEquals("name", name);
        normalClass.setName("set");
        // verify isn't work for the injectMocks
//        verify(normalClass, times(1)).setName(anyString());
        name = normalClass.getName();
        assertEquals("set", name);
    }

}