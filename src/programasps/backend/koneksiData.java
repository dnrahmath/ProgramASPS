/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programasps.backend;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.SQLException;

import static programasps.backend.koneksiData.DB_URL;
import static programasps.backend.koneksiData.JDBC_DRIVER;
import static programasps.backend.koneksiData.PASS;
import static programasps.backend.koneksiData.USER;
import static programasps.backend.koneksiData.conn;
import static programasps.backend.koneksiData.rs;
//import static programasps.backend.koneksiData.pstmt;
import static programasps.backend.koneksiData.stmt;

/**
 *
 * @author dnrahmath
 */
public class koneksiData {
    
    
    // Menyiapkan paramter JDBC untuk koneksi ke datbase
    static final String USER = "root";
    static final String PASS = "";
    static final String DB_NAME = "perpustakaan";
    static final String DB_URL = "jdbc:mysql://localhost/"+DB_NAME;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    //static PreparedStatement pstmt;
    static Statement stmt;
    static ResultSet rs;
    
    //jumlah array diCustom dari backend
    static final int TotalArrayClass = 10000;
    
    
    

    public static void main(String[] args) {
        /*
        String colDb = "id"; //pilihan colom
        String colDbs = "1"; //target
        String nmTbl = "tbl_buku";
        //String sqlString = "SELECT * FROM "+nmTbl+" WHERE "+colDb+"="+colDbs;
        
        
        int valKeAwal = 0; //awal data yg ingin ditampilkan
        int valKeAkhir = 100; // jumlah data yg ingin ditampilkan
        
        int id = 1;
   
        
        //"tbl_buku"
        String listColmn[]= { "id","nama","judul_buku","penulis","penerbit","tahun"};
        String listColmnRow[]= { "1","agus","qwerty","sertu","ciputra","2019"};
        
        //"tbl_kotakSaran"
        //String listColmn[]= { "id","nama","saran","tanggal"};
        //String listColmnRow[]= { "idss","nama saran","saran aku","2001"};
        
        //"tbl_pengumuman"
        //String listColmn[]= { "id","nama","pengumuman","tanggal"};
        //String listColmnRow[]= { "1","dia","GELAP","2001"};
        
        
        
        //Execute Query ---------------------------------------------------------------------------------------
        
        //cSelectOne
        String dataAllEQ[][]= cSelectOne("tbl_buku",listColmn,100,"id","45");   //Work - [namaTabel,Colom,initialSemuaArray,Target,TargetSource]
        
        //cSelectAll
        //String dataAllEQ[][]= cSelectAll("tbl_buku",listColmn,0,5,100);   //Work - [namaTabel,Colom,AwalDataBukanID,AkhirDataBukanID,initialSemuaArray]
        
        
        
        //Execute Update ---------------------------------------------------------------------------------------
        
        //cDeleteOne
        //String dataAllEU[][]= cDeleteOne("tbl_buku","id","19");   //Work
        
        //cDeleteAll
        //String dataAllEU[][]= cDeleteAll("tbl_buku");   //Work
        
        //----
        
        //cInsert
        //String dataAllEU[][]= cInsert("tbl_buku",listColmn,listColmnRow);
        
        //cUpdate
        String dataAllEU[][]= cUpdate("tbl_buku",listColmn,listColmnRow,"id","45");
        
        
        
        
        
        
        
        
        //hasil Execute ----------------------------------------------------------------------------------------
        System.out.println("Data Execute Update: " + dataAllEU[0][0]);
        
        
        
        //output data dari sql-----------------------------------------------
        //int valKeAwal = 0;
        
        
        for (int i = 0; i < dataAllEQ.length; i++) {
            for (int j = 0; j < dataAllEQ[i].length; j++) {
                System.out.println("Data Row ke - "+i+" = " + dataAllEQ[i][j]);
            }
        }
        */
        
        
        
        /*-------------------------------------------------------------------*/
        
        
        
    }
        
        

