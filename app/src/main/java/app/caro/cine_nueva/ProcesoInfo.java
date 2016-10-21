package app.caro.cine_nueva;

public class ProcesoInfo {
    private String Titulo;
    private String Horario;
    private String Id;

    public ProcesoInfo() {
        Titulo = null;
        Horario = null;
        Id = null;
    }

    public ProcesoInfo(String titulo, String horario, String id) {
        Titulo = titulo;
        Horario = horario;
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
