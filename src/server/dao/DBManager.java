package server.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import server.data.data.Album;
import server.data.data.Artista;
import server.data.data.Cancion;
import server.data.data.Lista;
import server.data.data.Pago;
import server.data.data.Reproduccion;
import server.data.data.Usuario;
import server.dao.IUsuarioDAO;

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
	private IUsuarioDAO usuDAO;
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
		
		usuDAO = new UsuarioDAO();
		
		try {
			Usuario user1 = new Usuario("dd", "dd", "aa", 22);
			System.out.println("Usuario 1");
			Usuario user2= new Usuario("ee", "e", "r", 01);
			System.out.println("Usuario 2");
			this.store(user1);
			System.out.println("Usuario 1 store");
			usuDAO.storeUsario(user1);
			System.out.println("Usuario 1 storeUsuario");
			this.store(user2);
			System.out.println("Usuario 2 store");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
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
	
	public boolean store(Usuario usuario) {
		this.usuariosCache.add(usuario);
		
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
	
	
	
	
	protected static void createUsuarioTest(IUsuarioDAO usuDAO) {		
		try {
			System.out.println(" - Creating usuario ... ");
			Usuario usu = new Usuario("aa", "bb", "cc", 1111);
			usuDAO.storeUsario(usu);
			
		} catch (Exception ex) {
			System.out.println(" $ Error creating a user: " + ex.getMessage());
		}
	}
	
	/*
	protected static void createBookTest(IProductDAO productDAO) {
		try {
			System.out.println(" - Creating 2 new books ... ");
			Book book = new Book("The Hobbit", "Basic Edition", 60d, "J.R.R. Tolkien", "0-321-12722-0", "Oxford Press");
			Book book1 = new Book("Dracula", "Paperback Edition", 5d, "Bram Stoker", "0-342-232345-0", "Dover Publishing");
			Shelf shelf= new Shelf("First Shelf");
			book.addCopy("2", "Perfect, almost new", shelf);
			book1.addCopy("4", "Scratches on front cover", shelf);
			book1.addCopy("6", "Reasonable", shelf);
			productDAO.storeProduct(book);
			productDAO.storeProduct(book1);
		} catch (Exception ex) {
			System.out.println(" $ Creating a new book: " + ex.getMessage());
		}
	}
	*/
	
	public List<Usuario> getAllUsuariosTest() {		
		
		List<Usuario> usuarios = usuDAO.getUsuarios();
	
		System.out.println("Returning Users to client ....");
		/*for (Usuario usuAux: usuarios){
			System.out.println("        # " + usuAux);
		}
		*/
		return usuarios;
	}

	public boolean registro(String usuario, String nombre, String apellido, float cuenta) {
		Usuario user1;
		try {
			user1 = new Usuario(usuario, nombre, apellido, cuenta);
			
			usuDAO = new UsuarioDAO();
			List<Usuario> users = usuDAO.getUsuarios();
			
			int semaforo = 0;
			for (Usuario user : users) {			
				if(user.getUsuario().equals(user1.getUsuario()) && semaforo == 0){
					semaforo=1;
					System.out.println("semaforo "+ semaforo);
				}
			}	
			if (semaforo == 0)
			{
				usuDAO.storeUsario(user1);
				return true;
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	
	public static void main(String[] args) {
		IUsuarioDAO usuDAO = new UsuarioDAO();		
		
		System.out.println("main BD");
		
		createUsuarioTest(usuDAO);
		/*createBookTest(productDAO);
		getAllProductsTest(productDAO);
		
		updateProductTest(productDAO);
		updateBookTest(productDAO);
		
		checkCopiesTest(productDAO);

		updateCopyShelf(productDAO);
		
		deleteAllObjects(productDAO);
		*/
			
		
	}
	

}