    /*  Array Data POST/GET  */

    /*
    SqlInsert - String sql ="INSERT INTO list_obat VALUES ("+id_obat+",'"+nama_obat+"', '"+kandungan+"');";
    SqlUpdate - String sql ="UPDATE list_obat SET nama_obat='"+nama_obat+"',kandungan='"+kandungan+"' WHERE id_obat="+id_obat+";";
    SqlDelete - String sql = "DELETE FROM list_obat WHERE id_obat="+id_obat+";";
	
    SqlSelect - 
    Statement st=conn.createStatement();        
    ResultSet rs=st.executeQuery("SELECT * FROM list_obat;");
    */



    /*
    create 	(POST)
    updateById 	(GET and POST)
    -
    findAll 	(GET All)
    findOne 	(GET One)
    removeAll	(DEL All)
    removeOne	(DEL One)
    */
        
    
    
    /*-------------------------------------------------------------------*/
    /*-------------------------------------------------------------------*/
      
    
    public static String[][] mColmnArr(String[] listColmn,int totalArray)  
    {   
        //int totalData = 1; /*data[0][0] dibaca data pertama 1*/
        //-------------------------------------------------------------------------
        String nmCol[]= listColmn;
        //System.out.println("colom nama = "+nmCol[3]);
        //System.out.println("total colom = "+nmCol.length);
                
        //int totalData = totalArray; //Jumlah diCustom dari frontend
        int totalData = TotalArrayClass; //Jumlah diCustom dari backend
        
        String dataColmn[][]=new String[totalData][nmCol.length]; //data[Data-Array yg diterima][kolom] 
        /*-------------------------------------------------------------------------------------------------------------*/
             
	return dataColmn;  
    }  

    
    /*-------------------------------------------------------------------*/
    /*-------------------------------------------------------------------*/
    /*-------------------------------------------------------------------*/
    /*-------------------------------------------------------------------*/
    /*-------------------------------------------------------------------*/
    /*-------------------------------------------------------------------*/

    
    public static String[][] mGetSqlEQ(String[] sqlString,String nmTbl,String[] listColmn,int valKeAwal,int valKeAkhir,int ArrayTotal,int option){  //ExecuteQuery
       
        //int totalData = 1; /*data[0][0] dibaca data pertama*/
        String nmCol[]= listColmn; //dimasukkan seluruh data colom
        
        String dataSql[][]= mColmnArr(listColmn,ArrayTotal); //data[list column][totalData yg ditampilkan] 
        //baru membuat array dengan total data 10 - masih proses -
        /*-------------------------------------------------------------------------------------------------------------*/
            
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_UPDATABLE);
            
            /*--------------------------------------------------------------------------------*/
            
//            String[] sql = sqlString;
//            for (int i = 0; i < sqlString.length; i++) {
//                stmt.addBatch(sqlString[i]);
//            }
//            stmt.executeBatch();
            rs = stmt.executeQuery(sqlString[0]);
            
            /*--------------------------------------------------------------------------------*/
                
            //System.out.println("----------------------");
            int berhitung=0;
            while(rs.next()){
                    
                int berhitungCol = 0;
                while(berhitungCol != nmCol.length){
                    dataSql[berhitung][berhitungCol] = rs.getString(nmCol[berhitungCol]);
                    berhitungCol += 1;
                }
                   
                berhitung = berhitung + 1;
                    
            }
            
            /*--------------------------------------------------------------------------------*/
            
            
            stmt.close();
            conn.close();
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
        //menghilangkan data Null ----------------------------------------------
        int iNull = 0;
        int arrNotNull = 0;
        
        for (int i = 0; i < ArrayTotal; i++) {
            if(dataSql[i][0] == null){//tidak akan menghasilkan hasil null
                //dataAll[valKeAwal][0] = "";
                iNull = iNull + 1;
            }else{}
        }
        arrNotNull = ArrayTotal - iNull;
            
