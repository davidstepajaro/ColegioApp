package modelo;

public class Estudiante extends Persona {

    private String codigo;
    private int grado;

    // CONSTRUCTOR (unico)
    public Estudiante(String nombre, String direccion, String telefono, String fechaNacimiento,
                      String codigo, int grado) {

        super(nombre, direccion, telefono, fechaNacimiento);

        setCodigo(codigo);
        setGrado(grado);
    }

    // SET CODIGO
    public void setCodigo(String codigo) {
        if (codigo == null || !codigo.matches("\\d+")) {
            throw new IllegalArgumentException("Codigo invalido");
        }
        this.codigo = codigo;
    }

    // SET GRADO
    public void setGrado(int grado) {
        if (grado <= 0 || grado > 11) {
            throw new IllegalArgumentException("Grado invalido (1-11)");
        }
        this.grado = grado;
    }

    // GETS
    public String getCodigo() {
        return codigo;
    }

    public int getGrado() {
        return grado;
    }

    // METODO POLIMORFISMO (sobrescritura)
    @Override
    public String toString() {
        return "Estudiante: " + nombre +
               " | Codigo: " + codigo +
               " | Grado: " + grado;
    }
}