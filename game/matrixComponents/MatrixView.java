package game.matrixComponents;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import game.BackgroundPanel;
import game.color.MatrixColor;
import game.matrixComponents.MatrixComboBox;

public class MatrixView extends JFrame{

	private Container pane;
	private GroupLayout gl;
	
	public MatrixView() {
		createDefaultFrame();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void createStartLayout() {
		JButton crateAccBtn = new MatrixButton("Create Account").createBtn();
		JButton logBtn = new MatrixButton("log In").createBtn();
		JButton guestBtn = new MatrixButton("Guest").createBtn();
		logBtn.addActionListener((e)->{
			pane.remove(guestBtn);
			pane.remove(logBtn);
			pane.remove(crateAccBtn);
			//ruft den logInScreen auf
			createLogInFrame();
		});
		guestBtn.addActionListener((e)->{
			//Erstellt einen GastAccount 
		});
		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addGap(230)
				.addGroup(gl.createParallelGroup(Alignment.CENTER)
						.addComponent(logBtn)
						.addComponent(crateAccBtn)
						.addComponent(guestBtn)));
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGap(250)
				.addComponent(logBtn)
				.addGap(100)
				.addComponent(crateAccBtn)
				.addGap(100)
				.addComponent(guestBtn));
	}
	
	private void createDefaultFrame() {
		setTitle("MATRIX - APM");
		setSize(575, 740);
//		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pane = new BackgroundPanel();
		this.gl = new GroupLayout(pane);
		pane.setLayout(gl);
		add(pane);
		createStartLayout();
//		createLobby();
	}
	
	private void createLogInFrame() {
		JTextField userName = new JTextField("Benutzername: ",1);
		JPasswordField pw = new JPasswordField("Passwort: ",1);
		JButton cancelBtn = new MatrixButton("Cancel").createBtn();
		JButton logBtn = new MatrixButton("Connect").createBtn();
		userName.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt) {
				userName.setText("");
			}
		});
		userName.setMaximumSize(new Dimension(100,10));;
		pw.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt) {
				pw.setText("");
			}
		});
		pw.setMaximumSize(new Dimension(100,10));
		logBtn.addActionListener((e)->{
			pane.remove(cancelBtn);
			pane.remove(logBtn);
			pane.remove(pw);
			pane.remove(userName);
			createConnectingScreen();
		});
		cancelBtn.addActionListener((e)->{
			pane.remove(cancelBtn);
			pane.remove(logBtn);
			pane.remove(pw);
			pane.remove(userName);
			createStartLayout();
		});
		gl.setHorizontalGroup(gl.createParallelGroup()
						.addGroup(gl.createSequentialGroup()
								.addGap(180)
								.addComponent(userName)
								.addGap(35)
								.addComponent(pw))
						.addGap(200)
						.addGroup(gl.createSequentialGroup()
								.addGap(150)
								.addComponent(logBtn)
								.addGap(75)
								.addComponent(cancelBtn))
						);
		
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGap(300)
				.addGroup(gl.createParallelGroup()
						.addComponent(userName)
						.addComponent(pw))
				.addGap(200)
				.addGroup(gl.createParallelGroup()
						.addComponent(logBtn)
						.addComponent(cancelBtn)));
	}
	
	@SuppressWarnings("unchecked")
	private void createLobby() {
		setSize(750, 850);
		String[] roundNumbers = {"5","7","10","15"};
		String[] difficultyArray = {"Low","Medium","Hard"};
		String[] players = {"5","6","7","8","9","10"};
		//Anzahl der Spieler
		JLabel playerSize = new JLabel("Spieleranzahl");
		playerSize.setForeground(new MatrixColor().getLabelColor());
		JComboBox<String> playerSizeField = new MatrixComboBox(players, 0).createBox();
		//Anzahl der Runden 
		JLabel rounds = new JLabel("Rundenanzahl");
		rounds.setForeground(new MatrixColor().getLabelColor());
		JComboBox<String> roundChooser = new MatrixComboBox(roundNumbers,1).createBox();
		roundChooser.setSelectedIndex(2);
		//Schwierigkeit des spieles -> wortlänge
		JLabel difficulty = new JLabel("Schwierigkeitsgrad");
		difficulty.setForeground(new MatrixColor().getLabelColor());
		JComboBox<String> difChooser = new MatrixComboBox(difficultyArray,1).createBox();
		difChooser.setSelectedIndex(1);
		//create btn 
		JButton createBtn = new MatrixButton("Create").createBtn();
		createBtn.addActionListener((e)->{
			//Schickt daten an Server
			//server.createGame
		});
		//cancel btn 
		JButton cancelBtn = new MatrixButton("Cancel").createBtn();
		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addGap(150)
				.addGroup(gl.createParallelGroup()
						.addComponent(playerSize)
						.addComponent(rounds)
						.addComponent(difficulty)
						.addComponent(createBtn))
				.addGap(150)
				.addGroup(gl.createParallelGroup()
						.addComponent(playerSizeField)
						.addGap(50)
						.addComponent(roundChooser)
						.addGap(50)
						.addComponent(difChooser)
						.addGap(50)
						.addComponent(cancelBtn)));
		gl.setVerticalGroup(gl.createParallelGroup()
				.addGroup(gl.createSequentialGroup()
						.addGap(205)
						.addComponent(playerSize)
						.addGap(68)
						.addComponent(rounds)
						.addGap(65)
						.addComponent(difficulty)
						.addGap(150)
						.addComponent(createBtn))
				.addGroup(gl.createSequentialGroup()
						.addGap(200)
						.addComponent(playerSizeField)
						.addGap(50)
						.addComponent(roundChooser)
						.addGap(50)
						.addComponent(difChooser)
						.addGap(145)
						.addComponent(cancelBtn)));
		
	}
	
	
	private void gameFrame() {
		
	}
	/*
	 * Versucht mit dem Server verbindung aufzunehmen 
	 * Der Server prüft ob benutzername / Passwort vorhanden sind
	 * oder ob als Gast angemeldet wird 
	 * 
	 * Wärend auf Rückmeldung vom Server gewartet wird 
	 * passiert... i-was oder nichts 
	 * vllt einen einfachen ladebalken? 
	 */
	private void createConnectingScreen() {
		JButton testBtn = new MatrixButton("Test").createBtn();
		testBtn.addActionListener((e)->{
			pane.remove(testBtn);
			createLobby();
		});
		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(testBtn));
		gl.setVerticalGroup(gl.createParallelGroup().addComponent(testBtn));
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() ->{
			MatrixView ex = new MatrixView(); 
			ex.setVisible(true);
		});
	}
}