        //----------------------------------------------------------------------
            
        //membuat Array baru dengan isi bukan NULL
        String dataParse[][]= new String[arrNotNull][listColmn.length]; 
        
        
        
        for (int i = 0; i < arrNotNull; i++) {
            for (int j = 0; j < listColmn.length; j++) {
                dataParse[i][j] = dataSql[i][j];
                //System.out.println(i+"dan"+j+dataParse[i][j]);
            }
        }
        
        
        //menghilangkan data Null ----------------------------------------------
        
        
        
        //sering terjadi error maka harus penempatan valKeAkhir = 1
        // Awal - menampilkan hanya rentang antara valKeAwal dan valKeAkhir -------
        String dataAkhir[][]= new String[valKeAkhir][listColmn.length];
        
        
        //pilihan output keluar
        String[][] forReturn = dataParse;
        if(option == 1){
            for (int i = 0; i < valKeAkhir; i++) {
                for (int j = 0; j < listColmn.length; j++) {
                    dataAkhir[i][j] = dataParse[i+valKeAwal][j]; //menampilkan dari titik awal
                    //System.out.println(i+"dan"+j+dataAkhir[i][j]);
                }
            }
            forReturn = dataAkhir; //untuk selectOne
        }
        
        else {
            for (int i = 0; i < arrNotNull; i++) {
                for (int j = 0; j < listColmn.length; j++) {
                    dataAkhir[i][j] = dataParse[i+valKeAwal][j]; //menampilkan dari titik awal
                    //System.out.println(i+"dan"+j+dataAkhir[i][j]);
                }
            }
            forReturn = dataAkhir; //untuk selectAll
        }
        
        
        return forReturn; 
            
    }

    
