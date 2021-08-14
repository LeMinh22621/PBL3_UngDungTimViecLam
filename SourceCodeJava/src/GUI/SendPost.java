package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import BLL.BLL;

public class SendPost extends JFrame 
{
	private static SendPost Instance;
	public static SendPost getInstance(String idEmployer, String idJobSeeker)
	{
		if(Instance == null)
			Instance = new SendPost(idEmployer, idJobSeeker);
		return Instance;
	}
	private JComboBox cbbPostSelection;
	private DefaultComboBoxModel<ItemPost> listItems;
	public SendPost(String idEmployer, String idJobSeeker)
	{
		setBounds(0, 0, 430, 420);
		getContentPane().setLayout(null);
		
		JLabel lbContentMessage = new JLabel("Content Message");
		lbContentMessage.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lbContentMessage.setBounds(25, 72, 132, 22);
		getContentPane().add(lbContentMessage);
		
		JLabel lbPostSelected = new JLabel("Selection Post");
		lbPostSelected.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lbPostSelected.setBounds(25, 217, 132, 22);
		getContentPane().add(lbPostSelected);
		
		cbbPostSelection = new JComboBox();
		cbbPostSelection.setBounds(68, 245, 292, 32);
		getContentPane().add(cbbPostSelection);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(262, 318, 98, 39);
		getContentPane().add(btnCancel);
		
		JLabel lbTitle = new JLabel("Send Message");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 24));
		lbTitle.setBounds(112, 22, 192, 39);
		getContentPane().add(lbTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 113, 292, 93);
		getContentPane().add(scrollPane);
		
		JTextArea txtAContentMess = new JTextArea();
		scrollPane.setViewportView(txtAContentMess);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(cbbPostSelection.getSelectedIndex() != -1)
				{
					String contents = txtAContentMess.getText();
					int index = cbbPostSelection.getSelectedIndex();
					ItemPost item = listItems.getElementAt(index);
					BLL.getInstance().sendMessToJobSeeker_BLL(idEmployer, idJobSeeker, contents, item.getIdPost());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Send Failed");
				}
			}
		});
		btnOK.setBounds(68, 318, 110, 39);
		getContentPane().add(btnOK);
		
		btnCancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		initialize(idEmployer);
	}
	public void initialize(String idEmployer)
	{
		List<DTO.Post> listPosts = BLL.getInstance().getListPostByIdemployer_BLL(idEmployer);
		listItems = new DefaultComboBoxModel<ItemPost>();
		for(DTO.Post i : listPosts)
		{
			ItemPost itemPost = new ItemPost();
			itemPost.setIdPost(i.getID_POST());
			itemPost.setTitle(i.getJOB_NAME());
			listItems.addElement(itemPost);
		}
		cbbPostSelection.setModel(listItems);
	}
}
class ItemPost
{
	private String title;
	private String idPost;
	public String getIdPost() {
		return idPost;
	}
	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString()
	{
		return title;
	}
}