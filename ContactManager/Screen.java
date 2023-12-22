import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
 
public class Screen extends JPanel implements ActionListener{
 
    
	private Contact[] contactList;
	
	private JTextPane allContactspane;
	private JTextPane searchResultPane;
	private JButton searchFirstNameButton;
	private JTextField searchInput;
    private JButton searchLastNameButton;
    private JButton searchUserNameButton;
    private JButton searchDomainButton;
    private JButton searchExtensionButton;
    private JButton sortByNameButton;
    private JButton sortByLastNameButton;
    private JButton sortByUserNameButton;

	
	
    public Screen(){
         
        this.setLayout(null);
        
        contactList = new Contact[10];
        contactList[0] = new Contact("John","Smith","JohnSmith@mvla.net");
        contactList[1] = new Contact("Javier","Garcia","JG@gmail.com");
        contactList[2] = new Contact("Maria","Garcia","Maria@yahoo.net");
        contactList[3] = new Contact("Patricia","Harbor","PatriciaHarbor@gmail.com");
        contactList[4] = new Contact("Jack","Harbor","JackHarbor@yahoo.net");
        contactList[5] = new Contact("John","Loui","jloui@stanford.edu");
        contactList[6] = new Contact("Adam","Johnson","adamjohnson@mvla.net");
        contactList[7] = new Contact("Eva","Mendes","evamendes@stanford.edu");
        contactList[8] = new Contact("Melissa","Johnson","mjohnsn@yahoo.com");
        contactList[9] = new Contact("Amir","Samson","samsonamir@gmail.com");

        
        
        allContactspane = new JTextPane();
        allContactspane.setBounds(10,100,250,450);
        add(allContactspane);
        
        
        String str = "";
        for(int i = 0; i<contactList.length;i++) {
        	str += contactList[i].toString() + "\n";
        }
        allContactspane.setText(str);

        
        //FirstNameSearch
        searchFirstNameButton = new JButton("Search First Name");
        searchFirstNameButton.setBounds(10,50,150,30);
        searchFirstNameButton.addActionListener(this);
        add(searchFirstNameButton);

        //LastNameSearch
        searchLastNameButton = new JButton("Search Last Name");
        searchLastNameButton.setBounds(170,50,150,30);
        searchLastNameButton.addActionListener(this);
        add(searchLastNameButton);

        //userNameSearch
        searchUserNameButton = new JButton("Search User Name");
        searchUserNameButton.setBounds(330,50,150,30);
        searchUserNameButton.addActionListener(this);
        add(searchUserNameButton);

        //DomainSearch
        searchDomainButton = new JButton("Search Domain");
        searchDomainButton.setBounds(480,50,150,30);
        searchDomainButton.addActionListener(this);
        add(searchDomainButton);


        //ExtensionSearch
        searchExtensionButton  = new JButton("Search Extension");
        searchExtensionButton.setBounds(630,50,150,30);
        searchExtensionButton.addActionListener(this);
        add(searchExtensionButton);
        
        //SearchInput
        searchInput  = new JTextField();
        searchInput.setBounds(10,10,150,30);
        add(searchInput);
        
        //searchResultPane
        searchResultPane = new JTextPane();
        searchResultPane.setBounds(310,100,250,450);
        add(searchResultPane);


        //sort by name
        sortByNameButton = new JButton("Sort by name");
        sortByNameButton.setBounds(580,120,150,30);
        sortByNameButton.addActionListener(this);
        add(sortByNameButton);

        //sort by last name
        sortByLastNameButton = new JButton("Sort by lastname");
        sortByLastNameButton.setBounds(580,160,150,30);
        sortByLastNameButton.addActionListener(this);
        add(sortByLastNameButton);

        //sort by username
        sortByUserNameButton = new JButton("Sort by username");
        sortByUserNameButton.setBounds(580,200,160,30);
        sortByUserNameButton.addActionListener(this);
        add(sortByUserNameButton);
        
 
         
        this.setFocusable(true);   
         
    }
     
    public Dimension getPreferredSize(){
        //Sets the size of the panel
        return new Dimension(800,600);
    }
  
    public void paintComponent(Graphics g){
         
        super.paintComponent(g);
 
     
    }
 
