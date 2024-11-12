package library.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LibraryDashboard extends JFrame {
    private Container cont;

    public LibraryDashboard() {
        initializeUI();
    }

    private void initializeUI() {
        cont = getContentPane();
        cont.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 720);
        setTitle("Library Management Dashboard");
        cont.setBackground(new Color(253, 243, 221));

        JPanel leftPanel = createLeftPanel();
        cont.add(leftPanel);

        JPanel rightPanel = createRightPanel();
        cont.add(rightPanel);

        setVisible(true);
    }

    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 600, 720);
        leftPanel.setBackground(new Color(253, 243, 221));
        leftPanel.setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("QUẢN LÝ THƯ VIỆN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        leftPanel.add(titleLabel, gbc);

        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(500, 560));
        ImageIcon imageIcon = new ImageIcon("src\\image\\dashboard.jpg");
        imageLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(500, 560, Image.SCALE_SMOOTH)));

        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        leftPanel.add(imageLabel, gbc);

        return leftPanel;
    }

    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(680, 100, 450, 570);
        rightPanel.setBackground(new Color(253, 243, 221));
        rightPanel.setLayout(new GridLayout(2, 2, 20, 20));

        JButton btnManageBooks = createButtonWithAction("Quản Lý Sách", new Color(202, 170, 205), e -> openBookManagement());
        JButton btnManageReaders = createButtonWithAction("Quản Lý Độc Giả", new Color(203, 150, 46), e -> openReaderManagement());
        JButton btnLoanReturn = createButton("Mượn Trả Sách", new Color(239, 96, 30));
        JButton btnStatistics = createButton("Thống Kê", new Color(255, 216, 63));

        rightPanel.add(btnManageBooks);
        rightPanel.add(btnManageReaders);
        rightPanel.add(btnLoanReturn);
        rightPanel.add(btnStatistics);

        return rightPanel;
    }

    private JButton createButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }

    private JButton createButtonWithAction(String text, Color bgColor, ActionListener actionListener) {
        JButton button = createButton(text, bgColor);
        button.addActionListener(actionListener);
        return button;
    }

    private void openBookManagement() {
        new BookManagement1().setVisible(true);
        dispose();
    }

    private void openReaderManagement() {
        new ReaderManagement().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        new LibraryDashboard();
    }
}
