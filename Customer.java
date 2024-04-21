import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;

public class Customer extends JFrame {
    private JComboBox<String> faqDropdown;

    private String[] faqQuestions = {"How do I apply for a loan?\", \"How much is the down payment?\", \"What types of loans do you offer?"};
    private String[] faqAnswers = {
        "You can start your loan application via My Home Credit App from Google Playstore prior to visiting \nour retail partner stores to continue the process or you can go directly to our retail partner stores \nand have our Sales Associate or Retail Associate to assist you.",
        "Down payment may be from 20-40%, depending on the item's price and installment offer available.\nFor lighter monthly installments, you may pay above the minimum required down payment.\nTo find available offers, log in to My Home Credit App or approach a Sales Associate at our \npartner stores nationwide.",
        "We offer Product Loans through in-store financing. We can help finance your purchase which you \ncan repay through easy, monthly installments.\r\n"
        + "\r\n"
        + "Home Credit currently finances:\r\n"
        + "\r\n"
        + "Gadgets (such as mobile phones, tablets, and laptops)\r\n"
        + "Home Appliances\r\n"
        + "Electronics (such as TVs, HIFI, and Cameras)\r\n"
        + "Furniture\r\n"
        + "Musical instruments\r\n"
        + "Hardware Tools\r\n"
        + "Ebike\r\n"
        + "Sporting Goods\r\n"
        + "Auto Supplies and Services\r\n"
        + "Beauty &Wellness\r\n"
        + "Optical\r\n"
        + "Events\r\n"
        + "Trainings\r\n"
        + "Home Improvement\r\n"
        + "Medical Supplies and Devices\r\n"
        + "Apparel Store\r\n"
        + "Department Store\r\n"
        + "Hardware Store\r\n"
        + "Toy Store\r\n"
        + "Motorcycle Accessories Store"
    };

    public Customer() {
        setTitle("FAQ Dropdown");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 134, 764, 316);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 0, 0));
        panel.setLayout(null);
        panel.add(scrollPane);
        
                faqDropdown = new JComboBox<>(faqQuestions);
                scrollPane.setColumnHeaderView(faqDropdown);
                faqDropdown.setFont(new Font("Dialog", Font.BOLD, 15));
                faqDropdown.setModel(new DefaultComboBoxModel(new String[] {"How do I apply for a loan?", "How much is the down payment?", "What types of loans do you offer?"}));
                
                JTextArea answerTextArea = new JTextArea();
                answerTextArea.setFont(new Font("Dialog", Font.PLAIN, 17));
                scrollPane.setViewportView(answerTextArea);
                answerTextArea.setEditable(false);
                
                        faqDropdown.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int selectedIndex = faqDropdown.getSelectedIndex();
                                if (selectedIndex >= 0 && selectedIndex < faqAnswers.length) {
                                    answerTextArea.setText(faqAnswers[selectedIndex]);
                                }
                            }
                        });

        getContentPane().add(panel);
        
        JLabel label = new JLabel("");
        Image img = new ImageIcon(this.getClass().getResource("FAQimg.png")).getImage();
        label.setIcon(new ImageIcon(img));
        label.setBounds(48, 11, 685, 112);
        panel.add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Customer faqDropdown = new Customer();
                faqDropdown.setVisible(true);
            }
        });
    }
}