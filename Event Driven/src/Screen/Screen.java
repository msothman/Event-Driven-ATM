package Screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Screen 
{

    protected JFrame frame;

    protected JFrame createFrame(String title, int width, int height)
	{
		JFrame frame = new JFrame(title);
		
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		return frame;
	}

	protected JLabel createLabel(String text, int alignment, Font font, Color foreground)
	{
		JLabel label = new JLabel(text, alignment);
		
		label.setFont(font);
		label.setForeground(foreground);
		
		return label;
	}

	protected JLabel createLabel(String text, Color foreground)
	{
		JLabel label = new JLabel(text);
		label.setForeground(foreground);
		return label;
	}

	protected JLabel createLabel(JPanel parent, String text, int alignment, Font font, Color foreground)
	{
		JLabel label = new JLabel(text, alignment);
		
		label.setFont(font);
		label.setForeground(foreground);
		parent.add(label);
		
		return label;
	}

	protected JLabel createLabel(JPanel parent, String text, Color foreground)
	{
		JLabel label = new JLabel(text);
		
		label.setForeground(foreground);
		parent.add(label);
		
		return label;
	}

	protected JTextField createTextField(JPanel parent)
	{
		JTextField textField = new JTextField();
		parent.add(textField);
		return textField;
	}

	protected JPasswordField createPasswordField(JPanel parent)
	{
		JPasswordField passwordField = new JPasswordField();
		parent.add(passwordField);
		return passwordField;
	}

	protected JPanel createPanel(LayoutManager layout, Color color)
	{
		JPanel panel = new JPanel(layout);
		panel.setBackground(color);
		return panel;
	}


	protected JPanel createPanel(LayoutManager layout, Border border, Color color)
	{
		JPanel panel = new JPanel(layout);
		
		panel.setBackground(color);
		panel.setBorder(border);
		
		return panel;
	}

	protected JPanel createPanel(JPanel parent, LayoutManager layout, Color color)
	{
		JPanel panel = new JPanel(layout);
		
		panel.setBackground(color);
		parent.add(panel);
		
		return panel;
	}

	protected JPanel createPanel(JPanel parent, LayoutManager layout, Border border, Color color)
	{
		JPanel panel = new JPanel(layout);
		
		panel.setBackground(color);
		panel.setBorder(border);
		parent.add(panel);
		
		return panel;
	}

	protected JButton createButton(String text, Color background, boolean opacity, boolean borderPainted, Color foreground, ActionListener actionListener)
	{
		JButton button = new JButton(text);
		
		button.setBackground(background);
		button.setOpaque(opacity);
		button.setBorderPainted(borderPainted);
		button.setForeground(foreground);
		button.addActionListener(actionListener);
		
		return button;
	}

	protected JButton createButton(JPanel parent, String text, Color background, boolean opacity, boolean borderPainted, Color foreground, ActionListener actionListener)
	{
		JButton button = new JButton(text);
		
		button.setBackground(background);
		button.setOpaque(opacity);
		button.setBorderPainted(borderPainted);
		button.setForeground(foreground);
		button.addActionListener(actionListener);
		parent.add(button);
		
		return button;
	}

	protected JComboBox<String> createComboBox(JPanel parent, String[] items, ActionListener actionListener)
	{
		JComboBox<String> comboBox = new JComboBox<>(items);
		comboBox.addActionListener(actionListener);
		parent.add(comboBox);
		return comboBox;

	}

    protected void initialize()
	{}

	public Screen()
	{}

}