package gitter.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Joshua Jensch
 * @author Darius Musiolik
 */
public class sysmenu extends javax.swing.JFrame
{

    private static final long serialVersionUID = 1L;
    public static String user;
    public static String repo;
    public static String email;
    public static String term;

    public sysmenu()
    {
        initComponents();
        envscan();
        envload();
        this.setTitle("Gitter-GUI -- " + motd());
    }

    public static void envload()
    {
        user = readfile("user");
        repo = readfile("repo");
        email = readfile("email");
        term = readfile("term");
        jList1.setListData(parse("repo"));
    }

    public static String readfile(String file)
    {

        String reader = null;

        try
        {
            FileReader fr = new FileReader("gitdata/" + file + ".save");
            BufferedReader br = new BufferedReader(fr);
            reader = br.readLine();
            br.close();
        }
        catch (Exception e)
        {}
        return reader;
    }

    public static void envscan()
    {

        File f = new File("gitdata");
        if (f.exists() && f.isDirectory())
        {
            System.out.println("gitdata found");
        }
        else
        {
            user = JOptionPane.showInputDialog("Please enter your username: ");
            f.mkdir();
            savetodisc(user, "user");
            repo = JOptionPane.showInputDialog("Please enter your reponame: ");
            savetodisc(repo, "repo");
            email = JOptionPane.showInputDialog("Please enter your git e-mail: ");
            savetodisc(email, "email");
            //Default terminal emulator
            savetodisc("terminator -x", "term");
        }
    }

    public static void savetodisc(String input, String savename)
    {
        try
        {

            File file = new File("gitdata/" + savename + ".save");

            iffile(file);

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(input);
            bw.close();

            System.out.println("Done -> " + savename + ".save\t=> Output from FileWriter\n");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static boolean iffile(File f)
    {
        boolean statement = false;
        try
        {

            if (f.exists())
            {
                statement = false;
            }
            else
            {
                f.createNewFile();
                statement = true;
            }

        }
        catch (Exception e)
        {}
        return statement;
    }

    public static String motd()
    {
        String feedback = null;
        File mottodatei = new File("gitdata/motd.save");
        if (!mottodatei.exists())
        {
            String motdz = "the one and only!\nRun 4 it!\nCan i haz a yolo version ?\nMade in Germany\n" + "Itz all 'bout the Swag\nWubba, lubba, dub, dub!\n" + "Das ist gut!\nBeem 'em up!\nOn mah way 2 f@ck Windowsusers!\n" + "Write your own MOTD configfile!\nBill Who ?!\nYuo hid'n something ?\n" + "Actually itz called GNU plus Linux\nI've never said we've 2 blame Windowsusers ... but we have to!\n" + "Gitter is love, Gitter is life\nWHO U GONNA CALL ?\nI hate Human!\n>>>Now in 3D<<<\n" + "God is a lie, the Government is weak and Windowsusers are suckers!\nFreedom Hackers!\n" + "Oh dayum, i wish i could read ( ._.)\nFork me on GitHub!\n\"Write more conf files!\" ~Richard Stallman" + "\nInstall Gentoo\nRandom MOTD Messige!\nJoakes 'bout german sausage are the Wurst\n";
            savetodisc(motdz, "motd");
            System.out.println("Writeing File");
        }

        String[] recive = parse("motd");
        feedback = rdom(recive);

        return feedback;
    }

    public static String rdom(String[] rdomer)
    {
        Random zufall = new Random();
        int zufallszahl = zufall.nextInt(rdomer.length - 1) + 1;
        return rdomer[zufallszahl];
    }

    public static String[] parse(String file)
    {

        int counter = 0;
        String[] feedback = null;

        try
        {

            FileReader fr = new FileReader("gitdata/" + file + ".save");
            String collector;
            BufferedReader br = new BufferedReader(fr);
            while (br.ready())
            {
                collector = br.readLine();
                if (collector != null)
                {
                    counter++;
                }
                else
                {
                    break;
                }
            }
            br.close();

            String[] parser = new String[counter];

            FileReader fr1 = new FileReader("gitdata/" + file + ".save");
            BufferedReader br1 = new BufferedReader(fr1);
            for (int i = 0; i < parser.length; i++)
            {
                parser[i] = br1.readLine();
                System.out.println(parser[i]);
            }
            br1.close();
            feedback = parser;

        }
        catch (Exception e)
        {}

        return feedback;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("gitter - the one and only");
        setLocation(new java.awt.Point(300, 200));

        jList1.setModel(new javax.swing.AbstractListModel<String>()
        {
            private static final long serialVersionUID = 1L;
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

            public int getSize()
            {
                return strings.length;
            }

            public String getElementAt(int i)
            {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("clone");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("delete local files");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("push master");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("delete online files");
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("add repo");
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(49, 49, 49).addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton3).addComponent(jButton5).addComponent(jButton1).addComponent(jButton2).addComponent(jButton4)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton1ActionPerformed
     // clone git repo

        repo = jList1.getSelectedValue();

        if (repo == null)
        {
            JOptionPane.showMessageDialog(null, "U tryed hard, but there was no Repo...", "Alert!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String input = term + " git clone " + "https://www.github.com/" + user + "/" + repo;
        shell(input);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton5ActionPerformed
     // add git repo
        String[] oldrepo = parse("repo");
        String input = JOptionPane.showInputDialog("Please enter a new Repo: ");
        for (int i = 0; i < oldrepo.length; i++)
        {
            input = input + "\n" + oldrepo[i];
        }
        savetodisc(input, "repo");
        envload();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton2ActionPerformed
     // delete local files

        String input = term + " rm -rf " + repo;
        shell(input);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton4ActionPerformed
     // Delete all Online Files 

        String input = term + " git -C " + repo + " -rm * ";
        shell(input);
        System.out.println("Ready..");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton3ActionPerformed
     // Push
        shell(term + " git config --global user.name \"" + user + "\"");
        shell(term + " git config --global user.email \"" + user + "\""); 
        shell(term + " git -C " + repo + " remote -v");
        shell(term + " git -C " + repo + " add *");
	shell(term + " git -C " + repo + " commit -m '" + JOptionPane.showInputDialog("Commit messige: ") + "'");
        shell(term + " git -C " + repo + " push origin master");
        System.out.println("Ready..");
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void shell(String eingabe)
    {
        try
        {
            Process p;
            p = Runtime.getRuntime().exec(eingabe);
            p.waitFor();
            p.destroy();
            // p.destroy();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(sysmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(sysmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(sysmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(sysmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new sysmenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    public static javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
