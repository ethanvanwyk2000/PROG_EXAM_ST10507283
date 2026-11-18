import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class ProductCalculationsGUI extends JFrame {

    // Calculation constants & file path
    private static final double VAT_RATE = 0.15;
    private static final double COMMISSION_RATE = 0.10;
    private static final String FILE_NAME = "data.txt";

    // Input & action components
    private final JTextField txtCustomerName = new JTextField(20);
    private final JComboBox<String> cmbProduct = new JComboBox<>(
            new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"}
    );
    private final JTextField txtProductPrice = new JTextField(20);
    private final JButton btnProcess = new JButton("Process");

    private final DecimalFormat moneyFormat = new DecimalFormat("#,##0.00");
    private String lastFileLog = "";

    public ProductCalculationsGUI() {
        setTitle("Product App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 260);
        setLocationRelativeTo(null);

        createMenu();
        createForm();
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu mnuFile = new JMenu("File");
        JMenu mnuTools = new JMenu("Tools");

        JMenuItem mnuExit = new JMenuItem("Exit");
        JMenuItem mnuProcess = new JMenuItem("Process Report");
        JMenuItem mnuClear = new JMenuItem("Clear");
        JMenuItem mnuSave = new JMenuItem("Save Report");

        mnuExit.addActionListener(e -> System.exit(0));
        mnuProcess.addActionListener(e -> processReport());
        mnuClear.addActionListener(e -> clearForm());
        mnuSave.addActionListener(e -> saveReport());

        mnuFile.add(mnuExit);
        mnuTools.add(mnuProcess);
        mnuTools.add(mnuClear);
        mnuTools.add(mnuSave);

        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        setJMenuBar(menuBar);
    }

    private void processReport() {
        String customerName = txtCustomerName.getText().trim();
        String product = (String) cmbProduct.getSelectedItem();
        String priceText = txtProductPrice.getText().trim();

        if (customerName.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            double vatAmount = price * VAT_RATE;
            double commissionAmount = price * COMMISSION_RATE;
            double totalAmount = price + vatAmount + commissionAmount;

            String popupMessage = "CUSTOMER NAME: " + customerName + "\n"
                    + "PRODUCT: " + product + "\n"
                    + "VAT AMOUNT: R " + moneyFormat.format(vatAmount) + "\n"
                    + "COMMISSION AMOUNT: R " + moneyFormat.format(commissionAmount) + "\n"
                    + "TOTAL: R " + moneyFormat.format(totalAmount);

            lastFileLog = "DATA LOG\n"
                    + "************************************\n"
                    + "CUSTOMER NAME: " + customerName + "\n"
                    + "PRODUCT: " + product + "\n"
                    + "PRODUCT PRICE: R " + moneyFormat.format(price) + "\n"
                    + "VAT AMOUNT: R " + moneyFormat.format(vatAmount) + "\n"
                    + "COMMISSION AMOUNT: R " + moneyFormat.format(commissionAmount) + "\n"
                    + "TOTAL: R " + moneyFormat.format(totalAmount) + "\n"
                    + "************************************";

            JOptionPane.showMessageDialog(this, popupMessage, "Product Report", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the price.", "Format Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveReport() {
        if (lastFileLog.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please process a report first before saving.", "Save Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(lastFileLog);
            writer.newLine();
            writer.newLine();

            JOptionPane.showMessageDialog(this, "Report saved to " + FILE_NAME, "Save Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 5, 7, 5);
        gbc.anchor = GridBagConstraints.WEST;

        addComponent(panel, gbc, 0, 0, new JLabel("CUSTOMER NAME:"));
        addComponent(panel, gbc, 1, 0, txtCustomerName);

        addComponent(panel, gbc, 0, 1, new JLabel("SELECT PRODUCT:"));
        addComponent(panel, gbc, 1, 1, cmbProduct);

        addComponent(panel, gbc, 0, 2, new JLabel("PRODUCT PRICE (R):"));
        addComponent(panel, gbc, 1, 2, txtProductPrice);

        // Process button centered at the bottom
        btnProcess.addActionListener(e -> processReport());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 5, 5, 5);
        panel.add(btnProcess, gbc);

        add(panel, BorderLayout.CENTER);
    }

    private void addComponent(JPanel panel, GridBagConstraints gbc, int x, int y, Component component) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(component, gbc);
    }

    private void clearForm() {
        txtCustomerName.setText("");
        cmbProduct.setSelectedIndex(0);
        txtProductPrice.setText("");
        lastFileLog = "";
        txtCustomerName.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductCalculationsGUI().setVisible(true));
    }
}
