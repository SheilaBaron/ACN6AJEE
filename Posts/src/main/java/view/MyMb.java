package view;

import java.io.Serializable;
import java.util.List;

//import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controller.PostController;
import controller.UserController;
import entities.User;
import entities.Post;

@Named
@SessionScoped
public class MyMb implements Serializable {
	private static final long serialVersionUID = 791515424619865689L;
	@Inject
	UserController cUser;

	@Inject
	PostController cPost;

	private User currentUser;
	private String userName;
	private String password;
	private String postContent;
	private String email;
	private String mesagge;

	public boolean isLogged() {
		return currentUser != null;
	}

	public String goTo(String s) {
		return s + "?faces-redirect=true";
	}

	public String login() {
		currentUser = cUser.verify(userName, password);
		if (isLogged()) {
			mesagge = "Usted se ha logeado exitosamente";
			return "Profile.xhtml?faces-redirect=true";
		}
		mesagge = "logeo erroneo";
		return null;
	}

	public void register() {
		cUser.createUser(new User(0, email, userName, password));
		mesagge = "Usted se ha registrado exitosamente";
		login();
	}

	public String newPost() {
		cPost.create(currentUser, postContent);
		return null;
	}

	public List<Post> getAllPost() {
		return cPost.getAllPost();
	}

	public List<Post> getUserPost() {
		return cPost.getPostByUser(currentUser);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMesagge() {
		return mesagge;
	}

	public void setMesagge(String mesagge) {
		this.mesagge = mesagge;
	}

}
