package ihm;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import bibAgenda.Employe;
import si.AppConsole;
import si.ServiceInfo;

public class GUInterface extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	static JPanel bottomPanel;
	static JButton serviceButton;
	static JTextArea resultText;
	static JButton consulterButton;
	static JTextField employeText;
	
	
	static ServiceInfo service = new ServiceInfo();

	public Component createBottomPanel() {
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		serviceButton = new JButton("Agendas du Service");
		serviceButton.setMnemonic(KeyEvent.VK_S);
		serviceButton.addActionListener(this);

		resultText = new JTextArea(25, 15);
		resultText.setLineWrap(true);
		resultText.setEditable(false);
		JScrollPane jscrollPane = new JScrollPane(resultText);
		jscrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel employeLabel = new JLabel("Agenda d'un employe");

		bottomPanel.add(serviceButton);
		bottomPanel.add(jscrollPane);
		bottomPanel.add(employeLabel);

		JPanel employePanel = new JPanel();
		employePanel.setLayout(new BoxLayout(employePanel, BoxLayout.X_AXIS));
		
		
		JLabel nomLabel = new JLabel("Nom de employe: ");
		consulterButton = new JButton("consulter");
		consulterButton.setMnemonic(KeyEvent.VK_C);
		consulterButton.addActionListener(this);
		employeText = new JTextField();
		
		employePanel.add(nomLabel);
		employePanel.add(employeText);
		employePanel.add(consulterButton);

		bottomPanel.add(employePanel);
		
		return bottomPanel;

	}
	
	
	private static void createAndShowGUI() {
		
		GUInterface app = new GUInterface();
		app.createBottomPanel();

		JPanel panelContainer = new JPanel();
		panelContainer.setLayout(new GridBagLayout());

		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 0;
		c3.gridy = 2;
		c3.weightx = 1.0;
		c3.weighty = 0;
		c3.fill = GridBagConstraints.HORIZONTAL;
		panelContainer.add(bottomPanel, c3);

		JFrame frame = new JFrame("Agenda");
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage("polytech_128.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelContainer.setOpaque(true);
		frame.setSize(new Dimension(800, 600));
		frame.setContentPane(panelContainer);
		frame.setVisible(true);
		
		
		
	}
	
	
	

    public static void main(String[] args)  {  
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream(
					AppConsole.PATH_DATA_FILE));
		} catch (FileNotFoundException e) {
			System.err.println("Data File Not Found.");
			e.printStackTrace();
			return;
		} catch (IOException e) {
			System.err.println("Data File Not readable.");
			e.printStackTrace();
			return;
		}
		try {
			service = (ServiceInfo)in.readObject();
		} catch (IOException e) {
			System.err.println("Data File Not readable.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			System.err.println("Data File Not readable.");
			e.printStackTrace();
			return;
		}
		
        //Schedule a job for the event-dispatching thread:  
        //creating and showing this application's GUI.  
        javax.swing.SwingUtilities.invokeLater(new Runnable() {  
            public void run() {  
                createAndShowGUI();  
            }  
        });  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(serviceButton)){
			String resService = "";
			List<Employe> listEmploye = service.getListeEmploye();
			for (Employe employe : listEmploye) {
				resService += employe.getNom()+" "+employe.getNum()+"\n";
				resService += employe.getEmploiTemps().toString();
			}
			resultText.setText(resService);
		}
		if(e.getSource().equals(consulterButton)){
			String resService = "";
			String nom = employeText.getText();
			Employe employe = null;
			List<Employe> listEmploye = service.getListeEmploye();
			for (Employe emp : listEmploye) {
				if (emp.getNom().equals(nom) ) {
					employe = emp;
					break;
				}
			}
			if (employe == null) {
				resService = "Employe " + nom + " non trouve.";
			}else{
				resService = service.getEmploiTemps(employe).toString();
			}
			resultText.setText(resService);
		}

	}

}
