package utils;

public class Constants {

    public static final String DB_HOST = "192.168.1.53:3307";
    public static final String DB_USER_NAME = "eadmin";
    public static final String DB_PASSWORD = "abc123.";
    
     public static final String ERROR = "Error";

    //DB messages
    public static final String ACCES_ERROR = "Error al intentar acceder a la base de datos";
    public static final String LOGIN_ERROR = "Usuario y/o contraseña incorrectos";
    
    //Home View messages
    public static final String DATE_NULL = "Las fechas son incorrectas";
    public static final String OVERLAP_DATE = "Existen vacaciones que coinciden en algún momento con este intervalo de fechas";

    //ERROR messages
    public static final String ADD_USER_ERROR = "Es necesario cubrir todos los datos para añadir un empleado";
    public static final String PHONE_ERROR = "El formato del teléfono introducido no es válido";
    public static final String MAIL_ERROR = "El formato del correo introducido no es válido";
    
    public static final String DEPTO_ERROR = "Debe indicar el nombre del departamento para poder añadirlo";
    public static final String CHANGE_DEPT_USER = "Ha ocurrido un error. No es posible encontrar el usuario indicado";
    
    public static final String PASS_MATCH_ERROR = "La contraseña no es válida, debe tener al menos 6 caracteres y un símbolo especial";

    //CONFIRM messages
    public static final String ACTION_CONFIRM = "Acción realizada correctamente";
}
