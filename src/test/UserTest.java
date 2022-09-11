package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.User;
import controller.ControlUser;
import data.Database;

/**
 * Classe de testes relacionados aos usuários da aplicação
 * @author Samuel Ricardo
 * @since release 1
 */
class UserTest {

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
		controlUser.create("nome de usuario", "senha", null, null, null);
		assertEquals("nome de usuario", controlUser.readOne("nome de usuario").getUsername());
		assertEquals("senha", controlUser.readOne("nome de usuario").getPassword());
	}

	@Test
	void readOneTest() {
		controlUser.create("nome de usuario", "senha de usuario", null, null, null);
		User user = controlUser.readOne("nome de usuario");
		User expectedUser = instance.getUsers().get(0);
		assertEquals(user, expectedUser);
	}

	@Test
	void updateTest() {
		controlUser.create("nome de usuario", "senha de usuario", null, null, null);
	}


}
