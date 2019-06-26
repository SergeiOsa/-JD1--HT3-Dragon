package by.oskerko.layer_architect.dragon_treasure.dao;

public class DAOException extends  Exception {
	
	private static final long serialVersionUID = 1L;
	
	public DAOException() {}
		
	public DAOException(String messege) {
		super(messege);
	}
	
	public DAOException(Exception e) {
		super(e);
	}
	
	public DAOException(String messege, Exception e) {
		super(messege, e);
	}
	

}
