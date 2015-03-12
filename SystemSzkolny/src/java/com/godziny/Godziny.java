
package com.godziny;

import com.klasa.Labcon;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="g")
@SessionScoped
public class Godziny {
Connection con1 = null;
    CallableStatement call= null;
    ResultSet result = null;
    Statement stmt = null;
    
    private List <String> godzinLista = new ArrayList();
    //connect to DB and get customer list
    public List getGodzinyList() throws SQLException{
        godzinLista.clear();
        Labcon lc = new Labcon();
        con1 = lc.getLocalConnection();
        stmt=con1.createStatement();
        String sql = "USE 686_szkola";
        stmt.executeQuery(sql); 
        
        String strSql="select Godzina from Godziny";
        //System.err.println("****"+strSql);
        result=stmt.executeQuery(strSql);
        
        while(result.next()){
            String nowa;
            nowa = result.getString("Godzina");
            godzinLista.add(nowa);
        }
        result.close();
        return godzinLista;
    }
    public Godziny() {
    }
    
}