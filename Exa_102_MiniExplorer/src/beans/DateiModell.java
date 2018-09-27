package beans;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

public class DateiModell extends AbstractListModel
{
  private LinkedList<Datei> list = new LinkedList<>();
  private Datei punkte;

  @Override
  public int getSize()
  {
    return list.size();
  }

  @Override
  public Object getElementAt(int index)
  {
    return list.get(index);
  }

  public void addDatei(Datei datei)
  {
    if (!list.contains(datei))
    {
      list.add(datei);
    }
    else
    {
      JOptionPane.showMessageDialog(null, "The list already contains the Object!");
    }
  }
  
  public void getFileList(Datei datei) throws NullPointerException
  {
    File[] files = datei.listFiles();
    list.clear();
    list.add(new Datei(datei.getReturnPathName() + File.separator + "aaa", "..."));

    for (File file : files)
    {
      if (file.exists())
      {
        list.add(new Datei(file.getAbsolutePath()));
      }
    }
    this.fireContentsChanged(this, 0, list.size() - 1);

  }
  
   public Datei getDatei(int index)
  {
    return list.get(index);
  }

  public void sort()
  {
    Comparator comp;
    comp = new Sort();
    Collections.sort(list, comp);
    this.fireContentsChanged(this, 0, list.size() - 1);
  }

  public String getReturnPathName()
  {
    String absolutePath = list.get(0).getAbsolutePath();
    String replace = absolutePath.substring(absolutePath.lastIndexOf(File.separator) + 1, absolutePath.length());
    return absolutePath.replace(replace, "");
  }
}
