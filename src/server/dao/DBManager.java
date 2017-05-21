package server.dao;

import java.util.ArrayList;
import java.util.List;

import server.data.data.Album;
import server.data.data.Artista;
import server.data.data.Cancion;
import server.data.data.Comun;
import server.data.data.Lista;
import server.data.data.Pago;
import server.data.data.Reproduccion;
import server.data.data.Usuario;
import server.data.data.Ventajoso;

public class DBManager {
	
	private static DBManager instance;
	
	private List<Album> albumCache;
	private List<Artista> artistaCache;
	private List<Usuario> usuariosCache;
	private List<Cancion> cancionCache;
	private List<Lista> listaCache;
	private List<Pago> pagoCache;
	private List<Reproduccion> reproduccionCache;
	//private  PersistenceManagerFactory pmf;
	//private PersistenceManager pm;
	//private Transaction tx;
	
	private DBManager() {
		this.albumCache = new ArrayList<>();
		this.artistaCache = new ArrayList<>();
		this.usuariosCache = new ArrayList<>();
		this.cancionCache =  new ArrayList<>();
		this.listaCache =  new ArrayList<>();
		this.pagoCache =  new ArrayList<>();
		this.reproduccionCache =  new ArrayList<>();
		
		/*
		User user1 = new User();
		user1.setEmail("sample@gmail.com");
		user1.setNickname("buyer33");
		user1.setPassword("12345");		
		
		User user2 = new User();
		user2.setEmail("troyaikman08@hotmail.com");
		user2.setNickname("troyaikman08");
		user2.setPassword("12345");
		
		this.usersCache.add(user1);
		this.usersCache.add(user2);
		
		Category iPadCat = new Category();
		iPadCat.setName("iPad");
		
		this.categoriesCache.add(iPadCat);
		
		Article iPadCover = new Article();
		iPadCover.setActive(true);
		iPadCover.setCategory(iPadCat);
		iPadCover.setInitialPrice(10.0f);
		iPadCover.setNumber(1);
		iPadCover.setOwner(user2);
		iPadCover.setTitle("iPad 2 Cover");		
		
		iPadCat.addArticle(iPadCover);
		user2.addArticle(iPadCover);
		
		Article iPadStylus = new Article();
		iPadStylus.setActive(true);
		iPadStylus.setCategory(iPadCat);
		iPadStylus.setInitialPrice(15.50f);
		iPadStylus.setNumber(2);
		iPadCover.setOwner(user2);
		iPadStylus.setTitle("iPad Stylus");
		
		iPadCat.addArticle(iPadStylus);
		user2.addArticle(iPadStylus);
		
		this.articlesCache.add(iPadCover);
		this.articlesCache.add(iPadStylus);
		*/
	}

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}		
		
		return instance;
	}

	public boolean store(Album Album) {
		this.albumCache.add(Album);
		
		return true;
	}

	public boolean store(Artista Artista) {
		this.artistaCache.add(Artista);
		
		return true;
	}

	public boolean store(Usuario Usuario) {
		this.usuariosCache.add(Usuario);
		
		return true;
	}
	
	public boolean store(Cancion cancion) {
		this.cancionCache.add(cancion);
		
		return true;
	}
	
	public boolean lista(Lista lista) {
		this.listaCache.add(lista);
		
		return true;
	}
	
	public boolean store(Pago pago) {
		this.pagoCache.add(pago);
		
		return true;
	}
	
	public boolean store(Reproduccion reproduccion) {
		this.reproduccionCache.add(reproduccion);
		
		return true;
	}
	
	public Cancion getCancion(String cancionNombre) {		
		for (Cancion cancion : this.cancionCache) {
			if (cancion.getTituloCancion().equalsIgnoreCase(cancionNombre)) {
				return cancion;
			}
		}
		
		return null;
	}

	/*
	public List<Category> getCategories() {
		return this.categoriesCache;
	}

	public Article getArticle(long number) {
		
		for (Article article : this.articlesCache) {
			if (article.getNumber() == number) {
				return article;
			}
		}		
		
		return null;
	}

	public List<Article> getArticles(String category) {
		List<Article> articles = new ArrayList<>();
		
		for (Article article : this.articlesCache) {
			if (article.getCategory().getName().equalsIgnoreCase(category)) {
				articles.add(article);
			}			
		}
		
		return articles;
	}
*/
	public Usuario getUsuario(String nombre) {
		for (Usuario user : this.usuariosCache) {
			if (user.getNombreUsuario().equalsIgnoreCase(nombre)) {
				return user;
			}
		}
		
		return null;
	}
}