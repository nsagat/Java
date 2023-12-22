public class Contact {
	private String firstName;
	private String lastName;
	private String email;
	
	public Contact(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
		
	}
	
	public String toString() {
		
		String str = firstName + " " + lastName+ " " + email + "\n";
		return str;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String getUserName(){
		//return the string before the @ in the mail adress.
		int index = email.indexOf('@');
		String sub = "";
		sub = email.substring(0,index);
		return sub;
	}
	public String getDomain(){
		int at = email.indexOf('@');
		int per = email.lastIndexOf('.');
		return email.substring(at+1,per);
	}
	public String getExtension(){
		return email.substring(email.indexOf('.')+1, email.length());

	}

}
