
package Model;

import java.util.Date;

public class Movimientos_Caja_Chica {
    
    private int movimiento_id;
    private int caja_id;
    private boolean tipo_movimiento;  // true para ingresos, false para egresos
    private double monto_movimiento;
    private Date fecha_movimiento;
    private int usuario_id;
    private double saldo_resultante;

    public Movimientos_Caja_Chica(int movimiento_id, int caja_id, boolean tipo_movimiento, double monto_movimiento, Date fecha_movimiento, int usuario_id, double saldo_resultante) {
        this.movimiento_id = movimiento_id;
        this.caja_id = caja_id;
        this.tipo_movimiento = tipo_movimiento;
        this.monto_movimiento = monto_movimiento;
        this.fecha_movimiento = fecha_movimiento;
        this.usuario_id = usuario_id;
        this.saldo_resultante = saldo_resultante;
    }
    
    public int getMovimiento_id() {
        return movimiento_id;
    }

    public void setMovimiento_id(int movimiento_id) {
        this.movimiento_id = movimiento_id;
    }

    public int getCaja_id() {
        return caja_id;
    }

    public void setCaja_id(int caja_id) {
        this.caja_id = caja_id;
    }

    public boolean isTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(boolean tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public double getMonto_movimiento() {
        return monto_movimiento;
    }

    public void setMonto_movimiento(double monto_movimiento) {
        this.monto_movimiento = monto_movimiento;
    }

    public Date getFecha_movimiento() {
        return fecha_movimiento;
    }

    public void setFecha_movimiento(Date fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public double getSaldo_resultante() {
        return saldo_resultante;
    }

    public void setSaldo_resultante(double saldo_resultante) {
        this.saldo_resultante = saldo_resultante;
    }

    @Override
    public String toString() {
        return "Movimientos_Caja_Chica{" +
                "movimiento_id=" + movimiento_id +
                ", caja_id=" + caja_id +
                ", tipo_movimiento=" + tipo_movimiento +
                ", monto_movimiento=" + monto_movimiento +
                ", fecha_movimiento=" + fecha_movimiento +
                ", usuario_id=" + usuario_id +
                ", saldo_resultante=" + saldo_resultante +
                '}';
    }
}
