package library.management;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;
import jdk.dynalink.beans.StaticClass;

public class StatisticUI extends JFrame {

    private StatisticModify statisticModify = new StatisticModify();
    private JPanel pnlStatistical; 
    private JLabel lblStatisticTotalBook;
    private JLabel lblStatisticPunish;
    private JLabel lblStatisticTotalLoan;
    private JLabel lblStatisticLoan;
    private JLabel jLabelBackground, lblStatistic;
    private JButton btnBack;

    public StatisticUI(){
        setTitle("Thống Kê");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 720);

        Container cont = getContentPane();
        cont.setLayout(null);

        pnlStatistical = new JPanel();
        pnlStatistical.setLayout(null);
        pnlStatistical.setBounds(0, 0, 1200, 720);
        
        lblStatistic = new JLabel("THỐNG KÊ", SwingConstants.CENTER);
        lblStatistic.setBackground(new Color(243,77,110));
        lblStatistic.setFont(new Font("Serif", Font.BOLD, 30));
        lblStatistic.setForeground(new Color(255, 255, 255));
        lblStatistic.setBounds(440, 10, 200, 50);
        
        lblStatistic.setOpaque(true);
        
        // Khởi tạo các nhãn với thông tin thống kê
        lblStatisticTotalBook = createLabel("TỔNG SỐ SÁCH: ", 240, 210);
        lblStatisticTotalLoan = createLabel("TỔNG SỐ PHIẾU MƯỢN: ", 240, 325);
        lblStatisticLoan = createLabel("SÁCH ĐANG CHO MƯỢN: ", 240, 435);
        lblStatisticPunish = createLabel("SÁCH ĐANG TRỄ HẠN: ", 240, 545);
        
        getStatistic();

        // Thêm các nhãn vào panel thống kê
        pnlStatistical.add(lblStatistic);
        pnlStatistical.add(lblStatisticTotalBook);
        pnlStatistical.add(lblStatisticTotalLoan);
        pnlStatistical.add(lblStatisticLoan);
        pnlStatistical.add(lblStatisticPunish);
        
        // Khởi tạo nút quay lại
        
        btnBack = new JButton("Quay lại");
        btnBack.setBounds(10, 10, 120, 50);
        
        btnBack.setBackground(new Color(255, 234, 197));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LibraryDashboard().setVisible(true);
                dispose();  // Ẩn cửa sổ LibraryManagement hiện tại
            }
        });
        pnlStatistical.add(btnBack);

        // Thiết lập hình nền
        ImageIcon icon = new ImageIcon("src\\images\\statistic_img.png");
        Image image = icon.getImage().getScaledInstance(1200, 720, Image.SCALE_SMOOTH); // Thay đổi kích thước ảnh
        jLabelBackground = new JLabel(new ImageIcon(image));
        jLabelBackground.setBounds(0, 0, 1200, 720);
        pnlStatistical.add(jLabelBackground);

        // Thêm panel thống kê vào container
        cont.add(pnlStatistical);
        
        setVisible(true);
    }

    // Phương thức tạo nhãn
    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        label.setForeground(new Color(164, 124, 134));
        label.setBounds(x, y, 400, 50);
        return label;
    }
    
    public void getStatistic()
    {
		lblStatisticTotalBook.setText("Tổng số sách: "+statisticModify.getStatisticTotalBook());
		lblStatisticTotalLoan.setText("Tổng số phiếu mượn sách: "+statisticModify.getStatisticTotalLoan());
		lblStatisticLoan.setText("Sách đang cho mượn: "+statisticModify.getStatisticLoan());
		lblStatisticPunish.setText("Sách đang bị trễ hạn trả: "+statisticModify.getStatisticPunish());
    }
    
}
