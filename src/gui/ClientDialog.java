package gui;

import api.model.Car;
import api.model.Client;
import api.services.AllCars;
import api.services.AllClients;

import javax.swing.*;
import java.awt.*;

/**
 * Παράθυρο διαλόγου για την προσθήκη πελάτη
 *
 * @author Αλεξάνδρα Σακελλαριάδη
 * @version 0.1(2025.12.12)
 */
public class ClientDialog extends JDialog {
    //Δομή αυτοκινήτων για την αποθήκευση των αυτοκίνητων
    private AllClients allClients;
    //Αυτοκίνητο
    private Client client;
    //Σημαιοφόρος για το αν αποθηκεύτηκαν οι αλλαγές
    private boolean saved=false;
    //Πεδία χαρακτηριστικών αυτοκινήτου
    private JTextField AFMField, firstNameField, lastNameField, phoneField, emailField;
    //Κουμπιά αποθήκευσης και ακύρωσης
    private JButton saveButton,cancelButton;

    /**
     * Δημιουργία παραθύρου διαλόγου για την προσθήκη αυτοκινήτου
     * @param parent Παράθυρο από το οποίο ενεργοποιήθηκε το παράθυρο διαλόγου
     * @param existingClient Αυτοκίνητο που θα προσθέσουμε
     */
    public ClientDialog(JFrame parent,Client existingClient){
        super(parent,existingClient==null);
        this.client=existingClient;
        initDialog();
    }

    /**
     * Πεδία που προορίζονται να συμπληρωθούν από τον χρήστη για την προσθήκη αυτοκινήτου
     */
    private void initDialog(){
        setSize(500,400);
        setLocationRelativeTo(getOwner());
        setLayout(new BorderLayout(10,10));

        JPanel mainPanel=new JPanel(new GridLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(5,5,5,5);
        gbc.fill=GridBagConstraints.HORIZONTAL;

        gbc.gridx=0;
        gbc.gridy=0;
        mainPanel.add(new JLabel("ID:"),gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        AFMField=new JTextField(8);
        if(client!=null){
            AFMField.setText(client.getAFM());
            AFMField.setEditable(false);
        }else{
            AFMField.setText("Client" + (allClients.getAllClients().size() + 1));
        }
        mainPanel.add(AFMField, gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        mainPanel.add(new JLabel("Πινακίδα:"),gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        firstNameField=new JTextField(20);
        if(client!=null){
            firstNameField.setText(client.getFirst_name());
        }
        mainPanel.add(firstNameField,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        mainPanel.add(new JLabel("Μάρκα:"),gbc);

        gbc.gridx=1;
        gbc.gridy=2;
        lastNameField=new JTextField(20);
        if(client!=null){
            lastNameField.setText(client.getLast_name());
        }
        mainPanel.add(lastNameField,gbc);


        gbc.gridx=0;
        gbc.gridy=3;
        mainPanel.add(new JLabel("Τύπος:"),gbc);

        gbc.gridx=1;
        gbc.gridy=2;
        phoneField=new JTextField(20);
        if(client!=null){
            phoneField.setText(client.getPhone());
        }
        mainPanel.add(phoneField,gbc);

        gbc.gridx=0;
        gbc.gridy=4;
        mainPanel.add(new JLabel("Μοντέλο:"),gbc);

        gbc.gridx=1;
        gbc.gridy=4;
        emailField=new JTextField(20);
        if(client!=null){
            emailField.setText(client.getEmail());
        }
        mainPanel.add(emailField,gbc);

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT,10,10));
        saveButton=new JButton("Αποθήκευση");
        saveButton.addActionListener(e -> saveCar());

        cancelButton=new JButton("Ακύρωση");
        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(mainPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

        getRootPane().setDefaultButton(saveButton);
    }

    /**
     * Αποθήκευση αυτοκινήτου και έλεγχος των πεδίων
     */
    private void saveCar(){
        if(AFMField.getText().trim().isEmpty()){
            showError("Το id είναι υποχρεωτικό πεδίο!");
            return;
        }
        if(firstNameField.getText().trim().isEmpty()){
            showError("Η πινακίδα είναι υποχρεωτικό πεδίο!");
            return;
        }
        if(lastNameField.getText().trim().isEmpty()){
            showError("Η μάρκα είναι υποχρεωτικό πεδίο!");
        }
        if (phoneField.getText().trim().isEmpty()){
            showError("Το μοντέλο είναι υποχρεωτικό πεδίο!");
        }
        if(emailField.getText().trim().isEmpty()){
            showError("Το μοντέλο είναι υποχρεωτικό πεδίο!");
        }
        client=new Client(AFMField.getText().trim(),firstNameField.getText().trim(),lastNameField.getText().trim(),phoneField.getText().trim(),emailField.getText().trim());
        saved=true;
        dispose();
    }

    /**
     * Εμφάνιση λάθους
     * @param message Μήνυμα κατάλληλου λάθους
     */
    private void showError(String message){
        JOptionPane.showMessageDialog(this,message,"Σφάλμα Εισαγωγής!",JOptionPane.ERROR_MESSAGE);
    }

    /**
     * @return saved Για τον έλεγχο αποθήκευσης
     */
    public boolean isSaved(){
        return saved;
    }

    /**
     * @return αυτοκινήτου
     */
    public Client getClient(){
        return client;
    }


}
