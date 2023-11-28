
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    //"jdbc:mysql://localhost:3306/cetim?serverTimezone=UTC";
   static final String database_url = "jdbc:mysql://localhost:3306/cetim?serverTimezone=UTC";
   static final String user = "root";
   static final String pass = "";
//jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC;
   public static void main(String[] args) {
      // Open a connection
      try {
          
          
           Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection(database_url, user, pass);
         Statement stmt = conn.createStatement();
         
         //create database
         String create="CREATE DATABASE IF NOT EXISTS cetim";
         stmt.executeUpdate(create);
         System.out.println("Database created ..."); 
         
         //create departement table
          String sql10 = "CREATE TABLE IF NOT EXISTS Departement " +
                   "(Code VARCHAR(10) , " +
                   " Nom VARCHAR(20) not NULL,"+
                   " PRIMARY KEY ( Code ))";
         stmt.executeUpdate(sql10);
         System.out.println("departement table created ...");  
         
         //create bureau table
          String sql11 = "CREATE TABLE IF NOT EXISTS Bureau " +
                   "(Num_id VARCHAR(10) , " +
                   " Bloc VARCHAR(50) not NULL,"+
                  " Code VARCHAR(10) not NULL,"+
                   " PRIMARY KEY (Num_id ),"+
                    "FOREIGN KEY (Code) REFERENCES Departement (Code))"; 
         stmt.executeUpdate(sql11);
         System.out.println("bureau table created ..."); 
         
          //create fornisseur table
          String sql12 = "CREATE TABLE IF NOT EXISTS Fournisseur " +
                   "(Matricule VARCHAR(10) , " +
                   " Nom VARCHAR(150) not NULL,"+
                   " PRIMARY KEY ( Matricule ))";
         stmt.executeUpdate(sql12);
         System.out.println("fournisseur table created ..."); 
         
          //create technicien table
          String sql13 = "CREATE TABLE IF NOT EXISTS Technicien " +
                   "(ID INT AUTO_INCREMENT , " +
                   " Username VARCHAR(150) not NULL ,"+
                  " Password VARCHAR(30) not NULL ,"+
                  " Admin_id INT ,"+
                  " UNIQUE (Username),"+
                   " PRIMARY KEY ( ID ),"+
                  " FOREIGN KEY (Admin_id) REFERENCES Technicien (Admin_id))" ;
         stmt.executeUpdate(sql13);
         System.out.println("technicien table created ..."); 
         
               //create modele table
          String sql14 = "CREATE TABLE IF NOT EXISTS Modele " +
                   "(Num_Modele INT AUTO_INCREMENT,"+
                  " Code VARCHAR (10) not NULL , " +
                   " Nom VARCHAR(50) not NULL ,"+
                  " Admin_id  INT ,"+
                   " PRIMARY KEY ( Num_Modele ),"+
                  " FOREIGN KEY (Admin_id) REFERENCES Technicien (Admin_id))" ;
         stmt.executeUpdate(sql14);
         System.out.println("modele table created ..."); 

          
          //create camera table
         /* String sql = "CREATE TABLE IF NOT EXISTS Camera " +
                   "(Code_barre VARCHAR(10),  " +
                   " Modele VARCHAR(150) not NULL, " + 
                   " Date_Acquisition DATE not NULL, " + 
                   " Statu VARCHAR(20) not NULL, " + 
                  " Reformé BOOLEAN not NULL, " +
                  " IPadress VARCHAR(50) not NULL, " +
                  " MACaddress VARCHAR(50) not NULL, " +
                  " Num_id VARCHAR(10) not NULL, " +
                  " Matricule VARCHAR(10) not NULL, " +
                   " PRIMARY KEY ( Code_barre ),"+
                  " FOREIGN KEY (Num_id) REFERENCES Bureau (Num_id)," +
                   "FOREIGN KEY (Matricule) REFERENCES Founisseur (Matricule))"; 
         stmt.executeUpdate(sql);
         System.out.println("camera table created ...");  
         
         
                   //create imprimante table
          String sql1 = "CREATE TABLE IF NOT EXISTS Imprimante " +
                   "(Code_barre VARCHAR(10),  " +
                   " Modele VARCHAR(150) not NULL, " + 
                   " Date_Acquisition DATE not NULL, " + 
                   " Statu VARCHAR(20) not NULL, " + 
                  " Reformé BOOLEAN not NULL, " +
                  " IPadress VARCHAR(50) not NULL, " +
                  " MACaddress VARCHAR(50) not NULL, " +
                  " Num_id VARCHAR(10) not NULL, " +
                  " Matricule VARCHAR(10) not NULL, " +
                   " PRIMARY KEY ( Code_barre ),"+
                  " FOREIGN KEY (Num_id) REFERENCES Bureau (Num_id)," +
                   "FOREIGN KEY (Matricule) REFERENCES Founisseur (Matricule))"; 
         stmt.executeUpdate(sql1);
         System.out.println("imprimante table created ...");  
         
                   //create scanner table
              //create camera table
          String sql2 = "CREATE TABLE IF NOT EXISTS Scanner " +
                   "(Code_barre VARCHAR(10),  " +
                   " Modele VARCHAR(150) not NULL, " + 
                   " Date_Acquisition DATE not NULL, " + 
                   " Statu VARCHAR(20) not NULL, " + 
                  " Reformé BOOLEAN not NULL, " +
                  " IPadress VARCHAR(50) not NULL, " +
                  " MACaddress VARCHAR(50) not NULL, " +
                  " Num_id VARCHAR(10) not NULL, " +
                  " Matricule VARCHAR(10) not NULL, " +
                   " PRIMARY KEY ( Code_barre ),"+
                  " FOREIGN KEY (Num_id) REFERENCES Bureau (Num_id)," +
                   "FOREIGN KEY (Matricule) REFERENCES Founisseur (Matricule))"; 
         stmt.executeUpdate(sql2);
         System.out.println("scanner table created ...");  
         
                   //create router table
          String sql3 = "CREATE TABLE IF NOT EXISTS Router " +
                   "(Code_barre VARCHAR(10) , " +
                   " Modele VARCHAR(150) not NULL, " + 
                   " Date_Acquisition DATE not NULL, " + 
                   " Statu VARCHAR(20) not NULL, " + 
                  " Reformé BOOLEAN not NULL, " +
                  " IPadress VARCHAR(50) not NULL, " +
                  " MACaddress VARCHAR(50) not NULL, " +
                  " Num_id VARCHAR(10) not NULL, " +
                  " Matricule VARCHAR(10) not NULL, " +
                   " PRIMARY KEY ( Code_barre ),"+
                  " FOREIGN KEY (Num_id) REFERENCES Bureau (Num_id)," +
                   "FOREIGN KEY (Matricule) REFERENCES Founisseur (Matricule))"; 
         stmt.executeUpdate(sql3);
         System.out.println("router table created ...");
         
                   //create onduleur table
          String sql4 = "CREATE TABLE IF NOT EXISTS Onduleur " +
                   "(Code_barre VARCHAR(10) , " +
                   " Modele VARCHAR(150) not NULL, " + 
                   " Date_Acquisition DATE not NULL, " + 
                   " Statu VARCHAR(20) not NULL, " + 
                  " Reformé BOOLEAN not NULL, " +
                  " IPadress VARCHAR(50) not NULL, " +
                  " MACaddress VARCHAR(50) not NULL, " +
                  " Num_id VARCHAR(10) not NULL, " +
                  " Matricule VARCHAR(10) not NULL, " +
                   " PRIMARY KEY ( Code_barre ),"+
                  " FOREIGN KEY (Num_id) REFERENCES Bureau (Num_id)," +
                   "FOREIGN KEY (Matricule) REFERENCES Founisseur (Matricule))"; 
         stmt.executeUpdate(sql4);
         System.out.println("onduleur table created ...");
         
                   //create telephone_portable table
          String sql5 = "CREATE TABLE IF NOT EXISTS Telephone_Portable " +
                   "(Code_barre VARCHAR(10) , " +
                   " Modele VARCHAR(150) not NULL, " + 
                   " Date_Acquisition DATE not NULL, " + 
                   " Statu VARCHAR(20) not NULL, " + 
                  " Reformé BOOLEAN not NULL, " +
                  " IPadress VARCHAR(50) not NULL, " +
                  " MACaddress VARCHAR(50) not NULL, " +
                  " Num_id VARCHAR(10) not NULL, " +
                  " Matricule VARCHAR(10) not NULL, " +
                   " PRIMARY KEY ( Code_barre ),"+
                  " FOREIGN KEY (Num_id) REFERENCES Bureau (Num_id)," +
                   "FOREIGN KEY (Matricule) REFERENCES Founisseur (Matricule))"; 
         stmt.executeUpdate(sql5);
         System.out.println("telephone_portable table created ...");
         
                   //create poste_telephone table
          String sql6 = "CREATE TABLE IF NOT EXISTS Poste_telephone " +
                   "(Code_barre VARCHAR(10) , " +
                   " Modele VARCHAR(150) not NULL, " + 
                   " Date_Acquisition DATE not NULL, " + 
                   " Statu VARCHAR(20) not NULL, " + 
                  " Reformé BOOLEAN not NULL, " +
                  " IPadress VARCHAR(50) not NULL, " +
                  " MACaddress VARCHAR(50) not NULL, " +
                  " Num_id VARCHAR(10) not NULL, " +
                  " Matricule VARCHAR(10) not NULL, " +
                   " PRIMARY KEY ( Code_barre ),"+
                  " FOREIGN KEY (Num_id) REFERENCES Bureau (Num_id)," +
                   "FOREIGN KEY (Matricule) REFERENCES Founisseur (Matricule))"; 
         stmt.executeUpdate(sql6);
         System.out.println("poste_telephone table created ...");
         
                   //create pc_bureau table
          String sql7 = "CREATE TABLE IF NOT EXISTS PC_Bureau " +
                   "(Code_barre VARCHAR(10) , " +
                   " Modele VARCHAR(150) not NULL, " + 
                   " Date_Acquisition DATE not NULL, " + 
                   " Statu VARCHAR(20) not NULL, " + 
                  " Reformé BOOLEAN not NULL, " +
                  " IPadress VARCHAR(50) not NULL, " +
                  " MACaddress VARCHAR(50) not NULL, " +
                  " Carte_Graphique VARCHAR(100) not NULL, " +
                  " RAM VARCHAR(10) not NULL, " +
                  " Disque_Dur VARCHAR(10) not NULL, " +
                  " SystemeType VARCHAR(50) not NULL, " +
                  " Processuer VARCHAR(100) not NULL, " +
                  " Systeme_Exploitation VARCHAR(50) not NULL, " +
                  " Domaine VARCHAR(50) not NULL, " +
                  " Num_id VARCHAR(10) not NULL, " +
                  " Matricule VARCHAR(10) not NULL, " +
                   " PRIMARY KEY ( Code_barre ),"+
                  " FOREIGN KEY (Num_id) REFERENCES Bureau (Num_id)," +
                   "FOREIGN KEY (Matricule) REFERENCES Founisseur (Matricule))"; 
         stmt.executeUpdate(sql7);
         System.out.println("pc_bureau table created ...");
         
                      //create pc_portable table
          String sql8 = "CREATE TABLE IF NOT EXISTS PC_Portable " +
                   "(Code_barre VARCHAR(10) , " +
                   " Modele VARCHAR(150) not NULL, " + 
                   " Date_Acquisition DATE not NULL, " + 
                   " Statu VARCHAR(20) not NULL, " + 
                  " Reformé BOOLEAN not NULL, " +
                  " IPadress VARCHAR(50) not NULL, " +
                  " MACaddress VARCHAR(50) not NULL, " +
                  " Carte_Graphique VARCHAR(100) not NULL, " +
                  " RAM VARCHAR(10) not NULL, " +
                  " Disque_Dur VARCHAR(10) not NULL, " +
                  " SystemeType VARCHAR(50) not NULL, " +
                  " Processuer VARCHAR(100) not NULL, " +
                  " Systeme_Exploitation VARCHAR(50) not NULL, " +
                  " Domaine VARCHAR(50) not NULL, " +
                  " Num_id VARCHAR(10) not NULL, " +
                  " Matricule VARCHAR(10) not NULL, " +
                   " PRIMARY KEY ( Code_barre ),"+
                  " FOREIGN KEY (Num_id) REFERENCES Bureau (Num_id)," +
                   "FOREIGN KEY (Matricule) REFERENCES Founisseur (Matricule))"; 
         stmt.executeUpdate(sql8);
         System.out.println("pc_portable table created ...");
         
                      //create serveur table
          String sql9 = "CREATE TABLE IF NOT EXISTS Serveur " +
                   "(Code_barre VARCHAR(10) , " +
                   " Modele VARCHAR(150) not NULL, " + 
                   " Date_Acquisition DATE not NULL, " + 
                   " Statu VARCHAR(20) not NULL, " + 
                  " Reformé BOOLEAN not NULL, " +
                  " IPadress VARCHAR(50) not NULL, " +
                  " MACaddress VARCHAR(50) not NULL, " +
                  " Carte_Graphique VARCHAR(100) not NULL, " +
                  " RAM VARCHAR(10) not NULL, " +
                  " Disque_Dur VARCHAR(10) not NULL, " +
                  " SystemeType VARCHAR(50) not NULL, " +
                  " Processuer VARCHAR(100) not NULL, " +
                  " Systeme_Exploitation VARCHAR(50) not NULL, " +
                  " Domaine VARCHAR(50) not NULL, " +
                  " Num_id VARCHAR(10) not NULL, " +
                  " Matricule VARCHAR(10) not NULL, " +
                   " PRIMARY KEY ( Code_barre ),"+
                  " FOREIGN KEY (Num_id) REFERENCES Bureau (Num_id)," +
                   "FOREIGN KEY (Matricule) REFERENCES Founisseur (Matricule))"; 
         stmt.executeUpdate(sql9);
         
         String query50;
           query50= "ALTER TABLE Fournisseur "
                   + "MODIFY Matricule INT AUTO_INCREMENT "
                   + "AFTER Nom ";
           
           stmt.execute(query50);
         
         String query15;
           query15 = "ALTER TABLE Camera "
                   + "ADD Marque VARCHAR(50) "
                   + "AFTER Modele "
                   ;
           
           stmt.execute(query15);
           
           String query16;
           query16 = "ALTER TABLE Imprimante "
                   + "ADD Marque VARCHAR(50) "
                   + "AFTER Modele ";
           
           stmt.execute(query16);
           
           String query17;
           query17 = "ALTER TABLE Scanner "
                   + "ADD Marque VARCHAR(50) "
                   + "AFTER Modele ";
           
           stmt.execute(query17);
           
           String query18;
           query18 = "ALTER TABLE Router "
                   + "ADD Marque VARCHAR(50) "
                   + "AFTER Modele ";
           
           stmt.execute(query18);
           
           String query19;
           query19 = "ALTER TABLE Onduleur "
                   + "ADD Marque VARCHAR(50) "
                   + "AFTER Modele ";
           
           stmt.execute(query19);
           
           String query20;
           query20 = "ALTER TABLE Telephone_Portable "
                   + "ADD Marque VARCHAR(50) "
                   + "AFTER Modele ";
           
           stmt.execute(query20);
           
           String query21;
           query21 = "ALTER TABLE Poste_telephone "
                   + "ADD Marque VARCHAR(50) "
                   + "AFTER Modele ";
           
           stmt.execute(query21);
           
           String query22;
           query22 = "ALTER TABLE PC_Bureau "
                   + "ADD Marque VARCHAR(50) "
                   + "AFTER Modele ";
           
           stmt.execute(query22);
           
           String query23;
           query23= "ALTER TABLE PC_Portable "
                   + "ADD Marque VARCHAR(50) "
                   + "AFTER Modele ";
           
           stmt.execute(query23);
           
           String query24;
           query24 = "ALTER TABLE Serveur "
                   + "ADD Marque VARCHAR(50) "
                   + "AFTER Modele ";
           
           stmt.execute(query24);
           
           String query25;
           query25 = "ALTER TABLE Camera "
                   + "MODIFY MACaddress VARCHAR(50) "
                   + "AFTER IPadress ";
           
           stmt.execute(query25);
           
           String query26;
           query26 = "ALTER TABLE Imprimante "
                   + "MODIFY MACaddress VARCHAR(50) "
                   + "AFTER IPadress ";
           
           stmt.execute(query26);
           
           String query27;
           query27 = "ALTER TABLE Scanner "
                   + "MODIFY MACaddress VARCHAR(50) "
                   + "AFTER IPadress ";
           
           stmt.execute(query27);
           
           String query28;
           query28 = "ALTER TABLE Router "
                   + "MODIFY MACaddress VARCHAR(50) "
                   + "AFTER IPadress ";
           
           stmt.execute(query28);
           
           String query29;
           query29 = "ALTER TABLE Onduleur "
                   + "MODIFY MACaddress VARCHAR(50) "
                   + "AFTER IPadress ";
           
           stmt.execute(query29);
           
           String query30;
           query30 = "ALTER TABLE Telephone_Portable "
                   + "MODIFY MACaddress VARCHAR(50) "
                   + "AFTER IPadress ";
           
           stmt.execute(query30);
           
           String query31;
           query31 = "ALTER TABLE Poste_telephone "
                   + "MODIFY MACaddress VARCHAR(50) "
                   + "AFTER IPadress ";
           
           stmt.execute(query31);
           
           String query32;
           query32 = "ALTER TABLE PC_Bureau "
                   + "MODIFY MACaddress VARCHAR(50) "
                   + "AFTER IPadress ";
           
           stmt.execute(query32);
           
           String query33;
           query33= "ALTER TABLE PC_Portable "
                   + "MODIFY MACaddress VARCHAR(50) "
                   + "AFTER IPadress ";
           
           stmt.execute(query33);
           
          
           
           String query34;
           query34 = "ALTER TABLE Serveur "
                   + "MODIFY MACaddress VARCHAR(50) "
                   + "AFTER IPadress ";
           
           stmt.execute(query34);
           
           
           String query35;
           query35 = "ALTER TABLE Camera "
                   + "DROP COLUMN IPadress ";
           
           stmt.execute(query35);
           
           String query36;
           query36 = "ALTER TABLE Imprimante "
                   + "DROP COLUMN IPadress ";
           
           stmt.execute(query36);
           
           String query37;
           query37 = "ALTER TABLE Scanner "
                   + "DROP COLUMN IPadress ";
           
           stmt.execute(query37);
           
           String query38;
           query38 = "ALTER TABLE Router "
                   + "DROP COLUMN IPadress ";
           
           stmt.execute(query38);
           
           String query39;
           query39 = "ALTER TABLE Onduleur "
                   + "DROP COLUMN IPadress ";
           
           stmt.execute(query39);
           
           String query40;
           query40 = "ALTER TABLE Telephone_Portable "
                   + "DROP COLUMN IPadress ";
           
           stmt.execute(query40);
           
           String query41;
           query41 = "ALTER TABLE Poste_telephone "
                   + "DROP COLUMN IPadress ";
           
           stmt.execute(query41);
           
           String query42;
           query42 = "ALTER TABLE PC_Bureau "
                   + "DROP COLUMN IPadress ";
           
           stmt.execute(query42);
           
           String query43;
           query43= "ALTER TABLE PC_Portable "
                   + "DROP COLUMN IPadress ";
           
           stmt.execute(query43);
           
           String query44;
           query44 = "ALTER TABLE Serveur "
                   + "DROP COLUMN IPadress ";
           
           stmt.execute(query44);*/
         System.out.println("pc_serveur table created ...");
} catch (Exception e) {
        e.printStackTrace();
}
    }
    
}

