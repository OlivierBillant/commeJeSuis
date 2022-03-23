	package view;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;

	public class Fenetre extends JFrame {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Fenetre() {
			setDefaultCloseOperation(DISPOSE_ON_CLOSE); //libérer l'espace mémoire
			//Les variables de notre fenetre : x, y, w; h valeurs en px
			setBounds(150,150,300,475);
			setTitle("Fenetre 1");
			
			JPanel monPanel = new JPanel();
			//Associer le panel à la fenêtre
			setContentPane(monPanel);
			setLayout(null);
			
			//Champ texte : JLabel
			JLabel monLabel_1 = new JLabel();
			monLabel_1.setText("Votre poids en kg : ");
			monLabel_1.setBounds(20, 20, 200, 20);
			//ajouter au panel
			monPanel.add(monLabel_1);
			
			//Champ de saisie
			JTextField saisie_1 = new JTextField();
			saisie_1.setBounds(20, 40, 100, 20);
			monPanel.add(saisie_1);
			
			//Champ texte : JLabel
			JLabel monLabel_2 = new JLabel();
			monLabel_2.setText("Votre taille en m : ");
			monLabel_2.setBounds(150, 20, 200, 20);
			//ajouter au panel
			monPanel.add(monLabel_2);
			
			//Champ de saisie
			JTextField saisie_2 = new JTextField();
			saisie_2.setBounds(150, 40, 100, 20);
			monPanel.add(saisie_2);
			
			//Le trigger / Bouton
			JButton benjamin = new JButton("Calculez votre IMC");
			benjamin.setBounds(20, 80, 230, 40);
			monPanel.add(benjamin);
			
			JLabel monLabel_3 = new JLabel();
			monLabel_3.setText("Affichage IMC");
			monLabel_3.setBounds(20, 130, 230, 20);
			//ajouter au panel
			monPanel.add(monLabel_3);
			
			
			JLabel monLabel_4 = new JLabel();
			monLabel_4.setBounds(20, 150, 230, 20);
			monPanel.add(monLabel_4);
			
			JLabel monLabel_5 = new JLabel();
			monLabel_5.setBounds(20, 180, 230, 230);
			monPanel.add(monLabel_5);
			
			setVisible(true); // rendre la fenetre visible
			
			benjamin.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					monLabel_3.setText("Affichage IMC");
					String poids_str = saisie_1.getText();
					String taille_str = saisie_2.getText();
					float poids = Float.parseFloat(poids_str);
					float taille = Float.parseFloat(taille_str); 
					float imc = poids/taille/taille;
					String imc_str = String.format("%.2f",imc);
						if(imc < 18) {
							monLabel_3.setText(imc_str+" - Vous êtes maigre");
							monLabel_4.setText("Vous devriez prendre "+String.format("%.2f",-(poids-(25*taille*taille)))+" kg");
							ImageIcon icon = new ImageIcon("photo/emt.jpg");
							monLabel_5.setIcon(icon);
						}
						else if(imc < 25) {
							monLabel_3.setText(imc_str+" - Vous êtes en bonne santé");
						}
						else {
							monLabel_3.setText(imc_str+" - Vous êtes en surpoids");
							monLabel_4.setText("Vous devriez perdre "+String.format("%.2f",(poids-(25*taille*taille)))+" kg");
							ImageIcon icon = new ImageIcon("photo/bmi.jpg");
							monLabel_5.setIcon(icon);
							
							
						}
					saisie_1.setText("");
					saisie_2.setText("");
				}
			});
		}
	}

