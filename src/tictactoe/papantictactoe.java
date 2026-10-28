/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Lenovo
 */
public class papantictactoe extends JFrame implements ActionListener {
    char papangame [][]  = new char [][] {{ '1','2','3'},
                                          { '4','5','6'},
                                          { '7','8','9'}};
    JLabel label1 = new JLabel("Andrean");
    JButton button1 = new JButton(" ");
    JButton button2 = new JButton(" ");
    JButton button3 = new JButton(" ");
    JButton button4 = new JButton(" ");
    JButton button5 = new JButton(" ");
    JButton button6 = new JButton(" ");
    JButton button7 = new JButton(" ");
    JButton button8 = new JButton(" ");
    JButton button9 = new JButton(" ");
    JButton buttonmulai = new JButton("Mulai");
    JButton buttonreset = new JButton("Reset");
    JButton buttonkeluar = new JButton("Keluar");
    
     
  
    char m_computer,m_orang;
    char m_linkaran,m_silang;
    
    boolean m_sedang_main = false;
    aitictactoe m_ai = new aitictactoe();
    
     public papantictactoe(){
        super("Main Tic tac toe - Andrean");
        initpapan ();
    }
     
    void initpapan(){
        JPanel panelgame = new JPanel();
        JPanel panelbutton = new JPanel ();
        
        panelgame.setLayout(new GridLayout(3,3,1,1));
        panelgame.add(button1);
         button1.setBackground(Color.GREEN);
        button1.addActionListener(this);
        panelgame.add(button2);
        button2.addActionListener(this);
        button2.setBackground(Color.GREEN);
        panelgame.add(button3);
        button3.addActionListener(this);
        button3.setBackground(Color.GREEN);
        panelgame.add(button4);
        button4.addActionListener(this);
        button4.setBackground(Color.GREEN);
        panelgame.add(button5);
        button5.addActionListener(this);
        button5.setBackground(Color.GREEN);
        panelgame.add(button6);
        button6.addActionListener(this);
        button6.setBackground(Color.GREEN);
        panelgame.add(button7);
        button7.addActionListener(this);
        button7.setBackground(Color.GREEN);
        panelgame.add(button8);
        button8.addActionListener(this);
        button8.setBackground(Color.GREEN);
        panelgame.add(button9);
        button9.addActionListener(this);
        button9.setBackground(Color.GREEN);
        
        Font font = new Font("Times New Roman", Font.BOLD ,32);
        button1.setFont(font);
        button2.setFont(font);
        button3.setFont(font);
        button4.setFont(font);
        button5.setFont(font);
        button6.setFont(font);
        button7.setFont(font);
        button8.setFont(font);
        button9.setFont(font);
              
                
                panelbutton.setLayout(new FlowLayout());
                
                panelbutton.setBorder(BorderFactory.createEtchedBorder());
                
                panelbutton.add(buttonmulai);
                buttonmulai.addActionListener(this);
                panelbutton.add(buttonkeluar);
                buttonkeluar.addActionListener(this);
                font = new Font("Times New Roman", Font.BOLD, 24);
                buttonmulai.setFont(font);
                buttonkeluar.setFont(font);
                
                getContentPane().setLayout(new BorderLayout());
                getContentPane().add(panelgame,BorderLayout.CENTER);
                getContentPane().add(panelbutton,BorderLayout.SOUTH);
                
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(400, 450);
                setLocationRelativeTo(null);
                
                setVisible(true);
                   
    } 
    
    protected boolean X_menang () {
        if ((papangame [0] [0] 
           == papangame [1][1] && papangame[0][0] == 
           papangame[2][2] && papangame [0][0] == 'X')
           ||
                    
                   (papangame [0][2] == papangame [1][1] && papangame[0][2] == papangame [2][0] && papangame [0][2] == 'X')){
      return true;  
    }
      for (int i  = 0; i<3; ++i){
          if(((papangame[i][0] == papangame[i][1] && papangame[i][0] == papangame[i][2] && papangame[i][0] == 'X' )
                  ||
                  (papangame[0][i] == papangame[1][i] && papangame[0][i] == 'X'))){
              return true;
          }
      }
      return false;
    }
     protected boolean O_menang(){
        if ((papangame [0][0] == papangame[1][1] && papangame[0][0] == papangame[2][2] && papangame[0][0]== 'O')
                ||
                (papangame[0][2] == papangame[1][1] && papangame[0][2] == papangame[2][0] && papangame[0][2] == 'O')){
            return true;
        }
        for (int i = 0; i < 3; ++i){
            if (((papangame[i][0] == papangame[i][1] && papangame[i][0] == papangame[i][2] && papangame[i][0] == 'O')
                    ||
                    (papangame[0][i]== papangame [1][i] && papangame[0][i]== papangame[2][i]&& papangame[0][i]== 'O'))){
                return true;
            }
            
        }
        return false;
    }
    
