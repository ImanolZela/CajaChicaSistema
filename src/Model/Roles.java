
package Model;

public class Roles {
    private int rol_id;
    private String nombre_rol;

    public Roles(int rol_id, String nombre_rol) {
        this.rol_id = rol_id;
        this.nombre_rol = nombre_rol;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    @Override
    public String toString() {
        return "Roles{" + "rol_id=" + rol_id + ", nombre_rol=" + nombre_rol + '}';
    }
    
    
}
