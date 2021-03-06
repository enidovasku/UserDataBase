import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.InsetsUIResource;


public class FormPanel extends JPanel {
	
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private FormListener formListener;
	
	private JButton okBtn;
	
	public FormPanel(){
		Dimension dim = getPreferredSize();
		dim.width=250;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Name:");
		occupationLabel= new JLabel("Occupation:");
		nameField = new JTextField(10); // how much chars
		occupationField = new JTextField(10);
		
		okBtn = new JButton("OK !");
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				
				FormEvent ev = new FormEvent(this,name,occupation);
				
				if(formListener!= null){
					formListener.formEventOccurred(ev);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Add a User");
		Border outBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outBorder, innerBorder)); 
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		///////////////// First Row /////////////////////
		gc.weightx=1;
		gc.weighty=0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill= GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets= new InsetsUIResource(0, 0, 0, 5);
		add(nameLabel,gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets= new InsetsUIResource(0, 0, 0, 0);
		add(nameField,gc);
		
		///////////////// Second Row /////////////////////
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets= new InsetsUIResource(0, 0, 0, 5);
		add(occupationLabel,gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets= new InsetsUIResource(0, 0, 0, 0);
		add(occupationField,gc);
		
		///////////////// Third Row /////////////////////
		gc.weightx=1;
		gc.weighty=2.0;
		gc.gridy = 2;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn,gc);
		
		
		
		
	}

	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}
}
