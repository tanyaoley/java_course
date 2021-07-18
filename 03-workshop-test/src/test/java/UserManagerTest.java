import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;


import java.io.IOException;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserManagerTest {


    @Test
    public void getUserByIndexTest() throws UserManagerException, IOException {
        ICollection collection = mock(ICollection.class);
        UserManager userManager = new UserManager(collection);
        String name = "name";
        String role = "admin";
        User user = new User(name, role);
        when(collection.get(0)).thenReturn(user);
        assertEquals(user, userManager.getUserByIndex(0));
    }


    @Test
    public void createDefaultTest() throws UserManagerException, IOException{
        ICollection collection = mock(ICollection.class);

        doNothing().when(collection).add(ArgumentMatchers.<User>any(User.class));

        UserManager userManager = new UserManager(collection);
        userManager.createDefault("name");
        verify(collection, Mockito.times(1)).add(ArgumentMatchers.<User>any(User.class));

    }

    @Test(expected = UserManagerException.class)
    public void getUserByIndexTestException() throws UserManagerException, IOException {
        ICollection collection = mock(ICollection.class);
        when(collection.get(0)).thenThrow(new IOException());
        UserManager userManager = new UserManager(collection);
        userManager.getUserByIndex(0);
    }


    @Test(expected = UserManagerException.class)
    public void createDefaultTestException() throws UserManagerException, IOException {
        ICollection collection = mock(ICollection.class);

        doThrow(IOException.class).when(collection).add(ArgumentMatchers.<User>any(User.class));

        UserManager userManager = new UserManager(collection);
        userManager.createDefault("name");

    }
}

