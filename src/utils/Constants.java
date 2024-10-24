package utils;

public class Constants {
     // Acceso BD
    public static final String DB_HOST = "192.168.1.53:3307";
    public static final String DB_USER_NAME = "eadmin";
    public static final String DB_PASSWORD = "abc123.";
    
     public static final String ERROR = "Error";

    // Mensajes ERROR BD
    public static final String ACCES_ERROR = "Error al intentar acceder a la base de datos";
    public static final String LOGIN_ERROR = "Usuario y/o contraseña incorrectos";

    // Mensajes ERROR
    public static final String ADD_USER_ERROR = "Es necesario cubrir todos los datos para añadir un empleado";
    public static final String PHONE_ERROR = "El formato del teléfono introducido no es válido";
    public static final String MAIL_ERROR = "El formato del correo introducido no es válido";
    public static final String DELETE_USER_ERROR = "Es necesario seleccionar un empleado en la tabla para poder borrarlo";
    
    public static final String DEPTO_ERROR = "Debe indicar el nombre del departamento para poder añadirlo";
    public static final String CHANGE_DEPT_USER = "Ha ocurrido un error. No es posible encontrar el usuario indicado";
    public static final String INVALID_CHANGE_ERROR = "Es necesario introducir el id del usuario y seleccionar el departamento en la tabla";
    
    public static final String PASS_VALID_ERROR = "La contraseña no es válida, debe tener al menos 6 caracteres y un símbolo especial";
    public static final String PASS_MATCH_ERROR = "La contraseña no es válida, debe tener al menos 6 caracteres y un símbolo especial";

    // Mensajes WARNING
    public static final String CHANGE_ADMIN_WAR = "No se puede cambiar el departamento de este usuario";

    // Mensajes CONFIRM
    public static final String ACTION_CONFIRM = "Acción realizada correctamente";
}
