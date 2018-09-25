package GUI;

import beans.Datei;
import beans.DateiModell;
import beans.FileListRenderer;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Lukas
 */
public class GUI extends javax.swing.JFrame
{

  /**
   * Creates new form GUI
   */
  private final DateiModell model = new DateiModell();
  private static String PATH_NAME = System.getProperty("user.dir");

  public GUI()
  {
    initComponents();
    this.setSize(500, 250);
    this.setTitle(PATH_NAME);
    list.setModel(model);
    //list.setCellRenderer(new FileListRenderer());      
    model.getFileList(new Datei(PATH_NAME));
    model.sort();
    list.setCellRenderer(new FileListRenderer());

  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    jMenu1 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jScrollPane1 = new javax.swing.JScrollPane();
    list = new javax.swing.JList<>();

    jMenu1.setText("jMenu1");

    jMenuItem1.setText("delete");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        onDel(evt);
      }
    });
    jMenu1.add(jMenuItem1);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new java.awt.GridLayout(1, 0));

    list.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
    list.setComponentPopupMenu(jMenu1.getPopupMenu());
    list.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        onChangeDir(evt);
      }
    });
    jScrollPane1.setViewportView(list);

    getContentPane().add(jScrollPane1);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void onChangeDir(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onChangeDir
      if (evt.getClickCount() == 2)
      {
        //Doppelklick
        if (model.getDatei(list.getSelectedIndex()).getDisplayName().equals("..."))
        {

          model.getFileList(new Datei(model.getReturnPathName()));
          model.sort();
          this.setTitle(model.getReturnPathName());
        }
        else
        {

          try
          {
            model.getFileList(model.getDatei(list.getSelectedIndex()));
            model.sort();
            this.setTitle(model.getDatei(0).getReturnPathName());

          }
          catch (NullPointerException e)
          {
            System.out.println("Nix funktionieren");
          }
        }

      }
    }//GEN-LAST:event_onChangeDir

  private void onDel(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onDel
  {//GEN-HEADEREND:event_onDel
    Dialog di = new Dialog(this,true);
    if(di.getOk() && di.isPasswordOk())
    {
      list.getSelectedValue().delete();
    }
      
  }//GEN-LAST:event_onDel

  public static void main(String args[])
  {

    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new GUI().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JList<Datei> list;
  // End of variables declaration//GEN-END:variables
}
