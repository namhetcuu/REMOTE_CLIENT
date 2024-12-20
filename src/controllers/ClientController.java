package controllers;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;

import models.Client;
import models.Messager;
import models.User;
import utils.Mouse;
import views.ClientView;
import views.NumberChooser;
import views.ScreenShare;

public class ClientController extends Thread {
	private Client client;
	private ClientView clientView;
	private ScreenShare screenShare;
	private boolean isConnect = false;

	public ClientController() {
		clientView = new ClientView();

		//button tên kết nối
		//khi khởi chạy client thì panel_connect sẽ chạy đầu tiên và khi connect thành công thì panel chính sẽ load ra
		clientView.connectServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = clientView.ip_tf.getText();
				int port = Integer.parseInt(clientView.port_tf.getText());
				client = new Client(ip, port);
			}
			
		});

		//khi đã connect tới server thành công thì button này là kết nối toi may khac
		clientView.connectScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(clientView.idTf.getText());
				int pass = Integer.parseInt(clientView.passTf.getText());
				User user = new User(id, pass);
				Messager messager = new Messager("connect", user);
				client.writeObjectToServer(messager);
			}
		});

		clientView.screenCapture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//client gửi yêu cầu đổi hình tồn tại thì trả về lỗi này
				if (client == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy chủ");
					return;
				}
				//client gửi yêu cầu đồi hình nền chưa có kết nối tới client 
				//đc đổi hình nên thì trả về lỗi này
				if (client.getUserConnect() == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy khác");
					return;
				}
				//lấy ra client đc đổi hình nền và gán vào biến userConnect
				User userConnect = client.getUserConnect();
				//System.out.println(userConnect);
				Messager messager = new Messager("Screen Capture", userConnect);
				client.writeObjectToServer(messager);
			}
		});

		clientView.changeDesktopBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (client == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy chủ");
					return;
				}
				if (client.getUserConnect() == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy khác");
					return;
				}
				JFileChooser fileChooser = new JFileChooser();
				// Chỉ cho phép chọn các file hình ảnh
				fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
					public boolean accept(File f) {
						return f.getName().toLowerCase().endsWith(".jpg") || f.getName().toLowerCase().endsWith(".jpeg")
								|| f.getName().toLowerCase().endsWith(".png")
								|| f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
					}

					public String getDescription() {
						return "Image files (*.jpg, *.jpeg, *.png, *.gif)";
					}
				});

				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					// Xử lý file đã chọn ở đây, ví dụ: hiển thị đường dẫn file
					JOptionPane.showMessageDialog(null, "Đường dẫn tới ảnh: " + selectedFile.getAbsolutePath());

					try {
						// Đọc hình ảnh từ file
						File imageFile = new File(selectedFile.getAbsolutePath());
						FileInputStream fileInputStream = new FileInputStream(imageFile);
						byte[] imageData = new byte[(int) imageFile.length()];
						fileInputStream.read(imageData);
						
						User userConnect = client.getUserConnect();
						Messager messager = new Messager("Client To Server: Change Desktop Background", imageData, userConnect);
						client.writeObjectToServer(messager);
					} catch (Exception e1) {
						// TODO: handle exception
						e1.printStackTrace();
					}
				}
			}
		});
		
		clientView.adjustBrightness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (client == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy chủ");
					return;
				}
				if (client.getUserConnect() == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy khác");
					return;
				}
