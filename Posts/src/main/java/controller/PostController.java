package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import db.DB;
import entities.Post;
import entities.User;

@Stateless
public class PostController {
	/*
	 * create(User user,String content) Crea un post en la base de datos Le
	 * asigna la fecha actual Le asigna un id autom�tico. all():List<Post>
	 * Devuelve todos los post by(User user): List<Post> Devuelve todos los post
	 * de un usuario
	 */
	@Inject
	DB db;

	public void create(User user, String content) {
		int newId = 0;
		newId = db.getPosts().size() + 1;
		long d = new Date().getTime();
		db.getPosts().add(new Post(newId, user, d, content));
	}

	public List<Post> getAllPost() {
		return db.getPosts();
	}

	public List<Post> getPostByUser(User user) {
		List<Post> ansPost = new ArrayList<>();
		for (Post item : db.getPosts()) {
			if (item.getUser().getId() == user.getId()) {
				ansPost.add(item);
			}
		}

		if (ansPost.isEmpty()) {
			Date d = new Date();
			ansPost.add(new Post(0, new User(0, "", "", ""), d.getTime(), "null"));
		}
		return ansPost;
	}
}
