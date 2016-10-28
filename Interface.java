import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class Interface extends JFrame  {

	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	   static final String DATABASE_URL = "jdbc:mysql://localhost/basedadosespaco"; 
	   static final String DEFAULT_QUERY = "Select * FROM  planeta";
	   
	   private ResultSetTableModel tableModel, tableModel2;
	   private UpdateQuery modoinserir;
	   
	   private JTabbedPane tabbedPane;
	   
	   private JPanel separador_planetas,separador_sistemasplanetarios,separador_constelacoes,separador_telescopios,separador_fotos;
	   private Box boxjuste;
	   private Box box1,box2,box3,box4,box5,box6,box7,box8,box9,box10;
	   private Box box11,box12,box13,box14,box15,box16,box17,box18,box19,box20;
	   private Box box21,box22,box23,box24_1,box24_2,box24_3,box24_4,box24_5,box25_1,box25_2,box25_3,box25_4,box25_5,box25_6,box26_1,box26_2,box26_3;
	   private Box boxverticalplanetas, boxverticalsistemasplanetarios, boxverticalconstelacoes, boxverticaltelescopios,boxverticalfotos1, boxverticalfotos2, boxverticalfotos3 ;
	   private Box b1,b2,b3,b4,b5,b6,b7,b8,boxverticaldeletepla;
	   private Box bb1,bb2,bb3,bb4,bb5,bb6,bb7,bb8,bb9,bb10,bb11,boxverticaldeletespla;
	   private Box bbb1,bbb2,bbb3,bbb4,bbb5,bbb6,bbb7,bbb8,bbb9,bbb10,bbb11,boxverticaldeleteconste;
	   private Box bbbb1,bbbb2,bbbb3,bbbb4,bbbb5,bbbb6,bbbb7,bbbb8,bbbb9,bbbb10,bbbb11,boxverticaldeletetel;
	   private JComboBox comboconstelacoes, formato, listafotos;
	   
	   private JButton butao1,butao2,butao3,butao4,butao5,butao6,butao7,butao8,butao9,butao10,butao11,butao12,butao13,butao14,butao14_1,butao15,butao16,butao17;
	   private JButton butao18,butao19,butao20,butao21,butao22,butao23,butao24,butao25,butao26,butao27;
	   
	   private JRadioButton intersect1,intersect2,intersect3,intersect4;
	  
	   public JRadioButton butao14a, butao14b, coisito, coisito2;
	 
	   public ButtonGroup groupintersect, groupintersectsistemas, grupobutoes_14;
	   
	   private JLabel labelplaneta1, labelplaneta2, labelplaneta3, labelplaneta4, labelsistemaplanetario1, labelsistemaplanetario2, labelsistemaplanetario3,labelsistemaplanetario4 ;
	   private JLabel labelconstelacoes1,labelconstelacoes2, labelconstelacoes3,labeltelescopios1, labeltelescopios2_1, labeltelescopios2_2,labeltelescopios3 ;
	   private JLabel labelfotos1, labelfotos2, labelfotos3, labeldeletefoto;
	   
	   private JLabel labelinsernumerofoto, labelinsertamanhofoto1,labelinsertamanhofoto2,labelinserformatofoto2,labelinsertdatafoto,labelinsertcoresfoto,labelinserttelescopiofoto;
       private JTextField textodeletefoto,textoinsernomefoto,textoinserttamanhofoto1,textoinsertformatofoto,textoinserttamanhofoto2,textocoresfoto,textoinsertdatafoto, textoinserttelescopiofoto;
    
       private JTextField tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8, tt9,tt10,tt11,tt12, tt13;
      
       private JTextField ttt1, ttt2,ttt3,ttt4, ttt5, ttt6, ttt7, ttt8, ttt9;
       private JTextField tttt1,tttt2,tttt3,tttt4,tttt5,tttt6,tttt7;
       
	   
	   private JTextField textoplaneta1, textoplaneta3,textosistemaplanetario1,textosistemaplanetario2, textoconstelacoes1,textotelescopios1,textotelescopios2_1, textotelescopios2_2, textotelescopios3 ;
	   private JTextField textofotos1, textofotos2, deleteplaneta, deletesistemaplanetario, deleteconstelacoes,deletetelescopios,deletefotos;
	   private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	   private JSlider sliderdistancia;
	   
	   public Interface(String USERNAME, String PASSWORD) 
	   {   
		   super( "GBD Space 1.0" );
		   try 
		   {
			   
			   try
			   {
				   String workingdirectory = System.getProperty("user.dir");
				  
			   setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(workingdirectory+ "/espaco.PNG")))));
			   }
			   catch(IOException e)
			   {
				   System.out.print("Erro imagem de fundo");	
			   }
			   setSize(720,470);
			   setVisible(true);
			  
			   try 
			   {
				   Thread.sleep(1500);                 //wait
			   } 
			   catch(InterruptedException ex) {
				   Thread.currentThread().interrupt();
			   }
			   	
		       setLayout(new FlowLayout());
			   JLabel teste=new JLabel("Base Dados Espacial");
			   
			   
			   add(teste).setForeground(Color.white);
			   setLayout(new FlowLayout());
			   tableModel = new ResultSetTableModel( JDBC_DRIVER, DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY );
			   tableModel2 = new ResultSetTableModel( JDBC_DRIVER, DATABASE_URL, USERNAME, PASSWORD, "select * from Telescopio" );
			   
			   modoinserir = new UpdateQuery( JDBC_DRIVER, DATABASE_URL, USERNAME, PASSWORD);
			   
			   tabbedPane=new JTabbedPane();

			   box1 = Box.createHorizontalBox(); 
			   box2 = Box.createHorizontalBox(); 
			   box3 = Box.createHorizontalBox(); 
			   box4 = Box.createHorizontalBox(); 
			   box5 = Box.createHorizontalBox(); 
			   box6 = Box.createHorizontalBox(); 
			   box7 = Box.createHorizontalBox(); 
			   box8 = Box.createHorizontalBox(); 
			   box9 = Box.createHorizontalBox(); 
			   box10 = Box.createHorizontalBox(); 
			   box11 = Box.createHorizontalBox(); 
			   box12 = Box.createHorizontalBox();
			   box13 = Box.createHorizontalBox(); 
			   box14 = Box.createHorizontalBox(); 
			   box15 = Box.createHorizontalBox();
			   box16 = Box.createHorizontalBox(); 
			   box17 = Box.createHorizontalBox(); 
			   box18 = Box.createHorizontalBox(); 
			   box19 = Box.createHorizontalBox(); 
			   box20= Box.createHorizontalBox(); 
			   box21 = Box.createHorizontalBox(); 
			   box22 = Box.createHorizontalBox(); 
			   box23 = Box.createHorizontalBox(); 
			   box24_1 = Box.createHorizontalBox(); 
			   box24_2 = Box.createHorizontalBox();
			   box24_3 = Box.createHorizontalBox();
			   box24_4 = Box.createHorizontalBox();
			   box24_5 = Box.createHorizontalBox();
			   box25_1 = Box.createHorizontalBox(); 
			   box25_2 = Box.createHorizontalBox(); 
			   box25_3 = Box.createHorizontalBox(); 
			   box25_4 = Box.createHorizontalBox(); 
			   box25_4 = Box.createHorizontalBox(); 
			   box25_5 = Box.createHorizontalBox(); 
			   box25_6 = Box.createHorizontalBox(); 
			   box26_1 =Box.createHorizontalBox(); 
			   box26_2 =Box.createHorizontalBox(); 
			   box26_3 =Box.createHorizontalBox(); 
			   boxverticalplanetas = Box.createVerticalBox(); 
			   boxverticaldeletepla=Box.createVerticalBox();
			   boxverticaldeletespla=Box.createVerticalBox();
			   boxverticaldeleteconste=Box.createVerticalBox();
			   boxverticaldeletetel=Box.createVerticalBox();
			   boxverticalsistemasplanetarios = Box.createVerticalBox();
			   boxverticalconstelacoes = Box.createVerticalBox(); 
			   boxverticaltelescopios = Box.createVerticalBox(); 
			   boxverticalfotos1 = Box.createVerticalBox(); 
			   boxverticalfotos2 = Box.createVerticalBox(); 
			   boxverticalfotos3 = Box.createVerticalBox(); 
			   		   
			   // --------------Abas Planetas ----------------
			   JTabbedPane abasPlanetas=new JTabbedPane();
		       JPanel separador1=new JPanel();
		       JPanel separador2=new JPanel();
		       JPanel separador3=new JPanel();
		       separador1.setOpaque(false);
		       separador2.setOpaque(false);
		       separador3.setOpaque(false);
		       // --------------Abas SistemaPlanetario ----------------
			   JTabbedPane abasSPlanetario=new JTabbedPane();
		       JPanel separador4=new JPanel();
		       JPanel separador5=new JPanel();
		       JPanel separador6=new JPanel();
		       separador4.setOpaque(false);
		       separador5.setOpaque(false);
		       separador6.setOpaque(false);
		       // --------------Abas Constelacoes ----------------
			   JTabbedPane abasConstelacoes=new JTabbedPane();
		       JPanel separador7=new JPanel();
		       JPanel separador8=new JPanel();
		       JPanel separador9=new JPanel();
		       separador7.setOpaque(false);
		       separador8.setOpaque(false);
		       separador9.setOpaque(false);
		       // --------------Abas Telescopio----------------
			   JTabbedPane abasTelescopio=new JTabbedPane();
		       JPanel separador10=new JPanel();
		       JPanel separador11=new JPanel();
		       JPanel separador12=new JPanel();
		       separador10.setOpaque(false);
		       separador11.setOpaque(false);
		       separador12.setOpaque(false);
		       //----------------Abas Fotos-----------------------
		       JTabbedPane testabas=new JTabbedPane();
		       JPanel separador77=new JPanel();
		       JPanel separador78=new JPanel();
		       JPanel separador79=new JPanel();
		       separador77.setOpaque(false);
		       separador78.setOpaque(false);
		       separador79.setOpaque(false);
		       
			   //--------------------------------------------
			   //-------------|| QUERY 1 || -----------------
		       labelplaneta1 = new JLabel ("Encontrar planeta: ");
		       labelplaneta1.setForeground(Color.white);
		       textoplaneta1 = new JTextField( "Earth", 10);
		       labelplaneta1.setToolTipText("Inserir nome de um planeta para ver os seus atributos.");
		       box1.add(labelplaneta1);
		       box1.add(textoplaneta1);
		       butao1 = new JButton( "OK" );
		       box1.add(butao1);
		       box1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalplanetas.add(box1);
		       
		       //--------------------------------------------
			   //-------------|| QUERY 2 || -----------------
		       labelplaneta2= new JLabel("Ver planetas ordenados por: ");
		       labelplaneta2.setForeground(Color.white);
		       labelplaneta2.setToolTipText("Ver todos os planetas ordenados pelo nome do sistema planetário a que pertencem ou ordenados pela sua massa ");
		       intersect1=new JRadioButton("Sistema Planetário ");
		       intersect2=new JRadioButton("Massa ");
		       intersect1.setForeground(Color.white);
		       intersect2.setForeground(Color.white);
		       butao2=new JButton("OK");
		       intersect1.setOpaque(false);
		       intersect2.setOpaque(false);
		       box2.add(labelplaneta2);
		       box2.add(intersect1);
		       box2.add(intersect2);
		       groupintersect=new ButtonGroup();
		       groupintersect.add(intersect1);
		       groupintersect.add(intersect2);
		       box2.add(butao2);
		       box2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalplanetas.add(box2);
	       
			   //----------------------------------------------
			   //---------------|| QUERY 3 ||------------------
		       butao3=new JButton("OK");
		       labelplaneta3= new JLabel("Nº Planetas descobertos em:  ");
		       labelplaneta3.setForeground(Color.white);
		       labelplaneta3.setToolTipText("Inserir ano para ver o número de planetas descobertos nesse ano.");
		       textoplaneta3=new JTextField("2014");
		       box3.add(labelplaneta3);
		       box3.add(textoplaneta3);
		       box3.add(butao3);
		       box3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalplanetas.add(box3);
		       separador1.add(boxverticalplanetas);
		       
		       //----------------------------------------------
			   //---------------|| QUERY 4 ||------------------
		       labelplaneta4= new JLabel("Eliminar planeta:  ");
		       labelplaneta4.setForeground(Color.white);
		       labelplaneta4.setToolTipText("Inserir o nome do planeta que se pretende eliminar.");
		       deleteplaneta=new JTextField("Planetaexemplo",12);
		       butao4= new JButton("DELETE");
		       boxjuste=Box.createHorizontalBox();
		       box4.add(labelplaneta4);
		       box4.add(deleteplaneta);
		       box4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxjuste.add(butao4);
		       boxjuste.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       separador3.add(box4);
		       separador3.add(boxjuste);
		       
			   // --------------|| QUERY 5 - INSERIR PLANETA ||---------------
		       butao5=new JButton("       Inserir Planeta       ");
		       JLabel l1= new JLabel("id: ");
		       l1.setForeground(Color.white);
		       l1.setToolTipText("ID do Planeta a adicionar");
		       JLabel l2= new JLabel("    Nome: ");
		       l2.setForeground(Color.white);
		       l2.setToolTipText("Nome do Planeta a adicionar");
		       JLabel l3= new JLabel("Massa: ");
		       l3.setForeground(Color.white);
		       l3.setToolTipText("Massa do Planeta a adicionar. Unidade= MJ");
		       JLabel l4= new JLabel("EixoSemiMaior: ");
		       l4.setForeground(Color.white);
		       l4.setToolTipText("Eixo Semi Maior do Planeta a adicionar. Unidade= graus");
		       JLabel l5= new JLabel(" Periodo: ");
		       l5.setForeground(Color.white);
		       l5.setToolTipText("Período de traslação do Planeta a adicionar. Unidades=dias");
		       JLabel l6= new JLabel("Excentricidade: ");
		       l6.setForeground(Color.white);
		       l6.setToolTipText("Excentricidade do Planeta a adicionar. Unidades=graus");
		       JLabel l7= new JLabel("Inclinação: ");
		       l7.setForeground(Color.white);
		       l7.setToolTipText("Inclinação do Planeta a adicionar. Unidades=graus");
		       JLabel l8= new JLabel("			  Descoberto em: ");
		       l8.setToolTipText("Ano em que foi descoberto o Planeta a adicionar.");
		       l8.setForeground(Color.white);
		       JLabel l9= new JLabel("idSPlanetario: ");
		       l9.setToolTipText("id do Sistema Planetário a que pertence o Planeta a adicionar.");
		       l9.setForeground(Color.white);
		       t1=new JTextField("500",10);
		       t2=new JTextField("Planetaexemplo",10);
		       t3=new JTextField("0.5",10);
		       t4=new JTextField("0.5",10);
		       t5=new JTextField("500",10);
		       t6=new JTextField("0.5",10);
		       t7=new JTextField("0.05",10);
		       t8=new JTextField("5000",10);
		       t9=new JTextField("1",5);
			   b1 = Box.createHorizontalBox(); 
			   b2 = Box.createHorizontalBox(); 
			   b3 = Box.createHorizontalBox(); 
			   b4 = Box.createHorizontalBox(); 
			   b5 = Box.createHorizontalBox(); 
			   b6 = Box.createHorizontalBox(); 
			   b7 = Box.createHorizontalBox(); 
			   b8 = Box.createHorizontalBox(); 
		       b1.add(l1);
		       b1.add(t1);
		       b1.add(l2);
		       b1.add(t2);
		       b2.add(l3);
		       b2.add(t3);
		       b2.add(l5);
		       b2.add(t5);
		       b3.add(l4);
		       b3.add(t4);
		       b3.add(l6);
		       b3.add(t6);
		       b4.add(l7);
		       b4.add(t7);
		       b4.add(l8);
		       b4.add(t8);
		       b5.add(l9);
		       b5.add(t9);
		       b6.add(butao5);
		       b1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       b2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       b3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       b4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       b5.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       b6.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticaldeletepla.add(b1);
		       boxverticaldeletepla.add(b2);
		       boxverticaldeletepla.add(b3);
		       boxverticaldeletepla.add(b4);
		       boxverticaldeletepla.add(b5);
		       boxverticaldeletepla.add(b6);
		       separador2.add(boxverticaldeletepla);

		       //------------------------------------------
		       // --------------|| QUERY 6 ||--------------
		       butao6=new JButton("Ver todos os Planetas");
		       butao6.setToolTipText("Ver tabela completa dos Planetas");
		       box6.add(butao6);
		       boxverticalplanetas.add(box6);
		       box6.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       
		       // ---------------------------------------------
		       //---------------|| QUERY 7 ||------------------
		       labelsistemaplanetario1 = new JLabel ("Ver características Sistema Planetário (nome): ");
		       labelsistemaplanetario1.setForeground(Color.white);
		       labelsistemaplanetario1.setToolTipText("Inserir nome de um planeta para ver os seus atributos.");
		       textosistemaplanetario1 = new JTextField( "Sun", 1 );
		       box7.add(labelsistemaplanetario1 );
		       box7.add(textosistemaplanetario1);
		       butao7 = new JButton( "OK" );
		       box7.add(butao7);
		       box7.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalsistemasplanetarios.add(box7);
		       
		       //----------------------------------------------
		       //---------------|| QUERY 8 ||------------------
		       labelsistemaplanetario2= new JLabel("Nº de planetas de um sistema ordenados por:  ");
		       labelsistemaplanetario2.setForeground(Color.white);
		       labelsistemaplanetario2.setToolTipText("Ver o número de planetas que um sistema tem ordenados por Constelações ou Galáxia");
		       intersect3=new JRadioButton("Constelações          ");
		       intersect4=new JRadioButton("Galáxia           ");
		       intersect3.setForeground(Color.white);
		       intersect4.setForeground(Color.white);
		       butao8=new JButton("OK");
		       intersect3.setOpaque(false);
		       intersect4.setOpaque(false);
		       box8.add(labelsistemaplanetario2);
		       box8.add(intersect3);
		       box8.add(intersect4);
		       groupintersectsistemas=new ButtonGroup();
		       groupintersectsistemas.add(intersect3);
		       groupintersectsistemas.add(intersect4);
		       box8.add(butao8);
		       box8.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalsistemasplanetarios.add(box8);
		       
		       //----------------------------------------------
		       //---------------|| QUERY 9 ||------------------
		       labelsistemaplanetario3= new JLabel("Encontrar sistemas cuja distância é inferior a: ");
		       labelsistemaplanetario3.setForeground(Color.white);
		       labelsistemaplanetario3.setToolTipText("Inserir distância para ver todos os sistemas que estão a essa distância mínima.");
		       butao9=new JButton("OK");
		       sliderdistancia=new JSlider(JSlider.HORIZONTAL,0,20000,0);
		       sliderdistancia.setOpaque(false);
		       sliderdistancia.setMajorTickSpacing(10000);
		       sliderdistancia.setMinorTickSpacing(500);
		       sliderdistancia.setPaintTicks(true);
		       sliderdistancia.setPaintLabels(true);
		       sliderdistancia.setForeground(Color.white);
		       box9.add(labelsistemaplanetario3);
		       box9.add(sliderdistancia);
		       box9.add(butao9);
		       box9.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalsistemasplanetarios.add(box9);
		      
		       
		       //----------------------------------------------
		       //---------------|| QUERY 10 ||------------------
		       labelsistemaplanetario4= new JLabel("Eliminar sistema planetário (indicar nome):  ");
		       labelsistemaplanetario4.setForeground(Color.white);
		       labelsistemaplanetario4.setToolTipText("Inserir nome de um sistema planetário.");
		       deletesistemaplanetario=new JTextField("Sistemaplanetario",10);
		       butao10= new JButton("DELETE");
		       box10.add(labelsistemaplanetario4);
		       box10.add(deletesistemaplanetario);
		       box10.add(butao10);
		       box10.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       separador6.add(box10);
		       
		       //---------------------------------------------
		       //--------------|| QUERY 11 ||-----------------
		       butao11=new JButton("       Inserir Sistema Planetário       ");
		       JLabel ll1= new JLabel("id: ");
		       ll1.setForeground(Color.white);
		       ll1.setToolTipText("Insira id do Planeta a adicionar");
		       JLabel ll2= new JLabel("Nome: ");
		       ll2.setForeground(Color.white);
		       ll2.setToolTipText("Nome do Sistema Planetário a adicionar.");
		       JLabel ll3= new JLabel("Ascensão: ");
		       ll3.setToolTipText("Eixo Semi Maior do sistema Planetário a adicionar. Unidade= graus");
		       ll3.setForeground(Color.white);
		       JLabel ll4= new JLabel("Declinação: ");
		       ll4.setToolTipText("Declinação do Sistema Planetário a adicionar. Unidades=dias");
		       ll4.setForeground(Color.white);
		       JLabel ll5= new JLabel("Magnitude Aparente: ");
		       ll5.setToolTipText("Magnitude Aparente do sistema Planetário a adicionar. Unidades=graus");
		       ll5.setForeground(Color.white);
		       JLabel ll6= new JLabel("Dsitância: ");
		       ll6.setToolTipText("Distância do sistema Planetário a adicionar. Unidades=light-year");
		       ll6.setForeground(Color.white);
		       JLabel ll7= new JLabel("Tipo de Espectro: ");
		       ll7.setToolTipText("Tipo de espectro do Sistema Planetário a adicionar.");
		       ll7.setForeground(Color.white);
		       JLabel ll8= new JLabel("Massa: ");
		       ll8.setToolTipText("Massa do Sistema Planetário a adicionar.Unidades:");
		       ll8.setForeground(Color.white);
		       JLabel ll9= new JLabel("Temperatura: ");
		       ll9.setToolTipText("Temperatura do Sistema Planetário a adicionar.Unidades=Kelvin");
		       ll9.setForeground(Color.white);
		       JLabel ll10= new JLabel("Idade: ");
		       ll10.setToolTipText("Idade do Sistema Planetário a adicionar.Unidades=GigaYear");
		       ll10.setForeground(Color.white);
		       JLabel ll11= new JLabel("NºPlanetas: ");
		       ll11.setToolTipText("Nº de Planetas que o Sistema Planetário a adicionar tem.");
		       ll11.setForeground(Color.white);
		       JLabel ll12= new JLabel("id Constelação: ");
		       ll12.setToolTipText("id da Constelação a que pertence o Sistema Planetário a adicionar.");
		       ll12.setForeground(Color.white);
		       JLabel ll13= new JLabel("id Galáxia: ");
		       ll13.setToolTipText("id da Galáxia a que pertence o Sistema Planetário a adicionar.");
		       ll13.setForeground(Color.white);
		       tt1=new JTextField("500",10);
		       tt2=new JTextField("Sistemaplanetario",10);
		       tt3=new JTextField("00h00",10);
		       tt4=new JTextField("0º 0 0",10);
		       tt5=new JTextField("10",10);
		       tt6=new JTextField("10",10);
		       tt7=new JTextField("G2V",10);
		       tt8=new JTextField("10",10);
		       tt9=new JTextField("5000",10);
		       tt10=new JTextField("4000",10);
		       tt11=new JTextField("1",10);
		       tt12=new JTextField("1",10);
		       tt13=new JTextField("1",10);
			   bb1 = Box.createHorizontalBox(); 
			   bb2 = Box.createHorizontalBox(); 
			   bb3 = Box.createHorizontalBox(); 
			   bb4 = Box.createHorizontalBox(); 
			   bb5 = Box.createHorizontalBox(); 
			   bb6 = Box.createHorizontalBox(); 
			   bb7 = Box.createHorizontalBox(); 
			   bb8 = Box.createHorizontalBox(); 
			   bb9 = Box.createHorizontalBox(); 
			   bb10 = Box.createHorizontalBox(); 
			   bb11 = Box.createHorizontalBox(); 
		       bb1.add(ll1);
		       bb1.add(tt1);
		       bb1.add(ll2);
		       bb1.add(tt2);
		       bb2.add(ll3);
		       bb2.add(tt3);
		       bb2.add(ll4);
		       bb2.add(tt4);
		       bb3.add(ll5);
		       bb3.add(tt5);
		       bb3.add(ll6);
		       bb3.add(tt6);
		       bb4.add(ll7);
		       bb4.add(tt7);
		       bb4.add(ll8);
		       bb4.add(tt8);
		       bb5.add(ll9);
		       bb5.add(tt9);
		       bb5.add(ll10);
		       bb5.add(tt10);
		       bb6.add(ll11);
		       bb6.add(tt11);
		       bb6.add(ll12);
		       bb6.add(tt12);
		       bb6.add(ll13);
		       bb6.add(tt13);
		       bb7.add(butao11);
		       bb1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bb2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bb3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bb4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bb5.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bb6.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bb7.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		       boxverticaldeletespla.add(bb1);
		       boxverticaldeletespla.add(bb2);
		       boxverticaldeletespla.add(bb3);
		       boxverticaldeletespla.add(bb4);
		       boxverticaldeletespla.add(bb5);
		       boxverticaldeletespla.add(bb6);
		       boxverticaldeletespla.add(bb7);
		       separador5.add(boxverticaldeletespla);
		    

		       //----------------------------------------------
		       //---------------|| QUERY 12 ||------------------
		       butao12=new JButton("Ver todos os Sistemas Planetarios");
		       butao12.setToolTipText("Ver tabela completa de Sistemas Planetários");
		       box12.add(butao12);
		       box12.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalsistemasplanetarios.add(box12);
		       separador4.add(boxverticalsistemasplanetarios);
		  
		       //-----------------------------------------------
		       //---------------|| QUERY 13 ||-----------------
		       labelconstelacoes1 = new JLabel ("Ver Constelação (nome): ");
		       labelconstelacoes1.setForeground(Color.white);
		       labelconstelacoes1.setToolTipText("Inserir nome de uma Constelação para ver os seus atributos.");
		       textoconstelacoes1 = new JTextField( "Andromeda", 1 );
		       box13.add(labelconstelacoes1 );
		       box13.add(textoconstelacoes1);
		       butao13 = new JButton( "OK" );
		       box13.add(butao13);
		       box13.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalconstelacoes.add(box13);
		       
		       //----------------------------------------------
		       //---------------|| QUERY 14 ||------------------
		       labelconstelacoes2= new JLabel("Constelações visíveis no hemisfério:  ");
		       labelconstelacoes2.setForeground(Color.white);
		       labelconstelacoes2.setToolTipText("Selecionar o hemisfério para ver as constelações ");
		       butao14a=new JRadioButton("  Norte ");
		       butao14a.setForeground(Color.white);
		       butao14b=new JRadioButton("   Sul  ");
		       butao14b.setForeground(Color.white);
		       butao14=new JButton("Ver todas");
		       butao14_1=new JButton("Contar");
		       butao14a.setOpaque(false);
		       butao14b.setOpaque(false);
		       box14.add(labelconstelacoes2);
		       box14.add(butao14a);
		       box14.add(butao14b);
		       grupobutoes_14=new ButtonGroup();
		       grupobutoes_14.add(butao14a);
		       grupobutoes_14.add(butao14b);
		       box14.add(butao14);
		       box14.add(new JLabel(" "));
		       box14.add(butao14_1);
		       box14.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalconstelacoes.add(box14);
  
		       //----------------------------------------------
		       //---------------|| QUERY 15 ||------------------
		       labelconstelacoes3= new JLabel("Ver constelacoes da família: ");
		      labelconstelacoes3.setForeground(Color.white);
		      labelconstelacoes3.setToolTipText("Inserir nome da família de constelações que pretende visualizar.");
		       String listafamiliasconstelacoes [] = {"Bayer","Heavenly Waters","Hercules","La Caille","Orion","Perseus","Ursa Major","Zodiac"};
		       comboconstelacoes=new JComboBox(listafamiliasconstelacoes);
		       butao15=new JButton("OK");
		       box15.add(labelconstelacoes3);
		       box15.add(comboconstelacoes);
		       box15.add(butao15);
		       box15.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalconstelacoes.add(box15);
		       separador7.add(boxverticalconstelacoes);
		      
		       //------------------------------------------------------------
		       //--------------|| QUERY 16 ||---------------------------------
		      JLabel labelconstelacoes4= new JLabel("Eliminar constelação (indicar nome):  ");
		      labelconstelacoes4.setForeground(Color.white);
		      labelconstelacoes4.setToolTipText("Indique o nome da constelação que pretende eliminar.");
		       deleteconstelacoes=new JTextField("Constelação",10);
		       butao16= new JButton("DELETE");
		       box16.add(labelconstelacoes4);
		       box16.add(deleteconstelacoes);
		       box16.add(butao16);
		       box16.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       separador9.add(box16);
		       
		       
		       //---------------------------------------------------------
		       //--------------.|| QUERY 17 |!--------------------------
		       butao17=new JButton("       Inserir constelacao       ");		       
		       JLabel lll1= new JLabel("id: ");
		       lll1.setForeground(Color.white);
		       lll1.setToolTipText("ID da Constelação a adicionar");
		       JLabel lll2= new JLabel("Nome: ");
		       lll2.setForeground(Color.white);
		       lll2.setToolTipText("Insira o Nome da Constelação a adicionar.");
		       JLabel lll3= new JLabel("Abreviatura: ");
		       lll3.setForeground(Color.white);
		       lll3.setToolTipText("Insira a Abreviatura da constelação a adicionar.");
		       JLabel lll4= new JLabel("Genitivo: ");
		       lll4.setForeground(Color.white);
		       lll4.setToolTipText("Insira o Genitivo da constelação a adicionar.");
		       JLabel lll5= new JLabel("Familia: ");
		       lll5.setForeground(Color.white);
		       lll5.setToolTipText("Insira a Família da constelação a adicionar.");
		       JLabel lll6= new JLabel("Significado: ");
		       lll6.setForeground(Color.white);
		       lll6.setToolTipText("Insira o significado da constelação a adicionar. Unidades=graus");
		       JLabel lll7= new JLabel("Estrela maisbrilhante: ");
		       lll7.setForeground(Color.white);
		       lll7.setToolTipText("Insira a estrela mais brilhante da Constelação a adicionar.");
		       JLabel lll8= new JLabel("HN: ");
		       lll8.setForeground(Color.white);
		       lll8.setToolTipText("Insira quando(Sempre, Inverno,Outono, Primavera,Verão,Nunca) é visível a Constelação a adicionar no hemisfério Norte.");
		       JLabel lll9= new JLabel("HS: ");
		       lll9.setForeground(Color.white);
		       ll9.setToolTipText("Insira quando(Sempre, Inverno,Outono, Primavera,Verão,Nunca) é visível a Constelação a adicionar no hemisfério Sul.");
		       
		       ttt1=new JTextField("500",10);
		       ttt2=new JTextField("Constelação",10);
		       ttt3=new JTextField("Const",10);
		       ttt4=new JTextField("Andromedae",10);
		       ttt5=new JTextField("FamiliaConstelação",10);
		       ttt6=new JTextField("The chained lady or the Princess",10);
		       ttt7=new JTextField("Alpheratz",10);
		       ttt8=new JTextField("Inverno",10);
		       ttt9=new JTextField("Verão",10);
			   bbb1 = Box.createHorizontalBox(); 
			   bbb2 = Box.createHorizontalBox(); 
			   bbb3 = Box.createHorizontalBox(); 
			   bbb4 = Box.createHorizontalBox(); 
			   bbb5 = Box.createHorizontalBox(); 
			   bbb6 = Box.createHorizontalBox(); 
			   bbb7 = Box.createHorizontalBox(); 
			   bbb8 = Box.createHorizontalBox(); 
			   bbb9 = Box.createHorizontalBox(); 
			   bbb10 = Box.createHorizontalBox(); 
			   bbb11 = Box.createHorizontalBox(); 
		       bbb1.add(lll1);
		       bbb1.add(ttt1);
		       bbb1.add(lll2);
		       bbb1.add(ttt2);
		       bbb2.add(lll3);
		       bbb2.add(ttt3);
		       bbb2.add(lll4);
		       bbb2.add(ttt4);
		       bbb3.add(lll5);
		       bbb3.add(ttt5);
		       bbb3.add(lll6);
		       bbb3.add(ttt6);
		       bbb4.add(lll7);
		       bbb4.add(ttt7);
		       bbb5.add(lll8);
		       bbb5.add(ttt8);
		       bbb5.add(lll9);
		       bbb5.add(ttt9);
		       bbb6.add(butao17);
		       bbb1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bbb2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bbb3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bbb4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bbb5.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bbb6.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticaldeleteconste.add(bbb1);
		       boxverticaldeleteconste.add(bbb2);
		       boxverticaldeleteconste.add(bbb3);
		       boxverticaldeleteconste.add(bbb4);
		       boxverticaldeleteconste.add(bbb5);
		       boxverticaldeleteconste.add(bbb6);
		       separador8.add(boxverticaldeleteconste);
		    
		       //------------------------------------------------------------
		       //--------------|| QUERY 18 ||--------------------------------
		       butao18=new JButton("       Ver todas as constelacoes      ");
		       butao18.setToolTipText("Ver tabela completa de Constelações");
		       box18.add(butao18);
		       box18.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalconstelacoes.add(box18);
		       
		       //------------------------------------------------------------
		       //---------------|| QUERY 19 ||--------------------------------
		       labeltelescopios1 = new JLabel ("Ver Telescopio (nome): ");
		       labeltelescopios1.setForeground(Color.white);
		       labeltelescopios1.setToolTipText("Inserir nome do Telescópio que pretende visualizar.");
		       textotelescopios1 = new JTextField("Hubble",10);
		       butao19=new JButton("OK");
		       box19.add(labeltelescopios1);
		       box19.add(textotelescopios1);
		       box19.add(butao19);
		       box19.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticaltelescopios.add(box19);
		       
		       //------------------------------------------------------------
		       //---------------|| QUERY 20 ||--------------------------------
		       labeltelescopios2_1 = new JLabel ("Abertura maior que: ");
		       labeltelescopios2_1.setToolTipText("Inserir o intervalo de valores da abertura que os telescopios pretende pesquisar devem ter.");
		       labeltelescopios2_1.setForeground(Color.white);
		       labeltelescopios2_2 = new JLabel ("  e menor que: ");
		       labeltelescopios2_2.setForeground(Color.white);
		       textotelescopios2_1 = new JTextField("0",5);
		       textotelescopios2_2 = new JTextField("10",5);
		       butao20=new JButton("OK");
		       box20.add(labeltelescopios2_1);
		       box20.add(textotelescopios2_1);
		       box20.add(labeltelescopios2_2);
		       box20.add(textotelescopios2_2);
		       box20.add(butao20);
		       box20.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticaltelescopios.add(box20);
		       separador10.add(boxverticaltelescopios);
		       
		       //------------------------------------------------------------
		       //---------------|| QUERY 21 ||--------------------------------
		       labeltelescopios3= new JLabel("Eliminar telescopio (indicar nome):  ");
		       labeltelescopios3.setToolTipText("Inserir nome do Telescópio que pretende eliminar.");
		       labeltelescopios3.setForeground(Color.white);
		       deletetelescopios=new JTextField("Telescópioexemplo",10);
		       butao21= new JButton("DELETE");
		       box21.add(labeltelescopios3);
		       box21.add(deletetelescopios);
		       box21.add(butao21);
		       box21.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       separador12.add(box21);
		       
		       //------------------------------------------------------------
		       //---------------|| QUERY 22 ||--------------------------------
		       butao22=new JButton("       Inserir telescopio      ");       
		       JLabel llll1= new JLabel("id: ");
		       llll1.setToolTipText("Inserir ID do Telescópio a adicionar.");
		       llll1.setForeground(Color.white);
		       JLabel llll2= new JLabel("Nome: ");
		       llll2.setToolTipText("Inserir Nome do Telescópio a adicionar.");
		       llll2.setForeground(Color.white);
		       JLabel llll3= new JLabel("Abertura: ");
		       llll3.setForeground(Color.white);
		       llll3.setToolTipText("Inserir Abertura do Telescópio a adicionar. Unidades = metros");
		       JLabel llll4= new JLabel("Espelho: ");
		       llll4.setForeground(Color.white);
		       llll4.setToolTipText("Inserir Espelho do Telescópio a adicionar.");
		       JLabel llll5= new JLabel("Sponsors: ");
		       llll5.setForeground(Color.white);
		       llll5.setToolTipText("Inserir Sponsors do Telescópio a adicionar.");
		       JLabel llll6= new JLabel("Localização: ");
		       llll6.setForeground(Color.white);
		       llll6.setToolTipText("Inserir Localização do Telescópio a adicionar.");
		       JLabel llll7= new JLabel("Construido: ");
		       llll7.setToolTipText("Inserir Ano em que o Telescópio a adicionar foi construído.");
		       llll7.setForeground(Color.white);
		       
		       tttt1=new JTextField("500",10);
		       tttt2=new JTextField("Telescópioexemplo",10);
		       tttt3=new JTextField("2.72",10);
		       tttt4=new JTextField("Single",10);
		       tttt5=new JTextField("USA",10);
		       tttt6=new JTextField("McDonald Observatory Texas USA",10);
		       tttt7=new JTextField("2014",10);
			   bbbb1 = Box.createHorizontalBox(); 
			   bbbb2 = Box.createHorizontalBox(); 
			   bbbb3 = Box.createHorizontalBox(); 
			   bbbb4 = Box.createHorizontalBox(); 
			   bbbb5 = Box.createHorizontalBox(); 
			   bbbb6 = Box.createHorizontalBox(); 
			   bbbb7 = Box.createHorizontalBox(); 
			   bbbb8 = Box.createHorizontalBox(); 
		       bbbb1.add(llll1);
		       bbbb1.add(tttt1);
		       bbbb1.add(llll2);
		       bbbb1.add(tttt2);
		       bbbb2.add(llll3);
		       bbbb2.add(tttt3);
		       bbbb2.add(llll4);
		       bbbb2.add(tttt4);
		       bbbb3.add(llll5);
		       bbbb3.add(tttt5);
		       bbbb4.add(llll6);
		       bbbb4.add(tttt6);
		       bbbb4.add(llll7);
		       bbbb4.add(tttt7);
		       bbbb5.add(butao22);
		       bbbb1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bbbb2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bbbb3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bbbb4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       bbbb5.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticaldeletetel.add(bbbb1);
		       boxverticaldeletetel.add(bbbb2);
		       boxverticaldeletetel.add(bbbb3);
		       boxverticaldeletetel.add(bbbb4);
		       boxverticaldeletetel.add(bbbb5);
		       separador11.add(boxverticaldeletetel);
		       
		       //------------------------------------------------------------
		       //---------------|| QUERY 23 ||--------------------------------
		       butao23=new JButton("       Ver todas os Telescópios      ");
		       butao23.setToolTipText("Ver tabela completa de Telescópios");
		       box23.add(butao23);
		       box23.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticaltelescopios.add(box23);
		       
		       //------------------------------------------------------------
		       //---------------|| QUERY 24 ||--------------------------------  
		       butao24=new JButton("Search!");
		       JLabel labelforamto=new JLabel("Inserir formato: ");
		       labelforamto.setToolTipText("Inserir Formato da Foto a pesquisar.");
		       labelforamto.setForeground(Color.white);
		       JLabel labeldoque=new JLabel("Imagens de: ");
		       labeldoque.setToolTipText("Inserir Tipo de Imagem da Foto a pesquisar.");
		       labeldoque.setForeground(Color.white);
		       String listaformato []={"ALL","jpeg","png","tiff","bmp","pcx","jpg"};
		       formato= new JComboBox(listaformato);
		       JLabel labelcores= new JLabel("Imagem a Cores: ");
		       labelcores.setToolTipText("Seleccione Se a imagem da Foto a pesquisar é a cores.");
		       labelcores.setForeground(Color.white);
		       coisito=new JRadioButton("Sim");
		       coisito.setForeground(Color.white);
		       coisito2=new JRadioButton("Não");
		       coisito2.setForeground(Color.white);
		       String list []= {"ALL","Planetas","Sist.Planetários","Constelações","Galáxias"};
		       listafotos=new JComboBox(list);
		       coisito.setOpaque(false);
		       coisito2.setOpaque(false);
		       ButtonGroup groupcoisito= new ButtonGroup();
		       groupcoisito.add(coisito);
		       groupcoisito.add(coisito2); 
		       box24_1.add(labelforamto);
		       box24_1.add(formato);
		       box24_2.add(labelcores);
		       box24_2.add(coisito);
		       box24_2.add(coisito2);
		       box24_3.add(labeldoque);
		       box24_3.add(listafotos);
		       box24_4.add(butao24);
		       box24_1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       box24_2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       box24_3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       box24_4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       box24_5.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalfotos1.add(box24_1);
		       boxverticalfotos1.add(box24_2);
		       boxverticalfotos1.add(box24_3);
		       boxverticalfotos1.add(box24_4);
		       boxverticalfotos1.add(box24_5);
		       //------------------------------------------------------------
		       //---------------|| QUERY 25 ||--------------------------------
		       
		       
		       labelinsernumerofoto=new JLabel("Número da foto: ");
		       labelinsernumerofoto.setToolTipText("Inserir Número da Foto a adicionar.");
		       labelinsernumerofoto.setForeground(Color.white);
		       textoinsernomefoto=new JTextField("5",10);
		       labelinsertamanhofoto1=new JLabel("Tamanho da foto: ");
		       labelinsertamanhofoto1.setToolTipText("Inserir Tamanho da Foto a adicionar.");
		       labelinsertamanhofoto1.setForeground(Color.white);
		       labelinsertamanhofoto2=new JLabel("X");
		       labelinsertamanhofoto2.setForeground(Color.white);
		       textoinserttamanhofoto1=new JTextField("5",5);
		       labelinserformatofoto2=new JLabel("Formato da foto: ");
		       labelinserformatofoto2.setToolTipText("Inserir Formato da Foto a adicionar.");
		       labelinserformatofoto2.setForeground(Color.white);
		       textoinsertformatofoto=new JTextField("jpeg",5);
		       textoinserttamanhofoto2=new JTextField("5",5);
		       labelinsertcoresfoto=new JLabel("Cores: ");
		       labelinsertcoresfoto.setToolTipText("Inserir se a Foto a adicionar é a cores (True ou False).");
		       labelinsertcoresfoto.setForeground(Color.white);
		       textocoresfoto=new JTextField("True",10);
		       labelinsertdatafoto=new JLabel("Data da foto: ");
		       labelinsertdatafoto.setToolTipText("Inserir Data da Foto a adicionar.");
		       labelinsertdatafoto.setForeground(Color.white);
		       textoinsertdatafoto=new JTextField("2014",10);
		       labelinserttelescopiofoto=new JLabel("Telescópio que tirou a foto: ");
		       labelinserttelescopiofoto.setToolTipText("Inserir Telescópio que tirou a Foto a adicionar.");
		       labelinserttelescopiofoto.setForeground(Color.white);
		       textoinserttelescopiofoto=new JTextField("Hubble",10);
		       butao25=new JButton("INSERIR");
		       box25_1.add(labelinsernumerofoto);
		       box25_1.add(textoinsernomefoto);
		       box25_2.add(labelinsertamanhofoto1);
		       box25_2.add(textoinserttamanhofoto1);
		       box25_2.add(labelinsertamanhofoto2);
		       box25_2.add(textoinserttamanhofoto2);
		       box25_2.add(labelinserformatofoto2);
		       box25_2.add(textoinsertformatofoto);
		       box25_3.add(labelinsertcoresfoto);
		       box25_3.add(textocoresfoto);
		       box25_4.add(labelinsertdatafoto);
		       box25_4.add(textoinsertdatafoto);
		       box25_5.add(labelinserttelescopiofoto);
		       box25_5.add(textoinserttelescopiofoto);
		       box25_6.add(butao25);
		       box25_1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       box25_2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       box25_3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       box25_4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       box25_5.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       box25_6.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalfotos2.add(box25_1);
		       boxverticalfotos2.add(box25_2);
		       boxverticalfotos2.add(box25_3);
		       boxverticalfotos2.add(box25_4);
		       boxverticalfotos2.add(box25_5);
		       boxverticalfotos2.add(box25_6);
		       //------------------------------------------------------------
		       //---------------|| QUERY 26 ||--------------------------------
		       labeldeletefoto=new JLabel("Número da foto: ");
		       labeldeletefoto.setToolTipText("Inserir Número da Foto a eliminar.");
		       labeldeletefoto.setForeground(Color.white);
		       textodeletefoto=new JTextField("5",10);
		       butao26=new JButton("DELETE");
		       box26_1.add(labeldeletefoto);
		       box26_1.add(textodeletefoto);
		       box26_3.add(butao26);
		       box26_1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       box26_3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		       boxverticalfotos3.add(box26_1);
		       boxverticalfotos3.add(box26_2);
		       boxverticalfotos3.add(box26_3);

		       //--------------------------------------------------------------
		       //---------------|| BOXVERTICAIS->SEPARADORES ||---------------- 
		       
		       separador77.add(boxverticalfotos1);
		       separador78.add(boxverticalfotos2);
		       separador79.add(boxverticalfotos3);
		       
		       //------------------------------------------------------------
		       //--------------|| SEPARADORES->TABBEDPANE ||---------------
		       testabas.add("Procurar", separador77);
		       testabas.add("Inserir", separador78);
		       testabas.add("Eliminar", separador79);
		       testabas.setOpaque(false);
		       abasPlanetas.add("Procurar", separador1);
		       abasPlanetas.add("Inserir", separador2);
		       abasPlanetas.add("Eliminar", separador3);
		       abasSPlanetario.add("Procurar", separador4);
		       abasSPlanetario.addTab("Inserir", separador5);
		       abasSPlanetario.addTab("Eliminar", separador6);
		       abasConstelacoes.add("Procurar", separador7);
		       abasConstelacoes.addTab("Inserir", separador8);
		       abasConstelacoes.addTab("Eliminar", separador9);
		       abasTelescopio.add("Procurar", separador10);
		       abasTelescopio.addTab("Inserir", separador11);
		       abasTelescopio.addTab("Eliminar", separador12);
			   tabbedPane.add("Planetas",abasPlanetas);
			   tabbedPane.add("Sistemas Planetários",abasSPlanetario);
			   tabbedPane.add("Constelações",abasConstelacoes);
			   tabbedPane.add("Telescópios",abasTelescopio);
			   tabbedPane.add("Fotografias",testabas);
			   add(tabbedPane);
		       setSize(720,470);
		       setVisible( true );
		       JOptionPane.showMessageDialog(new JFrame("HELP"),"Deixar ponteiro em cima das labels para receber ajudar.");
		       
		       //--------------------------------------------------------
		       // ------------|| Inciar actions listeners ||------------
		       thehandler handler=new thehandler ();
		       butao1.addActionListener(handler);
		       butao2.addActionListener(handler);
		       butao3.addActionListener(handler);
		       butao4.addActionListener(handler);
		       butao5.addActionListener(handler);
		       butao6.addActionListener(handler);
		       butao7.addActionListener(handler);
		       butao8.addActionListener(handler);
		       butao9.addActionListener(handler);
		       butao10.addActionListener(handler);
		       butao11.addActionListener(handler);
		       butao12.addActionListener(handler);
		       butao13.addActionListener(handler);
		       butao14.addActionListener(handler);
		       butao14_1.addActionListener(handler);
		       butao15.addActionListener(handler);
		       butao16.addActionListener(handler);
		       butao17.addActionListener(handler);
		       butao18.addActionListener(handler);
		       butao19.addActionListener(handler);
		       butao20.addActionListener(handler);
		       butao21.addActionListener(handler);
		       butao22.addActionListener(handler);
		       butao23.addActionListener(handler);
		       butao24.addActionListener(handler);
		       butao25.addActionListener(handler);
		       butao26.addActionListener(handler);
		       intersect1.addActionListener(handler);
		       intersect2.addActionListener(handler);
		       intersect3.addActionListener(handler);
		       intersect4.addActionListener(handler);
		       coisito.addActionListener(handler);
		       coisito2.addActionListener(handler);
		      
		   }

		   catch ( ClassNotFoundException classNotFound ) 
		   {
			   JOptionPane.showMessageDialog( null, 
		       "MySQL driver not found", "Driver not found",
		       JOptionPane.ERROR_MESSAGE );
		         
		       System.exit( 1 ); 
		   } 
		   catch ( SQLException sqlException ) 
		   {
		       JOptionPane.showMessageDialog( null, sqlException.getMessage(), 
		       "Database error", JOptionPane.ERROR_MESSAGE );
		               
		         
		       tableModel.disconnectFromDatabase();
		         
		       System.exit( 1 );   
		   } 
		   setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		   
		   addWindowListener(      
				   new WindowAdapter() 
			         {
			            public void windowClosed( WindowEvent event )
			            {
			               tableModel.disconnectFromDatabase();
			               modoinserir.disconnectFromDatabase();
			               System.exit( 0 );
			            } 
			         } 
			      ); 
	   }
	   private class thehandler implements ActionListener{
		   public void actionPerformed(ActionEvent event){
			   JTable resultTable = new JTable( tableModel );

			   String infoquery="";
			   String requestedquery="";
			   String estado = "";
			   int linhas =0;
//---------------------------------------------------!!!  QUERY Planeta  !!!!----------------
			
			   if(event.getSource()==butao1)
			   {
				   String pedido=textoplaneta1.getText();
				   requestedquery="Select planeta.idPlaneta,planeta.NomePlaneta,planeta.massa,planeta.eixosemimaior,planeta.periodo,planeta.excentricidade,planeta.inclinacao,planeta.ano,splanetario.nomeestrela,galaxia.nomegalaxia FROM planeta,splanetario,galaxia where(splanetario_idsplanetario=idsplanetario and splanetario.Galaxia_idGalaxia=Galaxia.idGalaxia and planeta.nomeplaneta="+"'"+pedido+"'"+")";
				 
			   }
			   else if(event.getSource()==butao2)
			   {
				   if(intersect1.isSelected())
					   requestedquery="Select planeta.*,splanetario.nomeestrela FROM planeta,splanetario where(splanetario_idsplanetario=idsplanetario) order by splanetario.nomeestrela";
				   else if(intersect2.isSelected())
					   requestedquery="Select * FROM planeta order by massa";
				   else
					   requestedquery="";
			   }
			   else if(event.getSource()==butao3)
			   {
				   String pedido=textoplaneta3.getText();
				   requestedquery="select count(idplaneta) from planeta where ano="+"'"+pedido+"'";
				   if (pedido.equals(""))
					   requestedquery="";
			   }
			   else if(event.getSource()==butao4) 
			   {
				   String pedido=deleteplaneta.getText();
				   requestedquery="delete from planeta where nomeplaneta="+"'"+pedido+"'";
				   if (pedido.equals(""))
					   requestedquery="";
			   }
			   else if(event.getSource()==butao5) 
			   {
				  String atributo1=t1.getText();
				  String atributo2=t2.getText();
				  String atributo3=t3.getText();
				  String atributo4=t4.getText();
				  String atributo5=t5.getText();
				  String atributo6=t6.getText();
				  String atributo7=t7.getText();
				  String atributo8=t8.getText();
				  String atributo9=t9.getText();
				  requestedquery="INSERT INTO Planeta VALUES ( "+atributo1+", '"+atributo2+"', " +atributo3 +" , "+atributo4 +" , "+atributo5 +" , "+atributo6 +" , "+atributo7 +" , "+atributo8 +" , "+atributo9+ ")";
				 
				  if ((atributo1.equals(""))||(atributo2.equals(""))||(atributo3.equals(""))||(atributo7.equals(""))||(atributo8.equals(""))||(atributo9.equals("")))
					   requestedquery="";
			   
				  else if((atributo4.equals(""))){
					  requestedquery="INSERT INTO Planeta VALUES ( "+atributo1+", '"+atributo2+"', " +atributo3 +" ," +"NULL"+", "+atributo5 +" , "+atributo6 +" , "+atributo7 +" , "+atributo8 +" , "+atributo9+ ")";
						 
				  }
				  else if((atributo5.equals(""))){
					  requestedquery="INSERT INTO Planeta VALUES ( "+atributo1+", '"+atributo2+"', " +atributo3 +" , "+atributo4 +" , "+"NULL" +" , "+atributo6 +" , "+atributo7 +" , "+atributo8 +" , "+atributo9+ ")";
					  }
				  else if (atributo6.equals("")){
					  requestedquery="INSERT INTO Planeta VALUES ( "+atributo1+", '"+atributo2+"', " +atributo3 +" , "+atributo4 +" , "+atributo5 +" , NULL" +" , "+atributo7 +" , "+atributo8 +" , "+atributo9+ ")";
				  	}
				  }
			   
			   else if(event.getSource()==butao6) 
			   {
				   requestedquery="SELECT * FROM planeta";
			   }
//---------------------------------------------------!!!  QUERY Sistem planetario  !!!!----------------
			   else if(event.getSource()==butao7) 
			   {
				   String pedido=textosistemaplanetario1.getText();
				   requestedquery="select * from splanetario where nomeestrela="+"'"+pedido+"'";
				   if (pedido.equals(""))
					   requestedquery="";
			   }
			   else if(event.getSource()==butao8)
			   {
				   if(intersect3.isSelected())
				   requestedquery="select count(planeta.nomeplaneta), splanetario.nomeestrela, constelacao.nomeconstelacao   from  planeta,splanetario,constelacao where (splanetario.idsplanetario=planeta.splanetario_idsplanetario and splanetario.constelacao_idconstelacao=constelacao.idconstelacao) group by splanetario.idsplanetario order by constelacao_idconstelacao ";
				   else if(intersect4.isSelected())
					   requestedquery="select count(planeta.nomeplaneta), splanetario.nomeestrela, galaxia.nomegalaxia   from  planeta,splanetario,galaxia where (splanetario.idsplanetario=planeta.splanetario_idsplanetario and splanetario.galaxia_idgalaxia=galaxia.idgalaxia) group by splanetario.idsplanetario order by galaxia.NomeGalaxia ";
				   else
						   requestedquery="";
			   }
			   else if(event.getSource()==butao9)
			   {
				   int pedido=sliderdistancia.getValue();
				   requestedquery="select * from splanetario where distancia<"+pedido;
				   
			   }	   
			   else if(event.getSource()==butao10) // DELETE
			   {
				   String pedido=deletesistemaplanetario.getText();
			       requestedquery="delete from splanetario where nomeestrela="+"'"+pedido+"'";
			       if (pedido.equals(""))
					   requestedquery="";
			   }
			   else if(event.getSource()==butao11) //INSERT
			   {
				   String atributo1=tt1.getText();
				   String atributo2=tt2.getText();
				   String atributo3=tt3.getText();
				   String atributo4=tt4.getText();
				   String atributo5=tt5.getText();
				   String atributo6=tt6.getText();
				   String atributo7=tt7.getText();
				   String atributo8=tt8.getText();
				   String atributo9=tt9.getText();
				   String atributo10=tt10.getText();
				   String atributo11=tt11.getText();
				   String atributo12 =tt12.getText();
				   String atributo13=tt13.getText();
  
				   requestedquery ="INSERT INTO SPlanetario values ( "+atributo1 + " , '"+atributo2+"' , '"+ atributo3+"' , '" + atributo4 +"' , "+atributo5+ " , "+atributo6+" , '"+atributo7+"', '"+atributo8+"', "+atributo9+", '"+atributo10+"' , '"+atributo11+"' , "+atributo12 +" , "+atributo13 +" );";
				  System.out.println(requestedquery);
				   if ((atributo1.equals(""))||(atributo2.equals(""))||(atributo3.equals(""))||(atributo4.equals(""))||(atributo13.equals(""))){
					   requestedquery="";
				   }
				   else if (atributo5.equals(""))
				   requestedquery ="INSERT INTO SPlanetario values ( "+atributo1 + " , '"+atributo2+"' , '"+ atributo3+"' , '" + atributo4 + " , NULL, "+atributo6+" , '"+atributo7+"', '"+atributo8+"', "+atributo9+", '"+atributo10+"' , '"+atributo11+"' , "+atributo12 +" , "+atributo13 +" );";
				   else if (atributo6.equals(""))
				   requestedquery ="INSERT INTO SPlanetario values ( "+atributo1 + " , '"+atributo2+"' , '"+ atributo3+"' , '" + atributo4 + " , "+atributo5+" , NULL,"+atributo8+"', "+atributo9+", '"+atributo10+"' , '"+atributo11+"' , "+atributo12 +" , "+atributo13 +" );";
				   else if (atributo7.equals(""))
				   requestedquery ="INSERT INTO SPlanetario values ( "+atributo1 + " , '"+atributo2+"' , '"+ atributo3+"' , '" + atributo4 + " , "+atributo5+" , "+atributo6+" , NULL,"+atributo8+"', "+atributo9+", '"+atributo10+"' , '"+atributo11+"' , "+atributo12 +" , "+atributo13 +" );";
				   else if (atributo8.equals(""))
				   requestedquery ="INSERT INTO SPlanetario values ( "+atributo1 + " , '"+atributo2+"' , '"+ atributo3+"' , '" + atributo4 + " , "+atributo5+" , NULL, "+atributo6+" , '"+atributo7+"', NULL,  "+atributo9+", '"+atributo10+"' , '"+atributo11+"' , "+atributo12 +" , "+atributo13 +" );";
				   else if (atributo9.equals(""))
				   requestedquery ="INSERT INTO SPlanetario values ( "+atributo1 + " , '"+atributo2+"' , '"+ atributo3+"' , '" + atributo4 + " , "+atributo5+" , NULL, "+atributo6+" , '"+atributo7+"', '"+atributo8+"', "+atributo9+", NULL , '"+atributo11+"' , "+atributo12 +" , "+atributo13 +" );";
				   else if (atributo10.equals(""))
				   requestedquery ="INSERT INTO SPlanetario values ( "+atributo1 + " , '"+atributo2+"' , '"+ atributo3+"' , '" + atributo4 + " , "+atributo5+" , NULL, "+atributo6+" , '"+atributo7+"', '"+atributo8+"', "+atributo9+", '"+atributo10+"' , NULL, "+atributo12 +" , "+atributo13 +" );";
				   else if (atributo11.equals(""))
				   requestedquery ="INSERT INTO SPlanetario values ( "+atributo1 + " , '"+atributo2+"' , '"+ atributo3+"' , '" + atributo4 +" , "+atributo5+ " , NULL, "+atributo6+" , '"+atributo7+"', '"+atributo8+"', "+atributo9+", '"+atributo10+"' , '"+atributo11+"' , NULL , "+atributo13 +" );";
				   else if (atributo12.equals(""))
				   requestedquery ="INSERT INTO SPlanetario values ( "+atributo1 + " , '"+atributo2+"' , '"+ atributo3+"' , '" + atributo4 +" , "+atributo5+ " , NULL, "+atributo6+" , '"+atributo7+"', '"+atributo8+"', "+atributo9+", '"+atributo10+"' , '"+atributo11+"' , "+atributo12 +" , NULL"+" );";
				   
			   }
			   else if(event.getSource()==butao12)
			   {
				   requestedquery="select * from splanetario";
			   }
 //-------------------------------------------!!!  QUERY'sConstelações  !!!!----------------			   
			   else if(event.getSource()==butao13)
			   {
				   String pedido=textoconstelacoes1.getText();
				   requestedquery="select * from constelacao where nomeconstelacao="+"'"+pedido+"'";
				   if (pedido.equals(""))
					   requestedquery="";
			   }
			   else if(event.getSource()==butao14)
			   {
				  if(butao14a.isSelected()){
					  requestedquery="select NomeConstelacao,HN from constelacao";
					  		}
				  else if(butao14b.isSelected()){
					 requestedquery="select NomeConstelacao,HS from constelacao";
				  }
				  else
						   requestedquery="";
			   }
			   
			   else if(event.getSource()==butao14_1)
			   {
				   if(butao14a.isSelected()){
					   requestedquery="select count(NomeConstelacao), HN from constelacao group by HN";
				   }
				   else if(butao14b.isSelected()){
					   requestedquery="select count(NomeConstelacao), HS from constelacao group by HS";
				   }
				   else
					   requestedquery="";
			   }
			   else if(event.getSource()==butao15)
			   {

				   String pedido = comboconstelacoes.getSelectedItem().toString();
				   requestedquery="select * from constelacao where familia="+"'"+pedido+"'";
				   if (pedido.equals(""))
					   requestedquery="";
			   }
			   else if(event.getSource()==butao16)
			   {
				  String atributo = deleteconstelacoes.getText();
				  requestedquery="delete from constelacao where NomeConstelacao= '"+atributo+"';";
				  if (atributo.equals(""))
					   requestedquery="";
			   }
			   else if(event.getSource()==butao17)
			   {
				  String atributo1=ttt1.getText();
				  String atributo2=ttt2.getText();
				  String atributo3=ttt3.getText();
				  String atributo4=ttt4.getText();
				  String atributo5=ttt5.getText();
				  String atributo6=ttt6.getText();
				  String atributo7=ttt7.getText();
				  String atributo8=ttt8.getText();
				  String atributo9=ttt9.getText();
				  
				  requestedquery = "INSERT INTO constelacao values ("+ atributo1+" , '"+ atributo2 +"' , '"+atributo3+"' , '"+atributo4+"' , '"+atributo5+"' , '"+atributo6+"' , '"+atributo7+"' , '"+atributo8+"' , '"+atributo9+"' );";
				  if ((atributo1.equals(""))||(atributo2.equals(""))||(atributo3.equals(""))||(atributo4.equals(""))||(atributo5.equals(""))){
					   requestedquery="";
				   }
				   else if (atributo6.equals(""))
					   requestedquery = "INSERT INTO constelacao values ("+ atributo1+" , '"+ atributo2 +"' , '"+atributo3+"' , '"+atributo4+"' , '"+atributo5+"' , NULL, '"+atributo7+"' , '"+atributo8+"' , '"+atributo9+"' );";
				   else if (atributo7.equals(""))
					   requestedquery = "INSERT INTO constelacao values ("+ atributo1+" , '"+ atributo2 +"' , '"+atributo3+"' , '"+atributo4+"' , '"+atributo5+"' , "+ atributo6+ "', NULL , '"+atributo8+"' , '"+atributo9+"' );";
				   else if (atributo8.equals(""))
					   requestedquery = "INSERT INTO constelacao values ("+ atributo1+" , '"+ atributo2 +"' , '"+atributo3+"' , '"+atributo4+"' , '"+atributo5+"' , '"+atributo6+"' , '"+atributo7+"' , NULL , '"+atributo9+"' );";
				   else if (atributo9.equals(""))
					   requestedquery = "INSERT INTO constelacao values ("+ atributo1+" , '"+ atributo2 +"' , '"+atributo3+"' , '"+atributo4+"' , '"+atributo5+"' , '"+atributo6+"' , '"+atributo7+"' , '"+atributo8+"' , NULL );";
				  
			   
			   }
			   else if(event.getSource()==butao18)
			   {
				   requestedquery="select * from constelacao";
				   
			   }
			   //-------------------------------------------!!!  QUERY Telescopio  !!!!----------------	
			   else if(event.getSource()==butao19)
			   {
				   String pedido = textotelescopios1.getText();
				   requestedquery="select * from telescopio where nometelescopio="+"'"+pedido+"'";
				   if (pedido.equals(""))
					   requestedquery="";
				  
			   }
			   else if(event.getSource()==butao20)
			   {
				   String pedidostring1 = textotelescopios2_1.getText();
				   String pedidostring2 = textotelescopios2_2.getText();
				   requestedquery="select * from telescopio where ( abertura > "+pedidostring1+" and "+"abertura < "+pedidostring2+" )";
				   if (pedidostring2.equals(""))
					   requestedquery="";
				   if (pedidostring1.equals("")){
					   requestedquery="select * from telescopio where ( abertura < "+pedidostring2+" )";  
				   }
			   }
			   else if(event.getSource()==butao21)
			   {
				   String atributo =deletetelescopios.getText();
				   requestedquery="Delete from Telescopio where NomeTelescopio= '"+atributo+"';";
				   if (atributo.equals(""))
					   requestedquery="";
			   }
			   else if(event.getSource()==butao22)
			   {
				   String atributo = tttt1.getText();
				   String atributo2 =tttt2.getText();
				   String atributo3 = tttt3.getText();
				   String atributo4 =tttt4.getText();
				   String atributo5 = tttt5.getText();
				   String atributo6 =tttt6.getText();
				   String atributo7 = tttt7.getText();
				   
				   requestedquery ="INSERT INTO Telescopio values("+atributo+" , '"+atributo2+"' , "+atributo3+" , '"+atributo4+"' , '"+atributo5+"' , '"+atributo6+"' , "+atributo7+");";
				   if ((atributo.equals(""))||(atributo2.equals(""))||(atributo3.equals(""))||(atributo4.equals(""))){
					   requestedquery="";
				   }
				   else if (atributo5.equals(""))
					   requestedquery ="INSERT INTO Telescopio values("+atributo+" , '"+atributo2+"' , "+atributo3+" , '"+atributo4+"' , NULL , '"+atributo6+"' , "+atributo7+");";
				   else if (atributo6.equals(""))
					   requestedquery ="INSERT INTO Telescopio values("+atributo+" , '"+atributo2+"' , "+atributo3+" , '"+atributo4+"' , '"+atributo5+"' , NULL , "+atributo7+");";
				   else if (atributo7.equals(""))
					   requestedquery ="INSERT INTO Telescopio values("+atributo+" , '"+atributo2+"' , "+atributo3+" , '"+atributo4+"' , '"+atributo5+"' , '"+atributo6+"' , NULL);";
				   
			   }
			   else if(event.getSource()==butao23)
			   {
				   requestedquery="select * from telescopio";
			   }
			   // -------------------------------------------||| QUERY FOTOS || -------------------------------------
			  // DONE
			   else if(event.getSource()==butao24)
			   {
				   String pedido1 = formato.getSelectedItem().toString();
		
				if (pedido1.equals("ALL")==true){
					pedido1="";
				}
				   
				   String pedido2=listafotos.getSelectedItem().toString();
				   String pedido="";
				   if (pedido2.equals("ALL")==true){
						  pedido="";
				   }
				   if (pedido2.equals("Planetas")==true){
						  pedido="Fotos_has_Planeta";
				   }
				   if (pedido2.equals("Sist.Planetários")==true){
					   pedido="Fotos_has_SPlanetario";
				   }
				   if (pedido2.equals("Constelações")==true){
					   pedido="Fotos_has_Constelacao";
				   }
				   if (pedido2.equals("Galáxias")==true){
					   pedido="Fotos_has_Galaxia";
				   }
				   if (coisito.isSelected()){
					   if (pedido.equals("")==true){
						   if (pedido1.equals("")==true){
							   requestedquery="select * from Fotos where (cores= 1 )";
						   }
						   else{
							   requestedquery="select * from Fotos where (formato= '"+pedido1+"' and cores= 1 )";
						  }
					   }
					else{
						 if (pedido1.equals("")==true){
							   requestedquery="select * from "+pedido +", Fotos where (cores= 1 )";
						   }
					  requestedquery="select * from "+pedido +", Fotos where (formato= '"+pedido1+"' and cores= 1 )";
					   }
				   }	
				   else if(coisito2.isSelected())
				   {
					   if (pedido.equals("")==true){
						   if (pedido1.equals("")==true){
							   requestedquery="select * from Fotos where cores= 0";
						   }
						   else{
						   requestedquery = "select * from Fotos where (formato= '"+pedido1+"' and cores=0)";
						   }
					   }
					   else{
						   if (pedido1.equals("")==true){
							   requestedquery="select * from "+pedido+", Fotos where (cores=0)";
						   }
						   else{
					   requestedquery = "select * from "+pedido+", Fotos where (formato= '"+pedido1+"' and cores=0)";
					    }
					   }
				   }
				   
			   }
			   
			   else if(event.getSource()==butao25)
			   {
				   String atributo1=textoinsernomefoto.getText();
				   String atributo2=textoinserttamanhofoto1.getText()+"X"+textoinserttamanhofoto2.getText();
				   String atributo3=textoinsertformatofoto.getText();
				   String atributo4=textocoresfoto.getText();
				   String atributo5=textoinsertdatafoto.getText();
				   String atributo6=textoinserttelescopiofoto.getText();
				   String atributo7="";
				   for (int i=0; i<tableModel2.getRowCount(); i++){
					   String a=tableModel2.getValueAt(i, 1).toString(); // vê a linha q tem o nome
					  System.out.println(a);
					   if (a.equals(atributo6)){
						   System.out.println("A");
						   atributo7=tableModel2.getValueAt(i, 0).toString(); // dá o id daquele nome
						   break;
				   }
				   }
				   System.out.println(atributo7 +"l");
				   if (atributo7.equals("")){
				   requestedquery=""; 
				   }
			   System.out.println(atributo7);
				   requestedquery ="INSERT INTO Fotos values("+atributo1+" , '"+atributo2+"' , '"+atributo3+"' , "+atributo4+" , '"+atributo5+"' , "+atributo7+");";
				   if ((atributo1.equals(""))||(atributo2.equals(""))||(atributo3.equals(""))||(atributo4.equals(""))||(atributo5.equals(""))||(atributo6.equals(""))){
					   requestedquery="";
				   }
					   
			   }
			   else if(event.getSource()==butao26)
			   {
				   
				   String atributo=textodeletefoto.getText();
				  requestedquery ="Delete from Fotos where idFotos= " +atributo +" ;";
				  if (atributo.equals(""))
					   requestedquery="";
				  
				  
			   }
			  // ------------------------------------|| enviar querys ||------------------------------
               try 
               {
            		 if(event.getSource()==butao1 || event.getSource()==butao2 || event.getSource()==butao3 || event.getSource()==butao6 || event.getSource()==butao7 || event.getSource()==butao8 || event.getSource()==butao9)
            		 {
            			 if (requestedquery.equals("")){
                			 System.out.println("a");
                			 JOptionPane.showMessageDialog(null, "Dados mal inseridos", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
                			 
                		 }
            			 else{
            			 tableModel.setQuery( requestedquery );
            			 JFrame popup= new JFrame("Tabela");
            			 popup.add( resultTable);
            			 popup.add( new JScrollPane( resultTable ), BorderLayout.CENTER );
            			 popup.setSize(450, 250);
            			 popup.setVisible(true);
            			 }
            		 }
            		 else if(event.getSource()==butao12 || event.getSource()==butao13 || event.getSource()==butao14 || event.getSource()==butao14_1 || event.getSource()==butao15 || event.getSource()==butao18 || event.getSource()==butao19 || event.getSource()==butao20 || event.getSource()==butao23 || event.getSource()==butao24)
            		 {
            			 if (requestedquery.equals("")){
                			 JOptionPane.showMessageDialog(null, "Dados mal inseridos", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
                			 
                		 }
            			 else{
            			 tableModel.setQuery( requestedquery );
            			 JFrame popup= new JFrame("Tabela");
            			 popup.add( resultTable);
            			 popup.add( new JScrollPane( resultTable ), BorderLayout.CENTER );
            			 popup.setSize(450, 250);
            			 popup.setVisible(true);
            			 }
            		 }
            		 else if(event.getSource()==butao4|| event.getSource()==butao10|| event.getSource()==butao16|| event.getSource()==butao21|| event.getSource()==butao26){
            			 if (requestedquery.equals("")){
                			 JOptionPane.showMessageDialog(null, "Dados mal inseridos", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
                			 
                		 }
            			 else{
            			 modoinserir.updateQuery(requestedquery);
            			 JOptionPane.showMessageDialog(null, "Delete Complete", "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
            			
            			 }
            		 }
            		 else if(event.getSource()==butao5  || event.getSource()==butao11  || event.getSource()==butao17 || event.getSource()==butao22 || event.getSource()==butao25 )
            		 {
            			 if (requestedquery.equals("")){
            			 JOptionPane.showMessageDialog(null, "Dados mal inseridos", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
            			 
            		 }
            			 else{
            			 modoinserir.updateQuery(requestedquery);
            			 JOptionPane.showMessageDialog(null, "Insert Complete", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
            			 
            		 }
            		 }
            		 
            	
               }
               catch ( SQLException sqlException ) 
               {
                  JOptionPane.showMessageDialog( null, 
                     sqlException.getMessage(), "Database error", 
                     JOptionPane.ERROR_MESSAGE );    
                  
               } 
               
            }   
	   }   

}
