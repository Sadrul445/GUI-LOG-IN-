import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.FlowLayout;
class gui extends JFrame{
	JLabel userName= new JLabel();
	JLabel pass= new JLabel();
	JTextField u= new JTextField();
	JPasswordField p= new JPasswordField();
	JButton logp = new JButton();
	
	public gui(){
		init();
		setLayout(new FlowLayout());
		JLabel userName = new JLabel("User name: ");
		JTextField name = new JTextField(20);
		add(userName);
		add(name);
		JLabel password = new JLabel("Password: ");
		add(password);
		JPasswordField pass = new JPasswordField(20);
		add(pass);
		JButton Log= new JButton(" Log In: ");
		add(Log);
		
	}
	public void init(){
		
	}
}
public class GraphicalUserInterface {

	
	public static void main(String[] args) {
		gui g=new gui();
		g.setSize(300,300);
		g.setVisible(true);
		g.setTitle("Facebook Log In - Sign In - ");
		
	}

}
