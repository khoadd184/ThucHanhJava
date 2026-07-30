package com.mycompany.movie;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Cửa sổ hiển thị danh sách phim, có thêm chức năng Thêm / Xóa phim
public class MovieFrame extends JFrame {

    private static final String[] COT = {
        "ID", "Tên phim", "Loại", "Giá gốc", "Giá sau tính toán"
    };

    // Field lưu danh sách phim -> dùng chung cho renderer, bảng, thêm, xóa
    private final List<Movie> danhSachPhim;
    private final DefaultTableModel model;
    private final JTable table;
    private int demId; // để tự sinh id cho phim mới

    public MovieFrame(List<Movie> danhSachPhim) {
        super("Quản Lý Phim");
        this.danhSachPhim = danhSachPhim;
        this.demId = danhSachPhim.size() + 1;

        model = new DefaultTableModel(COT, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false; // không cho sửa trực tiếp trên bảng
            }
        };

        for (Movie m : danhSachPhim) {
            model.addRow(taoDong(m));
        }

        table = new JTable(model);
        table.setRowHeight(28);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Tô màu cột "Tên phim" theo đúng toTitleColor() của từng phim
        table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object value, boolean isSelected,
                                                             boolean hasFocus, int row, int col) {
                Component c = super.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, col);
                String mau = MovieFrame.this.danhSachPhim.get(row).toTitleColor();
                if ("Trắng".equalsIgnoreCase(mau)) {
                    c.setBackground(Color.DARK_GRAY);
                    c.setForeground(Color.WHITE);
                } else if ("Xanh".equalsIgnoreCase(mau)) {
                    c.setBackground(Color.WHITE);
                    c.setForeground(Color.BLUE);
                } else {
                    c.setBackground(Color.WHITE);
                    c.setForeground(Color.BLACK);
                }
                c.setFont(getFont().deriveFont(Font.BOLD));
                return c;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ---- Panel nút Thêm / Xóa ----
        JButton btnThem = new JButton("Thêm phim");
        JButton btnXoa = new JButton("Xóa phim");
        btnThem.addActionListener(e -> moFormThemPhim());
        btnXoa.addActionListener(e -> xoaPhimDangChon());

        JPanel panelNut = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelNut.add(btnThem);
        panelNut.add(btnXoa);

        setLayout(new BorderLayout());
        add(new JLabel("  Danh sách phim", SwingConstants.LEFT), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelNut, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 380);
        setLocationRelativeTo(null);
    }

    private Object[] taoDong(Movie m) {
        String loai = m instanceof TVSeries ? "Phim bộ"
                    : m instanceof TheatricalFilm ? "Phim chiếu rạp"
                    : "Khác";
        return new Object[]{
            m.getId(),
            m.getName(),
            loai,
            String.format("%,.0f", m.getPrice()),
            String.format("%,.0f", m.calculatePrice())
        };
    }

    private void xoaPhimDangChon() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this,
                "Bạn chưa chọn phim nào để xóa.",
                "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int xacNhan = JOptionPane.showConfirmDialog(this,
            "Xóa phim \"" + danhSachPhim.get(row).getName() + "\"?",
            "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if (xacNhan == JOptionPane.YES_OPTION) {
            danhSachPhim.remove(row);
            model.removeRow(row);
        }
    }

    private void moFormThemPhim() {
        JComboBox<String> cboLoai = new JComboBox<>(new String[]{"Phim bộ", "Phim chiếu rạp"});
        JTextField txtTen = new JTextField();
        JTextField txtDes = new JTextField();
        JTextField txtGia = new JTextField();
        JTextField txtNSX = new JTextField();
        JTextField txtTheLoai = new JTextField();


        JTextField txtSoTap = new JTextField();
        JTextField txtThoiLuongTap = new JTextField();

        JTextField txtThoiLuongPhim = new JTextField();
        JTextField txtDoanhThu = new JTextField();

        JPanel panelRieng = new JPanel(new CardLayout());
        JPanel panelTVSeries = new JPanel(new GridLayout(2, 2, 5, 5));
        panelTVSeries.add(new JLabel("Số tập:"));
        panelTVSeries.add(txtSoTap);
        panelTVSeries.add(new JLabel("Thời lượng/tập (phút):"));
        panelTVSeries.add(txtThoiLuongTap);

        JPanel panelFilm = new JPanel(new GridLayout(2, 2, 5, 5));
        panelFilm.add(new JLabel("Thời lượng phim (phút):"));
        panelFilm.add(txtThoiLuongPhim);
        panelFilm.add(new JLabel("Doanh thu phòng vé:"));
        panelFilm.add(txtDoanhThu);

        panelRieng.add(panelTVSeries, "Phim bộ");
        panelRieng.add(panelFilm, "Phim chiếu rạp");

        cboLoai.addActionListener(e ->
            ((CardLayout) panelRieng.getLayout()).show(panelRieng, (String) cboLoai.getSelectedItem()));

        JPanel panelChung = new JPanel(new GridLayout(0, 2, 5, 5));
        panelChung.add(new JLabel("Loại phim:"));
        panelChung.add(cboLoai);
        panelChung.add(new JLabel("Tên phim:"));
        panelChung.add(txtTen);
        panelChung.add(new JLabel("Mô tả:"));
        panelChung.add(txtDes);
        panelChung.add(new JLabel("Giá:"));
        panelChung.add(txtGia);
        panelChung.add(new JLabel("Nhà sản xuất:"));
        panelChung.add(txtNSX);
        panelChung.add(new JLabel("Thể loại (catagories):"));
        panelChung.add(txtTheLoai);

        JPanel panelForm = new JPanel(new BorderLayout(10, 10));
        panelForm.add(panelChung, BorderLayout.NORTH);
        panelForm.add(panelRieng, BorderLayout.CENTER);

        int ketQua = JOptionPane.showConfirmDialog(this, panelForm,
            "Thêm phim mới", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (ketQua != JOptionPane.OK_OPTION) {
            return; 
        }

        try {
            double gia = Double.parseDouble(txtGia.getText().trim());
            String id = String.valueOf(demId);
            Movie phimMoi;

            if ("Phim bộ".equals(cboLoai.getSelectedItem())) {
                int soTap = Integer.parseInt(txtSoTap.getText().trim());
                double thoiLuongTap = Double.parseDouble(txtThoiLuongTap.getText().trim());
                phimMoi = new TVSeries(id, txtTen.getText().trim(), txtDes.getText().trim(), gia,
                        "TVSeries", txtNSX.getText().trim(), txtTheLoai.getText().trim(), new Date(),
                        soTap, thoiLuongTap);
            } else {
                double thoiLuongPhim = Double.parseDouble(txtThoiLuongPhim.getText().trim());
                double doanhThu = Double.parseDouble(txtDoanhThu.getText().trim());
                phimMoi = new TheatricalFilm(id, txtTen.getText().trim(), txtDes.getText().trim(), gia,
                        "TheatricalFilm", txtNSX.getText().trim(), txtTheLoai.getText().trim(), new Date(),
                        thoiLuongPhim, doanhThu);
            }

            danhSachPhim.add(phimMoi);
            model.addRow(taoDong(phimMoi));
            demId++;

        } catch (Movievalidationexception ex) {
            JOptionPane.showMessageDialog(this,
                "Dữ liệu không hợp lệ: " + ex.getMessage(),
                "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Giá / số tập / thời lượng / doanh thu phải là số hợp lệ.",
                "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}