/*----------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------*/

    
     
    public static String[][] cSelectOneLogin(String nmTbl,String[] listColmn,int totalArray,String colDb,String colDbs,String colDbPass)  
        {   
            //-------------------------------------------------------------------------
            
            String[] sqlString=new String[1];
            sqlString[0] = "SELECT * FROM "+nmTbl+" WHERE "+colDb+"='"+colDbs+"' AND password='"+colDbPass+"'";
            
            int valKeAwal = 0;
            int valKeAkhir = 1;
            
            
            // Awal - Handle Error ----------------------------------------------------------------------------------
            try {
                String dataQuery[][]= mGetSqlEQ(sqlString,nmTbl,listColmn,valKeAwal,valKeAkhir,totalArray,1);
                return dataQuery;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
                String dataQuery[][]=new String[1][listColmn.length]; 
                dataQuery[0][0]="err";
                dataQuery[0][1]="Terjadi Kesalahan. Data Tidak diTemukan !";
                   
                return dataQuery;
            }
            // Akhir - Handle Error ---------------------------------------------------------------------------------- 
        }  
    
    
    
     
    public static String[][] cSelectAll(String nmTbl,String[] listColmn)  
        {   
            //-------------------------------------------------------------------------
            String[] sqlString=new String[1];
            sqlString[0] =  "SELECT * FROM "+nmTbl;
            //ditambah option
            
            // Awal - Handle Error ----------------------------------------------------------------------------------
            
            int TotalArray = TotalArrayClass; //Jumlah diCustom dari backend
            int valKeAwal = 0;
            int jmlhTampil =TotalArrayClass;
            try {
                String dataQuery[][]= mGetSqlEQ(sqlString,nmTbl,listColmn,valKeAwal,jmlhTampil,TotalArray,0);
                //System.out.println(dataQuery[0][0]);
                return dataQuery;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
                String dataQuery[][]={{"Terjadi Kesalahan. Data Tidak diTemukan !"},
                                      {"err"}
                };
                return dataQuery;
            }
            // Akhir - Handle Error ----------------------------------------------------------------------------------
            
        }  
    
            
        
        public static String[][] cSelectOne(String nmTbl,String[] listColmn,int totalArray,String colDb,String colDbs)
        {   
            //-------------------------------------------------------------------------
            String[] sqlString=new String[1];
            sqlString[0] = "SELECT * FROM "+nmTbl+" WHERE "+colDb+"='"+colDbs+"'";
            
            int valKeAwal = 0;
            int valKeAkhir = 1;
            
            
            // Awal - Handle Error ----------------------------------------------------------------------------------
            try {
                String dataQuery[][]= mGetSqlEQ(sqlString,nmTbl,listColmn,valKeAwal,valKeAkhir,totalArray,1);
                return dataQuery;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
                String dataQuery[][]=new String[1][listColmn.length]; 
                dataQuery[0][0]="err";
                dataQuery[0][1]="Terjadi Kesalahan. Data Tidak diTemukan !";
                   
                return dataQuery;
            }
            // Akhir - Handle Error ---------------------------------------------------------------------------------- 
        }  
    
        
        public static String[][] cSelectOneDef(String nmTbl,String[] listColmn,int totalArray,String[] colDb,String[] colDbs)
        {   
            //-------------------------------------------------------------------------
            String[] sqlString=new String[1];
            //sqlString[0] = "SELECT * FROM "+nmTbl+" WHERE "+colDb+"='"+colDbs+"'";
            
            sqlString[0] = "SELECT * FROM "+nmTbl+" WHERE "+colDb[0]+"='"+colDbs[0]+"";
            if(2<colDb.length){ //array[0] dihitung 1
                for(int i=1; i<colDb.length; i++){
                    sqlString[0] += "AND"+colDb[i]+"='"+colDbs[i]+"";
                }
            }
            sqlString[0] += "'";

            int valKeAwal = 0;
            int valKeAkhir = totalArray;
            
            
            // Awal - Handle Error ----------------------------------------------------------------------------------
            try {
                String dataQuery[][]= mGetSqlEQ(sqlString,nmTbl,listColmn,valKeAwal,valKeAkhir,totalArray,0);
                return dataQuery;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
                String dataQuery[][]=new String[1][listColmn.length]; 
                dataQuery[0][0]="err";
                dataQuery[0][1]="Terjadi Kesalahan. Data Tidak diTemukan !";
                   
                return dataQuery;
            }
            // Akhir - Handle Error ---------------------------------------------------------------------------------- 
        }  
    
    
    
    
