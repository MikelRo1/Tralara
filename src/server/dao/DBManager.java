package server.dao;

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
	
	protected static void getAllUsuariosTest(IUsuarioDAO usuDAO) {		
		try {
			List<Usuario> usuarios = usuDAO.getUsuarios();
			System.out.println("     - Mixture of Products and Books ...");
			for (Usuario usuAux: usuarios){
				System.out.println("        # " + usuAux);
			}
		} catch (Exception ex) {
			System.out.println(" $ Error getting Mixture of Products and Books: " + ex.getMessage());
		}
	}
	
	protected static void updateUsuarioTest(IUsuarioDAO usuDAO) {	
		/*
		try {					
			
			Usuario usu = usuDAO.getUsu("Sony Xperia");
			System.out.println(" - Detaching and updating a product: " + usu);			
			usu.setDescription("Reduced Priced Mobile");
			usuDAO.updateUsuario(usu);
			System.out.println("     - Attaching a product after changing description: " + usu);
			
		} catch (Exception ex) {
			System.out.println(" $ Error detaching-attaching: " + ex.getMessage());
		}
		*/
	}
	
	
	public static void main(String[] args) {
		IUsuarioDAO usuDAO = new UsuarioDAO();		
		
		
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
	
	
	
	/*
	protected static void updateBookTest(IProductDAO productDAO) {
		try {
			List<Book> books = productDAO.getBooks();
			
			if (!books.isEmpty()) { 
				Book book = books.get(0);			
		
				System.out.println(" - Updating book copies (new copy in new shelf): " + book);		
				Shelf shelf = new Shelf ("Second Shelf");
				book.addCopy("5", "Good state", shelf);		
				productDAO.updateProduct(book);
				System.out.println("   * New copy in new shelf added: " + book);
			
			}
		} catch (Exception ex) {
			System.out.println(" $ Error retrieving the updated book: " + ex.getMessage());
		}		
	}
	
	protected static void checkCopiesTest(IProductDAO productDAO) {
		try {
					
				Book updatedBook = (Book)productDAO.getProduct("Dracula");		
				System.out.println("   * Retrieving updated book: " + updatedBook);
				System.out.println("   * Number of copies of this book: " + updatedBook.getCopies().size());
				
			
				for (Copy copy: updatedBook.getCopies()){
					System.out.println("     # " + copy);
				} 
	
		} catch (Exception ex) {
			System.out.println(" $ Error retrieving updated book: " + ex.getMessage());
		}		
	}
	
	protected static void updateCopyShelf(IProductDAO productDAO) {
		try {
			
			Book updatedBook = (Book)productDAO.getProduct("The Hobbit");		
			System.out.println("   * Retrieving updated book: " + updatedBook);
			
			Shelf existingShelf = (Shelf)productDAO.getShelf("First Shelf");
			System.out.println(" - Adding a new copy to an existing shelf: " + existingShelf.getIdentifier());		
			updatedBook.addCopy("7", "Bad state", existingShelf);		
			productDAO.updateProduct(updatedBook);
			System.out.println("   * New copy added to an existing shelf : " + updatedBook);
			
		} catch (Exception ex) {
			System.out.println(" $ Error retrieving updated a book: " + ex.getMessage());
		}		
	}
	
	 protected static void deleteAllObjects(IUsuarioDAO productDAO) {
	
		 try {
				
			 	productDAO.deleteAllUsuarios();	
				System.out.println("   ==== DB emptied ====    ");
				
			} catch (Exception ex) {
				System.out.println(" $ Error emptying DB: " + ex.getMessage());
			}		
	 }*/
}