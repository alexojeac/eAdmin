package utils;

/**
 *
 * @author Alejandro Ojea
 */
public class Constants {

    public static final String DB_HOST = "192.168.1.53:3307";
    public static final String DB_USER_NAME = "eadmin";
    public static final String DB_PASSWORD = "abc123.";

    public static final String ERROR = "Error";
    public static final String CONFIRM = "Confirmar";

    //DB messages
    public static final String ACCES_ERROR = "Error al intentar acceder a la base de datos.";
    public static final String LOGIN_ERROR = "Usuario y/o contraseña incorrectos.";

    //Home view messages
    public static final String DATE_NULL = "Las fechas son incorrectas.";
    public static final String OVERLAP_DATE = "Existen vacaciones que coinciden en algún momento con este intervalo de fechas.";
    public static final String INVALID_TIME_RECORD_IN = "Ya existe una ficha de entrada para el día de hoy.";
    public static final String INVALID_TIME_RECORD_OUT = "Ya existe una ficha de salida para el día de hoy.";
    public static final String INVALID_TIME_RECORD_BEFORE_NOW = "La fecha inicial no puede ser inferior al día de hoy.";

    //Department view messages
    public static final String ERROR_DEPT_NAME = "Debe indicar un nombre de departamento válido, este nombre tampoco puede ser igual al de otro departamento.";
    public static final String CONFIRM_DELETE_DEPT = "Seguro que quiere eliminar este departamento, lo empleados que pertenecen a este departamento serán reubicados en uno genérico.";

    //RRHH View messages
    public static final String HOLIDAY_REQUEST_MESSAGE = "El empleado %s solicita vacaciones del día %s al día %s.";
    public static final String INSERT_EMP_SUCCESS = "Empleado creado correctamente, su usuario es %s.";
    public static final String UPDATE_EMP_SUCCESS = "Empleado actualizado correctamente.";
    public static final String CONFIRM_DELETE_EMP_TITLE = "Eliminar empleado";
    public static final String CONFIRM_DELETE_EMP = "Quiere eliminar el empleado %s?, se eliminará su usuario, y todas sus fichadas y solicitudes de vacaciones.";
    public static final String DELETE_EMP = "Empleado eliminado correctamente.";
    public static final String ERROR_DELETE_EMPTY = "Tiene que haber un empleado seleccionadopara poder borrarlo.";
    public static final String ERROR_DELETE_EMP = "Error al intentar eliminar el empleado.";
    public static final String ERROR_UPDATE_EMP = "Error al intentar actualizar el empleado.";
    public static final String INVALID_DATA_SEARCH = "No se puede filtrar con los datos introducidos, seleccione departamento y empleado.";
    public static final String INSERT_EMP_ERROR = "Ha ocurrido un error al intentar crear el empleado, compruebe que no existe un empleado con este DNI.";

    //Asministration view messages
    public static final String ENTERPRISE_ERROR = "Error al guardad los datos de la empresa, comprueba que todos los campos están cubiertos.";
    public static final String ENTERPRISE_SAVE = "Datos de la empresa guardados correctamente.";

    //ERROR messages
    public static final String PASS_MATCH_ERROR = "La contraseña no es válida, debe tener al menos 6 caracteres y un símbolo especial";
    public static final String DNI_ERROR = "El campo DNI no es correcto.";
    public static final String EMAIL_ERROR = "El campo email no es correcto.";
    public static final String PHONE_NUMBER_ERROR = "El campo tlf no es correcto.";
    public static final String INVALID_SALARY = "El salario introducido no es válido.";
    public static final String ERROR_NAME_LASTNAME = "El campo Nombre y el campo Apellido 1 no pueden estar vacíos.";
}
