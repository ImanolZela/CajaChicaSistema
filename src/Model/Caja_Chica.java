
package Model;

import java.util.Date;

public class Caja_Chica {
    private int caja_id;
    private String nombre_proyecto;
    private int usuario_id;
    private double monto_asignado;
    private Date fecha_apertura;
    private Date fecha_cierre;
    private boolean estado_proyecto;

    public Caja_Chica(int caja_id, String nombre_proyecto, int usuario_id, double monto_asignado, Date fecha_apertura, Date fecha_cierre, boolean estado_proyecto) {
        this.caja_id = caja_id;
        this.nombre_proyecto = nombre_proyecto;
        this.usuario_id = usuario_id;
        this.monto_asignado = monto_asignado;
        this.fecha_apertura = fecha_apertura;
        this.fecha_cierre = fecha_cierre;
        this.estado_proyecto = estado_proyecto;
    }

    public int getCaja_id() {
        return caja_id;
    }

    public void setCaja_id(int caja_id) {
        this.caja_id = caja_id;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public double getMonto_asignado() {
        return monto_asignado;
    }

    public void setMonto_asignado(double monto_asignado) {
        this.monto_asignado = monto_asignado;
    }

    public Date getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Date fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public Date getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(Date fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public boolean isEstado_proyecto() {
        return estado_proyecto;
    }

    public void setEstado_proyecto(boolean estado_proyecto) {
        this.estado_proyecto = estado_proyecto;
    }
    
    @Override
    public String toString() {
        return "Caja_Chica{" +
                "caja_id=" + caja_id +
                ", nombre_proyecto='" + nombre_proyecto + '\'' +
                ", usuario_id=" + usuario_id +
                ", monto_asignado=" + monto_asignado +
                ", fecha_apertura=" + fecha_apertura +
                ", fecha_cierre=" + fecha_cierre +
                ", estado_proyecto=" + estado_proyecto +
                '}';
    }
}