    public void actionPerformed(ActionEvent e) {
     if(e.getSource() == searchFirstNameButton) {
    	 //System.out.println("hello");
    	 
    	 String fname = searchInput.getText();
    	 //go through my contacts, and get only the people with that name(Store in a string)
    	 String str = "";
    	 for(int i = 0; i< contactList.length;i++) {
    		 //get  the first naeme and check it
    		 
    		 if( contactList[i].getFirstName().equals(fname)) {
    			 str += contactList[i].toString() + "\n";
    		 }
    	 }
    	 //System.out.println(str);
    	 searchResultPane.setText(str);
    	 
     }
     if(e.getSource() == searchLastNameButton) {
         //System.out.println("hello");
         
         String Lastname = searchInput.getText();
         //go through my contacts, and get only the people with that name(Store in a string)
         String str = "";
         for(int i = 0; i< contactList.length;i++) {
             //get  the first naeme and check it
             
             if( contactList[i].getLastName().equals(Lastname)) {
                 str += contactList[i].toString() + "\n";
             }
         }
         //System.out.println(str);
         searchResultPane.setText(str);
         
     }
     if(e.getSource() == searchUserNameButton) {
         //System.out.println("hello");
         
         String username = searchInput.getText();
         //go through my contacts, and get only the people with that name(Store in a string)
         String str = "";
         for(int i = 0; i< contactList.length;i++) {
             //get  the first naeme and check it
             
             if( contactList[i].getUserName().equals(username)) {
                 str += contactList[i].toString() + "\n";
             }
         }
         //System.out.println(str);
         searchResultPane.setText(str);
         
     }
     if(e.getSource() == searchDomainButton) {
         //System.out.println("hello");
         
         String domain = searchInput.getText();
         //go through my contacts, and get only the people with that name(Store in a string)
         String str = "";
         for(int i = 0; i< contactList.length;i++) {
             //get  the first naeme and check it
             
             if( contactList[i].getDomain().equals(domain)) {
                 str += contactList[i].toString() + "\n";
             }
         }
         //System.out.println(str);
         searchResultPane.setText(str);
         
     }
     if(e.getSource() == searchExtensionButton) {
         //System.out.println("hello");
         
         String extension = searchInput.getText();
         //go through my contacts, and get only the people with that name(Store in a string)
         String str = "";
         for(int i = 0; i< contactList.length;i++) {
             //get  the first naeme and check it
             
             if( contactList[i].getExtension().equals(extension)) {
                 str += contactList[i].toString() + "\n";
             }
         }
         //System.out.println(str);
         searchResultPane.setText(str);
         
     }
     if(e.getSource() == sortByNameButton){
            Contact temp1, temp2;
            for(int i=0;i<contactList.length-1;i++){
                for(int j=i+1;j<contactList.length;j++){
                    if(contactList[i].getFirstName().compareTo(contactList[j].getFirstName()) > 0) {
                        temp1 = contactList[i];
                        temp2 = contactList[j];
                       
                        contactList[i] = temp2;
                        contactList[j] = temp1;
                    }
                }
            }
               
            String str = "";
            for(int i=0;i<contactList.length;i++){
                //compare the search result with the first name government
                str += contactList[i].toString() + "\n";
            }
           
            //display it
            searchResultPane.setText(str);
            repaint();
        }

    if(e.getSource() == sortByUserNameButton){
        Contact temp1, temp2;
        for(int i=0;i<contactList.length-1;i++){
            for(int j=i+1;j<contactList.length;j++){
                if(contactList[i].getUserName().compareTo(contactList[j].getUserName()) > 0) {
                    temp1 = contactList[i];
                    temp2 = contactList[j];
                       
                    contactList[i] = temp2;
                    contactList[j] = temp1;
                  }
            }
        }
               
        String str = "";
        for(int i=0;i<contactList.length;i++){
            //compare the search result with the first name government
            str += contactList[i].toString() + "\n";
        }
           
            //display it
        searchResultPane.setText(str);
        repaint();
        }

        if(e.getSource() == sortByLastNameButton){
        Contact temp1, temp2;
        for(int i=0;i<contactList.length-1;i++){
            for(int j=i+1;j<contactList.length;j++){
                if(contactList[i].getLastName().compareTo(contactList[j].getLastName()) > 0) {
                    temp1 = contactList[i];
                    temp2 = contactList[j];
                       
                    contactList[i] = temp2;
                    contactList[j] = temp1;
                  }
            }
        }
               
        String str = "";
        for(int i=0;i<contactList.length;i++){
            //compare the search result with the first name government
            str += contactList[i].toString() + "\n";
        }
           
            //display it
        searchResultPane.setText(str);
        repaint();
        }


    }


}