package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import models.User;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ClientView extends JFrame {

	private JPanel contentPane;
	public JTextField ip_tf;
	public JTextField port_tf;
	private JTextField myID;
	private JTextField myPass;
	public JTextField idTf;
	public JTextField passTf;
	private JPanel connect_pn;
	private JPanel main_pn;
	public JButton connectScreen;
	public JButton connectServer;
	public JButton screenCapture;
	public JButton changeDesktopBackground;
	public JButton adjustBrightness;
	public JButton screenShare;
	public JTextField messageTf;
	private boolean isChat = false;
	public JButton chatBt;
	public JTextArea messageTa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientView frame = new ClientView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientView() {
		setTitle("Điều khiển màn hình");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 443);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(277, 11, 303, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		main_pn = new JPanel();
		main_pn.setBackground(new Color(192, 192, 192));
		main_pn.setBounds(10, 11, 283, 331);
		panel.add(main_pn);
		main_pn.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 11, 283, 126);
		main_pn.add(panel_1_1);
		
		myID = new JTextField();
		myID.setBackground(new Color(255, 255, 255));
		myID.setFont(new Font("Roboto", Font.BOLD, 13));
		myID.setColumns(10);
		myID.setBounds(49, 50, 224, 26);
		myID.setHorizontalAlignment(JTextField.CENTER);
		panel_1_1.add(myID);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblId.setBounds(10, 56, 61, 14);
		panel_1_1.add(lblId);
		
		JLabel lblChoPhpKt = new JLabel("Cho phép điều khiển", SwingConstants.CENTER);
		lblChoPhpKt.setForeground(new Color(0, 0, 0));
		lblChoPhpKt.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblChoPhpKt.setBounds(10, 11, 263, 14);
		panel_1_1.add(lblChoPhpKt);
		
		JLabel lblPass = new JLabel("PASS");
		lblPass.setForeground(new Color(0, 0, 0));
		lblPass.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblPass.setBounds(10, 93, 61, 14);
		panel_1_1.add(lblPass);
		
		myPass = new JTextField();
		myPass.setBackground(new Color(255, 255, 255));
		myPass.setFont(new Font("Roboto", Font.BOLD, 13));
		myPass.setColumns(10);
		myPass.setBounds(49, 87, 224, 26);
		myPass.setHorizontalAlignment(JTextField.CENTER);
		panel_1_1.add(myPass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 148, 263, 2);
		main_pn.add(separator);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(192, 192, 192));
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(0, 161, 283, 171);
		main_pn.add(panel_1_2);
		
		idTf = new JTextField();
		idTf.setBackground(new Color(255, 255, 255));
		idTf.setFont(new Font("Roboto", Font.BOLD, 13));
		idTf.setColumns(10);
		idTf.setBounds(52, 50, 221, 26);
		idTf.setHorizontalAlignment(JTextField.CENTER);
		panel_1_2.add(idTf);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 56, 61, 14);
		panel_1_2.add(lblNewLabel_1);
		
		JLabel lbliuKhinMn = new JLabel("Điều khiển máy tính khác", SwingConstants.CENTER);
		lbliuKhinMn.setForeground(new Color(0, 0, 0));
		lbliuKhinMn.setFont(new Font("Roboto", Font.PLAIN, 17));
		lbliuKhinMn.setBounds(10, 11, 263, 29);
		panel_1_2.add(lbliuKhinMn);
		
		JLabel lblPort_1 = new JLabel("PASS");
		lblPort_1.setForeground(new Color(0, 0, 0));
		lblPort_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblPort_1.setBounds(10, 93, 61, 14);
		panel_1_2.add(lblPort_1);
		
		passTf = new JTextField();
		passTf.setBackground(new Color(255, 255, 255));
		passTf.setFont(new Font("Roboto", Font.BOLD, 13));
		passTf.setColumns(10);
		passTf.setBounds(52, 87, 221, 26);
		passTf.setHorizontalAlignment(JTextField.CENTER);
		panel_1_2.add(passTf);
		
		connectScreen = new JButton("Bắt đầu điều khiển");
		connectScreen.setFont(new Font("Roboto", Font.PLAIN, 11));
		connectScreen.setBackground(new Color(192, 192, 192));
		connectScreen.setForeground(new Color(0, 0, 0));
		connectScreen.setBounds(84, 125, 138, 23);
		panel_1_2.add(connectScreen);
		
		connect_pn = new JPanel();
		connect_pn.setBackground(new Color(192,192,192));
		connect_pn.setBounds(13, 57, 273, 171);
		panel.add(connect_pn);
		connect_pn.setLayout(null);
		
		ip_tf = new JTextField("localhost");
		ip_tf.setBackground(Color.decode("#acadaf"));
		ip_tf.setFont(new Font("Roboto", Font.BOLD, 13));
		ip_tf.setBounds(49, 50, 214, 26);
		ip_tf.setHorizontalAlignment(JTextField.CENTER);
		connect_pn.add(ip_tf);
		ip_tf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("IP");
		lblNewLabel.setForeground(new Color(0,0,0));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 56, 46, 14);
		connect_pn.add(lblNewLabel);
		
		JLabel lblKtNiTi = new JLabel("Kết nối tới máy chủ", SwingConstants.CENTER);
		lblKtNiTi.setBackground(Color.decode("#3d3b37"));
		lblKtNiTi.setForeground(new Color(0,0,0));
		lblKtNiTi.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblKtNiTi.setBounds(10, 11, 263, 14);
		connect_pn.add(lblKtNiTi);
		
		JLabel lblPort = new JLabel("PORT");
		lblPort.setForeground(new Color(0,0,0));
		lblPort.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblPort.setBounds(10, 93, 46, 14);
		connect_pn.add(lblPort);
		
		port_tf = new JTextField("6868");
		port_tf.setBackground(Color.decode("#acadaf"));
		port_tf.setFont(new Font("Roboto", Font.BOLD, 13));
		port_tf.setColumns(10);
		port_tf.setHorizontalAlignment(JTextField.CENTER);
		port_tf.setBounds(49, 87, 214, 26);
		connect_pn.add(port_tf);
		
		connectServer = new JButton("Kết nối");
		connectServer.setFont(new Font("Roboto", Font.PLAIN, 11));
		connectServer.setBackground(new Color(192,192,192));
		connectServer.setForeground(new Color(0,0,0));
		connectServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setPanelMain();
			}
		});
		connectServer.setBounds(101, 125, 89, 23);
		connect_pn.add(connectServer);
		
		chatBt = new JButton("Show chat");
		chatBt.setForeground(new Color(0, 0, 0));
		chatBt.setBackground(new Color(192, 192, 192));
		chatBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSizeAll();
			}
		});
		chatBt.setBounds(197, 347, 96, 29);
		panel.add(chatBt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 257, 384);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		screenCapture = new JButton("");
		screenCapture.setIcon(getIcon("screen_capture"));
		screenCapture.setBounds(10, 11, 113, 113);
		panel_1.add(screenCapture);
		
		changeDesktopBackground = new JButton("");
		changeDesktopBackground.setBounds(133, 11, 113, 113);
		changeDesktopBackground.setIcon(getIcon("change_desktop_background"));
		panel_1.add(changeDesktopBackground);
		
		adjustBrightness = new JButton("");
		adjustBrightness.setBounds(10, 135, 113, 113);
		adjustBrightness.setIcon(getIcon("adjust_brightness"));
		panel_1.add(adjustBrightness);
		
		screenShare = new JButton("");
		screenShare.setBounds(133, 135, 113, 113);
		screenShare.setIcon(getIcon("screen_share"));
		panel_1.add(screenShare);
		
		JButton screenCapture_3 = new JButton("");
		screenCapture_3.setIcon(getIcon("coming_soon"));
		screenCapture_3.setBounds(10, 260, 113, 113);
		panel_1.add(screenCapture_3);
		
		JButton screenCapture_1_2 = new JButton("");
		screenCapture_1_2.setIcon(getIcon("coming_soon"));
		screenCapture_1_2.setBounds(133, 260, 113, 113);
		panel_1.add(screenCapture_1_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(601, 11, 226, 384);
		panel_2.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 202, 327);
		panel_2.add(scrollPane);
		
		messageTa = new JTextArea();
		messageTa.setBackground(Color.decode("#acadaf"));
		scrollPane.setViewportView(messageTa);
		
		messageTf = new JTextField();
		messageTf.setBackground(Color.decode("#acadaf"));
		messageTf.setBounds(10, 349, 202, 24);
		panel_2.add(messageTf);
		messageTf.setColumns(10);
		setLocationRelativeTo(null);
		this.addHoverListener();
		setSizeAll();
		
		setPanelConnect();
		setVisible(true);
	}
	
	public void addHoverListener() {
		screenCapture.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                screenCapture.setIcon(getIcon("screen_capture_hover"));
            }
        });

		screenCapture.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
            	screenCapture.setIcon(getIcon("screen_capture"));
            }
        });
		
		adjustBrightness.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            	adjustBrightness.setIcon(getIcon("adjust_brightness_hover"));
            }
        });

		adjustBrightness.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
            	adjustBrightness.setIcon(getIcon("adjust_brightness"));
            }
        });
		
		changeDesktopBackground.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            	changeDesktopBackground.setIcon(getIcon("change_desktop_background_hover"));
            }
        });

		changeDesktopBackground.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
            	changeDesktopBackground.setIcon(getIcon("change_desktop_background"));
            }
        });

		screenShare.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            	screenShare.setIcon(getIcon("screen_share_hover"));
            }
        });

		screenShare.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
            	screenShare.setIcon(getIcon("screen_share"));
            }
        });
	}
	
	void setSizeAll() {
		if (isChat) {
			setBounds(100, 100, 851, 450);
			chatBt.setText("Hide chat");
		}
		else {
			chatBt.setText("Show chat");
			setBounds(100, 100, 620, 450);
		}
			
		setLocationRelativeTo(null);
		isChat = !isChat;
	}
	
	public Icon getIcon(String name) {
		int width = 113;
		int height = 113;
		Image image = new ImageIcon(getClass().getResource("/icons/" + name + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	
	public void setPanelConnect() {
		main_pn.setVisible(false);
		connect_pn.setVisible(true);
	}
	
	public void setPanelMain() {
//		System.out.println("cc");
		main_pn.setVisible(true);
		connect_pn.setVisible(false);
	}
	
	public void setUser(User user) {
		myID.setText(user.getId() + "");
		myPass.setText(user.getPassword() + "");
	}
	
	public void setIsChat(boolean isChat) {
		this.isChat = isChat;
		setSizeAll();
	}

	public void addMessage(String message) {
		messageTa.append(message + "\n");
	}
}