package Client;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JLabel lblJoin;
	private JButton joinCompleteBtn, btnjb, btnsignup, btncancel;
	private JTextField tfUsername;
	private JTextField tfId;
	private JTextField tfpwd;
	private JTextField tfName;
	private JTextField tfAddress;
	private JTextField tfPhone;
	private static ClientChat ch = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup(ch);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Signup(ClientChat ch) {
		this.ch = ch;
		createjlabel();
		createtxtfield();
		createbtn();
		jbchk();
		Pwdchk();
		complete();
	}

	private void createjlabel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(430, 490);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblJoin = new JLabel("ȸ������");

		Font f1 = new Font("HY������M", Font.BOLD, 20); // �ü� ���� ����
		lblJoin.setFont(f1);
		lblJoin.setBounds(159, 41, 101, 20);
		contentPane.add(lblJoin);

		JLabel lblUsername = new JLabel("���̵�: ");
		lblUsername.setBounds(69, 113, 69, 20);
		contentPane.add(lblUsername);

		JLabel lblName = new JLabel("�̸�: ");
		lblName.setBounds(69, 163, 69, 20);
		contentPane.add(lblName);

		JLabel pwd = new JLabel("��й�ȣ : ");
		pwd.setBounds(69, 210, 69, 20);
		contentPane.add(pwd);

		JLabel lblAddress = new JLabel("�ּ�: ");
		lblAddress.setBounds(69, 276, 69, 20);
		contentPane.add(lblAddress);

		JLabel lblPhone = new JLabel("�޴���: ");
		lblPhone.setBounds(69, 330, 69, 20);
		contentPane.add(lblPhone);

		JLabel lblMsg = new JLabel(("<html>**�޴�����ȣ �Է� ������ : <br>01012345678<br></html>"));
		lblMsg.setBounds(159, 355, 200, 55);
		Component aa = new JLabel();
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(aa.getFont().deriveFont(12.0f));
		lblMsg.setForeground(new Color(241, 95, 95));
		contentPane.add(lblMsg);

		JLabel lbl8word = new JLabel(("<html>*8���� �̻� *<html>"));
		lbl8word.setBounds(350, 190, 100, 30);
		// lbl8word.setFont(aa.getFont().deriveFont(12.0f));
		contentPane.add(lbl8word);

		JLabel lblove = new JLabel(("<html>*Ư������ ����*<html>"));
		lblove.setBounds(350, 210, 100, 30);
		contentPane.add(lblove);
	}

	private void createtxtfield() {
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(159, 106, 186, 35);
		contentPane.add(tfUsername);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(159, 156, 186, 35);
		contentPane.add(tfName);

		tfpwd = new JTextField();
		tfpwd.setColumns(10);
		tfpwd.setBounds(159, 203, 186, 35);
		contentPane.add(tfpwd);
		tfpwd.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 10)
					ke.consume();
			}
		});

		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(159, 276, 186, 35);
		contentPane.add(tfAddress);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(159, 330, 186, 35);
		contentPane.add(tfPhone);
	}

	private void createbtn() {
		btnsignup = new JButton("����");
		btncancel = new JButton("���");
		btncancel.setBounds(280, 440, 80, 29);
		contentPane.add(btncancel);
		setSize(500, 600);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //���α׷�����
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // dispose(); //����â�� �ݴ´�.
	}

	private void Pwdchk() {
		JLabel chkpwd = new JLabel((""));
		chkpwd.setBounds(150, 239, 186, 35);
		Component a = new JLabel();
		chkpwd.setHorizontalAlignment(SwingConstants.CENTER);
		chkpwd.setFont(a.getFont().deriveFont(12.0f));
		chkpwd.setForeground(new Color(204, 61, 61));
		contentPane.add(chkpwd);

		tfpwd.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) { // Ű ������ ��
			}

			@Override
			public void keyReleased(KeyEvent e) { // Ű ������ ���� ��
				String[] specialtxt = { "!", "@", "#", "$", "%", "^", "&", "*" };
				for (int i = 0; i < specialtxt.length; i++) {
					if (tfpwd.getText().indexOf(specialtxt[i]) == -1) { // Ư������ ����
						System.out.print(specialtxt[i]);
						if (tfpwd.getText().length() < 8 && tfpwd.getText().length() >= 1) {
							chkpwd.setText("Ư������X 8���� �����Դϴ�.");
							chkpwd.setForeground(new Color(153, 000, 000));
						} else if (tfpwd.getText().length() >= 8) {
							chkpwd.setText("Ư������X 8���� �̻��Դϴ�.");
							chkpwd.setForeground(new Color(153, 000, 000));
						}

					} else if (tfpwd.getText().indexOf(specialtxt[i]) != -1) {
						if (tfpwd.getText().length() < 8 && tfpwd.getText().length() >= 1) {
							chkpwd.setText("Ư������O 8���� �����Դϴ�.");
							chkpwd.setForeground(new Color(153, 000, 000));
							break;
						} else if (tfpwd.getText().length() >= 8) {
							chkpwd.setText("��밡���� ��й�ȣ�Դϴ�.");
							chkpwd.setForeground(new Color(000, 102, 000));
							break;

						}
					}
					if (tfpwd.getText().isEmpty()) {
						chkpwd.setText("");
					}
				}
				System.out.println();
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

		});

	}

	private void jbchk() {
		btnjb = new JButton("�ߺ�Ȯ��");
		btnjb.setBounds(350, 110, 100, 30);
		contentPane.add(btnjb);

		btnjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// MemberDTO member = new MemberDTO();
				// member.setId(tfUsername.getText());

				try {
					// MemberDAO dao = MemberDAO.getInstance();
					// Boolean result = dao.idchk(member);
//					if (result) {
//						JOptionPane.showMessageDialog(null, "�̹� ������� ���̵��Դϴ�.");
//						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//						tfUsername.setText("");
//					} else {
//						JOptionPane.showMessageDialog(null, "��� ������ ���̵��Դϴ�.");
//						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
	}

	private void complete() {
		joinCompleteBtn = new JButton("ȸ�����ԿϷ�");
		joinCompleteBtn.setBounds(130, 440, 139, 29);
		contentPane.add(joinCompleteBtn);

		setVisible(true);
		joinCompleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// MemberDTO member = new MemberDTO();
				// member.setId(tfUsername.getText());
				// member.setName(tfName.getText());
				// member.setPwd(tfpwd.getText());
				// member.setAdr(tfAddress.getText());
				// member.setCell(tfPhone.getText());

				String[] check = { tfUsername.getText(), 
						tfName.getText(),
						tfpwd.getText(), 
						tfAddress.getText(),
						tfPhone.getText()};
				ch.streamSet(check);

//				if (result) {
//					JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
//					dispose();
//				} else {
//					JOptionPane.showMessageDialog(null, "ȸ�������� �����Ͽ����ϴ�.");
//					dispose();
//				}
			}
		});

	}
}