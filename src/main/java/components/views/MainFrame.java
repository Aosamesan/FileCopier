package components.views;

import components.controllers.CopyController;
import components.models.PathInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

@Component
public class MainFrame extends JFrame implements Showable {
	@Resource(name = "mainHeight")
	int height;

	@Resource(name = "mainWidth")
	int width;

	@Resource(name = "mainTitle")
	String title;

	@Autowired
	CopyController controller;

	public MainFrame() {
		super();
		initializeComponents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void showFrame() {
		setSize(width, height);
		setTitle(title);
		setVisible(true);
	}

	private void initializeComponents() {
		// assign
		JPanel mainPane = new JPanel();
		JPanel inputPane = new JPanel();
		JTextField preField = new JTextField();
		JTextField regexField = new JTextField();
		JTextField postField = new JTextField();
		JTextField postTargetField = new JTextField();
		JTextField fileNameField = new JTextField();
		JLabel preLabel = new JLabel("Parent Prefix");
		JLabel regexLabel = new JLabel("Regex");
		JLabel postLabel = new JLabel("Parent Postfix");
		JLabel postTargetLabel = new JLabel("Target Postfix");
		JLabel fileLabel = new JLabel("Filename");

		JButton copyButton = new JButton("Copy");
		LayoutManager entireLayout = new BorderLayout(2, 2);
		LayoutManager inputLayout = new GridLayout(5, 2);

		// process
		/// input pane
		inputPane.setLayout(inputLayout);
		inputPane.add(preLabel);
		inputPane.add(preField);
		inputPane.add(regexLabel);
		inputPane.add(regexField);
		inputPane.add(postLabel);
		inputPane.add(postField);
		inputPane.add(postTargetLabel);
		inputPane.add(postTargetField);
		inputPane.add(fileLabel);
		inputPane.add(fileNameField);

		mainPane.setLayout(entireLayout);
		mainPane.add(inputPane, BorderLayout.CENTER);

		copyButton.addActionListener((ActionEvent action) -> {
			try {
				PathInfo info = new PathInfo(preField.getText(), regexField.getText(), postField.getText(), fileNameField.getText());
				controller.execute(info, postTargetField.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
			}
		});

		mainPane.add(copyButton, BorderLayout.SOUTH);
		setContentPane(mainPane);
	}
}
