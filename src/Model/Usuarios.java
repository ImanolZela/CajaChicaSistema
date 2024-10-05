
package Model;

import java.util.Date;

public class Usuarios {
    private int usuario_id;
    private String nombres;
    private String apellidos;
    private String dni_ce;
    private Date fecha_nacimiento;
    private String correo;
    private String direccion;
    private String password;
    private Date fecha_registro;
    private Date fecha_baja;
    private int rol_id;

    public Usuarios(int usuario_id, String nombres, String apellidos, String dni_ce, Date fecha_nacimiento, String correo, String direccion, String password, Date fecha_registro, Date fecha_baja, int rol_id) {
        this.usuario_id = usuario_id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni_ce = dni_ce;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.direccion = direccion;
        this.password = password;
        this.fecha_registro = fecha_registro;
        this.fecha_baja = fecha_baja;
        this.rol_id = rol_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni_ce() {
        return dni_ce;
    }

    public void setDni_ce(String dni_ce) {
        this.dni_ce = dni_ce;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }
    
    @Override
    public String toString() {
        return "Usuarios{" +
                "usuario_id=" + usuario_id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni_ce='" + dni_ce + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", password='" + password + '\'' +
                ", fecha_registro=" + fecha_registro +
                ", fecha_baja=" + fecha_baja +
                ", rol_id=" + rol_id +
                '}';
    }
}
