
package Model;

import java.util.Date;

public class Rendicion_Gastos {
    private int rendicion_id;
    private int caja_id;
    private int categoria_id;
    private String tipo_comprobante;
    private String num_comprobante;
    private String descripcion_gasto;
    private double monto;
    private Date fecha_gasto;
    private int usuario_id;

    public Rendicion_Gastos(int rendicion_id, int caja_id, int categoria_id, String tipo_comprobante, String num_comprobante, String descripcion_gasto, double monto, Date fecha_gasto, int usuario_id) {
        this.rendicion_id = rendicion_id;
        this.caja_id = caja_id;
        this.categoria_id = categoria_id;
        this.tipo_comprobante = tipo_comprobante;
        this.num_comprobante = num_comprobante;
        this.descripcion_gasto = descripcion_gasto;
        this.monto = monto;
        this.fecha_gasto = fecha_gasto;
        this.usuario_id = usuario_id;
    }

    public int getRendicion_id() {
        return rendicion_id;
    }

    public void setRendicion_id(int rendicion_id) {
        this.rendicion_id = rendicion_id;
    }

    public int getCaja_id() {
        return caja_id;
    }

    public void setCaja_id(int caja_id) {
        this.caja_id = caja_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getTipo_comprobante() {
        return tipo_comprobante;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    public String getNum_comprobante() {
        return num_comprobante;
    }

    public void setNum_comprobante(String num_comprobante) {
        this.num_comprobante = num_comprobante;
    }

    public String getDescripcion_gasto() {
        return descripcion_gasto;
    }

    public void setDescripcion_gasto(String descripcion_gasto) {
        this.descripcion_gasto = descripcion_gasto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha_gasto() {
        return fecha_gasto;
    }

    public void setFecha_gasto(Date fecha_gasto) {
        this.fecha_gasto = fecha_gasto;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    @Override
    public String toString() {
        return "Rendicion_Gastos{" +
                "rendicion_id=" + rendicion_id +
                ", caja_id=" + caja_id +
                ", categoria_id=" + categoria_id +
                ", tipo_comprobante='" + tipo_comprobante + '\'' +
                ", num_comprobante='" + num_comprobante + '\'' +
                ", descripcion_gasto='" + descripcion_gasto + '\'' +
                ", monto=" + monto +
                ", fecha_gasto=" + fecha_gasto +
                ", usuario_id=" + usuario_id +
                '}';
    }
}
