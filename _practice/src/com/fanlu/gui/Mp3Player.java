package com.fanlu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public class Mp3Player extends JFrame implements ActionListener,
		ListSelectionListener {

	String[] data = { "one", "two", "three", "four" };

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private DefaultListModel allsongsModel;
	private DefaultListModel mp3sModel;
	private DefaultListModel listsModel;
	private DefaultListModel findsongModel;
	private javax.swing.JScrollPane sp1;
	private javax.swing.JScrollPane sp2;
	private javax.swing.JScrollPane sp3;
	private javax.swing.JScrollPane sp4;
	private JList list, list_1, list_2;
	static private LinkedList<IndividualMP3s> arrayofsongs = new LinkedList<IndividualMP3s>();
	static private LinkedList<Playlists> arrayoflists = new LinkedList<Playlists>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		IndividualMP3s m1 = new IndividualMP3s("song1", "someone1");
		IndividualMP3s m2 = new IndividualMP3s("song2", "someone2");
		IndividualMP3s m3 = new IndividualMP3s("song3", "someone3");
		arrayofsongs.add(m1.getId(), m1);
		arrayofsongs.add(m2.getId(), m2);
		arrayofsongs.add(m3.getId(), m3);

		Playlists p1 = new Playlists("list1");
		Playlists p2 = new Playlists("list2");
		arrayoflists.add(p1.getId(), p1);
		arrayoflists.add(p2.getId(), p2);

		p1.getList().add(m1.getId());
		p1.getList().add(m2.getId());
		p1.getList().add(m3.getId());

		p2.getList().add(m1.getId());
		p2.getList().add(m2.getId());
		p2.getList().add(m3.getId());

		// for(int i=0;i<arrayoflists.size();i++){
		// System.out.println(arrayoflists.get(i).getName());
		// System.out.println(arrayofsongs.get(arrayoflists.get(0).getList().get(i)));
		// }

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mp3Player frame = new Mp3Player();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mp3Player() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// first list
		list = new JList();
		allsongsModel = new DefaultListModel();
		list.setModel(allsongsModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sp1 = new JScrollPane();
		sp1.setViewportView(list);
		sp1.setBounds(20, 35, 266, 116);
		contentPane.add(sp1);
		list.addListSelectionListener(this);

		JLabel lblSongs = new JLabel("Songs");
		lblSongs.setBounds(20, 10, 79, 23);
		contentPane.add(lblSongs);

		JLabel lblNewLabel = new JLabel("Artist");
		lblNewLabel.setBounds(296, 35, 64, 23);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(355, 37, 279, 21);

		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(296, 80, 64, 23);
		contentPane.add(lblTitle);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(355, 82, 279, 21);
		contentPane.add(textField_1);

		JLabel lblMemory = new JLabel("Memory");
		lblMemory.setBounds(296, 128, 64, 23);
		contentPane.add(lblMemory);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(355, 130, 279, 21);
		contentPane.add(textField_2);

		JButton btnNewButton = new JButton("Add MP3 Song");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().isEmpty()
						|| textField.getText().isEmpty()) {
					JOptionPane
							.showMessageDialog(
									null,
									"the name of the song or aritist should not be empty",
									"Warning", JOptionPane.WARNING_MESSAGE);
				} else {
					IndividualMP3s m = new IndividualMP3s(
							textField_1.getText(), textField.getText());
					arrayofsongs.add(m);
					allsongsModel.addElement(m);
					// for(int i=0;i<arrayofsongs.size();i++){
					// System.out.println(arrayofsongs.get(i).getTitle()+" "+arrayofsongs.get(i).getArtist());
					// }
				}
			}
		});
		btnNewButton.setBounds(330, 163, 123, 23);
		contentPane.add(btnNewButton);

		JLabel lblMemoryLeft = new JLabel("Memory Left");
		lblMemoryLeft.setBounds(20, 198, 99, 27);
		contentPane.add(lblMemoryLeft);

		JLabel label_3 = new JLabel("New label");
		label_3.setForeground(Color.BLUE);
		label_3.setBounds(209, 202, 64, 23);
		contentPane.add(label_3);

		JLabel lblPlaylist = new JLabel("Playlists");
		lblPlaylist.setBounds(20, 244, 64, 23);
		contentPane.add(lblPlaylist);

		JButton btnDeleteSongs = new JButton("Delete Song");
		btnDeleteSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedIndex() > -1) {
					// System.out.println(list.getSelectedIndex()+" zhehang");
			 		// System.out.println(list.getSelectedIndex());
					for (int i = 0; i < arrayoflists.size(); i++) {
						System.out.println(arrayofsongs.get(((IndividualMP3s) list.getSelectedValue()).getId()));
						try {
							arrayoflists.get(i)
									.getList()
									.remove((Object)((IndividualMP3s) list.getSelectedValue()).getId());
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					allsongsModel.remove(list.getSelectedIndex());
				}

			}
		});
		btnDeleteSongs.setBounds(16, 162, 115, 25);
		contentPane.add(btnDeleteSongs);
