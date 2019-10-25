package analisador;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.Color;

public class Interface extends javax.swing.JFrame { 
    
    public JTextArea jText;
    
   // metodo executar
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
               
                textArea.setText(resultado);
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

    public Interface() {
        initComponents();
        this.setLocationRelativeTo(this);
        Look.definelook(this);
        //setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_analiseLexica = new javax.swing.JLabel();
        lb_entrada = new javax.swing.JLabel();
        btnAnalisar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea1 = new javax.swing.JTextArea();
        btn_analiseSintatica = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaSintatico = new javax.swing.JTextArea();
        btnAnalisarSintatico = new javax.swing.JButton();
        btnLimpar1 = new javax.swing.JButton();
        btnBuscarArquivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_analiseLexica.setBackground(new java.awt.Color(102, 102, 0));
        lb_analiseLexica.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lb_analiseLexica.setForeground(new java.awt.Color(153, 51, 0));
        lb_analiseLexica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_analiseLexica.setText("Análise Léxica");
        lb_analiseLexica.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 171, 134)));

        lb_entrada.setBackground(new java.awt.Color(51, 153, 0));
        lb_entrada.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lb_entrada.setForeground(new java.awt.Color(153, 0, 51));
        lb_entrada.setText("Entrada");
        lb_entrada.setBorder(new javax.swing.border.MatteBorder(null));

        btnAnalisar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAnalisar.setForeground(new java.awt.Color(153, 0, 51));
        btnAnalisar.setText("Analisar");
        btnAnalisar.setBorder(new javax.swing.border.MatteBorder(null));
        btnAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(153, 0, 51));
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(new javax.swing.border.MatteBorder(null));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane3.setViewportView(textArea);

        textArea1.setColumns(20);
        textArea1.setRows(5);
        jScrollPane1.setViewportView(textArea1);

        btn_analiseSintatica.setBackground(new java.awt.Color(102, 102, 0));
        btn_analiseSintatica.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_analiseSintatica.setForeground(new java.awt.Color(153, 51, 0));
        btn_analiseSintatica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_analiseSintatica.setText("Análise Sintática");
        btn_analiseSintatica.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 171, 134)));

        textAreaSintatico.setColumns(20);
        textAreaSintatico.setRows(5);
        jScrollPane2.setViewportView(textAreaSintatico);

        btnAnalisarSintatico.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAnalisarSintatico.setForeground(new java.awt.Color(153, 0, 51));
        btnAnalisarSintatico.setText("Analisar");
        btnAnalisarSintatico.setBorder(new javax.swing.border.MatteBorder(null));
        btnAnalisarSintatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisarSintaticoActionPerformed(evt);
            }
        });

        btnLimpar1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpar1.setForeground(new java.awt.Color(153, 0, 51));
        btnLimpar1.setText("Limpar");
        btnLimpar1.setBorder(new javax.swing.border.MatteBorder(null));
        btnLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar1ActionPerformed(evt);
            }
        });

        btnBuscarArquivo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnBuscarArquivo.setForeground(new java.awt.Color(153, 0, 51));
        btnBuscarArquivo.setText("Arquivo");
        btnBuscarArquivo.setBorder(new javax.swing.border.MatteBorder(null));
        btnBuscarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAnalisarSintatico, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(290, 290, 290))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_analiseSintatica, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnBuscarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_analiseLexica, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(107, 107, 107))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lb_entrada)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_analiseLexica)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_entrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(30, 30, 30)
                .addComponent(btn_analiseSintatica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalisarSintatico, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarActionPerformed
        //chamada do metod executar
        try{
            executar();
        }catch(Exception e)
                {e.printStackTrace();
                }
    }//GEN-LAST:event_btnAnalisarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // ira apenas apagar o que foi inserido nos resultados
        textArea1.setText("");
        textArea.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAnalisarSintaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarSintaticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnalisarSintaticoActionPerformed

    private void btnLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar1ActionPerformed
        // ira apenas apagar o que foi inserido nos resultados
        textAreaSintatico.setText("");
        textAreaSintatico.setText("");
    }//GEN-LAST:event_btnLimpar1ActionPerformed

    private void btnBuscarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArquivoActionPerformed
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
    }//GEN-LAST:event_btnBuscarArquivoActionPerformed

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
    private javax.swing.JButton btnAnalisar;
    private javax.swing.JButton btnAnalisarSintatico;
    private javax.swing.JButton btnBuscarArquivo;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLimpar1;
    private javax.swing.JLabel btn_analiseSintatica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_analiseLexica;
    private javax.swing.JLabel lb_entrada;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextArea textArea1;
    private javax.swing.JTextArea textAreaSintatico;
    // End of variables declaration//GEN-END:variables
}
