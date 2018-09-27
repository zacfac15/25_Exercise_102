package beans;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class FileListRenderer implements ListCellRenderer<Datei> 
{

  @Override
  public Component getListCellRendererComponent(JList<? extends Datei> list, Datei value, int index, boolean isSelected, boolean cellHasFocus)
  {
    JLabel lb = new JLabel(value.toString());

    lb.setOpaque(true);
    //lb.setFont(new Font("Courier New",Font.ITALIC,24));
    //lb.setHorizontalAlignment(JLabel.CENTER);

    if (value.isDirectory() || value.getDisplayName().equals("..."))         
    {
      lb.setBackground(Color.DARK_GRAY);
      lb.setForeground(Color.red);
    }
    else
    {
      lb.setBackground(Color.GRAY);
      lb.setForeground(Color.blue);
    }

    return lb;
  }

}