// second list
		list_1 = new JList();
		listsModel = new DefaultListModel();
		list_1.setModel(listsModel);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.addListSelectionListener(this);

		sp2 = new JScrollPane();
		sp2.setViewportView(list_1);
		sp2.setBounds(20, 270, 266, 116);
		contentPane.add(sp2);

		JButton btnDeletePlaylist = new JButton("Delete Playlist");
		btnDeletePlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list_1.getSelectedIndex() > -1) {
					listsModel.remove(list_1.getSelectedIndex());
				}
			}
		});
		btnDeletePlaylist.setBounds(301, 316, 130, 27);
		contentPane.add(btnDeletePlaylist);

		JLabel lblPlaylistName = new JLabel("Playlist Name");
		lblPlaylistName.setBounds(296, 365, 79, 23);
		contentPane.add(lblPlaylistName);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(381, 365, 253, 23);
		contentPane.add(textField_3);
// third list
		list_2 = new JList();
		mp3sModel = new DefaultListModel();
		list_2.setModel(mp3sModel);
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_2.addListSelectionListener(this);

		sp3 = new JScrollPane();
		sp3.setViewportView(list_2);
		sp3.setBounds(20, 418, 384, 116);
		contentPane.add(sp3);

		JButton btnDeletePlaylistSong = new JButton("Delete Playlist Song");
		btnDeletePlaylistSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list_2.getSelectedIndex() > -1) {
					deleteSongFromList();
				}
			}
		});
		btnDeletePlaylistSong.setBounds(414, 418, 158, 40);
		contentPane.add(btnDeletePlaylistSong);

		JButton btnAddMpSong = new JButton("Add MP4 Song");
		btnAddMpSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddMpSong.setBounds(487, 163, 124, 25);
		contentPane.add(btnAddMpSong);

		JButton btnChangeSong = new JButton("Change Song");
		btnChangeSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() > -1) {
					arrayofsongs.get(
							((IndividualMP3s) list.getSelectedValue()).getId())
							.setArtist(textField.getText());
					arrayofsongs.get(
							((IndividualMP3s) list.getSelectedValue()).getId())
							.setTitle(textField_1.getText());
				}
			}
		});
		btnChangeSong.setBounds(330, 198, 123, 23);
		contentPane.add(btnChangeSong);

		JButton btnFindSong = new JButton("Find Song");
		btnFindSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findSong();
			}
		});
		btnFindSong.setBounds(487, 198, 124, 21);
		contentPane.add(btnFindSong);

		JButton btnCreatePlaylist = new JButton("Create Playlist");
		btnCreatePlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Playlists pl = new Playlists(textField_3.getText());
				arrayoflists.add(pl.getId(), pl);
				listsModel.addElement(pl);
			}
		});
		btnCreatePlaylist.setBounds(481, 316, 130, 27);
		contentPane.add(btnCreatePlaylist);

		JButton btnAddSongTo = new JButton("Add Song to Playlist");
		btnAddSongTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() > -1
						&& list_1.getSelectedIndex() > -1) {
					addSongToList();
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"please select the song and playlist you wanna add to",
									"Warning", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnAddSongTo.setBounds(141, 163, 158, 23);
		contentPane.add(btnAddSongTo);
// fourth list
		JList list_3 = new JList();
		findsongModel = new DefaultListModel();
		list_3.setModel(findsongModel);
		list_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_3.addListSelectionListener(this);
		list_3.setBackground(Color.BLACK);
		sp4 = new JScrollPane();
		sp4.setViewportView(list_3);
		sp4.setBounds(311, 231, 310, 73);
		contentPane.add(sp4);
 
		populateJlist();
	}

	private void populateJlist() {
		for (int i = 0; i < arrayofsongs.size(); i++) {
			allsongsModel.addElement(arrayofsongs.get(i));
		}
		for (int i = 0; i < arrayoflists.size(); i++) {
			listsModel.addElement(arrayoflists.get(i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == list && list.getSelectedIndex() > -1) {
			displaySongs();
		} else if (e.getSource() == list_1 && list_1.getSelectedIndex() > -1) {
			displaySongsOfList();
			// System.out.println(list_1.getSelectedIndex());
		} else if (e.getSource() == list_2 && list_2.getSelectedIndex() > -1) {
			// System.out.println(list_2.getSelectedIndex());
		}

	}
	//method to get input from artist text field
	private String getArtistInput(){
		//get trimmed input into local variable
		String s = textField.getText().trim();
		
		//check if empty
		if (s.length() == 0){
			//set to unknown
			s = "unknown";
		}
		
		//return the input
		return s;
	}


	//method to get input from title text field
	private String getTitleInput(){
		//get trimmed input into local variable
		String s = textField_1.getText().trim();
		//return the input
		return s;
	}

	public void displaySongs() {
		textField
				.setText(arrayofsongs.get(
						((IndividualMP3s) list.getSelectedValue()).getId())
						.getArtist());
		textField_1.setText(arrayofsongs.get(
				((IndividualMP3s) list.getSelectedValue()).getId()).getTitle());
	}

	public void displaySongsOfList() {
		mp3sModel.clear();
		for (int i = 0; i < arrayoflists
				.get(((Playlists) list_1.getSelectedValue()).getId()).getList()
				.size(); i++) {
			mp3sModel.addElement(arrayofsongs.get(arrayoflists
					.get(((Playlists) list_1.getSelectedValue()).getId())
					.getList().get(i)));
		}
	}

	public void findSong() {
		//create a list to return
		ArrayList<Integer> foundList = new ArrayList<Integer>();
		
		//use for loop to search entire arraylist
		for (int i=0; i<arrayofsongs.size(); i++ ){
			
			//check if current element has id
			if ( arrayofsongs.get(i).getArtist().compareToIgnoreCase(textField.getText()) == 0  || arrayofsongs.get(i).getTitle().compareToIgnoreCase(textField_1.getText()) == 0 ){
				//found match, so index to list
				foundList.add(i);
				findsongModel.addElement(arrayofsongs.get(i));
			}
		}
		
	}

	public void addSongToList() {
		arrayoflists.get(((Playlists) list_1.getSelectedValue()).getId())
				.getList()
				.add(((IndividualMP3s) list.getSelectedValue()).getId());
		displaySongsOfList();
	}

	public void deleteSongFromList() {
		if (list_2.getSelectedIndex() > -1) {
			int index = list_2.getSelectedIndex();			
			arrayoflists.get(((Playlists) list_1.getSelectedValue()).getId())
					.getList().remove(index);
			mp3sModel.remove(index);
		}
	}
}
