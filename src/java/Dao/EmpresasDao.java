
package Dao;

import Dto.EmpresasDto;
import Genericos.CRUD;
import Genericos.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmpresasDao implements CRUD<EmpresasDto>{
    private String query;
    private String msg;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public EmpresasDao() {
        ConexionBD.getConexionBD();
    }

    @Override
    public boolean insertar(EmpresasDto t) {
       try {
            query = "insert into empresas ( razon_social, ruc, direccion, telefono ) values ( ? , ? , ?, ?);";
            ps= ConexionBD.getRutaConexion().prepareStatement(query);
            ps.setString(1, t.getRazon_social());
            ps.setString(2, t.getRuc());
            ps.setString(3, t.getDireccion());
             ps.setString(4, t.getTelefono());
            if (ps.executeUpdate() > 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresasDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    @Override
    public boolean modificar(EmpresasDto t) {
        try {
            query = "update  empresas set  razon_social = ?, ruc = ?, direccion = ?, telefono = ?  where id = ? ;";
            ps= ConexionBD.getRutaConexion().prepareStatement(query); // esto debe tener si o si
            ps.setString(1, t.getRazon_social());
            ps.setString(2, t.getRuc());
            ps.setString(3, t.getDireccion());
            ps.setString(4, t.getTelefono());
            ps.setInt(5, t.getId());
            if (ps.executeUpdate() > 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresasDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(EmpresasDto t) {
        try {
            query = "delete from  empresas  where id = ? ;";
            ps= ConexionBD.getRutaConexion().prepareStatement(query);
            ps.setInt(1, t.getId());
            if (ps.executeUpdate() > 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresasDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<EmpresasDto> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmpresasDto> consultarSegunId(EmpresasDto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMensaje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
