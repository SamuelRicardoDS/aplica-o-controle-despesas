package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.User;
import controller.ControlGroup;
import controller.ControlUser;
import data.Database;

/**
 * Classe de testes para a classe ControlUser
 * @author Samuel Ricardo
 * @since release 1
 */
class ControlUserTest {

	Database instance;
    ControlUser controlUser;

    @BeforeEach 
    void setUp() {
        this.instance = Database.getInstance();
		this.controlUser = new ControlUser();
        this.instance.clearDatabase();
    }

	@Test
	void createTest(){
		User user = new User("nome de usuario", "senha de usuario", null, null, null);
		assertEquals("nome de usuario", user.getUsername());
	}

	@Test
	void readOneTest() {
		User user = new User("username", "senha de usuario", null, null, null);
		User expectUser = controlUser.readOne(user.getUsername());
		assertEquals(user, expectUser);
	}

}
