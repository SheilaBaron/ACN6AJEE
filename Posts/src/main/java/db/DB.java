package db;

import java.util.List;

import javax.inject.Singleton;

import entities.Post;
import entities.User;

@Singleton
public class DB {
	private List<User> users;
	private List<Post> posts;

	public List<User> getUsers() {
		return users;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}


	

}