/*----------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------*/
    
    
    
    
    
    public static String[][] mGetSqlEU(String[] sqlString){  //ExecuteUpdate
       
        /*-------------------------------------------------------------------------------------------------------------*/
        
        String info[][]=new String[1][1]; //banyaknya data 1
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            
            if (conn != null) {
                stmt = conn.createStatement();  
                
                // [=+=] mengganti Update menjadi Batch agar bisa multiple - walaupun tidak bisa ResultSet [=+=]
//              String sql = sqlString; //SQL-DELETE
                for (int i = 0; i < sqlString.length; i++) {
                    stmt.addBatch(sqlString[i]);
                }
//              stmt.executeBatch();
//              stmt.executeUpdate (sql);
                System.out.println(sqlString[0]);
                stmt.executeUpdate(sqlString[0]);

                info[0][0] = "data berhasil dieksekusi";
                conn.close();
            }
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return info;
            
    }
    
    
     
    public static String[][] cDeleteOne(String nmTbl,String colDb,String colDbTarget)  
        {   
            //-------------------------------------------------------------------------
            String[] sqlString=new String[1];
            sqlString[0] = "DELETE FROM "+nmTbl+" WHERE "+colDb+"='"+colDbTarget+"'";
            
            
            // Awal - Handle Error ----------------------------------------------------------------------------------
            try {
                String dataQuery[][]= mGetSqlEU(sqlString);
                return dataQuery;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
                String dataQuery[][]={
                    {"err"},
                    {"Terjadi Kesalahan. Data Tidak diTemukan !"}
                    }; 
                return dataQuery;
            }  
            // Akhir - Handle Error ----------------------------------------------------------------------------------    
        }
    
    public static String[][] cDeleteAll(String nmTbl)  
        {   
            //-------------------------------------------------------------------------
            String[] sqlString=new String[1];
            sqlString[0] = "DELETE FROM "+nmTbl;
            
            
            // Awal - Handle Error ----------------------------------------------------------------------------------
            try {
                String dataQuery[][]= mGetSqlEU(sqlString);
                return dataQuery;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
                String dataQuery[][]={
                    {"err"},
                    {"Terjadi Kesalahan. Data Tidak diTemukan !"}
                    }; 
                return dataQuery;
            }  
            // Akhir - Handle Error ----------------------------------------------------------------------------------       
        }
    
    
    
    
    /*----------------------------------------------------------------------------------------------------*/
    
    
    
    
    public static String[][] cInsert(String nmTbl,String[] listColmn,String[] listColmnRow)  
        {   
            
            
            //Awal - membuat Array baru dengan isi colom dan isi -----------------------------------------
            String dataAll[][]= new String[listColmnRow.length][listColmn.length]; //[isi,colom]
            
            
            for (int j = 0; j < listColmn.length; j++) {
                dataAll[0][j] = listColmn[j];  //colom
                dataAll[1][j] = listColmnRow[j];  //isi
            }
            //Akhir - membuat Array baru dengan isi colom dan isi -----------------------------------------
            
            
            
            
            /*
            String sqlString = 
                    "INSERT INTO perpustakaan.tbl_buku (`"
                    +dataAll[0][0]+"`,`"
                    +dataAll[0][1]+"`,`"
                    +dataAll[0][2]+"`,`"
                    +dataAll[0][3]+"`,`"
                    +dataAll[0][4]+"`,`"
                    +dataAll[0][5]+"`) "
                    + "VALUES ("
                    + "NULL,'"
                    +dataAll[1][1]+"','"
                    +dataAll[1][2]+"','"
                    +dataAll[1][3]+"','"
                    +dataAll[1][4]+"','"
                    +dataAll[1][5]+"')";
            */
            
            int lastindex = 0; //cape ubah manual
            
            //Awal - proses pembuatan string SQL sebelum di eksekusi ---------------------------
            String[] sqlString=new String[1];
//            sqlString[0] = "SET @systemid=0;";
//            sqlString[1] = "SELECT @systemid:=`system_id` FROM "+DB_NAME+"."+nmTbl+" ORDER BY `system_id` DESC LIMIT 1;";
//            sqlString[2] = "SET @system_id:=@system_id+0;";
//            sqlString[3] = "SET @wherenot:=0;";
//            sqlString[4] = "SELECT @wherenot:=`system_id` FROM "+DB_NAME+"."+nmTbl+" WHERE system_id=@systemid;"; //untuk WHERE NOT
//            sqlString[5] = "SET @wherenot:=@wherenot+0;";
            sqlString[lastindex] = "INSERT INTO "+DB_NAME+"."+nmTbl+" (`";
            
            int kBatas = listColmn.length - 1;  //data dikurang 1 karena array mulai dari 0
            for (int k = 0; k < kBatas; k++) {  //akan berhenti sebelum nilai kBatas
                sqlString[lastindex] += dataAll[0][k]+"`,`";
            }
            sqlString[lastindex] += dataAll[0][kBatas];
            
            //sqlString[lastindex] += "`) VALUES (NULL,'";  //karena sudah AUTO_INCREMENT sudah otomatis
            sqlString[lastindex] += "`) VALUES ('";  //karena sudah AUTO_INCREMENT sudah otomatis
            for (int k = 0; k < kBatas; k++) {
                sqlString[lastindex] += dataAll[1][k]+"','";
            }
            sqlString[lastindex] += dataAll[1][kBatas];
            sqlString[lastindex] += "');";
//            sqlString[lastindex] += "') WHERE NOT EXISTS system_id=@wherenot;";
                    
            
            System.out.println(sqlString[lastindex]);
            //Akhir - proses pembuatan string SQL sebelum di eksekusi ---------------------------
            
            
            
            
            
            // Awal - Handle Error ----------------------------------------------------------------------------------
            try {
                String dataQuery[][]= mGetSqlEU(sqlString);
                return dataQuery;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
                String dataQuery[][]=new String[1][listColmn.length]; 
                dataQuery[0][0]="err";
                dataQuery[0][1]="Terjadi Kesalahan. Data Tidak diTemukan !";
                   
                return dataQuery;
            } 
            // Akhir - Handle Error ----------------------------------------------------------------------------------
        }
    
    
    
    
    
    
    
    
    public static String[][] cUpdate(String nmTbl,String[] listColmn,String[] listColmnRow,String colDb,String colDbTarget)  
        {   
            
            
            //Awal - membuat Array baru dengan isi colom dan isi -----------------------------------------
            String dataAll[][]= new String[listColmnRow.length][listColmn.length]; //[isi,colom]
            
            
            for (int j = 0; j < listColmn.length; j++) {
                dataAll[0][j] = listColmn[j];  //colom
                dataAll[1][j] = listColmnRow[j];  //isi
            }
            //Akhir - membuat Array baru dengan isi colom dan isi -----------------------------------------
            
            
            
            
            /*
            String sqlString = 
                    "UPDATE perpustakaan.tbl_buku SET "
                    
                    + "`nama` = 'pak Seto Perpuss', "
                    + "`judul_buku` = 'perahu kertas', "
                    + "`penulis` = 'Hanung Bramantyoo', "
                    + "`diterbitkan` = 'Mizan Productionn', "
                    + "`buku_tahun` = '2013' "
                    
                    + "WHERE id=1";
            */
            
            /*
            String sqlString = 
                    "UPDATE perpustakaan.tbl_buku SET "
                    
                    + "`"+dataAll[0][1]+"` = '"+dataAll[1][1]+"', "
                    + "`"+dataAll[0][2]+"` = '"+dataAll[1][2]+"', "
                    + "`"+dataAll[0][3]+"` = '"+dataAll[1][3]+"', "
                    + "`"+dataAll[0][4]+"` = '"+dataAll[1][4]+"', "
                    + "`"+dataAll[0][5]+"` = '"+dataAll[1][5]+"' "
                    
                    + "WHERE id=16";
            */
            
            
            
            
            //Awal - proses pembuatan string SQL sebelum di eksekusi ---------------------------
            String[] sqlString=new String[1];
            sqlString[0] = "UPDATE "+DB_NAME+"."+nmTbl+" SET ";
            //sqlString[0] = "UPDATE "+nmTbl+" SET ";
            
            int kBatas = listColmn.length - 1;
            for (int k = 1; k < kBatas; k++) {
                sqlString[0] += "`"+dataAll[0][k]+"` = '"+dataAll[1][k]+"', ";
            }
            sqlString[0] += "`"+dataAll[0][kBatas]+"` = '"+dataAll[1][kBatas]+"' ";
            sqlString[0] += "WHERE "+colDb+"="+colDbTarget+"";
            //System.out.println(sqlString);
            //Akhir - proses pembuatan string SQL sebelum di eksekusi ---------------------------
            
            
            
            
            // Awal - Handle Error ----------------------------------------------------------------------------------
            try {
                String dataQuery[][]= mGetSqlEU(sqlString);
                return dataQuery;
            } 
            catch(ArrayIndexOutOfBoundsException e) {
                String dataQuery[][]=new String[1][listColmn.length]; 
                dataQuery[0][0]="err";
                dataQuery[0][1]="Terjadi Kesalahan. Data Tidak diTemukan !";
                   
                return dataQuery;
            }
            // Akhir - Handle Error ----------------------------------------------------------------------------------
        }
    
    
    
}


