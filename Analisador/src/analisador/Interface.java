/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 *
 * @author vitau
 */
public class Interface extends javax.swing.JFrame {
    public JTextArea jText;
      
    /**
     * Creates new form Novo
     */
    public Interface() {
        initComponents();
    }
    
    public void executar()throws Exception{ 
       int cont = 0;     
       
       jText = textArea1;    //recebe o que foi digitado
       String expr;
       //jText = textArea1;
       expr = (String)jText.getText();   //passa o que foi digitado para uma string e armazena na variável "expr"
       Lexer lexer = new Lexer(new StringReader(expr));   //cria um objeto "lexer", que é da classe "Lexer.java" em passamos 
                                                         //a expressão que foi digitada pelo usuário
                                                         //vai fazer a analise e retorna o tipo de "token" que foi inserido, 
                                                         //que foi especificado na classe "Lexer.java"   
       
        System.out.println(expr);                                               
        String resultado="";
     
       while(true){
           Token token = lexer.yylex();
           
           if(token == null){
               
                textArea2.setText(resultado);
                //textArea.setForeground(Color.BLACK);
          
                return;
           }
               //cases para mostrarmos a saida dos tokens 
               switch(token){                
                
                case LINHA:                    
                    cont ++;
                    resultado = resultado + "Linha: " + cont +  "<Linha> " + lexer.lexeme + "\n";     
                break;
                    
                case OP_ARITMETICO:
//                    cont++;
                    resultado = resultado + "Linha: " + cont + "<Operador_Aritmético> "  + lexer.lexeme + "\n"; 
                    break;
                    
                case OPERADOR_LOGICO:
//                    cont ++;
                    resultado = resultado + "Linha: " + cont + "<Operador_Lógico> "  + lexer.lexeme + "\n";
                    break;
                                  
                case OP_RELACIONAL:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Operador_Relacional> " + lexer.lexeme + "\n";
                    break;
                    
                case OP_COMPARACAO:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Operador_Comparacao> " + lexer.lexeme + "\n";
                    break;              
                    
                case OP_BOOLEANO:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Operador_Booleano> " + lexer.lexeme + "\n" ;
                    break;
                    
                case ABRE_PARENTESES:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Abre_Parenteses> " + lexer.lexeme + "\n";
                    break;

                case FECHA_PARENTESES:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Fecha_Parenteses> " + lexer.lexeme + "\n";
                    break;
                    
                case ABRE_COLCHETES:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Abre_Colchetes> " + lexer.lexeme + "\n";
                    break;
                    
                case FECHA_COLCHETES:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Fecha_Colchetes> " + lexer.lexeme + "\n";
                    break;
                    
                case PONTO_VIRGULA:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Ponto_Virgula> " + lexer.lexeme + "\n";
                    break;

                case DOIS_PONTOS:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Dois_Pontos> " + lexer.lexeme + "\n";
                    break;
 
                case VIRGULA:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Virgula> " + lexer.lexeme + "\n";
                    break;

                case PONTO:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Ponto> " + lexer.lexeme + "\n";
                    break;
                    
                case ASPAS_DUPLAS:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Aspas_Duplas> " + lexer.lexeme + "\n";
                    break;
                    
                case ASPAS_SIMPLES:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Aspas_Simples> " + lexer.lexeme + "\n";
                    break;                   
                                        
                case COMENTARIO:
//                    cont++;
                    resultado = resultado + "Linha: " + cont +  "<Comentario> " + lexer.lexeme + "\n";
                    break;
                  
                                                     
                case PRINCIPAL:                    
//                    cont ++;                    
                    resultado = resultado + "Linha: " + cont + "<Inicio_algoritmo>" + lexer.lexeme + "\n";
                    break;
                 
                case FIM:
//                    cont++;
                    resultado = resultado + "Linha: " + cont + "<Fim_algoritmo>" + lexer.lexeme + "\n";
                    break;
                    
                case FUNCAO:
//                    cont++;
                    resultado = resultado + "Linha: " + cont + "<Inicio_bloco>" + lexer.lexeme + "\n";
                    break;        
                    
                case FUNCAO_FIM:
//                    cont++;
                    resultado = resultado + "Linha: " + cont + "<Fim_bloco>" + lexer.lexeme + "\n";
                    break;       
                    
                case SE:
//                    cont ++;
                    resultado = resultado + "Linha: " + cont + "<Inicio_se>" + lexer.lexeme + "\n";
                    break;      
                    
                case SE_FIM:
//                    cont ++;
                    resultado = resultado + "Linha: " + cont + "<Fim_se>" + lexer.lexeme + "\n";
                    break;
                    
               case ESE:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Incio_ese>" + lexer.lexeme + "\n";
                   break;         
                   
               case ESE_FIM:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Fim_ese>" + lexer.lexeme + "\n";
                   break;    
                   
               case SENAO:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Inicio_senao>" + lexer.lexeme + "\n";
                   break;  
                   
               case SENAO_FIM:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Fim_senao>" + lexer.lexeme + "\n";
                   break; 
                   
                case REPETICAO:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Inicio_repeticao>" + lexer.lexeme + "\n";
                   break; 
                   
                case REPETICAO_FIM:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Fim_repeticao>" + lexer.lexeme + "\n";
                   break; 
                 
                case ENQUANTO:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Incio_enquanto>" + lexer.lexeme + "\n";
                   break; 
                   
                case ENQUANTO_FIM:
//                  cont ++;
                  resultado = resultado + "Linha: " + cont + "<Fim_enquanto>" + lexer.lexeme + "\n";
                  break;   
                  
                case ESCREVA:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Escreva>" + lexer.lexeme + "\n";
                   break;  
                   
                case LEIA:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Leia>" + lexer.lexeme + "\n";
                   break; 
                   
                case RETORNA:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Retorna>" + lexer.lexeme + "\n";
                   break;                   
                   
                case IDENTIFICADOR:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Identificador>" + lexer.lexeme + "\n";
                   break;  

                case INTEIRO:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Numero>" + lexer.lexeme + "\n";
                   break;
                   
                case REAL:
//                   cont ++;
                   resultado = resultado + "Linha: " + cont + "<Numero>" + lexer.lexeme + "\n";
                   break;                   
               
                case ERROR:
//                   cont ++;
                   resultado = resultado + "Erro na linha " + cont + ": Símbolo não reconhecido \n" ;   
                   break;           
                   
                default:
//                    cont ++;
                    resultado = resultado + "Linha: " + cont + "<" + lexer.lexeme +">" + cont++;
                    break;                
           }
       }
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainFrame = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        importBtn = new javax.swing.JLabel();
        jLabel915 = new javax.swing.JLabel();
        Sidebar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        compileBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        separator2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea2 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        ComboBox = new javax.swing.JComboBox();
        Sidebar1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        folderIcon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea1 = new javax.swing.JTextArea();
        separator = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IDE | Análisador VAL");
        setPreferredSize(new java.awt.Dimension(1600, 1000));
        setSize(new java.awt.Dimension(1600, 1000));

        MainFrame.setBackground(new java.awt.Color(39, 39, 47));
        MainFrame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(48, 50, 62));
        Header.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codekit");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/terminal.png"))); // NOI18N

        importBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/import.png"))); // NOI18N
        importBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importBtnMouseClicked(evt);
            }
        });

        jLabel915.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/info.png"))); // NOI18N

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1245, Short.MAX_VALUE)
                .addComponent(importBtn)
                .addGap(36, 36, 36)
                .addComponent(jLabel915)
                .addGap(65, 65, 65))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel915))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(importBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MainFrame.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 80));

        Sidebar.setBackground(new java.awt.Color(48, 50, 62));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("COMPILADOR");

        compileBtn.setBackground(new java.awt.Color(80, 147, 240));
        compileBtn.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        compileBtn.setForeground(new java.awt.Color(255, 255, 255));
        compileBtn.setText("COMPILAR");
        compileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compileBtnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(251, 206, 79));
        jPanel1.setPreferredSize(new java.awt.Dimension(189, 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SAÍDA");

        separator2.setBackground(new java.awt.Color(251, 206, 79));
        separator2.setPreferredSize(new java.awt.Dimension(189, 2));
        separator2.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout separator2Layout = new javax.swing.GroupLayout(separator2);
        separator2.setLayout(separator2Layout);
        separator2Layout.setHorizontalGroup(
            separator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        separator2Layout.setVerticalGroup(
            separator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        textArea2.setBackground(new java.awt.Color(60, 65, 84));
        textArea2.setColumns(20);
        textArea2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textArea2.setForeground(new java.awt.Color(255, 255, 255));
        textArea2.setRows(5);
        textArea2.setBorder(null);
        textArea2.setSelectionColor(new java.awt.Color(255, 153, 51));
        jScrollPane1.setViewportView(textArea2);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tipo de Análise");

        ComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Léxica", "Sintática" }));

        javax.swing.GroupLayout SidebarLayout = new javax.swing.GroupLayout(Sidebar);
        Sidebar.setLayout(SidebarLayout);
        SidebarLayout.setHorizontalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidebarLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(SidebarLayout.createSequentialGroup()
                .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SidebarLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2))
                    .addGroup(SidebarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(compileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SidebarLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SidebarLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(220, Short.MAX_VALUE)))
        );
        SidebarLayout.setVerticalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidebarLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(compileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SidebarLayout.createSequentialGroup()
                    .addGap(318, 318, 318)
                    .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(709, Short.MAX_VALUE)))
        );

        MainFrame.add(Sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1191, -30, 410, 1030));

        Sidebar1.setBackground(new java.awt.Color(35, 35, 43));
        Sidebar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(251, 206, 79));
        jPanel2.setPreferredSize(new java.awt.Dimension(3, 38));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Programa Principal");

        folderIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/folder.png"))); // NOI18N

        javax.swing.GroupLayout Sidebar1Layout = new javax.swing.GroupLayout(Sidebar1);
        Sidebar1.setLayout(Sidebar1Layout);
        Sidebar1Layout.setHorizontalGroup(
            Sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sidebar1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(folderIcon)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        Sidebar1Layout.setVerticalGroup(
            Sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sidebar1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(Sidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(folderIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap(858, Short.MAX_VALUE))
        );

        MainFrame.add(Sidebar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ENTRADA");
        MainFrame.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        textArea1.setBackground(new java.awt.Color(60, 65, 84));
        textArea1.setColumns(20);
        textArea1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textArea1.setForeground(new java.awt.Color(255, 255, 255));
        textArea1.setRows(5);
        textArea1.setSelectionColor(new java.awt.Color(255, 153, 51));
        jScrollPane2.setViewportView(textArea1);

        MainFrame.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 830, 790));

        separator.setBackground(new java.awt.Color(251, 206, 79));
        separator.setPreferredSize(new java.awt.Dimension(189, 2));
        separator.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout separatorLayout = new javax.swing.GroupLayout(separator);
        separator.setLayout(separatorLayout);
        separatorLayout.setHorizontalGroup(
            separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );
        separatorLayout.setVerticalGroup(
            separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        MainFrame.add(separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 135, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void importBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importBtnMouseClicked
        try {
            // TODO add your handling code here:
        JFileChooser abrir = new JFileChooser();
        abrir.showOpenDialog(this);
        
        textArea1.setText(abrir.getSelectedFile().getAbsolutePath());
        
        File Arquivo = new File(textArea1.getText());
        String ST = new String(Files.readAllBytes(Arquivo.toPath()));
        textArea1.setText(ST);
        
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_importBtnMouseClicked

    private void compileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compileBtnActionPerformed
        try{
            String value = ComboBox.getSelectedItem().toString();

            if(value.equals("Léxica")){
                executar();
            }

            else{
                textArea2.setText("teste");
            }

        }catch(Exception e)
        {e.printStackTrace();
        }
    }//GEN-LAST:event_compileBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel MainFrame;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JPanel Sidebar1;
    private javax.swing.JButton compileBtn;
    private javax.swing.JLabel folderIcon;
    private javax.swing.JLabel importBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel915;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel separator;
    private javax.swing.JPanel separator2;
    private javax.swing.JTextArea textArea1;
    private javax.swing.JTextArea textArea2;
    // End of variables declaration//GEN-END:variables
}
