package library.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryDashboard extends JFrame {
    private Container cont;

    public LibraryDashboard() {
        cont = this.getContentPane();
        cont.setLayout(null);

        // Cấu hình cửa sổ chính
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 720);
        setTitle("Library Management Dashboard");

        // Panel bên trái chứa hình ảnh và tiêu đề
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 600, 720);
        leftPanel.setBackground(new Color(253, 243, 221));  // Đặt màu nền cho dễ nhìn
        leftPanel.setLayout(new GridBagLayout());  // Sử dụng GridBagLayout để căn giữa nội dung
        cont.add(leftPanel);

        // Tạo JLabel cho tiêu đề
        JLabel titleLabel = new JLabel("QUẢN LÝ THƯ VIỆN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));  // Thiết lập font chữ
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));  // Tạo khoảng cách
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;  // Căn tiêu đề lên trên
        leftPanel.add(titleLabel, gbc);

        // Tạo JLabel để chứa hình ảnh
        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(500, 560));  // Chỉ định kích thước cho imageLabel
        ImageIcon imageIcon = new ImageIcon("src\\image\\dashboard.jpg");  // Đường dẫn đến ảnh của bạn
        imageLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(500, 560, Image.SCALE_SMOOTH)));
        
        // Thêm imageLabel vào giữa leftPanel
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        leftPanel.add(imageLabel, gbc);

        // Panel bên phải chứa các button
        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(600, 0, 600, 720);
        rightPanel.setBackground(new Color(253, 243, 221));
        rightPanel.setLayout(new GridLayout(2, 2, 20, 20));  // Chia thành 2x2 ô, khoảng cách giữa các nút là 20
        cont.add(rightPanel);
        
        // Tạo các button cho các chức năng
        JButton btnManageBooks = new JButton("Quản Lý Sách");
        btnManageBooks.setBackground(new Color(202, 170, 205));
        
        
        JButton btnManageReaders = new JButton("Quản Lý Độc Giả");
        btnManageReaders.setBackground(new Color(203, 150, 46));
        
        JButton btnLoanReturn = new JButton("Mượn Trả Sách");
        btnLoanReturn.setBackground(new Color(239, 96, 30));
        
        JButton btnStatistics = new JButton("Thống Kê");
        btnStatistics.setBackground(new Color(255, 216, 63));

        // Thiết lập kích thước các button
        btnManageBooks.setPreferredSize(new Dimension(90, 90));
        btnManageReaders.setPreferredSize(new Dimension(90, 90));
        btnLoanReturn.setPreferredSize(new Dimension(90, 90));
        btnStatistics.setPreferredSize(new Dimension(90, 90));

        // Thêm các button vào rightPanel
        rightPanel.add(btnManageBooks);
        rightPanel.add(btnManageReaders);
        rightPanel.add(btnLoanReturn);
        rightPanel.add(btnStatistics);
        
        btnManageBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookManagement1().setVisible(true);
                dispose();  // Ẩn cửa sổ Dashboard hiện tại
            }
        });
        
        btnManageReaders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReaderManagement().setVisible(true);
                dispose();  // Ẩn cửa sổ Dashboard hiện tại
            }
        });
        
        setVisible(true);
    }
    
    private JButton createButtonWithImageAndText(String text, String imagePath, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setFont(new Font("Arial", Font.BOLD, 14));  // Thiết lập font chữ

        // Đặt vị trí của văn bản bên dưới hình ảnh
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        // Đặt hình ảnh vào nút
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);  // Kích thước hình ảnh
            button.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Thiết lập kích thước của nút
        button.setPreferredSize(new Dimension(120, 120));
        return button;
        }

    public static void main(String[] args) {
        new LibraryDashboard();
    }
}