    protected boolean papanpenuh(){
        for(int i=0; i<3; i++){
            for(int j = 0; j <3; j++){
                if((papangame[i][j] != 'X') && (papangame[i][j] != 'O'))
                    return false;
            }
        }
        return true;
    }
      protected boolean gameover(){
        return X_menang() || O_menang() || papanpenuh();
    }
       protected char[] ambilsemuapetak(){
        int jumlah = 0;
        for(int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if((papangame[i][j] != 'X') && (papangame[i][j] != 'O'))
                    jumlah++;
            }
        }
        char[] petak_kosong = new char[jumlah];
        int index_petak =0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if ((papangame[i][j] != 'X') && (papangame[i][j]!='O'))
                    petak_kosong[index_petak++]= papangame[i][j];
            }
        }
        return petak_kosong;
        
    }
        protected boolean langkahvalid(char langkah){
        char[] petak_kosong = ambilsemuapetak();
        for(int i=0; i< petak_kosong.length; i++){
            if(petak_kosong[i]== langkah)
                return true;
    }
        return false;
    }
        
        protected void tandaipapan(char petak,char tanda){
        switch(petak){
            case '1': papangame[0][0] = tanda;
            break;
            case '2': papangame[0][1] = tanda;
            break;
            case '3': papangame[0][2] = tanda;
            break;
            case '4': papangame[1][0] = tanda;
            break;
            case '5': papangame[1][1] = tanda;
            break;
            case '6': papangame[1][2] = tanda;
            break;
            case '7': papangame[2][0] = tanda;
            break;
            case '8': papangame[2][1] = tanda;
            break;
            case '9': papangame[2][2] = tanda;
            break;
            
            
        }
    }
       protected void resetpapan(char petak){
        switch (petak){
            case'1' : papangame[0][0] = '1';
            break;
            case'2' : papangame[0][1] = '2';
            break;
            case'3' : papangame[0][2] = '3';
            break;
            case'4' : papangame[1][0] = '4';
            break;
            case'5' : papangame[1][1] = '5';
            break;
            case'6' : papangame[1][2] = '6';
            break;
            case'7' : papangame[2][0] = '7';
            break;
            case'8' : papangame[2][1] = '8';
            break;
            case'9' : papangame[2][2] = '9';
            break;
            
        }
    }
       
       protected void susunulangpapan(){
          papangame = new char [][]{{'1','2','3'},
                                    {'4','5','6'},
                                    {'7','8','9'}};
          susunulangpapanGUI();
          enableallfieldbuttons();
          }
       
          protected void tandaipapanGUI (char langkah,char symbol){
          switch (langkah){
              case '1' :
                  button1.setText("");
                  if(symbol == 'X')
                      button1.setText("X");
                  else
                      button1.setText("O");
                  button1.setEnabled(false);
                  break;
                  case '2' :
                  button2.setText("");
                  if(symbol == 'X')
                      button2.setText("X");
                  else
                      button2.setText("O");
                  button2.setEnabled(false);
                  break;
                  case '3' :
                  button3.setText("");
                  if(symbol == 'X')
                      button3.setText("X");
                  else
                      button3.setText("O");
                  button3.setEnabled(false);
                  break;
                  case '4' :
                  button4.setText("");
                  if(symbol == 'X')
                      button4.setText("X");
                  else
                      button4.setText("O");
                  button4.setEnabled(false);
                  break;
                  case '5' :
                  button5.setText("");
                  if(symbol == 'X')
                      button5.setText("X");
                  else
                      button5.setText("O");
                  button5.setEnabled(false);
                  break;
                  case '6' :
                  button6.setText("");
                  if(symbol == 'X')
                      button6.setText("X");
                  else
                      button6.setText("O");
                  button6.setEnabled(false);
                  break;
                  case '7' :
                  button7.setText("");
                  if(symbol == 'X')
                      button7.setText("X");
                  else
                      button7.setText("O");
                  button7.setEnabled(false);
                  break;
                  case '8' :
                  button8.setText("");
                  if(symbol == 'X')
                      button8.setText("X");
                  else
                      button8.setText("O");
                  button8.setEnabled(false);
                  break;
                  case '9' :
                  button9.setText("");
                  if(symbol == 'X')
                      button9.setText("X");
                  else
                      button9.setText("O");
                  button9.setEnabled(false);
                  
          }
          
      }  
     
       protected void resetpapanGUI(char petak){
          switch (petak){
              case '1' :
                  button1.setText(" ");
                  button1.setEnabled(true);
                  break;
                  case '2' :
                  button2.setText(" ");
                  button2.setEnabled(true);
                  break;
                  case '3' :
                  button3.setText(" ");
                  button3.setEnabled(true);
                  break;
                  case '4' :
                  button4.setText(" ");
                  button4.setEnabled(true);
                  break;
                  case '5' :
                  button5.setText(" ");
                  button5.setEnabled(true);
                  break;
                  case '6' :
                  button6.setText(" ");
                  button6.setEnabled(true);
                  break;
                  case '7' :
                  button7.setText(" ");
                  button7.setEnabled(true);
                  break;
                  case '8' :
                  button8.setText(" ");
                  button8.setEnabled(true);
                  break;
                  case '9' :
                  button9.setText(" ");
                  button9.setEnabled(true);
                  
          }
      }
       
           protected void enableallfieldbuttons(){
          button1.setEnabled(true);
          button1.setBackground(Color.RED);
          button2.setEnabled(true);
          button2.setBackground(Color.RED);
          button3.setEnabled(true);
          button3.setBackground(Color.RED);
          button4.setEnabled(true);
          button4.setBackground(Color.RED);
          button5.setEnabled(true);
          button5.setBackground(Color.RED);
          button6.setEnabled(true);
          button6.setBackground(Color.RED);
          button7.setEnabled(true);
          button7.setBackground(Color.RED);
          button8.setEnabled(true);
          button8.setBackground(Color.RED);
          button9.setEnabled(true);
          button9.setBackground(Color.RED);
                 
          
      }
      protected void susunulangpapanGUI(){
          button1.setText(" ");
          button2.setText(" ");
          button3.setText(" ");
          button4.setText(" ");
          button5.setText(" ");
          button6.setText(" ");
          button7.setText(" ");
          button8.setText(" ");
          button9.setText(" ");
                   
          
      }
      protected int ambillangkahcomputer(){
          Random random = new Random();
          int langkah = random.nextInt(9);
          langkah++;
          return langkah;
      }
      
       @Override
      public void actionPerformed(ActionEvent e){
          if (e.getSource() == buttonkeluar){
              Object[] options ={"IYA", "TIDAK"};
              int n = JOptionPane.showOptionDialog(this,"apakah anda ingin keluar dari permainan tic tac toe ini ?","keluar permainan",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
              if (n == JOptionPane.YES_OPTION){
                  dispose();
              }
              
          }else if (e.getSource() == buttonmulai){
              if(m_sedang_main){
                  Object[] options = {"Ya","Tidak"};
                  int n = JOptionPane.showOptionDialog(this,"Anda sedang dalam permainan ini.apakah anda ingin memulai lagi?","mulai lagi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
                  if(n == JOptionPane.NO_OPTION)
                      return;
              }
              susunulangpapan();
              
             Object[] possibilities = {"komputer memulai dahulu","Saya yang memulai"};
             String s = (String)JOptionPane.showInputDialog(this,
                     "Siapa yang akan memulai terlebih dahulu?","langkah pertama",JOptionPane.PLAIN_MESSAGE,null,possibilities,possibilities[0]);
               if (s.equals(possibilities[0])){
                   m_computer = 'X';
                   m_orang = 'O';
                   int langkah = ambillangkahcomputer();
                   
                   tandaipapan(String.valueOf(langkah).charAt(0), m_computer);
                   
                   tandaipapanGUI(String.valueOf(langkah).charAt(0), m_computer);
                   
               }else
                   if(s.equals(possibilities[1])){
                       m_computer ='O';
                       m_orang = 'X';
                       
                   }
               m_sedang_main = true;
               
          }else if (m_sedang_main){
              if(e.getSource() == button1){
                  tandaipapan('1',m_orang);
                  tandaipapanGUI('1',m_orang);
              }else if (e.getSource()== button2){
                  tandaipapan('2',m_orang);
                  tandaipapanGUI('2',m_orang);
              } else if (e.getSource() == button3){
                   tandaipapan('3',m_orang);
                  tandaipapanGUI('3',m_orang);
              }else if (e.getSource()== button4){
                   tandaipapan('4',m_orang);
                  tandaipapanGUI('4',m_orang);
              }else if (e.getSource()== button5){
                   tandaipapan('5',m_orang);
                  tandaipapanGUI('5',m_orang);
              }else if (e.getSource()== button6){
                   tandaipapan('6',m_orang);
                  tandaipapanGUI('6',m_orang);
              }else if (e.getSource()== button7){
                   tandaipapan('7',m_orang);
                  tandaipapanGUI('7',m_orang);
              }else if (e.getSource() == button8){
                   tandaipapan('8',m_orang);
                  tandaipapanGUI('8',m_orang);
              }else if (e.getSource()== button9){
                   tandaipapan('9',m_orang);
                  tandaipapanGUI('9',m_orang);
              }
              if(!gameover()){
                  m_ai.hitungminimax(this, 0, m_computer, m_computer);
                  char langkah_computer = m_ai.Langkahcomputer ();
                  tandaipapan(langkah_computer,m_computer);
                  tandaipapanGUI(langkah_computer,m_computer);
              }
              if(gameover()){
                  m_sedang_main = false;
                  enableallfieldbuttons();
                  if((m_computer == 'X' && X_menang())|| (m_computer == 'O'&& O_menang())){
                      JOptionPane.showMessageDialog(this,"Anda kalah","anda belum berhasil menang",JOptionPane.INFORMATION_MESSAGE,null);
                  }else if ((m_orang == 'X'&& X_menang())|| (m_orang == 'O' && O_menang())){
                      JOptionPane.showMessageDialog(this,"anda berhasil memenangkan game ini","selamat anda menang",JOptionPane.INFORMATION_MESSAGE,null);
                  }else
                      JOptionPane.showMessageDialog(this,"permainan seri !","draw",JOptionPane.INFORMATION_MESSAGE,null);
              }
          }
      }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new papantictactoe();
    }
    
}
