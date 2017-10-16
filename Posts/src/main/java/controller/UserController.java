package controller;

import javax.ejb.Stateless;
import javax.inject.Inject;

import db.DB;
import entities.User;

@Stateless
public class UserController {
	/*
	 * UserController verify(String username,String password) : User Verificar
	 * que exista un usuario y contrase�a. En caso de exisit lo retorna.
	 * createUser(User) Crear un usuario en la base de datos. Asigna
	 * automaticamente el ID Valida que no exista previamente.
	 */
	@Inject
	DB db;

	public User verify(String username, String password) {
		for (User item : db.getUsers()) {
			if (item.getUserName().equals(username) && item.getPassword().equals(password)) {
				return item;
			}
		}
		return new User(0, "null", "null", "null");
	}

	public boolean userNameExist(String username) {
		for (User user : db.getUsers()) {
			if (user.getUserName().equals(username)) {
				return true;
			}
		}
		return false;
	}

	public void createUser(User user) {
		if (userNameExist(user.getUserName())) {
			throw new RuntimeException("Usuario ya existe");
		}
		int newId = 0;
		newId = db.getUsers().size() + 1;
		user.setId(newId);
		db.getUsers().add(user);
	}

}
