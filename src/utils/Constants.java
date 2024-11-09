package utils;

public class Constants {

    public static final String DB_HOST = "192.168.1.53:3307";
    public static final String DB_USER_NAME = "eadmin";
    public static final String DB_PASSWORD = "abc123.";
    
     public static final String ERROR = "Error";
     public static final String CONFIRM = "Confirmar";

    //DB messages
    public static final String ACCES_ERROR = "Error al intentar acceder a la base de datos";
    public static final String LOGIN_ERROR = "Usuario y/o contraseña incorrectos";
    
    //Home View messages
    public static final String DATE_NULL = "Las fechas son incorrectas";
    public static final String OVERLAP_DATE = "Existen vacaciones que coinciden en algún momento con este intervalo de fechas";

    //Department View messages
    public static final String ERROR_DEPT_NAME = "Debe indicar un nombre de departamento válido";
    public static final String CONFIRM_DELETE_DEPT = "Seguro que quiere eliminar este departamento, lo empleados que pertenecen a este departamento serán reubicados en uno genérico";
    
    //ERROR messages
    public static final String PASS_MATCH_ERROR = "La contraseña no es válida, debe tener al menos 6 caracteres y un símbolo especial";

    //CONFIRM messages
    public static final String ACTION_CONFIRM = "Acción realizada correctamente";
}
