package com.tineo.reto.config;

public class Constant {

    // api version
    public static final String API_VERSION = "/api/v1";

    // global exception messages
    public static final String GLOBAL_EXCEPTION_ERROR_DETAILS = "[%s] %s";
    public static final String GLOBAL_EXCEPTION_ERROR_PARAMETER_TYPE = "El parámetro '%s' debe ser de tipo %s";

    // tipo cambio - endpoints
    public static final String TIPO_CAMBIO = API_VERSION + "/tipo-cambio";

    // tipo cambio - messages
    public static final String TIPO_CAMBIO_FOUND = "Tipo de cambio encontrado";

    public static final String TIPO_CAMBIO_NOT_FOUND = "Tipo de cambio no encontrado -> id: ";

    // moneda - messages
    public static final String MONEDA_NOT_FOUND_BY_ID = "Moneda no encontrada -> id: ";
    public static final String MONEDA_NOT_FOUND_BY_CODIGO = "Moneda no encontrada -> codigo: ";

    // transaccion - endpoints
    public static final String TRANSACCION = API_VERSION + "/transaccion";

    // transaccion - messages
    public static final String TRANSACCION_CREATED = "Transaccion creada";
    public static final String TRANSACCION_FOUND = "Transaccion encontrada";

    public static final String TRANSACCION_NOT_FOUND = "Transaccion no encontrada -> id: ";
}