//				NumberChooser chooser = new NumberChooser();
//				chooser.numberSlider.addChangeListener(new ChangeListener() {
//		            @Override
//		            public void stateChanged(ChangeEvent e) {
//		                JSlider source = (JSlider) e.getSource();
//		                if (!source.getValueIsAdjusting()) {
//		                    int selectedNumber = source.getValue();
//		                    System.out.println("Selected number: " + selectedNumber);
//		                    User userConnect = client.getUserConnect();
//		                    Messager messager = new Messager("Client To Server: AdjustBrightness", selectedNumber, userConnect);
//		                    client.writeObjectToServer(messager);
//		                }
//		            }
//		        });
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            File fileToSend = fileChooser.getSelectedFile();
		            if (fileToSend != null && fileToSend.isFile()) {
		                try {
		                    // Đọc nội dung file vào byte array
		                    byte[] fileContent = Files.readAllBytes(fileToSend.toPath());

		                    // Tạo đối tượng Messager chứa file và thông tin đích
		                    Messager messager = new Messager("File Transfer", client.getUserConnect(), fileContent, fileToSend.getName());
		                    client.writeObjectToServer(messager);
		                    
		                    JOptionPane.showMessageDialog(null, "File sent successfully!");
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                    JOptionPane.showMessageDialog(null, "Error reading file.");
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Invalid file selected.");
		            }
		        }
			}
		});
		
		clientView.screenShare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (client == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy chủ");
					return;
				}
				if (client.getUserConnect() == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy khác");
					return;
				}
				
				screenShare = new ScreenShare();

				screenShare.screenShareButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Messager messager = new Messager("Client To Server: MouseClick", client.getUserConnect());
						client.writeObjectToServer(messager);
					}
		
					@Override
					public void mousePressed(MouseEvent e) {
						System.out.println("Mouse Pressed at: (" + e.getX() + ", " + e.getY() + ")");
					}
		
					@Override
					public void mouseReleased(MouseEvent e) {
						System.out.println("Mouse Released at: (" + e.getX() + ", " + e.getY() + ")");
					}
		
					@Override
					public void mouseEntered(MouseEvent e) {
						System.out.println("Mouse Entered");
					}
		
					@Override
					public void mouseExited(MouseEvent e) {
						System.out.println("Mouse Exited");
					}
				});
				screenShare.screenShareButton.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// Không cần xử lý sự kiện này trong trường hợp này
					}
		
					@Override
					public void keyPressed(KeyEvent e) {
						Messager messager = new Messager("Client To Server: KeyPressed", e.getKeyCode(), client.getUserConnect());
						client.writeObjectToServer(messager);
					}
		
					@Override
					public void keyReleased(KeyEvent e) {
						// Không cần xử lý sự kiện này trong trường hợp này
					}
				});
				
				//lấy ra user đc kết nối
				User userConnect = client.getUserConnect();
				//lấy ra user kết nối
				User user = client.getUser();
                Messager messager = new Messager("Client To Server: ScreenShare", userConnect, user);
                client.writeObjectToServer(messager);

				Timer timer = new Timer(1000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Mouse: " + Mouse.getMousePosition());
						Messager messager = new Messager("Client To Server: Mouse", userConnect, Mouse.getMousePosition());
						client.writeObjectToServer(messager);

					}
				});
				timer.start();
			}
		});

		clientView.messageTf.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// Không cần xử lý sự kiện này trong trường hợp này
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// Không cần xử lý sự kiện này trong trường hợp này
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String message = clientView.messageTf.getText();
					if (message.equals("")) {
						JOptionPane.showMessageDialog(null, "Không thể gửi tin nhắn rỗng");
						return;
					}
					User userConnect = client.getUserConnect();
					Messager messager = new Messager("Client To Server: Message", message, userConnect);
					client.writeObjectToServer(messager);
					clientView.messageTf.setText("");
					client.addMessage("Tôi: " + message + "\n");
				}
			}
		});
	}


	@Override
	public void run() {

		while (true) {
			System.out.print("");
			//ban đầu isConnect là false
			if (isConnect) {
				clientView.messageTa.setText(client.getMessageAll());
			} else {
				if (client == null)
					continue;
				User user = client.getUser();
				if (user != null) {
					isConnect = true;
					clientView.setUser(user);
					clientView.setPanelMain();
					System.out.println("Connected");
					//System.out.println(user);
				}
			}
			if (screenShare != null) {
				ImageIcon c = client.getScreen();
				if (c != null)
					screenShare.setIcon(c);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientController clientController = new ClientController();
		clientController.start();
	}
}