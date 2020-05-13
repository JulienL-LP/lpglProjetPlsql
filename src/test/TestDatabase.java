package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import database.Database;

public class TestDatabase {

	@Test
	public void testConnection() {
		assertTrue(Database.getInstance().isConnected());
		
	}
	
}
