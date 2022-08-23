package test;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.Database;
import controller.ControlGroup;
import model.Group;

class ControlGroupTest {
    Database instance;
    ControlGroup controlGroup;

    @BeforeEach 
    void setUp() {
        this.instance = Database.getInstance();
        this.controlGroup = new ControlGroup();
    }

    @Test
    void createGroupTest() {
        Group testGroup = new Group("membros", "nome", "lider", "12");
        controlGroup.createGroup(name, lider); 
    }

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
