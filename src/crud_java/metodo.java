/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class metodo {
    public static boolean Insertar (Productos x){
    
        Connection cn=conexion.Conectar();
        PreparedStatement ps=null;
        
        String sql="insert into producto (CODIGO, NOMBRE, ESTADO, PRECIO, DESCRIPCION, EXISTENCIAS) values (?,?,?,?,?,?) ";
        
        try {
            
            ps= cn.prepareStatement(sql);
            ps.setInt(1, x.getCodigo());
            ps.setString(2, x.getNombre());
            ps.setString(3, x.getEstado());
            ps.setFloat(4, x.getPrecio());
            ps.setString(5, x.getDescripcion());
            ps.setInt(6, x.getExistencias());
            ps.execute();
            cn.close();
            
            return true;
            
            
        }catch(Exception e){
            
            System.out.println(e.toString());
            
            return false;
        }
        
    }
    
    public static ResultSet ListarTabla(String consulta){
        
        Connection cn=conexion.Conectar();
        Statement sql;
        
        ResultSet datos = null;
        
        try{
            
            sql=cn.createStatement();
            datos=sql.executeQuery(consulta);
            
        }catch(Exception e){
            
            System.out.println(e);

        }    
            return datos;
    }
    
    public static boolean Eliminar (String id){
    
        Connection cn=conexion.Conectar();
        PreparedStatement ps=null;
        
        String sql="delete from producto where id =" +id;
        
        try {
            
            ps= cn.prepareStatement(sql);
            

            ps.execute();
            cn.close();
            
            return true;
            
            
        }catch(Exception e){
            
            System.out.println(e.toString());
            
            return false;
        }
        
    }

    static boolean Actualizar(int id, int codigo, String nombre, String estado, float precio, String descripcion, int existencias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public DefaultTableModel Buscar (String buscar){
        
        String[] nombreColumna={"ID","CODIGO","NOMBRE","ESTADO","PRECIO","DESCRIPCION","EXISTENCIAS"};
        String[] registros=new String[7];
        DefaultTableModel modelo= new DefaultTableModel(null, nombreColumna);
        
        String sql="select * from producto where CODIGO like '%"+buscar+"%' or NOMBRE like '%"+buscar+"%' ";
        
        Connection cn=null;
        PreparedStatement past = null;
        ResultSet rs = null;
        
        try{
            
            cn=conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while (rs.next()){
                
                registros [0]=rs.getString("ID");
                registros [1]=rs.getString("CODIGO");
                registros [2]=rs.getString("NOMBRE");
                registros [3]=rs.getString("ESTADO");
                registros [4]=rs.getString("PRECIO");
                registros [5]=rs.getString("DESCRIPCION");
                registros [6]=rs.getString("EXISTENCIAS");
                modelo.addRow(registros);
                
            }
            
        }catch (Exception e) {
            
            System.out.println(e.toString());
           
    }
        
        return modelo;
        
    }
    
}
